package com.surfaceduo.training.listitems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.microsoft.device.dualscreen.ScreenInfoProvider
import com.surfaceduo.training.listitems.recyclerview.Item
import com.surfaceduo.training.listitems.recyclerview.ItemsAdapter

class ListItemsFragment() : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: ItemsAdapter
    private lateinit var myViewManager: RecyclerView.LayoutManager

    private val sharedVM: SharedVM by activityViewModels()

    private val dataset = arrayOf(
        Item(1, "This is number 1"),
        Item(2, "This is number 2"),
        Item(3, "This is number 3"),
        Item(4, "This is number 4"),
        Item(5, "This is number 5"),
        Item(6, "This is number 6"),
        Item(7, "This is number 7"),
        Item(8, "This is number 8"),
        Item(9, "This is number 9"),
        Item(10, "This is number 10"),
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_items_layout, container, false)

        myAdapter = ItemsAdapter(dataset, ::onItemClickListener, sharedVM)
        myViewManager = LinearLayoutManager(requireContext())
        recyclerView = view.findViewById<RecyclerView>(R.id.list_items).apply {
            setHasFixedSize(true)
            layoutManager = myViewManager
            adapter = myAdapter
        }
        return view
    }

    private fun onItemClickListener() {
        //If we are on single screen mode we change fragments, but if we are on dual screen mode, we take
        //advantage of the shared content the view model has to just update the detail fragment automatically.
        activity?.run {
            if (!ScreenInfoProvider.getScreenInfo(requireContext()).isDualMode()) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.first_container_id, DetailFragment())
                    .addToBackStack("detailFragment")
                    .commit()
            }
        }
    }
}