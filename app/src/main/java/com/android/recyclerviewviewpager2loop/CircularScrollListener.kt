package com.android.recyclerviewviewpager2loop

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by NguyenLinh on 30,August,2022
 */
open class CircularScrollListener : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val firstItemVisible: Int = layoutManager.findFirstVisibleItemPosition()
        if (firstItemVisible != 1 && (firstItemVisible % InfinityAdapter.numberItems == 1)) {
            Log.d("case 3 ", "last item")
            layoutManager.scrollToPosition(1)
        } else if (firstItemVisible != 1 && firstItemVisible > InfinityAdapter.numberItems && (firstItemVisible % InfinityAdapter.numberItems > 1)) {
            Log.d("case 2 ", "scroll to position ${firstItemVisible % InfinityAdapter.numberItems}")
            layoutManager.scrollToPosition(firstItemVisible % InfinityAdapter.numberItems)
        } else if (firstItemVisible == 0) {
            Log.d("case 1 ", "first init scroll to center")
            layoutManager.scrollToPositionWithOffset(
                InfinityAdapter.numberItems,
                -recyclerView.computeHorizontalScrollOffset()
            )
        }
    }
}