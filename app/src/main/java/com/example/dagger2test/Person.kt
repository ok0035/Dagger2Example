package com.example.dagger2test

import javax.inject.Inject

class Person(name:String?, age:Int?) {
    var name = name
        @Inject set

    var age = age
        @Inject set
}