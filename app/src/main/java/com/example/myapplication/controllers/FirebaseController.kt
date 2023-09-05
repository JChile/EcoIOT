package com.example.myapplication.controllers
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await

class FirebaseController {

    private val firestore = FirebaseFirestore.getInstance()

    // obtener documentos de una colección
    suspend fun getDocumentsFromCollection(collectionName: String): QuerySnapshot {
        return firestore.collection(collectionName).get().await()
    }

    //añadir un documento a una colección
    suspend fun addDocumentToCollection(collectionName: String, data: Map<String, Any>) {
        firestore.collection(collectionName).add(data).await()
    }
}