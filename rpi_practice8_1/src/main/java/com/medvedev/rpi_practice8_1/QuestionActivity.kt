package com.medvedev.rpi_practice8_1

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.medvedev.rpi_practice8_1.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private enum class Question{
        EQUALS, LESS
    }

    private lateinit var binding : ActivityQuestionBinding
    private var start : Int = 0
    private var end : Int = 0
    private var middle : Int = 0
    private var quest : Question = Question.EQUALS

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        start = intent.getIntExtra("start", 0)
        end = intent.getIntExtra("end", 0)
        middle =(end + start) / 2

        setOnClick()
        printQuestion()
    }

    private fun printQuestion(){
        val question = when (quest){
            Question.EQUALS ->{ "Ваше число $middle?" }
            Question.LESS ->{ "Ваше число меньше $middle?" }
        }
        binding.tvQuestion.text = question
    }

    private fun setOnClick(){
        binding.btnNo.setOnClickListener { handle(false) }
        binding.btnYes.setOnClickListener { handle(true) }
    }

    private fun handle(ans : Boolean){
        if(end == start)
            win()
        if(quest == Question.EQUALS)
            if(ans)
                win()
            else {
                quest = Question.LESS
                printQuestion()
            }
        else{
            divideBorder(ans)
            quest = Question.EQUALS
        }
        printQuestion()
    }

    private fun divideBorder(toLeft : Boolean){
        if(toLeft)
            end = middle
        else
            start = middle
        middle = (end + start) / 2
    }

    private fun win(){
        Toast.makeText(this, "Ваше число $middle!", Toast.LENGTH_SHORT).show()
        finish()
    }
}