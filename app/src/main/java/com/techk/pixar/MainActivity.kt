package com.techk.pixar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.techk.pixar.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BuildConfig.API_KEY

    }

}