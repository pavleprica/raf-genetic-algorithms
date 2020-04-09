package com.ga.homework_i.model

import com.ga.homework_i.service.GeneticAlgorithm
import java.io.File
import java.io.PrintWriter

/**
 * This file is used to print either to a file or to a console.
 * If we want to debug, we can change the initialisation of the class in @see GeneticAlgorithm
 */

class Output(val file: File?) {


    var printWriter: PrintWriter? = null

    init {
        if(file != null) {
            printWriter = PrintWriter(file)
        }
    }

}

fun Output.println(message: String) {
    if(file == null) {
        kotlin.io.println(message)
    } else {
        this.printWriter?.println(message)
    }
}

fun Output.close() {
    this.printWriter?.close()
}