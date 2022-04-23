package com.example.dagger2test.test.case10

import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class NumberKey(val value: KClass<out Any>)