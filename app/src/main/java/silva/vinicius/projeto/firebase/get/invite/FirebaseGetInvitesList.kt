package silva.vinicius.projeto.firebase.get.invite

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import silva.vinicius.projeto.model.Users

class FirebaseGetInvitesList {

    fun getInvitesList(callback: (Boolean, ArrayList<Users>?, String) -> Unit){
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        var documentReferenceBase: CollectionReference? = null

        if(userId != null){
            documentReferenceBase = firebaseFirestore.collection("user_profile")
                .document(userId).collection("invites")
            documentReferenceBase.get().addOnCompleteListener{
                if(it.isSuccessful){

                    val userList: ArrayList<Users> = ArrayList()

                    val size: Int = it.result.size() - 1
                    if(size >= 0){
                        for(index: Int in 0..size){

                            val user = it.result.documents[index]
                            userList.add(
                                Users(
                                    user.id.toString(),
                                    user.getString("user_name"),
                                    user.getString("description"),
                                    0,
                                    user.getString("tags")
                                )
                            )
                        }
                    }

                    callback(true, userList, "Sucesso")

                }
                else
                    callback(false, null, "Erro ao conectar com o servidor")
            }
        }

    }
}