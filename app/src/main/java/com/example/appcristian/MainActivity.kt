package com.example.appcristian

import WineListAdapter
import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.appcristian.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: WineListAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapter()
        setupRecyclerView()
    }

    private fun setupAdapter() {
        adapter = WineListAdapter()
    }

    private fun setupRecyclerView(){
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(3,RecyclerView.VERTICAL)
            adapter = this@MainActivity.adapter
        }
    }

    private fun getWines(){
        val wines = getLocalWines()
        adapter.submitList(wines)
    }

    private fun getLocalWines() = listOf(
        Wine("Cursos Android ANT", "UVANT",
            Rating("4.8", "236 ratings"), "Mexico",
            "https://images.vivino.com/thumbs/GPvEr_IUSKS1CDhhsY1ySg_pb_x300.png", 21),

        Wine("Castilla", "Liria",
            Rating("4.5", "Cool!"), "España",
            "https://live.staticflickr.com/2208/2201099990_42e528a85e_b.jpg", 22),

        Wine("Casillero", "Shiraz y Merlot",
            Rating("4.2", "Good!"), "Chile",
            "https://live.staticflickr.com/2528/4317577251_83d34054cf_z.jpg", 23),

        Wine("Rivera", "Malbec",
            Rating("4.6", "Top!"), "Argentina",
            "https://live.staticflickr.com/4035/4717565996_b8749c27ce_b.jpg", 24),

        Wine("California", "Tempranillo",
            Rating("4.0", "OK!"), "USA",
            "https://live.staticflickr.com/4035/4717565996_b8749c27ce_b.jpg", 25)
    )
override fun onResume(){
    super.onResume()
    getWines()
}
}
