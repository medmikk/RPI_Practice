package com.medvedev.rpi_practice10_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BlankFragment2 : Fragment() {

    override fun onCreateView(  inflater: LayoutInflater,
                                container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    companion object { fun newInstance() = BlankFragment2 }
}