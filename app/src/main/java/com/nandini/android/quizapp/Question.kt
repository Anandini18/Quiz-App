package com.nandini.android.quizapp

data class Question(
    val id : Int,
    val ques : String,
    val image : Int,
    val op1 : String,
    val op2 : String,
    val op3 : String,
    val op4 : String,
    val Ans : Int
)
