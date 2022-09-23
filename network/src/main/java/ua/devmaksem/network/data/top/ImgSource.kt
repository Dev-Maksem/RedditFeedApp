package ua.devmaksem.network.data.top

import com.google.gson.annotations.SerializedName

data class ImgSource(
    @SerializedName("height")
    val imageHeight: Int,

    @SerializedName("width")
    val imageWidth: Int,

    @SerializedName("url")
    val imageURL: String
)