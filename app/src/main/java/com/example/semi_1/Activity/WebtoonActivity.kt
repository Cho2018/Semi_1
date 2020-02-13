package com.example.semi_1.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.semi_1.R
import kotlinx.android.synthetic.main.toolbar_webtoon.*
import org.jetbrains.anko.startActivity

class WebtoonActivity : AppCompatActivity() {

    lateinit var title: String
    var product_id = -1
    var episode_id = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webtoon)

        configureTitleBar()
    }

    private fun configureTitleBar() {
        title = intent.getStringExtra("title")
        product_id = intent.getIntExtra("product_id", -1)
        episode_id = intent.getIntExtra("episode_id", -1)

        if(product_id == -1 || episode_id == -1) finish()

        txt_toolbar_webtoon_title.text = title

        btn_toolbar_webtoon_comment.setOnClickListener {
            startActivity<CommentActivity>()
        }

        btn_toolbar_webtoon_back.setOnClickListener {
            finish()
        }
    }
}
