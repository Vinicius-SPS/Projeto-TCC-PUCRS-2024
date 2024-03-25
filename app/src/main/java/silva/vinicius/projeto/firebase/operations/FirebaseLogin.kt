package silva.vinicius.projeto.firebase.operations
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.ContentViewCallback
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Firebase
import com.google.firebase.auth.*;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
class FirebaseLogin {
    private var auth: FirebaseAuth = Firebase.auth
    //Vereficando os dados para fazer o Login do Usuário
    fun doLogin(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful) {
                callback(true, null)
            }
            else{
                callback(false, null)
            }
        }
    }
}
