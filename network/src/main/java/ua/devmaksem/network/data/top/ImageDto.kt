package ua.devmaksem.network.data.top

import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("id")
    val imageId: String,

    @SerializedName("resolutions")
    val availableImageResolutions: List<ResolutionDto>,

    @SerializedName("source")
    val imageSource: ImgSourceDto
)