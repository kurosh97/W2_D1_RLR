package com.example.recyclerview_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_demo.adapter.Adapter
import com.example.recyclerview_demo.models.DataSource
import com.example.recyclerview_demo.models.President
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Adapter.OnItemClickListener {

    private lateinit var presidentAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRV()
        addDataSet()
    }

    private fun addDataSet() {
        val data = DataSource.createDataSet()
        presidentAdapter.submitList(data)
    }

    override fun onItemClick(position: Int) {
        val clickedItem = DataSource.createDataSet()[position].fullname
        Toast.makeText(this, "Item $clickedItem clicked", Toast.LENGTH_SHORT).show()
    }

    private fun initRV() {
        recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            presidentAdapter = Adapter(this@MainActivity)
            adapter = presidentAdapter

        }
    }


}