package com.nandini.android.quizapp

object Constants {

    const val USER_NAME : String ="user_name"
    const val TOTAL_QUES : String ="total_ques"
    const val CORRECT_ANS : String ="correct_ans"

    fun getQuestion() : ArrayList<Question>
    {
        val quesList = ArrayList<Question>()
        val ques1=Question(1,"What country does this flag belongs to ? ",R.drawable.india,
        "India","Canada","Australia","France",1)
        quesList.add(ques1)

        val ques2=Question(2,"What country does this flag belongs to ? ",R.drawable.france,
            "United States","China","Germany","France",4)
        quesList.add(ques2)

        val ques3=Question(3,"What country does this flag belongs to ? ",R.drawable.canada,
            "India","Canada","Australia","France",2)
        quesList.add(ques3)

        val ques4=Question(4,"What country does this flag belongs to ? ",R.drawable.download,
            "China","Germany","Australia","France",3)
        quesList.add(ques4)

        val ques5=Question(5,"What country does this flag belongs to ? ", R.drawable.uss,
            "United States","India","Canada","Australia",1)
        quesList.add(ques5)

        val ques6=Question(6,"What country does this flag belongs to ? ",R.drawable.germany,
            "United States","China","Germany","Japan",3)
        quesList.add(ques6)

        val ques7=Question(7,"What country does this flag belongs to ? ",R.drawable.japan,
            "Australia","France","Germany","Japan",4)
        quesList.add(ques7)

        val ques8=Question(8,"What country does this flag belongs to ? ",R.drawable.china,
            "Canada","China","Germany","Japan",2)
        quesList.add(ques8)

        val ques9=Question(9,"What country does this flag belongs to ? ",R.drawable.russia,
            "Japan","Russia","Germany","Japan",2)
        quesList.add(ques9)

        val ques10=Question(10,"What country does this flag belongs to ? ",R.drawable.pakistan,
            "Germany","United States","China","Pakistan",4)
        quesList.add(ques10)
 return quesList
    }

}