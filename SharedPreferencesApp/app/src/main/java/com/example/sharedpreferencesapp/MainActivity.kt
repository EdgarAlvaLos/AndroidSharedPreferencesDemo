package com.example.sharedpreferencesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val  key = "MySessionKey";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //GetPreferenceManager
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        //GetReferences
        getButton.setOnClickListener{
            val myPrefs = prefs.getString(key , "There[s nothing here")
            showAlert(myPrefs.toString());
        }
        //SavePreferences
        putButton.setOnClickListener{
            val editor = prefs.edit();
            editor.putString(key,"This is a sample");
            editor.apply();
            showAlert("Value Saved");
        }
        //DeletePreferences
        delButton.setOnClickListener{
            val editor = prefs.edit();
            editor.remove(key);
            editor.apply();
            showAlert("Value Deleted");
        }

    }

    //just to show an alert
    private fun showAlert (message: String){
        val builder = AlertDialog.Builder(this);
        builder.setTitle("my preference");
        builder.setMessage(message);
        val dialog = builder.create();
        dialog.show();
    }
}