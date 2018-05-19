package com.my.ecc

import java.io.File
import java.time.LocalDateTime
import java.time.ZoneOffset

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            var line = File("license.dat").readText().trim()
            val decrypted = Ecc.decryptString(line)
            println("decrypted: $decrypted")
        } catch(e: Exception) {
            println("exception reading license file: ${e.message}")
        }
        var expire = LocalDateTime.now().plusDays(3).plusHours(2).toEpochSecond(ZoneOffset.UTC)
        var data = Ecc.encryptString("{ id: 105, expire: $expire, name: ultimate_edition, user: north star }")
        println("3d:  $data")
        expire = LocalDateTime.now().plusDays(10).plusHours(2).toEpochSecond(ZoneOffset.UTC)
        data = Ecc.encryptString("{ id: 105, expire: $expire, name: ultimate_edition, user: north star }")
        println("10d: $data")
        expire = LocalDateTime.now().plusDays(30).plusHours(2).toEpochSecond(ZoneOffset.UTC)
        data = Ecc.encryptString("{ id: 105, expire: $expire, name: ultimate_edition, user: north star }")
        println("30d: $data")
        expire = LocalDateTime.now().plusDays(60).plusHours(2).toEpochSecond(ZoneOffset.UTC)
        data = Ecc.encryptString("{ id: 105, expire: $expire, name: ultimate_edition, user: north star }")
        println("60d: $data")
    }
}

