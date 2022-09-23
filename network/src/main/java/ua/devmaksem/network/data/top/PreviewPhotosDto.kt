package ua.devmaksem.network.data.top

import com.google.gson.annotations.SerializedName

data class PreviewPhotosDto(
    @SerializedName("enabled")
    val isEnabled: Boolean,

    @SerializedName("images")
    val imageList: List<ImageDto>
)