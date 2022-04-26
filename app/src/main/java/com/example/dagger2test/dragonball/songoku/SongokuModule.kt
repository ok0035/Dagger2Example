package com.example.dagger2test.dragonball.songoku

import com.example.dagger2test.dragonball.*
import dagger.Module
import dagger.Provides

@Module
class SongokuModule {

//    @Provides
//    fun provideCharacter(builder: CharacterComponent.Builder) : Character {
//        return Character(builder)
//    }

    @Provides
    @Name
    fun provideName(): String {
        return "손오공"
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

    @Provides
    @Kamehameha
    fun provideKamehameha() : String{
        return "에~네~르~기... 파앗!!!!!"
    }

    @Provides
    @SolarFlare
    fun provideSolarFlare(): String{
        return "태양권!!!!"
    }

    @Provides
    @Teleportation
    fun provideTeleportation() :String {
        return "순간이동...푸슛"
    }

}