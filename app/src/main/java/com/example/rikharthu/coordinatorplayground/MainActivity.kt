package com.example.rikharthu.coordinatorplayground

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.rikharthu.coordinatorplayground.behaviors.MyBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val params = squareView.layoutParams as CoordinatorLayout.LayoutParams
        params.behavior = MyBehavior()

        callFab.setOnClickListener {
            Toast.makeText(this, "Calling...", Toast.LENGTH_SHORT).show()
        }
    }
}
