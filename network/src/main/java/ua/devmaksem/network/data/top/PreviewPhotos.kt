package ua.devmaksem.network.data.top

import com.google.gson.annotations.SerializedName

data class PreviewPhotos(
    @SerializedName("enabled")
    val isEnabled: Boolean,

    @SerializedName("images")
    val imageList: List<Image>
)