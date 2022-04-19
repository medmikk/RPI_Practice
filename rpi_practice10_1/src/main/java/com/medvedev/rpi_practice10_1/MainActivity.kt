package com.medvedev.rpi_practice10_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.medvedev.rpi_practice10_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var tempo: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClick()
    }

    private fun setOnClick(){
        binding.button?.setOnClickListener { swapFragments() }
    }

    private fun swapFragments(){
        tempo = if(tempo){
            supportFragmentManager.beginTransaction().replace(R.id.fr1, BlankFragment()).commit()
            supportFragmentManager.beginTransaction().replace(R.id.fr2, BlankFragment2()).commit()
            false
        } else{
            supportFragmentManager.beginTransaction().replace(R.id.fr2, BlankFragment()).commit()
            supportFragmentManager.beginTransaction().replace(R.id.fr1, BlankFragment2()).commit()
            true
        }
    }
}