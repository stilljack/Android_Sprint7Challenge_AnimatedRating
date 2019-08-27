package com.example.sprint3.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.sprint3.activities.MainActivity
import com.example.sprint3.activities.ReplaceFragmentListener
import com.example.sprint3.customViews.RatingView.Companion.finalRating
import com.example.sprint3.model.Items
import com.example.sprint3.model.ItemsRepository.Companion.list
import com.maciejkozlowski.fragmentutils_kt.getListenerOrThrowException
import kotlinx.android.synthetic.main.fragment_rating.*


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
    private var id: Int? = null ?: 0
    private var item: Items? = null ?: Items("failed",1)

    private var replaceFragmentListener: ReplaceFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var id = arguments?.getInt(MainActivity.ITEM_KEY) ?: 0
        var namecheck =arguments?.getString(MainActivity.ITEMTRANSFER)  ?: "AWW CRAP" as String
        for(i in list.size -1 downTo 0){
            if (list[i].name == namecheck){
                id = i

            }
            else if (i == 0 && list[i].name != namecheck) {
                //i don't believe this can ever trigger, but if it can.. sure whatever...
                id= list.size
                list.add(Items("new entry", 1))
            }
        }
        item= list[id]
        currentItemRating=list[id].rating
        nameTest=list[id].name
        idTrack=id
        return inflater.inflate(com.example.sprint3.R.layout.fragment_rating, container, false)




    }
    //
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("lognow", "name = ${list[idTrack].name}id = ${id.toString()}")

        relative.setidref(idTrack)
        edit.setText(item!!.name)
        relative.setRating(item!!.rating)
       // if (edit.text.toString()==list[id])
        btn.setOnClickListener {
            if (chkbx.isChecked) {
                list.removeAt(idTrack)
                MainActivity.adapter!!.notifyItemRemoved(idTrack)
                getActivity()!!.getSupportFragmentManager().popBackStack();
            }
            else if (list[idTrack].name==edit.text.toString()) {
                list[idTrack].rating= finalRating
                MainActivity.adapter!!.notifyItemChanged(idTrack)
                getActivity()!!.getSupportFragmentManager().popBackStack();
            }
            else {
                list.add(Items(edit.text.toString(), finalRating))
                MainActivity.adapter!!.notifyItemInserted(list.size)
                getActivity()!!.getSupportFragmentManager().popBackStack();
                // recycle_view.adapter?.notifyItemInserted(id) ?: 0
            }
        }


       // relative.rating= list[id].rating
        //relative.rating
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        replaceFragmentListener = getListenerOrThrowException()
    }

    override fun onDetach() {
        super.onDetach()
        replaceFragmentListener = null
    }

/*
    interface FragmentListener {
        // TODO: RETURN HERE JACK
        fun replaceFragmentListener(item: Items)
    }
*/

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
        var currentItemRating = 6
        var nameTest ="wrong"
        var idTrack =0
        fun newInstance(id: Int, item: Items) =
            RatingFragment().apply {
                arguments = Bundle().apply {
                    putInt(RATINGID, id)
                    putSerializable(TRANSFERFRAG, item)

                }
            }
    }
}