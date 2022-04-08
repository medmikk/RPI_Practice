package com.medvedev.rpi_practice6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var msg: MutableLiveData<String> = MutableLiveData()

    fun setValue( editTextValue: String,
        checkBoxValue: String,
        toggleButtonValue: String,
        radioButtonValue: String) {
        msg.value = """
            EditText: $editTextValue
            CheckBox: $checkBoxValue
            ToggleButton: $toggleButtonValue
            RadioGroup: $radioButtonValue
        """.trimIndent()
    }
}