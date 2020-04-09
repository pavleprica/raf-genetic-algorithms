package com.ga.homework_i.model

import java.io.File
import java.io.PrintWriter

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