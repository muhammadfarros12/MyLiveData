package com.farroos.mylivedata2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.farroos.mylivedata2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mLiveDataTimeViewModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        mLiveDataTimeViewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun subscribe(){
        val elapsedTimeObserver = Observer<Long?>{ aLong ->
            val newText = this@MainActivity.resources.getString(R.string.seconds, aLong)
            activityMainBinding.timerTextview.text = newText
        }

        mLiveDataTimeViewModel.getElapsedTime().observe(this, elapsedTimeObserver)

    }

}