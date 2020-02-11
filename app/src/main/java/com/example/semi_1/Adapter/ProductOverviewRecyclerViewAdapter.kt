package com.example.semi_1.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.semi_1.R

class ProductOverviewRecyclerViewAdapter {
    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var container = itemView.findViewById(R.id.ll_rv_item_product_overview_container) as LinearLayout
        var img_thumbnail = itemView.findViewById(R.id.img_rv_item_product_overview_thumbnail) as ImageView
        var title = itemView.findViewById(R.id.txt_rv_item_product_overview_title) as TextView
        var num_like = itemView.findViewById(R.id.txt_rv_item_product_overview_numlike) as TextView
        var author = itemView.findViewById(R.id.txt_rv_item_product_overview_author) as TextView
    }
}
