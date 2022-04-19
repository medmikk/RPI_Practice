package com.medvedev.rpi_practice11_1

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import java.util.*

class MyTimePickerDialog (private val checkedItems: Array<Boolean>, fID: Int, fManager : FragmentManager): DialogFragment() {
    private val calendar = Calendar.getInstance();
    private val fragment: BlankFragment = fManager.findFragmentById(fID) as BlankFragment
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return TimePickerDialog(activity, {
                _, hour, minute ->
            fragment.setState(
                hour,
                minute,
                checkedItems[0],
                checkedItems[1]
            )
        }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), false)
    }
}