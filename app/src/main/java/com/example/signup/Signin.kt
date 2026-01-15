package com.example.signup

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signin : AppCompatActivity() {

    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button = findViewById<Button>(R.id.button)
        val eTname = findViewById<EditText>(R.id.eTname)
        val eTUID = findViewById<EditText>(R.id.eTUID)
        val eTcreatePassword = findViewById<EditText>(R.id.eTcreatePassword)
        val eTconfirmPassword = findViewById<EditText>(R.id.eTconfirmPassword)

        button.setOnClickListener {
            val name = eTname.text.toString()
            val UID = eTUID.text.toString()
            val createPassword = eTcreatePassword.text.toString()
            val confirmPassword = eTconfirmPassword.text.toString()

            val user = User(name,UID,createPassword,confirmPassword)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(UID).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
