package com.jobheist.jobheist.model

class JobData {
    private val joblist_id : IntArray = intArrayOf(1, 2, 3, 4, 5)
    private val joblist_name : kotlin.Array<String> = arrayOf("Job 1", "Job 2", "Job 3","Job 4", "Job 5")
    private val joblist_company : kotlin.Array<String> = arrayOf("Company 1","Company 2","Company 3","Company 4","Company 5")

    fun getJobIds() : IntArray{
        return joblist_id
    }

    fun getJobNames() : kotlin.Array<String>{
        return joblist_name
    }

    fun getJobCompanies() : kotlin.Array<String>{
        return joblist_company
    }
}