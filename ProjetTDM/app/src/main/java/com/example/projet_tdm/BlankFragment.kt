package com.example.projet_tdm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_blank.view.*


class BlankFragment : Fragment() {
    lateinit var layoutView:View;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayOrdersCount()
        view?.ongoingCard?.setOnClickListener { view ->
            goToOrdersList("ongoing")
        }
        view.lateCard?.setOnClickListener { view ->
            goToOrdersList("late")
        }
        view?.deliveredCard?.setOnClickListener { view ->
            goToOrdersList("delivered")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.layoutView = inflater.inflate(R.layout.fragment_blank, container, false)
        return this.layoutView
    }



    fun displayOrdersCount(){
        view?.ongoingOrdersText?.text  = AuthService.user.ongoingOrdersCount.toString()
        view?.deliveredOrdersText?.text = AuthService.user.deliveredOrdersCount.toString()
        view?.lateOrdersText?.text = AuthService.user.lateOrdersCount.toString()
    }

    fun goToOrdersList(status:String){
        var bundle= bundleOf( "status" to status)
        view?.findNavController()?.navigate(R.id.action_blankFragment_to_orderListFragment,bundle)
    }

}