package com.example.dagger2test
import dagger.Component
import dagger.MembersInjector

@Component(modules = [MyModule::class])
interface MyComponent {
    fun getString(): String //프로비전 메소드, 바인드된 모듈로부터 의존성을 제공
    fun inject(myClass: MyClass)
    var injector: MembersInjector<MyClass>
}

