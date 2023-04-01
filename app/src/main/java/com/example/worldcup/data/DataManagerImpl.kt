package com.example.worldcup.data

import android.util.Log
import com.example.worldcup.data.datasource.WorldCupDataSource
import com.example.worldcup.data.domain.models.Match

class DataManagerImpl(  private val dataSource: WorldCupDataSource) : DataManager {


    private  var matchIndex = 0



    override fun addMatch() {

      dataSource.getMatchesData()[matchIndex]

    }

    override fun getCurrentMatch(): Match = dataSource.getMatchesData()[matchIndex]

    override fun getNextMatch(): Match {
        matchIndex++
        if ( matchIndex == dataSource.getMatchesData().size) {
            matchIndex =0
        }
        return dataSource.getMatchesData()[matchIndex]
    }

    override fun getPreviuosMatch(): Match {
        matchIndex--
        if ( matchIndex < 0) {
            matchIndex =dataSource.getMatchesData().size -1
        }
        return dataSource.getMatchesData()[matchIndex]
    }
}