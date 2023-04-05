package com.ibs.delibery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         /*
         VARIABLES PARA EL INICIO DE SESION
          */





        /*
        DECLARACION  VARIABLES INICIO DE SESION EN FIRE BASE
            */

        val login: Button = findViewById(R.id.buttonlogin)
        val user: EditText = findViewById(R.id.usuario)
        val pass: EditText = findViewById(R.id.Password)

        firebaseAuth = Firebase.auth

        /*
        LLAMADO DE VARIABLES
         */
        login.setOnClickListener()
        {

            signIn(user.text.toString(), pass.text.toString())
        }
    }

    /*
     VERIFICACION DE DATOS SI ESTA VACIO O LLENOS
     */
    private fun signIn(user: String, pass: String) {
        /*
        prueba
         */
        /*
        MENSAJES  PARA RELLENAR
         */
        if (user == null || user.isEmpty())
        {
            Toast.makeText(baseContext,"Complete los Campos", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass == null || pass.isEmpty())
        {
            Toast.makeText(baseContext,"Ingrese Contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        /*
                VERIFICACION DE USUARIO CON BASE DE DATOS
         */
        firebaseAuth.signInWithEmailAndPassword(user, pass)
            .addOnCompleteListener(this,) { task ->

                /*
                    SI SE CUMPLE LA VARIABLE PROCEDE

                 */

                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext, "Autenticacion Exitosa", Toast.LENGTH_SHORT)
                        .show()
                    //DECLARACION DE PANTALLA  NAVEGACION EN TICKETS
                    val i = Intent(this, AccessPoint::class.java)
                    startActivity(i)
                } else {
                    Toast.makeText(baseContext,"Error de Email y/o Contraseña", Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

    }
}
