package com.example.dagger2test.test.cafe

import javax.inject.Inject

class Cafe {
    var coffeeMachine: Machine? = null
        @Inject set
    fun orderCoffee(): Coffee? {
        return coffeeMachine!!.extract()
    }

    init {
        DaggerCafeComponent.create().inject(this)
    }
}