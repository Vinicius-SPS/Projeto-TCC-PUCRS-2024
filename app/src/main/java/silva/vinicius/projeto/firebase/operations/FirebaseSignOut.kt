package silva.vinicius.projeto.firebase.operations

import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class FirebaseSignOut {
    fun doLogOff(){
        Log.d("FirebaseSignOut", "Desconectando")
        FirebaseAuth.getInstance().signOut()
    }
}