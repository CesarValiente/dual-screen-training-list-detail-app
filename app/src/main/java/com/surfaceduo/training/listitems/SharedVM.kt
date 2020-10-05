package com.surfaceduo.training.listitems

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surfaceduo.training.listitems.recyclerview.Item

class SharedVM : ViewModel() {
    val selectedItem = MutableLiveData<Item>()
    val selectedItemPosition = MutableLiveData<Int>()

    fun setSelectedItem(item: Item) {
        selectedItem.value = item
    }

    fun setSelectedItemPosition(position: Int) {
        selectedItemPosition.value = position
    }
}