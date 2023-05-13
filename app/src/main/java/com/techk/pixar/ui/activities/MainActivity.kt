package com.techk.pixar.ui.activities

import android.os.Bundle
import com.techk.pixar.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initViews() {

    }

    override fun setObservers() {

    }

    override val binding: ActivityMainBinding
        get() = ActivityMainBinding.inflate(layoutInflater)

}