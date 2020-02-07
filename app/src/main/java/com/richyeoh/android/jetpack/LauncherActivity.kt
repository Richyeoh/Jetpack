package com.richyeoh.android.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.richyeoh.android.jetpack.R
import com.richyeoh.android.jetpack.databinding.ActivityLauncherBinding

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityLauncherBinding>(this, R.layout.activity_launcher)
    }
}
