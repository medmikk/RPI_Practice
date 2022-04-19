package com.medvedev.rpi_practice10_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class BlankFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var viewModel = MyViewModel.getMyViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val colorNames: Array<String> = resources.getStringArray(R.array.colorNames)
        val colorValues: IntArray = resources.getIntArray(R.array.colorValues)

        recyclerView = view.findViewById(R.id.recyclerViewGgs)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CustomAdapter(colorNames,colorValues,viewModel)

        super.onViewCreated(view, savedInstanceState)
    }
}