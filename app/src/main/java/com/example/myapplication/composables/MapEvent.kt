package com.example.myapplication.composables

import com.example.myapplication.data.ContainerData
import com.google.type.LatLng

sealed class MapEvent {
    data class OnMapLongClick(val latLng: LatLng): MapEvent()
    data class OnInfoWindowLongClik(val spot: ContainerData): MapEvent()
}