package com.example.worldcup.ui.matches.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcup.R
import com.example.worldcup.data.domain.models.Match
import com.example.worldcup.databinding.ItemMatchBinding

class MatchAdapter (val list:List<Match>):RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_match,parent,false)
        return MatchViewHolder(view)
    }

    override fun getItemCount() = list.size
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
       val currentMatch = list[position]
        holder.binding.apply {
            textTeam1.text =currentMatch.homeTeamName
            textTeam2.text = currentMatch.awayTeamName
            textTeam1Score.text = currentMatch.homeTeamGoals
            textTeam2Score.text = currentMatch.awayTeamGoals.toString()
            textYear.text = currentMatch.year.toString()

        }
    }
    class MatchViewHolder(viewItem: View):RecyclerView.ViewHolder(viewItem){
        val binding = ItemMatchBinding.bind(viewItem)
    }
}