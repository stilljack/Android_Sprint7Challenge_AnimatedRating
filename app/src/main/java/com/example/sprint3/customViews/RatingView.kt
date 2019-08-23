package com.example.sprint3.customViews

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.sprint3.R


class RatingView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

companion object {
    fun startAnimation (position:Int) {
        // will get the position interacted with, then adjust the stars up or down based on the position and state of the stars at said position
        //THEN we can either write directly to ItemsRepository.list or create a seperate function to handle book keeping
        Log.i("testtest","$position")
    }
}

    init {
// var test =RelativeLayout.CENTER_VERTICAL
       // val star1:ImageView = LayoutInflater.from(context).inflate(R.layout.ratingview, this, true) as ImageView
    // val imageLayoutParams = LayoutParams(100, 200)

  //
     inflate(context, R.layout.ratingview, this)
        val star1:ImageView = findViewById(R.id.star1)
        val star2:ImageView = findViewById(R.id.star2)
        val star3:ImageView = findViewById(R.id.star3)
        val star4:ImageView = findViewById(R.id.star4)
        val star5:ImageView = findViewById(R.id.star5)

     star1.setOnClickListener{
         startAnimation(1)
     }
        star2.setOnClickListener{
            startAnimation(2)
        }
        star3.setOnClickListener{
            startAnimation(3)
        }
        star4.setOnClickListener{
            startAnimation(4)
        }
        star5.setOnClickListener{
            startAnimation(5)
        }







       /* star1.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                android.R.drawable.ic_media_previous
            )
        )
        star1.setOnClickListener {
            startAnimation(1)
        }



        star1.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                android.R.drawable.ic_btn_speak_now
            )
        )
        star2.setOnClickListener {
            startAnimation(2)
        }


        star1.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                android.R.drawable.ic_lock_lock
            )
        )
        star4.setOnClickListener {
            startAnimation(3)
        }

        star1.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                android.R.drawable.ic_lock_lock
            )
        )
        star5.setOnClickListener {
            startAnimation(3)
        }*/




       // star1.layoutParams = imageLayoutParams
      //  star2.layoutParams = imageLayoutParams
      //  star3.layoutParams = imageLayoutParams
        }
    }

