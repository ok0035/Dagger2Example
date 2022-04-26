package com.example.dagger2test.dragonball

import javax.inject.Inject

class Character {

    @Inject
    @Walk
    @JvmField
    internal var walk: String? = null

}