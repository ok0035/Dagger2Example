package com.example.dagger2test

import dagger.Module
import dagger.Provides

@Module
class PersonModule {
    @Provides
    fun getName(): String {
        return "Youngdo"
    }

    @Provides
    fun getAge(): Int {
        return 30
    }
}