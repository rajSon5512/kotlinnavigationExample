package com.example.kotlinnavigationexample


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_choose_recipient.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    var navController:NavController?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        view.findViewById<TextInputEditText>(R.id.name_editview)
        view.findViewById<Button>(R.id.start_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.resent_buttom).setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.start_button->{

                if(!TextUtils.isEmpty(name_editview.text.toString())){

                    var bundle:Bundle= bundleOf("user_name" to name_editview.text.toString())
                    navController!!.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment,bundle)

                }

            }
            R.id.resent_buttom-> activity!!.onBackPressed()
        }

    }


}
