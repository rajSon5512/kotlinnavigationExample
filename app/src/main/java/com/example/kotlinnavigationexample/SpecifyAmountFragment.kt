package com.example.kotlinnavigationexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    var navController:NavController?=null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(arguments!=null){

            var user_name: String? = arguments!!.getString("user_name")
            Toast.makeText(context,""+user_name,Toast.LENGTH_LONG).show()
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)

        view.findViewById<Button>(R.id.send_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v!!.id){

            R.id.send_button->{
                navController!!.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment)
            }
            R.id.cancel_button-> activity!!.onBackPressed()
        }


    }

}
