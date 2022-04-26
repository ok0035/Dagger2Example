package com.example.dagger2test.dragonball

import dagger.Component
import dagger.Subcomponent

@Component(modules = [SongokuModule::class])
interface SongokuComponent {
    fun inject(songoku: Songoku)
}