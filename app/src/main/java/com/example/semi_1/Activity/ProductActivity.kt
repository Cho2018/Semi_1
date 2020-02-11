package com.example.semi_1.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.semi_1.R
import kotlinx.android.synthetic.main.toolbar_product.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        var title = intent.getStringExtra("title")
        txt_toolbar_product_title.text = title

        btn_toolbar_product_like.setOnClickListener {
            btn_toolbar_product_like.isSelected = !btn_toolbar_product_like.isSelected
        }

        btn_toolbar_product_back.setOnClickListener {
            finish()
        }
    }
}
