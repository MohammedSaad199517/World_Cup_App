package com.example.worldcup.ui

import android.util.Log
import android.view.LayoutInflater

import com.example.worldcup.data.domain.models.Match
import com.example.worldcup.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding> (){
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =ActivityMainBinding::inflate
    override fun setup() {
        dataManager.addMatch()
        bindMatch(dataManager.getCurrentMatch())

    }
    override fun addCallBack() {

        binding?.apply {
            iconNext.setOnClickListener{
                bindMatch(dataManager.getNextMatch())
            }
            iconPrevious.setOnClickListener{
                bindMatch( dataManager.getPreviuosMatch())
            }
        }

    }
    private fun bindMatch (match: Match){
        binding?.apply {
            textYear.text =match.year.toString()
            textStadium.text = match.stadium
            textHomeName.text = match.homeTeamName
            textAwayName.text = match.awayTeamName
            textHomeGoals.text = match.homeTeamGoals
            textAwayGoals.text = match.awayTeamGoals.toString()


        }
    }

}