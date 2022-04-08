package com.medvedev.rpi_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.medvedev.rpi_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RandomNumberViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        SingletonManager.getInstance().setState(RandomNumberViewModel())
        viewModel = SingletonManager.getInstance().getState()
        initView()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.currentRandomNumber.observe(this, Observer {
            binding.rndNum.setText(it.toString())
        })
    }

    private fun initView() {
        binding.getRnd.setOnClickListener {
            viewModel.generateRandomNumber()
        }
    }
}



