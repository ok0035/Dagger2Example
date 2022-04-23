package com.example.dagger2test

import com.example.dagger2test.test.cafe.Cafe
import org.junit.Test

class CoffeeUnitTest {
    @Test
    fun testCafe() {
        val cafe = Cafe()
        println(cafe.orderCoffee())
        println(cafe.orderCoffee())
        println(cafe.orderCoffee())
    }
}