package kotlinSample

class ParamSample {

    fun test2(var1: Int, var2: String, var3: Int) {

    }

    fun test(var1: Int = 0, var2: String = "sample", var3: Int = 0) {
        println("var1 = $var1, var2 = $var2, var3 = $var3")
    }

}