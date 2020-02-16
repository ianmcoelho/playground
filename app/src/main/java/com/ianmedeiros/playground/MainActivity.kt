package com.ianmedeiros.playground

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ianmedeiros.featuremodule1.Feature1Activity
import com.ianmedeiros.featuremodule2.Feature2Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFeature1.setOnClickListener {
            startActivity(Intent(this, Feature1Activity::class.java))
        }

        buttonFeature2.setOnClickListener {
            startActivity(Intent(this, Feature2Activity::class.java))
        }
    }
}
