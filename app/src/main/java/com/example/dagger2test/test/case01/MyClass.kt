package com.example.dagger2test.test.case01

import javax.inject.Inject
import com.example.dagger2test.test.cafe.Machine
import com.example.dagger2test.test.cafe.Coffee
import com.example.dagger2test.test.cafe.CoffeeBean
import com.example.dagger2test.test.cafe.Water
import com.example.dagger2test.test.cafe.MachineComponent
import com.example.dagger2test.test.cafe.MachineModule
import com.example.dagger2test.test.cafe.CafeModule
import com.example.dagger2test.test.cafe.Cafe
import dagger.Subcomponent
import javax.inject.Qualifier
import com.example.dagger2test.test.case01.Hello
import javax.inject.Singleton
import com.example.dagger2test.test.case02.DuplicationModule
import com.example.dagger2test.test.case04.PersonA
import com.example.dagger2test.test.case04.PersonB
import com.example.dagger2test.test.case05.CounterModule
import dagger.BindsOptionalOf
import com.example.dagger2test.test.case06.CommonModule
import com.example.dagger2test.test.case06.HelloModule
import com.example.dagger2test.test.case06.Foo
import com.example.dagger2test.test.case07.Foo2
import dagger.BindsInstance
import com.example.dagger2test.test.case07.BindsComponent
import dagger.multibindings.IntoSet
import dagger.multibindings.ElementsIntoSet
import com.example.dagger2test.test.case08.SetModule
import com.example.dagger2test.test.case08.Foo3
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import dagger.multibindings.ClassKey
import dagger.MapKey
import com.example.dagger2test.test.case10.Animal
import com.example.dagger2test.test.case10.AnimalKey
import com.example.dagger2test.test.case10.NumberKey
import kotlin.reflect.KClass
import com.example.dagger2test.test.case11.ChildComponent
import com.example.dagger2test.test.case11.ChildModule
import com.example.dagger2test.test.case11.ParentModule
import dagger.multibindings.Multibinds
import com.example.dagger2test.test.case12.MultibindsModules
import com.example.dagger2test.test.case13.ModuleA
import com.example.dagger2test.test.case13.ModuleB
import com.example.dagger2test.test.case13.ComponentA
import com.example.dagger2test.test.case13.Foo4
import javax.inject.Named

class MyClass {
    var str: String? = null
        @Inject set

    //non-null일 경우 아래와 같이 사용
    @Named("hello")
    @Inject
    lateinit var strHello: String

    //nullable하게 사용할 경우 아래와 같이 사용
    @Named("world")
    @Inject
    @JvmField // getter/setter를 생성하지 않고 필드를 직접 노출시켜 사용하도록 하게 함
    internal var strWorld: String? = null
    /* internal -> java와 달리 패키지 가시성이 없기 때문에 internal을 사용하여 같은 모듈 내에서만
    *             사용할 수 있도록 만들어주는 키워드
    *
    * 즉 jvm필드를 선언하여 필드를 직접 노출시키고, 같은 모듈 내에서만 볼 수 있게 함으로써 캡슐화(?)한 모습
    *
    *  */


    @Hello
    @Inject
    lateinit var strHelloWithQualifier: String

}