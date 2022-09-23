package ua.devmaksem.network.data.top

import com.google.gson.annotations.SerializedName

data class FeedDataDto(

    @SerializedName("modHash")
    val modHash: String,

    @SerializedName("before")
    val before: String?,

    @SerializedName("after")
    val after: String?,

    @SerializedName("children")
    val childrenList: List<ChildrenDto>,
)