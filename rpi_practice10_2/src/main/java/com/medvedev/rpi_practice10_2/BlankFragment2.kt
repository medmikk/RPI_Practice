package com.medvedev.rpi_practice10_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer


class BlankFragment2 : Fragment() {

    private var viewModel = MyViewModel.getMyViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fr: View? = view.findViewById(R.id.fragmentF2)
        viewModel.currentColor.observe(viewLifecycleOwner, Observer {
            fr?.setBackgroundColor(it)
        })
    }

}