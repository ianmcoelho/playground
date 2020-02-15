package com.ianmedeiros.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ianmedeiros.featuremodule1.FeatureTest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FeatureTest().foo()
    }
}
