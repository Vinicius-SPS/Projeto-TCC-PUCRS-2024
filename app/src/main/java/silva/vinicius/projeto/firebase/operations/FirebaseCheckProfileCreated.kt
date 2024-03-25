package silva.vinicius.projeto.firebase.operations

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseCheckProfileCreated {
    fun verifyProfile(callback: (Boolean, Boolean?) -> Unit) {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        if (!userId.isNullOrBlank()) {
            firebaseFirestore.collection("user_profile")
                .document(userId).get()
                .addOnSuccessListener {
                    Log.d(
                        "FirebaseCheckProfileCreated",
                        it.getBoolean("isProfileCreated").toString()
                    )
                    callback(true, it.getBoolean("isProfileCreated"))
                }
                .addOnFailureListener {
                    callback(false, false)
                }

        }
    }
}