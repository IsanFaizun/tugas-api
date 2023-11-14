package com.example.tugasapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasapi.databinding.ActivityMainBinding
import com.example.tugasapi.model.Anime
import com.example.tugasapi.model.Data
import com.example.tugasapi.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllAnime()
        response.enqueue(object: Callback<Anime>{
            override fun onResponse(call: Call<Anime>, response: Response<Anime>) {
                if (response.isSuccessful) {
                    val animeData = response.body()?.data ?: emptyList()
                    val animeList = animeData.map {
                        Data(
                            it.images,
                            it.title,
                            it.type,
                            it.source,
                            it.episodes,
                            it.status,
                            it.score
                        )
                    }
                    val adapterAnime = AnimeAdapter(animeList)
                    binding.rvItem.apply {
                        adapter = adapterAnime
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }
            override fun onFailure(call: Call<Anime>, t: Throwable) {

            }
        })
    }
}