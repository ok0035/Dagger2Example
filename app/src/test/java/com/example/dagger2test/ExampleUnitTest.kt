package com.example.dagger2test

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testHelloWorld() {
        val component = DaggerMyComponent.create()
        println("result=${component.getString()}")
    }

    @Test
    fun testMemberInjection() {
        var myClass = MyClass()
        var str: String? = myClass.str
//        assertNotNull("조회결과 null", str) // Null이면 Exception 반환
        val myComponent = DaggerMyComponent.create()
        myComponent.inject(myClass)
        str = myClass.str
        assertEquals("Hello World", str) // 같지 않으면 Exception 반환
    }

    @Test
    fun testMemberInjector() {
        val myClass = MyClass()
        var str = myClass.str
        println("result -> $str")
        val myComponent = DaggerMyComponent.create()
        var injector = myComponent.injector
        injector.injectMembers(myClass)
        str = myClass.str
        println("result2 -> $str")
    }
}