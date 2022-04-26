package com.example.dagger2test.dragonball

import androidx.annotation.NonNull
import javax.inject.Inject

class Songoku {

    @Inject
    lateinit var character: Character

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

    init {
        DaggerSongokuComponent.create().inject(this)
    }

}