package com.matrix.fragmenttoactivityviceversa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matrix.fragmenttoactivityviceversa.databinding.FragmentTextChangeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentTextChange.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentTextChange : Fragment(), ActivityInterface {
    var binding:FragmentTextChangeBinding?=null
    var activityInterface:ActivityInterface?=null
    var activityTextChange:ActivityTextChange?=null
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        activityTextChange=activity as ActivityTextChange
        activityTextChange?.activityInterface=this
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentTextChangeBinding.inflate(layoutInflater)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.btnFragment?.setOnClickListener {
            if (binding?.etFragment?.text.toString().isEmpty()==true){
                binding?.etFragment?.error="Enter Something"
            }
            else{
                activityTextChange?.changeActivityText(binding?.etFragment?.text.toString())

            }
        super.onViewCreated(view, savedInstanceState)
    }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentTextChange.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentTextChange().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun changeFragmentText(text:String){
        binding?.btnFragment?.setText(text)



    }
}