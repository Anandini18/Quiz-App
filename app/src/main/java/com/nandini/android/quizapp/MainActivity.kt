package com.nandini.android.quizapp


import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btn_start : Button =findViewById(R.id.btn_start)
        val et_name : EditText=findViewById(R.id.et_name)
        btn_start.setOnClickListener {
            if(et_name.text.isEmpty())
            {
                et_name.setError("")
                Toast.makeText(this, "Enter name",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,et_name.text.toString())
                startActivity(intent)
            }
        }


    }

}