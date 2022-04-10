package com.medvedev.rpi_practice6_2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.medvedev.rpi_practice6_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val solutionName = resources.getStringArray(R.array.SolutionName)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, solutionName)
        binding.spinner.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        getSolution(solutionName)

        viewModel.solution.observe(this) {
            binding.solution.text = it.toString()
        }
    }

    private fun getSolution(solutionName: Array<String>) {
        binding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.getSolution.setOnClickListener {
                    try {
                        val sideA: Double = binding.sideA.text.toString().toDouble()
                        val sideB: Double = binding.sideB.text.toString().toDouble()
                        val sideC: Double = binding.sideC.text.toString().toDouble()
                        viewModel.getSolution(sideA, sideB, sideC, solutionName[p2])
                    } catch (e: NumberFormatException) {
                        binding.solution.text = "Ошибка ввода"
                    }
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}


