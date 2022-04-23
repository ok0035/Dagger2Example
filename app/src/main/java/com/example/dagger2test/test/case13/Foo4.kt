package com.example.dagger2test.test.case13

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

class Foo4 {
    var str: String? = null
        @Inject set

    var integer: Int? = null
        @Inject set
}