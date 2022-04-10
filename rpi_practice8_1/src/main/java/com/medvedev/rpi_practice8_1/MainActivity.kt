package com.medvedev.rpi_practice8_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.medvedev.rpi_practice8_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setOnClick()
    }

    private fun setOnClick(){
        binding.button.setOnClickListener {
            if(binding.etFrom.text.isNotEmpty() and binding.etTo.text.isNotEmpty()) {
                var start: Int = binding.etFrom.text.toString().toInt()
                var end: Int = binding.etTo.text.toString().toInt()
                if(start >= end){
                    binding.etFrom.setText("")
                    binding.etTo.setText("")
                    Toast.makeText(this, "Ошибка ввода", Toast.LENGTH_SHORT).show()
                } else{
                    val intent = Intent(this, QuestionActivity::class.java)
                    intent.putExtra("start", start)
                    intent.putExtra("end", end)
                    startActivity(intent)
                }
            }
        }
    }
}