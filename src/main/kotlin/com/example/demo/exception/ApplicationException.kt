package com.example.demo.exception


open class ApplicationException : RuntimeException {

    constructor() : super(MESSAGE) {}

    constructor(message: String) : super(message) {}

    companion object {

        private val MESSAGE = "app exception"
    }
}
