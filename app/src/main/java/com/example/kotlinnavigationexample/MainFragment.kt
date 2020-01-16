package com.example.kotlinnavigationexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(),View.OnClickListener {

     var  navController:NavController?=null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view);
        view.findViewById<Button>(R.id.view_transaction_button).setOnClickListener (this)
        view.findViewById<Button>(R.id.send_money_button).setOnClickListener (this)
        view.findViewById<Button>(R.id.view_balance_button).setOnClickListener (this)
    }

    override fun onClick(v: View?) {

        when(v!!.id){

            R.id.view_transaction_button-> navController!!.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
            R.id.send_money_button->navController!!.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
            R.id.view_balance_button->navController!!.navigate(R.id.action_mainFragment_to_viewBalanceFragment)

        }

    }
}
