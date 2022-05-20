package com.example.kkk.models

import java.util.*

class CompetenceModel(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "UNKONW",
    val description: String = "",
    var modifiedAt: Date = Date(),
    private var _level: Int = 0,
    var tags: MutableList<TagModel> = mutableListOf<TagModel>()){

    var level: Int
        get() = _level
        set(lvl) {
            if(lvl < 0) _level = 0
            else if(lvl >= 20) _level = 20
            else _level = lvl
        }
}