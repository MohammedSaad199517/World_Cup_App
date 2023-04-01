package com.example.worldcup.data.datasource.utils

import com.example.worldcup.data.domain.models.Match
import com.example.worldcup.util.Constants

class CsvParser {


    fun parseLine(line: String): Match {
        val tokens = line.split(",")
        return Match(

            year = tokens[Constants.ColumnIndex.YEAR].toInt(),
            stadium = tokens[ Constants.ColumnIndex.STADIUM],
            city = tokens[Constants.ColumnIndex.CITY],
            homeTeamName = tokens[Constants.ColumnIndex.HOME_TEAM_NAME],
            awayTeamName = tokens[Constants.ColumnIndex.AWAY_TEAM_NAME],
            homeTeamGoals = tokens[Constants.ColumnIndex.HOME_TEAM_GOALS],
            awayTeamGoals = tokens[Constants.ColumnIndex.AWAY_TEAM_GOALS].toInt(),

        )
    }
}