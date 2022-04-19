package ru.samsung.itschool.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import ru.samsung.itschool.myapplication.R

class BlankFragment6 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View=inflater.inflate(R.layout.fragment_blank6, container, false)
        var btngo: Button =view.findViewById(R.id.buttonToAct2)
        btngo.setOnClickListener(View.OnClickListener { view -> view.findNavController().navigate(R.id.action_blankFragment6_to_main2Activity)})
        var btnBack: Button =view.findViewById(R.id.buttonToAct2_back)
        btnBack.setOnClickListener(View.OnClickListener { view -> view.findNavController().popBackStack()})
        findNavController().previousBackStackEntry?.savedStateHandle?.set("result_from_activity", "ответные данные")
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            BlankFragment6()
    }
}