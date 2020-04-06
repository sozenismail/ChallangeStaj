package com.ismailsozen.challangestaj.mock

class MainCls(val status:String, val data: Data)

class Data(val coins : List<Coins>)

class Coins (

    val name : String,
    val description : String,
    val color : String,
    val price:String,
    val iconUrl:String

)