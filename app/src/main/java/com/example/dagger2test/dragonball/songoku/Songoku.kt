package com.example.dagger2test.dragonball.songoku

import com.example.dagger2test.dragonball.*
import javax.inject.Inject

class Songoku {

//    @Inject
//    lateinit var character: Character

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
    @Kamehameha
    @JvmField
    internal var kamehameha: String? = null

    @Inject
    @SolarFlare
    @JvmField
    internal var solarFlare: String? = null

    @Inject
    @Teleportation
    @JvmField
    internal var teleportation: String? = null

//    init {
//        DaggerSongokuComponent.create().inject(this)
//    }

}