package ua.devmaksem.network.data.top

import com.google.gson.annotations.SerializedName

data class FeedDto(

    @SerializedName("kind")
    val kind: String,

    @SerializedName("data")
    val feedDataDto: FeedDataDto
)