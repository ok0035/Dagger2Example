package com.example.dagger2test.dragonball

import javax.inject.Inject

class Character(builder: CharacterComponent.Builder) {

    @Inject
    @Name
    @JvmField
    internal var name: String? = null

    @Inject
    @HP
    @JvmField
    internal var hp: Int = -1

    @Inject
    @Ki
    @JvmField
    internal var ki: Long = 0

    init {
        val component = builder.setCharacterModule(CharacterModule()).build()
        component.inject(this)
    }

}