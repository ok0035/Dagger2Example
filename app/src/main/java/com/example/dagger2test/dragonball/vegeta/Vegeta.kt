package com.example.dagger2test.dragonball.vegeta

import com.example.dagger2test.dragonball.*
import javax.inject.Inject

class Vegeta {

    //    @Inject
//    lateinit var character: Character
    @Inject
    @Walk
    @JvmField
    internal var walk: String? = null

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

    @Inject
    @FinalFlash
    @JvmField
    internal var finalFlash: String? = null

    @Inject
    @GaligFlare
    @JvmField
    internal var galigFlare: String? = null

    @Inject
    @SuperSaiyan1
    @JvmField
    internal var superSaiyan1: String? = null

}