package com.example.kotlinsample.kotlinSample

object ParamSample {

    fun test(var1: Int = 0, var2: String = "sample", var3: Int = 0) {
        println("var1 = $var1, var2 = $var2, var3 = $var3")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        test(100)
        test(100, var3 = 100)
        test(var2 = "test")
    }
}