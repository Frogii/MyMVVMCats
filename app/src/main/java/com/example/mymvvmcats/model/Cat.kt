package com.example.mymvvmcats.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "cats")
data class Cat(
    @PrimaryKey(autoGenerate = true)
    var dbId: Int? = null,
    @SerializedName("id")
    val idCat: String,
    @SerializedName("url")
    val imageUrl: String
): Serializable

