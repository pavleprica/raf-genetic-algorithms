package com.ga.homework_i.service

import com.ga.homework_i.model.*
import java.io.File
import kotlin.random.Random

class GeneticAlgorithm {

    private val mutation = Mutation()

    init {
        doGeneticAlgorithm()
    }

    private fun tournament(population: List<Chromosome>, size: Int): Chromosome {
        val z: MutableList<Chromosome> = mutableListOf()

        while (z.size < ConfigConstants.tournament) {
            z.add(population.random())
        }

        var best: Chromosome? = null
        var best_f: Double? = null

        z.forEach {
            val ff = it.expense()
            if (best == null || ff < best_f!!) {
                best_f = ff
                best = it
            }
        }

        return best!!
    }

    private fun cross(chromosomeOne: Chromosome, chromosomeTwo: Chromosome): MutableList<Chromosome> {
        val list: MutableList<Chromosome> = mutableListOf()

        for (i in 0..1) {
            val beta = Random.nextDouble(0.0, 1.0)

            val resultOne = (beta * chromosomeOne.x) + ((1.0 - beta) * chromosomeTwo.x)
            val resultTwo = (beta * chromosomeOne.y) + ((1.0 - beta) * chromosomeTwo.y)
            list.add(Chromosome(resultOne, resultTwo))
        }

        return list
    }

    private fun doGeneticAlgorithm() {
        val outputFile = File(ConfigConstants.output)
        val output = Output(outputFile)
//        val output = Output(null)

        var bestEverSolution: Chromosome? = null
        var bestEverFunction: Double? = null


        for (k in 0..ConfigConstants.maxIteration) {
            output.println("Run: GA $k")
            var bestChromosome: Chromosome? = null
            var bestFunction: Double? = null

            var t = 0
            var population: MutableList<Chromosome> = mutableListOf()

            for(i in 0..ConfigConstants.populationSize) { //population size
                population.add(Chromosome(
                        Random.nextDouble(
                            ConfigConstants.constraint.leftConstraint,
                            ConfigConstants.constraint.rightConstraint
                        ),
                        Random.nextDouble(
                                ConfigConstants.constraint.leftConstraint,
                                ConfigConstants.constraint.rightConstraint
                        )
                ))
            }


            while (bestFunction != 3.0 && t < ConfigConstants.maxIteration) { //3.0 is desired result
                val n_population = population.toMutableList()

                while(n_population.size < ConfigConstants.populationSize + ConfigConstants.populationSizeNew) {
                    var chromosomeOne = tournament(population, 3)
                    var chromosomeTwo = tournament(population, 3)

                    var crossedChromosones = cross(chromosomeOne, chromosomeTwo)
                    var chromosomeThree = crossedChromosones[0]
                    var chromosomeFour = crossedChromosones[1]

                    chromosomeThree = mutation.mutate(chromosomeThree, ConfigConstants.constraint)
                    chromosomeFour = mutation.mutate(chromosomeFour, ConfigConstants.constraint)

                    n_population.add(chromosomeThree)
                    n_population.add(chromosomeFour)
                }
                population = n_population.sortedBy { it.expense() }.toMutableList().subList(0, ConfigConstants.populationSize)

                val f = population[0].expense()

                if (bestFunction == null || bestFunction > f) {
                    bestFunction = f
                    bestChromosome = Chromosome(
                            population[0].x, population[0].y
                    )
                }

                var averageExpense = 0.0

                population.forEach {
                    averageExpense += it.expense()
                }

                averageExpense /= population.size

                output.println("Best expense: $f averageExpense: $averageExpense")

                t++
                }

                if(bestEverFunction == null || bestEverFunction > bestFunction!!) {
                    bestEverFunction = bestFunction
                    bestEverSolution = bestChromosome
                }


                }

        output.println("Best solution: $bestEverSolution")
        output.println("Best expense: $bestEverFunction")

        output.close()
    }

}