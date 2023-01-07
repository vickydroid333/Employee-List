package com.anglertech.anglertask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.anglertech.anglertask.databinding.EmployeeAdapterBinding


class EmployeeAdapter(private val employeeList: ArrayList<EmployeeListModel>) :
    RecyclerView.Adapter<EmployeeAdapter.EmpViewHolder>() {
    class EmpViewHolder(private val binding: EmployeeAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(memberListModel: EmployeeListModel) {
            binding.apply {
                initial.text = memberListModel.name!!.substring(0, 1)
                name.text = memberListModel.name
                mobileNo.text = memberListModel.mobile


            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpViewHolder {
        return EmpViewHolder(
            EmployeeAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EmpViewHolder, position: Int) {
        val view = employeeList[position]
        holder.bind(view)

    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    private val callback = object : DiffUtil.ItemCallback<EmployeeListModel>() {

        override fun areItemsTheSame(
            oldItem: EmployeeListModel,
            newItem: EmployeeListModel
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: EmployeeListModel,
            newItem: EmployeeListModel
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

}