package com.techk.pixar.ui.activities

import android.view.LayoutInflater
import com.techk.pixar.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun initViews() {

    }

    override fun setObservers() {

    }

}