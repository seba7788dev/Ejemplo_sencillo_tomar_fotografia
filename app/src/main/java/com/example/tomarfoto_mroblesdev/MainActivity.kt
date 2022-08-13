package com.example.tomarfoto_mroblesdev

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton=findViewById<Button>(R.id.boton)


        boton.setOnClickListener {

            starForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }
    private val starForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result:ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK){
            val foto=findViewById<ImageView>(R.id.foto)
            //recibimos la info
            val intent= result.data
            //guardo la foto
            val imageBitmap=intent?.extras?.get("data") as Bitmap
            foto.setImageBitmap(imageBitmap)
        }
    }

}
