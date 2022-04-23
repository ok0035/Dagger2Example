package com.example.dagger2test.test.case09

import com.example.dagger2test.test.case06.Foo
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
object MapModule {
    @Provides
    @IntoMap
    @StringKey("foo")
    fun provideFooValue(): Long {
        return 100L
    }

    @Provides
    @IntoMap
    @ClassKey(Foo::class)
    fun provideFooStr(): String {
        return "Foo String"
    }
}