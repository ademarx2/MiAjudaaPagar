package com.rameda.miajudaapagar.ui.partys

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rameda.miajudaapagar.Adapter.AdapterRecyclerParty
import com.rameda.miajudaapagar.R

class HomeFragment : Fragment() {
    private lateinit var mRecyclerTaskList: RecyclerView
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(this, Observer {
        })
        //1 obter elemento
        mRecyclerTaskList = root.findViewById(R.id.recyclerParty)

        //2 obter um adapter
        mRecyclerTaskList.adapter = AdapterRecyclerParty()

        //3 definir um layout
        mRecyclerTaskList.layoutManager = LinearLayoutManager(context)

        return root
    }
}