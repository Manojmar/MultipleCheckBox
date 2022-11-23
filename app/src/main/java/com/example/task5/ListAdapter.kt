package com.example.task5

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.task5.databinding.DayListBinding

class ListAdapter(var modal: ArrayList<DaysData>,var onClick:(DaysData,Int)->Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: DayListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(task: DaysData,position: Int) {
            binding.daysName.text = task.days
            binding.customerName.text = task.personName

            binding.card.setOnClickListener {
                val intent = Intent(itemView.context, SecondActivity::class.java)
                onClick(task,position)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val checkedItem = DayListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(checkedItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
holder.bind(modal[position],position)
        }




    override fun getItemCount(): Int {
        return modal.size
    }
}