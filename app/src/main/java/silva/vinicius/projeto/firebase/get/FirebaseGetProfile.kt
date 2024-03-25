package silva.vinicius.projeto.firebase.get

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import silva.vinicius.projeto.model.PersonalProfile
import silva.vinicius.projeto.model.Profile

class FirebaseGetProfile {
    fun getProfile(userId: String?, callback: (Boolean, Profile?, String) -> Unit){
        val firebaseFirestore = FirebaseFirestore.getInstance()
        var documentReferenceBase: DocumentReference? = null




        if (userId != null) {
            documentReferenceBase = firebaseFirestore.collection("user_profile").document(userId)
            documentReferenceBase.get().addOnSuccessListener {
                    callback(true, Profile(
                        it.getString("user_name"),
                        it.getString("description"),
                        0,
                        it.getString("tags")?.replace("[","")?.replace("]","")
                    ), "sucesso")
                }
                .addOnFailureListener{
                    callback(false, null, "Erro ao recuperar o perfil")
                }

        }
    }
}
