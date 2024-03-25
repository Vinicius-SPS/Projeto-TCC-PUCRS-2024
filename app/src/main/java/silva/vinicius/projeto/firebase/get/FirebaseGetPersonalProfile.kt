package silva.vinicius.projeto.firebase.get

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import silva.vinicius.projeto.model.PersonalProfile

class FirebaseGetPersonalProfile {

    fun getPersonalProfile(callback: (Boolean, PersonalProfile?, String) -> Unit){
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        var documentReferenceBase: DocumentReference? = null



        if (!userId.isNullOrBlank()) {
            documentReferenceBase = firebaseFirestore.collection("user_profile").document(userId)
            documentReferenceBase.get().addOnSuccessListener {

                    callback(true, PersonalProfile(
                        it.getBoolean("isProfileCreated"),
                        it.getString("user_name"),
                        it.getString("description"),
                        0,
                        it.getString("tags")),
                        "Sucesso")
                }
                .addOnFailureListener{
                    callback(false, null, "Erro ao acessar o banco de dados")
                }

        }
    }
}
