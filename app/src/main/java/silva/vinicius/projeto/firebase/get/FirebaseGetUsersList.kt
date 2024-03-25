package silva.vinicius.projeto.firebase.get

import android.util.Log
import com.google.android.material.snackbar.ContentViewCallback
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import silva.vinicius.projeto.model.Users

class FirebaseGetUsersList {
    fun getUserList(callback: (Boolean, ArrayList<Users>?, String) -> Unit){
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        var documentReferenceBase: CollectionReference? = null

        if(userId != null){
            Log.d("FirebaseGetUsersList", "Funcionou 1")
            documentReferenceBase = firebaseFirestore.collection("user_profile")
            documentReferenceBase.get().addOnCompleteListener{
                if(it.isSuccessful){
                    Log.d("FirebaseGetUsersList", "Funcionou 2")
                    val userList: ArrayList<Users> = ArrayList()

                    val size: Int = it.result.size() - 1
                    if(size >= 0){
                        for(index: Int in 0..size){
                            val data = it.result.documents[index]
                            val creationStatus = data.getBoolean("is_profile_created")
                            val dataId = data.id
                            if (dataId!= userId && creationStatus == true){
                                userList.add(
                                    Users(
                                        data.id,
                                        data.getString("user_name"),
                                        data.getString("description"),
                                        0,
                                        data.getString("tags")
                                    )
                                )
                            }

                        } //*/
                    }

                    Log.d("FirebaseGetUsersList", "Funcionou 3")
                    callback(true, userList, "Sucesso")

                }
                else
                    callback(false, null, "Erro ao conectar com o servidor")
            }
        }

    }
}