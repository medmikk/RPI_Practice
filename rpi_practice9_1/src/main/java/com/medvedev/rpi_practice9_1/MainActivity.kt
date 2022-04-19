package com.medvedev.rpi_practice9_1

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.medvedev.rpi_practice9_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var mapper: ObjectMapper;
    private lateinit var binding: ActivityMainBinding
    private lateinit var data: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapper = jacksonObjectMapper()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //data = getAsset()
        data = getRaw()
        setOnItemSelected()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.spinner.setSelection(1)
    }

    private fun setOnItemSelected(){
        binding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                sortRV(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }

    private fun getAsset(): List<Person>{
        val fileName = "persons.json"
        val jsonString = application.assets.open(fileName).bufferedReader().use{
            it.readText()
        }
        return mapper.readValue(jsonString)
    }

    private fun getRaw(): List<Person>{
        val fileName = "persons_raw"
        val id: Int = resources.getIdentifier(fileName,
            "raw", packageName
        );
        val jsonString = resources.openRawResource(id).bufferedReader().use{
            it.readText()
        }
        return mapper.readValue(jsonString)
    }

    private fun sortRV(position: Int){
        when(position){
            0 -> {binding.recyclerView.adapter = RVAdapter(data.sortedBy { it.sex })}
            1 -> {binding.recyclerView.adapter = RVAdapter(data.sortedBy { it.name })}
            2 -> {binding.recyclerView.adapter = RVAdapter(data.sortedBy { it.phoneNumber })}
        }
    }
}