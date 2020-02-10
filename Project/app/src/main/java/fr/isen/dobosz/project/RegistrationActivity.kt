package fr.isen.feltrin.technical_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.regex.Pattern


class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        registerButton.setOnClickListener(){
            checkForm()
            System.out.println(passwField.getText().toString() + confirmPasswField.getText().toString())
        }
    }

    fun checkPasswords(): Boolean {
        if(passwField.getText().toString().length == confirmPasswField.getText().toString().length){ //same length
            if(passwField.getText().toString().length < 8){ //length not enough
                Toast.makeText(this,"Passwords must contain at least 8 characters", Toast.LENGTH_LONG).show()
                return false
            }
            else if(passwField.getText().toString() != confirmPasswField.getText().toString()){ //different passw
                Toast.makeText(this,"The passwords must be the same", Toast.LENGTH_LONG).show()
                return false
            }
            else { //password are the same
                var countNumber = false //passw does not contain number
                var countCapLetter = false //passw does not capital letter
                for (letter in passwField.getText().toString()) { //Check number in passw
                    try { //is letter a number ?
                       // val i = Integer.parseInt(letter.toString())
                        System.out.println("C'est un entier")
                        informations.setText("")
                        countNumber = true
                    } catch (e: Exception) {
                        //System.out.println("Je ne suis pas un entier, et alors ca te derange ?")
                    }
                    if (letter == letter.toUpperCase()) { // letter upCase
                        // Vérifier si le texte est en majuscule
                        countCapLetter = true
                    }
                }
                if (countNumber && countCapLetter)
                    return true
                else {
                    informations.setText("Password must contain at least 1 number and 1 up case")
                    return false
                }
            }
        }
        else{ //password not same length
            Toast.makeText(this,"The passwords must be the same", Toast.LENGTH_LONG).show()
            return false
        }
    }
    fun checkFields():Boolean{
        if(nameField.getText().toString() =="" || surnameField.getText().toString() =="" || emailField.getText().toString() =="" || passwField.getText().toString() =="" || confirmPasswField.getText().toString() =="") {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
        return false
        }
        else
            return true
    }
    fun checkMail():Boolean{
        val masque =
            "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+" + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$"
        val pattern = Pattern.compile(masque)
        val controler = pattern.matcher(emailField.getText().toString())
        if (controler.matches()) {
            System.out.println("Ok")
            return true

        } else {
            informations.setText("Please enter a correct email address")
            return false
        }
    }

    fun checkNames():Boolean {
        for (letter in nameField.getText().toString()) {
            if(letter.toString() == " "){
                informations.setText("No space on name and family name")
                return false
            }
        }
        for (letter in surnameField.getText().toString()) {
            if(letter.toString() == " "){
                informations.setText("No space on name and family name")
                return false
            }
        }
        return true
    }

    fun checkForm(){
        if(checkFields()){
            if(checkNames()) {
                if (checkMail()) {
                    if (checkPasswords()) {
                        informations.setText("Everything is ok")
                    }
                }
            }
        }
        //if checkPasswords()
    }



}