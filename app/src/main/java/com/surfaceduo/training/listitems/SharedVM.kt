package com.surfaceduo.training.listitems

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surfaceduo.training.listitems.recyclerview.Item

class SharedVM : ViewModel() {
    val selectedItem = MutableLiveData<Item>()

    fun setSelectedItem(item: Item) {
        selectedItem.value = item
    }
}