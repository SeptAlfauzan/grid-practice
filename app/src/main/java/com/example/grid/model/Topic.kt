package com.example.grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val activityNameId: Int,
    val participants: Int,
    @DrawableRes val imageId: Int
)
