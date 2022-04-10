package com.medvedev.rpi_practice8_2

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.medvedev.rpi_practice8_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val regexGeo = Regex("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)\$")
    private val regexPhone = Regex("([+]79[0-9]{9})|(89[0-9]{9})")
    private val regexWeb = Regex("(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { handle() }
    }

    private fun handle(){
        val uri = binding.etUri.text.toString()
        if (uri.isNotEmpty()) {
            when {
                binding.rbMaps.isChecked -> if (check("maps", uri)) { openGeo(uri); return }
                binding.rbPhone.isChecked -> if (check("phone", uri)) { openPhone(uri); return }
                binding.rbWeb.isChecked -> if (check("web", uri)) { openBrowser(uri); return }
            }
            when {
                uri.matches(regexGeo) -> { openGeo(uri); return }
                uri.matches(regexPhone) -> { openPhone(uri); return }
                uri.matches(regexWeb) -> { openBrowser(uri); return }
                else -> Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun check(type : String, uri: String) : Boolean{
        val res = when (type) {
            "maps" -> uri.matches(regexGeo)
            "phone" -> uri.matches(regexPhone)
            "web" -> uri.matches(regexWeb)
            else -> false
        }
        if(!res) Toast.makeText(this, "Can't open in $type", Toast.LENGTH_SHORT).show()
        return res
    }


    private fun openBrowser(uri : String){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https:$uri")))
    }

    private fun openPhone(number : String){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this as Activity, Manifest.permission.CALL_PHONE))
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CALL_PHONE),1)
        try {
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:$number")))
        } catch (e : SecurityException){
            e.printStackTrace()
        }
    }

    private fun openGeo(coords : String){
        startActivity(Intent(Intent.ACTION_VIEW,
            Uri.parse("geo:$coords")))
    }
}