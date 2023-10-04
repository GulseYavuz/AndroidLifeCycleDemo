package com.yavuz.androidlifecycledemo

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val rv:RecyclerView by lazy { findViewById(R.id.rv) }
    private var list = arrayListOf<LifeCycleStep>()
    private lateinit var adapter: RVAdapter
    var currentStepIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)

        //recyclerview update
        var recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RVAdapter(list)

        adapter = RVAdapter(lifeCycleStepList = list)

        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv.adapter = adapter

        button.setOnClickListener {
            val imageResource = R.drawable.baseline_cruelty_free_24
            adapter.addList(LifeCycleStep( "ON START" , imageResource))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "ON START LOG MESAJI")
        adapter.addList(LifeCycleStep("ON START", R.drawable.baseline_cruelty_free_24))
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "ON RESUME LOG MESAJI")
        val imageResource2 = R.drawable.baseline_bedtime_24
        adapter.addList(LifeCycleStep("ON RESUME", imageResource2))
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "ON PAUSE LOG MESAJI")
        val imageResource2 = R.drawable.baseline_bedtime_24
        adapter.addList(LifeCycleStep("ON RESUME", imageResource2))
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "ON STOP LOG MESAJI")
        val imageResource2 = R.drawable.baseline_bedtime_24
        adapter.addList(LifeCycleStep("ON RESUME", imageResource2))
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Main Activity", "ON RESTART LOG MESAJI")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("Main Activity", "ON DESTROY LOG MESAJI")
    }
}