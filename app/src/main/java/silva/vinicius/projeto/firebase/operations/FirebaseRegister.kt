package silva.vinicius.projeto.firebase.operations

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseRegister {
    fun doRegister(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful) {
                callback(true, null)
            }
            else{
                callback(false, null)
            }
        }

    }
}