package com.nandini.android.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionList : ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int =0

    private var mUserName : String?=null
    private var mCorrectAnswers: Int = 0

    private var tv_ques : TextView? = null
    private var img_flag : ImageView?=null
    private var progressBar : ProgressBar?=null
    private var tv_progress : TextView?=null

    private var op1 : TextView?=null
    private var op2 : TextView?=null
    private var op3 : TextView?= null
    private var op4 : TextView?=null
    private var btn_submit : Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question2)

         mUserName=intent.getStringExtra(Constants.USER_NAME)

         tv_ques=findViewById(R.id.tv_ques)
         img_flag=findViewById(R.id.img_flag)
        progressBar=findViewById(R.id.progessBar)
        tv_progress=findViewById(R.id.tv_progress)
        op1=findViewById(R.id.op1)
        op2=findViewById(R.id.op2)
        op3=findViewById(R.id.op3)
        op4=findViewById(R.id.op4)
        btn_submit=findViewById(R.id.btn_submit)


        mQuestionList=Constants.getQuestion()
        setQuestion()

        op1?.setOnClickListener(this)
        op2?.setOnClickListener(this)
        op3?.setOnClickListener(this)
        op4?.setOnClickListener(this)
        btn_submit?.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.op1->{
                op1?.let { selectedOptionView(it,1) }
            }
            R.id.op2->{
                op2?.let{selectedOptionView(it,2)}
            }
            R.id.op3->{
                op3?.let{selectedOptionView(it,3)}
            }
            R.id.op4->{
                op4?.let{selectedOptionView(it,4)}
            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition==0)
                {
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            setQuestion()}
                        else->{
                            val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUES,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                 }else{
                    val question=mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.Ans !=mSelectedOptionPosition)
                    {
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_background)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.Ans,R.drawable.correct_option_background)

                    if (mCurrentPosition==mQuestionList!!.size){
                        btn_submit?.text="FINISH"
                    }else{
                        btn_submit?.text="GO TO THE NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }
    }

    private fun setQuestion() {

        var q: Question = mQuestionList!!.get(mCurrentPosition - 1)
        defaultOptionView()

        if(mCurrentPosition==mQuestionList!!.size){
            btn_submit?.text="FINISH"
        }else{
            btn_submit?.text="SUBMIT"
        }

        progressBar?.progress = mCurrentPosition
        tv_progress?.text = "$mCurrentPosition/${progressBar?.max}"
        tv_ques?.text = q.ques
        img_flag?.setImageResource(q.image)
        op1?.text = q.op1
        op2?.text = q.op2
        op3?.text = q.op3
        op4?.text = q.op4

    }

    fun defaultOptionView(){
        var options = ArrayList<TextView>()
        op1?.let { options.add(0,it) }
        op2?.let { options.add(1,it) }
        op3?.let { options.add(2,it) }
        op4?.let { options.add(3,it) }

        for (option in options)
        {
            option.setTextColor(ContextCompat.getColor(this,R.color.black))
            option.setTypeface(ResourcesCompat.getFont(this,R.font.font10))
            option.background=ContextCompat.getDrawable(this,R.drawable.option_background)
        }

    }

    fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(ResourcesCompat.getFont(this,R.font.font10))
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_background)

    }



    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{op1?.background=ContextCompat.getDrawable(this,drawableView)}
            2->{op2?.background=ContextCompat.getDrawable(this,drawableView)}
            3->{op3?.background=ContextCompat.getDrawable(this,drawableView)}
            4->{op4?.background=ContextCompat.getDrawable(this,drawableView)}
        }
    }


}