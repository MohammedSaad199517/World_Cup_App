package com.example.worldcup.data.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Match (
    val year : Int,
    val stadium : String,
    val city : String,
    val homeTeamName:String,
    val awayTeamName:String,
    val homeTeamGoals:String,
    val awayTeamGoals: Int,


        ):Parcelable