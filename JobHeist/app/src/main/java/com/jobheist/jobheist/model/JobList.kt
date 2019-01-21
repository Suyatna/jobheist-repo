package com.jobheist.jobheist.model

import com.google.gson.annotations.SerializedName

data class JobList(@SerializedName("jobs") val jobs : List<JobModel>)