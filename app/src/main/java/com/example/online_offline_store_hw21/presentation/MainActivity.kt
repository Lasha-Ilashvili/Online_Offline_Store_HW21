package com.example.online_offline_store_hw21.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.online_offline_store_hw21.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}