package com.example.tugasapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasapi.databinding.ItemListViewBinding
import com.example.tugasapi.model.Data

//typealias OnClickAnime = (Data) -> Unit

class AnimeAdapter(private val listAnime: List<Data>,
//    private val onClickAnime: OnClickAnime
                   ) :
    RecyclerView.Adapter<AnimeAdapter.ItemAnimeViewHolder>(){
    inner class ItemAnimeViewHolder(
        private val binding: ItemListViewBinding
    ):
    RecyclerView.ViewHolder(binding.root){
        fun bind(data: Data) {
            with(binding){
                animeTitle.text = data.title
                animeType.text = data.type
                animeSource.text = data.source
                animeEpisodes.text = data.episodes.toString()
                animeStatus.text = data.status
                animeScore.text = data.score.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAnimeViewHolder {
        val binding = ItemListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemAnimeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listAnime.size
    }

    override fun onBindViewHolder(holder: ItemAnimeViewHolder, position: Int) {
        holder.bind(listAnime[position])
    }

}