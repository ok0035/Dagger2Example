package com.example.dagger2test.dragonball

import dagger.Module
import dagger.Provides

@Module
class CharacterModule {

    @Provides
    @Name
    fun provideName(): String?{
        return "손오공"
    }

    @Provides
    @HP
    fun provideHP(): Int {
        return 100
    }

    @Provides
    @Ki
    fun provideKi(): Long{
        return 150000000
    }

}