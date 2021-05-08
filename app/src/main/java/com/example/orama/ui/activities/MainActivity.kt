package com.example.orama.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orama.R
import com.example.orama.ui.fragments.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    MainFragment.newInstance()
                )
                .commitNow()
        }
    }

}