package com.example.dagger2test.dragonball.vegeta

import com.example.dagger2test.dragonball.*
import dagger.Module
import dagger.Provides

@Module
class VegetaModule {

    @Provides
    @Name
    fun provideName(): String {
        return "베지터"
    }

    @Provides
    @HP
    fun provideHP(): Int {
        return 100
    }

    @Provides
    @Ki
    fun provideKi(): Long {
        return 150000000
    }

//    @Provides
//    fun provideCharacter(builder: CharacterComponent.Builder) : Character {
//        return Character(builder)
//    }

    @Provides
    @FinalFlash
    fun provideFinalFlash() : String{
        return "파이널... 플래쉬!!!!!!"
    }

    @Provides
    @GaligFlare
    fun provideGaligFlare(): String{
        return "갤릭포!!!"
    }

    @Provides
    @SuperSaiyan1
    fun provideSupersaiyan1() :String {
        return "슈퍼 사이어인.. 베지터다!!"
    }

}