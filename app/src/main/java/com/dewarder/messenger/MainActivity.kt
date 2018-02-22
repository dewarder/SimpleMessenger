package com.dewarder.messenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseAuth.getInstance()
                .signInWithEmailAndPassword("myemail@mail.ru", "password")
                .addOnCompleteListener { result: Task<AuthResult> ->
                    if (!result.isSuccessful) {
                        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
                        result.exception!!.printStackTrace()
                        return@addOnCompleteListener
                    }


                    Log.e("MainActivity", "id = " + result.result.user.uid)

                    FirebaseFirestore.getInstance()
                            .collection("chats")
                            .document("09KX8kmU3ZXg5w6oV84MlMkZzta2")
                            .set(mapOf("name" to "Name5"))
                            .addOnCompleteListener { snapshot ->
                                if (!snapshot.isSuccessful) {
                                    snapshot.exception!!.printStackTrace()
                                }
                                Toast.makeText(this, "DONE ${snapshot.isSuccessful}", Toast.LENGTH_SHORT).show()
                            }
                }


    }
}
