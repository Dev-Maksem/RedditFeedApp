package ua.devmaksem.network.data.top

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("id")
    val imageId: String,

    @SerializedName("resolutions")
    val availableImageResolutions: List<Resolution>,

    @SerializedName("source")
    val imageSource: ImgSource
)