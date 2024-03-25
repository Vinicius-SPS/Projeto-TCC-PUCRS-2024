package silva.vinicius.projeto.firebase.update

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseUpdateProfileCreation {

    fun updateProfile(userName: String,tags: String, callback: (Boolean, String?) -> Unit) {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        var documentReferenceBase: DocumentReference? = null

        val userProfile: MutableMap<String, Any> = HashMap()
        userProfile["is_profile_created"] = true
        userProfile["user_name"] = userName
        userProfile["tags"] = tags
        userProfile["description"] = "Olá! Estou em busca de alguém para jogar junto."

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