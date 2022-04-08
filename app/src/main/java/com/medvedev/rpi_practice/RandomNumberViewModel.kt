package com.medvedev.rpi_practice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomNumberViewModel:ViewModel() {
    val currentRandomNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun generateRandomNumber() {
        currentRandomNumber.value = (0..50).random()
    }
}