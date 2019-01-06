package com.jobheist.jobheist

class AccountData{
    private var bookmarks : BooleanArray = booleanArrayOf(false, false, true, false, false)

    fun getBookmark(): BooleanArray{
        return bookmarks
    }
}