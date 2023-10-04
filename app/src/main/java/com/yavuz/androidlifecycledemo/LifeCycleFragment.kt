package com.yavuz.androidlifecycledemo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


class LifeCycleFragment : Fragment() {
    companion object{
        const val TAG = "LifeCycle"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, "ON ATTACH LOG MESAJI")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "ON CREATE VİEW LOG MESAJI")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_life_cycle, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i(TAG, "ON ACTIVITY CREATED LOG MESAJI")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "ON START LOG MESAJI")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "ON RESUME LOG MESAJI")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "ON PAUSE LOG MESAJI")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "ON STOP LOG MESAJI")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "ON DESTROY LOG MESAJI")
        Log.d("msg", "Log message")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "ON DETACH LOG MESAJI")
    }
}