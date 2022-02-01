package com.nandini.android.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_userName : TextView=findViewById<TextView>(R.id.username)
        val score : TextView=findViewById(R.id.score)
        val btn_finish : Button =findViewById<Button>(R.id.btn_finish)

        tv_userName.text=intent.getStringExtra(Constants.USER_NAME)
        val totalQuestion=intent.getIntExtra(Constants.TOTAL_QUES,0)
        val correctAns=intent.getIntExtra(Constants.CORRECT_ANS,0)

        score.text="Your score is $correctAns out of $totalQuestion"

        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}