package com.example.playercount.mmo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.playercount.MyApplication
import com.example.playercount.R
import com.example.playercount.databinding.ActivityMmoactivityBinding

class MMOActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMmoactivityBinding
    private lateinit var viewModel: MMOViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmoactivity)

        binding = ActivityMmoactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as MyApplication
        viewModel = ViewModelProvider(this, MMOViewModelFactory(app.repository, this)).get(MMOViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this


    }
}