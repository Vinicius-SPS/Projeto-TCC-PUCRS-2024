package silva.vinicius.projeto.firebase.operations.profilecreation

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore


class FirebaseCreateProfile {

    fun createProfile(): Boolean {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        var documentReferenceBase: DocumentReference? = null

        val userProfile: MutableMap<String, Any> = HashMap()
        userProfile["is_profile_created"] = false
        userProfile["description"] = ""
        userProfile["user_name"] = ""
        userProfile["tags"] = ""


        if (!userId.isNullOrBlank()) {
            documentReferenceBase = firebaseFirestore.collection("user_profile").document(userId)
            documentReferenceBase.set(userProfile).addOnFailureListener{
                Log.d("firebaseCreateProfile","erro: " + it)
            }
        }
        return false
    }
}