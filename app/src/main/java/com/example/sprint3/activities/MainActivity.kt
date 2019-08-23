package com.example.sprint3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3.R
import com.example.sprint3.fragments.RatingFragment
import com.example.sprint3.model.Items
import com.example.sprint3.model.ItemsRepository
import com.example.sprint3.model.ItemsRepository.Companion.list
import com.example.sprint3.recyclerView.Adapter
import kotlinx.android.synthetic.main.activity_main.*

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
//.2. reyclerview working, if ugly TODO: fix xml for recycler view
//.3. dialog fragment added, TODO: EDIT XML TO PROPERLY DISPLAY item.title plus item.rating as ratingview
//.4. Adding customview:RatingView

class MainActivity : AppCompatActivity(), RatingFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(item: Items) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ItemsRepository.startUp()
        println("${list}")


        //recycle_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        var adapter = Adapter(list)

        recycle_view.setHasFixedSize(true)
        recycle_view.layoutManager = manager
        recycle_view.adapter = adapter

        //TODO REMOVE THIS TEST
        /*btn_button.setOnClickListener {
            val fragment =
                RatingFragment()
            supportFragmentManager.beginTransaction()
                .add(fragment, "test")
                .commit()
        }*/

    }
}
