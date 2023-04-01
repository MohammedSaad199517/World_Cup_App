package com.example.worldcup.data.datasource


import android.content.Context
import com.example.worldcup.data.datasource.utils.CsvParser
import com.example.worldcup.data.domain.models.Match
import java.io.InputStreamReader
interface WorldCupDataSource {
    fun getMatchesData(): List<Match>
}
class CsvDataSource(private val parser: CsvParser, private val context: Context):
WorldCupDataSource{
    override fun getMatchesData():List<Match>{
        return getCsvFile().readLines().map {  line ->
            parser.parseLine(line)
        }
    }

    private fun getCsvFile(): InputStreamReader{
        val inputStream = context.assets.open(FILE_NAME)
        return (InputStreamReader(inputStream))
    }

    companion object {
        private  const val  FILE_NAME  = "WorldCupMatches.csv"
    }
}