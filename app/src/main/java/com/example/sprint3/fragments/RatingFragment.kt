package com.example.sprint3.fragments

import android.content.Context

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView

import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3.activities.MainActivity
import com.example.sprint3.customViews.RatingView.Companion.finalRating
import com.example.sprint3.model.Items
import com.example.sprint3.model.ItemsRepository.Companion.list
import com.example.sprint3.recyclerView.Adapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_rating.*
import kotlinx.android.synthetic.main.list_layout.*

private const val RATINGID = "ratingid"
private const val TRANSFERFRAG = "UNUSED"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DetailsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class RatingFragment : DialogFragment() {

    // TODO: Rename and change types of parameters
    private var ratingID: Int? = null ?: 0
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var id = arguments?.getInt(MainActivity.ITEM_KEY) ?: "AWW CRAP" as Int

        ratingTest=list[id].rating
        nameTest=list[id].name
        idTrack=id
        return inflater.inflate(com.example.sprint3.R.layout.fragment_rating, container, false)




    }
    //
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id = arguments?.getInt(MainActivity.ITEM_KEY) as Int

        Log.i("lognow", "name = ${list[id].name}id = ${id.toString()}")


        edit.setText(list[idTrack].name)


       // if (edit.text.toString()==list[id])
        btn.setOnClickListener {
            list.add(Items(edit.text.toString(), finalRating))
           // recycle_view.adapter?.notifyItemInserted(id) ?: 0
            getActivity()!!.getSupportFragmentManager().popBackStack();
        }
        btn2.setOnClickListener {
            list.removeAt(id)
            getActivity()!!.getSupportFragmentManager().popBackStack();
        }
       // relative.rating= list[id].rating
        //relative.rating
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: RETURN HERE JACK
        fun onFragmentInteraction(item: Items)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        var ratingTest = 6
        var nameTest ="wrong"
        var idTrack =0
        fun newInstance(param1: String, param2: String) =
            RatingFragment().apply {
                arguments = Bundle().apply {
                    putString(RATINGID, param1)
                    putString(TRANSFERFRAG, param2)


                }
            }
    }
}