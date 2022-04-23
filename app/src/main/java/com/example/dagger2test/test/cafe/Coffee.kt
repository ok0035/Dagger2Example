package com.example.dagger2test.test.cafe

import javax.inject.Inject

class Coffee @Inject constructor(private val coffeeBean: CoffeeBean, private val water: Water)