package com.surfaceduo.training.listitems.recyclerview

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.surfaceduo.training.listitems.R

class ItemViewHolder(val view: View, val onClick: () -> Unit) :
    RecyclerView.ViewHolder(view) {
    val layout: LinearLayout = itemView.findViewById(R.id.item_layout)
    val numberView: TextView = itemView.findViewById(R.id.item_number)
    val bodyView: TextView = itemView.findViewById(R.id.item_body)

}
