package silva.vinicius.projeto.firebase.update.singleupdates

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseUpdateTags {
    fun updateProfile(tags: String, callback: (Boolean, String?) -> Unit) {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        var documentReferenceBase: DocumentReference? = null

        val userProfile: MutableMap<String, Any> = HashMap()
        userProfile["tags"] = tags

        documentReferenceBase = firebaseFirestore.collection("user_profile").document(userId!!)
        documentReferenceBase.update(userProfile).addOnCompleteListener(){
            if (it.isSuccessful) {
                callback(true, null)
            }
            else{
                callback(false, "Erro em acessar o Banco de Dados")
            }
        }
    }
}