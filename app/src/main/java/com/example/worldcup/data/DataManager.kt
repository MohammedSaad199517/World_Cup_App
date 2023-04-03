package com.example.worldcup.data

import com.example.worldcup.data.domain.models.Match
import java.io.Serializable

interface DataManager : Serializable {

    fun addMatch()
    fun getCurrentMatch():Match
    fun getNextMatch():Match
    fun getPreviuosMatch():Match
    fun matches():List<Match>
}