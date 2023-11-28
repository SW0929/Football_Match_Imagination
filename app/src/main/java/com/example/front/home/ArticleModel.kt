package com.example.front.home

data class ArticleModel(
    val userId: String,
    val title: String,
    val createdAt: Long,
    val teamName: String,
    val imageUrl: String
) {
    constructor(): this("", "", 0, "", "")
}