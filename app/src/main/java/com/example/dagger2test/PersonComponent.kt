package com.example.dagger2test


import dagger.Component
import dagger.MembersInjector

@Component(modules = [PersonModule::class])
interface PersonComponent {
    var injector: MembersInjector<Person>
}