package com.ga.homework_i.model

/**
 * This is a singleton class that holds all the constant required for program running. It will be changed on program start
 */
object ConfigConstants {

    var rate: Double? = null
    var populationSize: Int? = null
    var populationSizeNew: Int? = null
    var tournament: Int? = null
    var output = ""
    val constraint = Constraint(-2.0, 2.0) //This is fixed because of the expense function assignment
    var maxIteration: Int? = null

}