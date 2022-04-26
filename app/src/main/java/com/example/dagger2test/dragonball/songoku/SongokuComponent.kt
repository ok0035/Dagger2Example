package com.example.dagger2test.dragonball.songoku

import dagger.Component

@Component(modules = [SongokuModule::class])
interface SongokuComponent {
    fun inject(songoku: Songoku)
}