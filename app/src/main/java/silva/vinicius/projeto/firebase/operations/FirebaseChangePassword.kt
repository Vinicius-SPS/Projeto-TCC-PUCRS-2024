package silva.vinicius.projeto.firebase.operations

import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.android.material.snackbar.ContentViewCallback
import com.google.firebase.auth.FirebaseAuth

class FirebaseChangePassword {

    fun changePassword(email: String, callback: (Boolean, String) -> Unit){
        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
            if (it.isSuccessful){
                callback(true, "sucesso")
            }
            else{
                callback(false, "Erro ao enviar a solicitalção de troca de senha.")
            }
        }
    }
}