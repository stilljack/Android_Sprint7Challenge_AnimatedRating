package com.example.sprint3.customViews

import android.content.Context
import android.graphics.drawable.Animatable
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.sprint3.R
import kotlinx.android.synthetic.main.ratingview.view.*
import com.example.sprint3.activities.MainActivity
import com.example.sprint3.model.ItemsRepository.Companion.list


class RatingView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {
//class RatingView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {
override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
}
companion object {
    var finalRating:Int = 5
    var ida:Int =0
}

    fun setRating(rating: Int) {
        finalRating=rating
        setInitial(finalRating)
    }
    fun setidref(idref: Int) {
        ida=idref.toInt()
    }
    init {
// var test =RelativeLayout.CENTER_VERTICAL
       // val star1:ImageView = LayoutInflater.from(context).inflate(R.layout.ratingview, this, true) as ImageView
    // val imageLayoutParams = LayoutParams(100, 200)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.RatingView)
        var testString = attributes.getString(R.styleable.RatingView_example)
 //       Toast.makeText(context, testString, Toast.LENGTH_SHORT).show()
        attributes.recycle()
        Log.i("is it working?", finalRating.toString())


        inflate(context, R.layout.ratingview, this)
        val star1:ImageView = findViewById(R.id.star1)
        val star2:ImageView = findViewById(R.id.star2)
        val star3:ImageView = findViewById(R.id.star3)
        val star4:ImageView = findViewById(R.id.star4)
        val star5:ImageView = findViewById(R.id.star5)
 invalidate()

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





        }
    fun setInitial (pos:Int){
        val starFull = ContextCompat.getDrawable(context, R.drawable.redtoblack)
        val starEmpty = ContextCompat.getDrawable(context, R.drawable.blacktored)
        for (i in 1 .. finalRating) {
            when (i){
                1 -> star1.setImageDrawable(starFull)
                2 -> star2.setImageDrawable(starFull)
                3 ->star3.setImageDrawable(starFull)
                4 -> star4.setImageDrawable(starFull)
                5 ->star5.setImageDrawable(starFull)
            }
        }
        for (i in finalRating+1 .. 5) {
            when (i) {
                1 -> star1.setImageDrawable(starEmpty) /// this should never trigger...
                2 -> star2.setImageDrawable(starEmpty)
                3 -> star3.setImageDrawable(starEmpty)
                4 -> star4.setImageDrawable(starEmpty)
                5 -> star5.setImageDrawable(starEmpty)
            }
        }
            (starFull as Animatable).start()
            (starEmpty as Animatable).start()
    }
    fun startAnimation (position:Int) {
        val starFull = ContextCompat.getDrawable(context, R.drawable.redtoblack)
        val starEmpty = ContextCompat.getDrawable(context, R.drawable.blacktored)
        if (position == 1) {
            star1.setImageDrawable(starFull)
            star2.setImageDrawable(starEmpty)
            star3.setImageDrawable(starEmpty)
            star4.setImageDrawable(starEmpty)
            star5.setImageDrawable(starEmpty)
            (starFull as Animatable).start()
            (starEmpty as Animatable).start()
            invalidate()
            finalRating=1
        }
        else if(position == 2) {
            star1.setImageDrawable(starFull)
            star2.setImageDrawable(starFull)
            star3.setImageDrawable(starEmpty)
            star4.setImageDrawable(starEmpty)
            star5.setImageDrawable(starEmpty)
            (starFull as Animatable).start()
            (starEmpty as Animatable).start()
            invalidate()
            finalRating=2
        }
        else if(position == 3) {
            star1.setImageDrawable(starFull)
            star2.setImageDrawable(starFull)
            star3.setImageDrawable(starFull)
            star4.setImageDrawable(starEmpty)
            star5.setImageDrawable(starEmpty)
            (starFull as Animatable).start()
            (starEmpty as Animatable).start()
            invalidate()
            finalRating=3
        }
            else if (position == 4) {
                star1.setImageDrawable(starFull)
                star2.setImageDrawable(starFull)
                star3.setImageDrawable(starFull)
                star4.setImageDrawable(starFull)
                star5.setImageDrawable(starEmpty)
            (starFull as Animatable).start()
            (starEmpty as Animatable).start()
            invalidate()
            finalRating=4
            }
            else if (position == 5) {
                star1.setImageDrawable(starFull)
                star2.setImageDrawable(starFull)
                star3.setImageDrawable(starFull)
                star4.setImageDrawable(starFull)
                star5.setImageDrawable(starFull)
            (starFull as Animatable).start()
            (starEmpty as Animatable).start()
            invalidate()
            finalRating=5
            }
        // will get the position interacted with, then adjust the stars up or down based on the position and state of the stars at said position
        //THEN we can either write directly to ItemsRepository.list or create a seperate function to handle book keeping
        cleanup()
        Log.i("testtest","d")
    }

    fun cleanup(){
        list[ida].rating= finalRating
        MainActivity.adapter!!.notifyItemChanged(ida)
    }
    }

