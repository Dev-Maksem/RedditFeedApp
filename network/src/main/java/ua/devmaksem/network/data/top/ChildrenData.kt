package ua.devmaksem.network.data.top

import com.google.gson.annotations.SerializedName

data class ChildrenData(

    @SerializedName("author")
    val author: String,

    @SerializedName("created")
    val createdDate: Int, // epoch

    @SerializedName("created_utc")
    val createdUTCEpoch: Int, // epoch

    @SerializedName("name")
    val name: String,

    @SerializedName("preview")
    val photoPreviews: PreviewPhotos,

    @SerializedName("thumbnail")
    val thumbnail: String?,

    @SerializedName("thumbnail_height")
    val thumbnail_height: Int?,

    @SerializedName("thumbnail_width")
    val thumbnail_width: Int?,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("view_count")
    val viewCount: Int?,

    @SerializedName("visited")
    val isVisited: Boolean
)