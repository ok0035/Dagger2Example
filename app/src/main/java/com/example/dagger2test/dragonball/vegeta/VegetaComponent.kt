package com.example.dagger2test.dragonball.vegeta

import com.example.dagger2test.dragonball.CharacterComponent
import dagger.Component

@Component(
    modules = [VegetaModule::class],
    dependencies = [CharacterComponent::class])
interface VegetaComponent {
    fun inject(vegeta: Vegeta)
}