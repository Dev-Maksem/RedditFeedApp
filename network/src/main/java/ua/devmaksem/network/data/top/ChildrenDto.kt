package ua.devmaksem.network.data.top

import com.google.gson.annotations.SerializedName

data class ChildrenDto(

    @SerializedName("kind")
    val kind: String,

    @SerializedName("data")
    val data: ChildrenDataDto
)