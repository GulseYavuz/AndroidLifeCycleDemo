package com.yavuz.androidlifecycledemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val lifeCycleStepList: ArrayList<LifeCycleStep> )
    :RecyclerView.Adapter<RVAdapter.LayoutFeaturesHolder>(){
    private var list: ArrayList<LifeCycleStep> = lifeCycleStepList

    inner class LayoutFeaturesHolder(view:View):RecyclerView.ViewHolder(view){
        val textView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.textView)
            imageView = view.findViewById(R.id.imageView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayoutFeaturesHolder {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false)
        return LayoutFeaturesHolder(design)
    }

    override fun getItemCount(): Int {
        return lifeCycleStepList.size
    }

    override fun onBindViewHolder(holder: LayoutFeaturesHolder, position: Int) {
        val step = list[position]
        holder.textView.text = step.lifeCycleName
        holder.imageView.setImageResource(step.imageResource)
    }
    fun addList(lifeCycleStep: LifeCycleStep){
        list.add(lifeCycleStep)
        notifyItemChanged(list.size)
    }
}