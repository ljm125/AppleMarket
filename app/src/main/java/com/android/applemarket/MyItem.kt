package com.android.applemarket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyItem(
    val image:Int,val name:String, val location:String, val money:String,
    val chat:Int, val heart:Int, val seller:String, val detail:String ):Parcelable

