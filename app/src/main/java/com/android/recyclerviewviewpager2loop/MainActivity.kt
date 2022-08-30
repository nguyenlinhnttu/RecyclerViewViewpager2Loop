package com.android.recyclerviewviewpager2loop

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerViewCircular()
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