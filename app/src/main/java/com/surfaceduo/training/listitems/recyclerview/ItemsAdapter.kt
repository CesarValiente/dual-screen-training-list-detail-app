package com.surfaceduo.training.listitems.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.microsoft.device.dualscreen.core.ScreenHelper
import com.surfaceduo.training.listitems.R
import com.surfaceduo.training.listitems.SharedVM

class ItemsAdapter(
    private val items: Array<Item>,
    private val onClick: () -> Unit,
    private val sharedVM: SharedVM
) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view, onClick, sharedVM)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        with(holder) {
            val item = items[position]
            numberView.text = item.number.toString()
            bodyView.text = item.body
            layout.setOnClickListener {
                sharedVM.setSelectedItemPosition(position)
                sharedVM.setSelectedItem(item)
                onClick()
                notifyDataSetChanged()
            }
            if (ScreenHelper.isDualMode(view.context)) {
                changeItemBackground(position, sharedVM.selectedItemPosition.value as Int, layout)
            }
        }
    }

    private fun changeItemBackground(currentItemPosition: Int, selectedItemPosition: Int, layout: LinearLayout) {
        layout.isSelected = currentItemPosition == selectedItemPosition
    }

    override fun getItemCount(): Int = items.size

    fun getItem(position: Int): Item = items[position]
}