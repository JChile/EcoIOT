package com.example.myapplication.data
import com.google.android.gms.maps.model.LatLng

data class ContainerData (
    val codigoContenedor: String,
    val ubicacion: LatLng,
    val recoger: String
)
