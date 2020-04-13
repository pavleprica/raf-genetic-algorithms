package com.ga.homework_i.service

import com.ga.homework_i.model.Chromosome
import com.ga.homework_i.model.ConfigConstants
import com.ga.homework_i.model.Constraint
import kotlin.random.Random

/**
 * This class contains only one method. It's used to separate the mutation. Uniform dot mutation with random
 * value within constraint
 */
class Mutation {

    fun mutate(chromosome: Chromosome, constraint: Constraint): Chromosome {

        if(Random.nextDouble(0.0, 1.0) < ConfigConstants.rate!!) {
            chromosome.x = Random.nextDouble(constraint.leftConstraint, constraint.rightConstraint)
            chromosome.y = Random.nextDouble(constraint.leftConstraint, constraint.rightConstraint)
        }

        return chromosome
    }
}