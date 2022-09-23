package ua.devmaksem.network.data.top

import com.google.gson.annotations.SerializedName

data class ResolutionDto(
    @SerializedName("height")
    val imageHeight: Int,

    @SerializedName("width")
    val imageWidth: Int,

    @SerializedName("url")
    val imageURL: String
)