package com.example.dagger2test

import com.example.dagger2test.dragonball.Character
import com.example.dagger2test.dragonball.CharacterComponent
import com.example.dagger2test.dragonball.DaggerCharacterComponent
import com.example.dagger2test.dragonball.songoku.DaggerSongokuComponent
import com.example.dagger2test.dragonball.songoku.Songoku
import com.example.dagger2test.dragonball.vegeta.DaggerVegetaComponent
import com.example.dagger2test.dragonball.vegeta.Vegeta
import org.junit.Test

class DragonballTest {
    @Test
    fun testSongoku() {
        val songoku = Songoku()
        val vegeta = Vegeta() //FOO
        val characterComponent = DaggerCharacterComponent.create() //A
        val vegetaComponent = DaggerVegetaComponent.builder()
            .characterComponent(characterComponent)
            .build()

        DaggerSongokuComponent.create()
            .inject(songoku)

        vegetaComponent.inject(vegeta)


//        println("${songoku.character.walk}")
        println("나는 ${songoku.name}이다!!!")
        println("HP -> ${songoku.hp}")
        println("KI -> ${songoku.ki}")
        println("Skil -> ${songoku.kamehameha}")
        println("Skil -> ${songoku.solarFlare}")
        println("Skil -> ${songoku.teleportation}")

        println()
        
        println("${vegeta.walk}")
        println("나는 슈퍼 ${vegeta.name}이다!!!")
        println("HP -> ${vegeta.hp}")
        println("KI -> ${vegeta.ki}")
        println("Skil -> ${vegeta.galigFlare}")
        println("Skil -> ${vegeta.finalFlash}")
        println("Skil -> ${vegeta.superSaiyan1}")
    }
}