package com.example.dagger2test.test.cafe

import dagger.Component

@Component(modules = [CafeModule::class])
interface CafeComponent {
    fun inject(cafe: Cafe?)
}