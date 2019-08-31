package com.namlu.airtasker

import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_base.*

class FeedListActivity : BaseActivity() {

    private lateinit var buttonTest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_list)

        buttonTest = findViewById(R.id.button_test)

        // test showProgressBar()
        buttonTest.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                if (progress_bar.visibility == View.VISIBLE) {
                    showProgressBar(false)
                } else {
                    showProgressBar(true)
                }
            }

        })
    }
}
