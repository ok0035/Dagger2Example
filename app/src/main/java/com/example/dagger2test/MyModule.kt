package com.example.dagger2test

import dagger.Module
import dagger.Provides

@Module
class MyModule {

    @Provides
    fun provideHelloWorld() : String{
        return "Hello World"
    }

}