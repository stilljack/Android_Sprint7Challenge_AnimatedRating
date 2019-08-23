package com.example.sprint3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sprint3.R
import com.example.sprint3.model.ItemsRepository
import com.example.sprint3.model.ItemsRepository.Companion.list

//.0.planning...

/*          stuff we'll nneed
*          Data class to collect added items and ratings "Items"
*            dialog fragment for displaying custom view "RatingDialogFrag" & text entry field and a button to submit & needed layouts
*           customeview class "RatingView"
*           Recyclerview adapter {implement next, off top of my head, an adapter and some layout
*
*       AND HORRIBLY HARD TO MAKE (for me) animated vector drawable
*       at least i don't have to work with onTouch -- that was rough last night
*
*           I've got a feeling I'm missing something from the instructions so back
*       to the whiteboard for another ten to continue planning
*                   ...maybe not
*
* */

//.1. model stuff added, Items is the mutablelist we'll use throughout, ItemsRepository.startUp() creates some dummy data to
// play with along the way

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ItemsRepository.startUp()
        println("${list}")
    }
}
