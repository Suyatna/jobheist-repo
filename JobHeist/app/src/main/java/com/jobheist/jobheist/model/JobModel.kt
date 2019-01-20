package com.jobheist.jobheist.model

import com.google.gson.annotations.SerializedName

class JobModel(@SerializedName("id") val id : Int,
               @SerializedName("title") val title : String,
               @SerializedName("imageUrl") val imageUrl : String,
               @SerializedName("author") val author : String,
               @SerializedName("category") val category : String,
               @SerializedName("salary") val salary : String,
               @SerializedName("location") val location : String,
               @SerializedName("content_desc") var content_desc : String,
               @SerializedName("date_created") var date_created : String) {
    fun getIdJob() : Int{
        return id
    }

    fun getTitleJob() : String{
        return title
    }

    fun getImageUrlJob() : String{
        return imageUrl
    }

    fun getAuthorJob() : String{
        return author
    }

    fun getCategoryJob() : String {
        return category
    }

    fun getSalaryJob() : String{
        return salary
    }

    fun getLocationJob() : String{
        return location
    }

    fun getDateCreatedJob() : String{
        return date_created
    }
}