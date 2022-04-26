package com.example.dagger2test.dragonball

import dagger.Component
import dagger.Subcomponent

@Component(modules = [CharacterModule::class])
interface CharacterComponent {

    @Walk
    fun provideBehavior(): String

//    @Subcomponent.Builder
//    interface Builder {
//        fun setCharacterModule(characterModule: CharacterModule): Builder
//        fun build(): CharacterComponent
//    }

}