package com.android.recyclerviewviewpager2loop

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewviewpager2loop.recyclerview.CircularScrollListener
import com.android.recyclerviewviewpager2loop.recyclerview.InfinityAdapter
import com.android.recyclerviewviewpager2loop.viewpager.FoodCardAdapter
import com.android.recyclerviewviewpager2loop.viewpager.FoodEntity
import com.android.recyclerviewviewpager2loop.viewpager.InfiniteViewPager2
import com.android.recyclerviewviewpager2loop.viewpager.InfiniteViewPager2Adapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerViewCircular()
        setUpViewPager2()
    }

    private fun setUpViewPager2() {
        val foods = mutableListOf<FoodEntity>()
        foods.add(FoodEntity(-1,"Food 1 (FAKE FIST ITEM)", R.drawable.image_1))
        foods.add(FoodEntity(0,"Food 1", R.drawable.image_1))
        foods.add(FoodEntity(1, "Food 2", R.drawable.image_2))
        foods.add(FoodEntity(2,"Food 3", R.drawable.image_1))
        foods.add(FoodEntity(3,"Food 4", R.drawable.image_2))
        foods.add(FoodEntity(-1,"Food 5 (FAKE LAST ITEM)", R.drawable.image_1))
        findViewById<InfiniteViewPager2>(R.id.infinite_view_pager2).apply {
            //setMargin()
            setAdapter(FoodCardAdapter(foods, this@MainActivity))
           // setAdapter(InfiniteViewPager2Adapter(listOf("1", "2", "3", "4","5")))
            addScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        Log.d("Tracking", "I am at item index ${getCurrentItem()}")
                    }
                }
            })
        }
    }

    private fun setUpRecyclerViewCircular() {
        findViewById<RecyclerView>(R.id.infinite_recyclerview).apply {
            adapter = InfinityAdapter(object : InfinityAdapter.ItemClickListener {
                override fun onPosition(position: Int) {
                    Toast.makeText(
                        this@MainActivity,
                        "Position Clicked : $position",
                        Toast.LENGTH_SHORT
                    ).show()
                    //scrollToPosition(90)
                }
            })
            PagerSnapHelper().attachToRecyclerView(this)
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL, false
            )
            addOnScrollListener(CircularScrollListener())
        }
    }
}