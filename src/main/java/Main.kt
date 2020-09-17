import javaSample.StringUtil
import kotlinSample.ParamSample
import kotlinSample.lettersCount

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

    }

    /**
     * 扩展函数示例
     */
    fun getLettersCount() {
        var count = "ABC123xsy#@\$".lettersCount()
        count = StringUtil.lettersCount("ABC123xsy#@\$")
    }

    /**
     * 方法默认参数示例
     */
    fun testParams() {
        val paramSample = ParamSample()
        paramSample.test(100, var3 = 100)
        paramSample.test(var2 = "test")
    }

    /**
     * 空安全机制
     */
    fun testNull() {
        var str1: String = ""
        var str2: String? = null

//        str1 = null
//        str2 = null
//
//        str1.length
//        str2.length
//
//        str2!!.length
//        str2?.length
    }
}