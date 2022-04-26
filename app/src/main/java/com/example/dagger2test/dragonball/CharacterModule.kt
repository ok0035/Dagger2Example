package com.example.dagger2test.dragonball

import dagger.Module
import dagger.Provides

@Module
class CharacterModule {

    @Provides
    @Walk
    fun provideWalk(): String {
        return "터벅 터벅..."
    }

}