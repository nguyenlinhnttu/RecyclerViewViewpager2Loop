package com.android.recyclerviewviewpager2loop.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.android.recyclerviewviewpager2loop.R

/**
 * Created by NguyenLinh on 30,August,2022
 */
class FoodCardFragment : Fragment() {
    companion object {
        fun newInstance (foodEntity: FoodEntity) :FoodCardFragment{
            val fragment = FoodCardFragment()
            val bundle = Bundle()
            bundle.putSerializable("Food_Arg",foodEntity)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_food_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val food  = arguments?.getSerializable("Food_Arg") as FoodEntity
        if (food.id != -1){
            view.findViewById<ImageView>(R.id.image).setImageResource(food.image)
            view.findViewById<TextView>(R.id.tv_name).text = food.name
        }
    }
}
