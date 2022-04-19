package com.medvedev.rpi_practice9_1

data class Person(var name: String, var sex: String, var phoneNumber: String) {
    override fun toString(): String {
        return """name = $name, sex = $sex, number = $phoneNumber"""
    }
}