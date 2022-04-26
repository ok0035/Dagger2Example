package com.example.dagger2test.dragonball

import dagger.Subcomponent

@Subcomponent(modules = [CharacterModule::class])
interface CharacterComponent {

    fun inject(character: Character)

    @Subcomponent.Builder
    interface Builder {
        fun setCharacterModule(characterModule: CharacterModule): Builder
        fun build(): CharacterComponent
    }

}