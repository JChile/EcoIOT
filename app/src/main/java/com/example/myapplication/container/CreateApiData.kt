package com.example.myapplication.container

import com.example.myapplication.data.ContainerData
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path

interface CreateApiData {

    @PUT("container")
    suspend fun putData(
        @Body objectCreate: ContainerData
    )
    companion object {
        const val BASE_URL = "https://tgqetvnk03.execute-api.us-east-2.amazonaws.com/"
    }
}