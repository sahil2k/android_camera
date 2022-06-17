package com.example.camerasample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.camerasample.databinding.ActivityViewImageBinding
import java.io.File

class ViewImageActivity : AppCompatActivity() {

    private lateinit var viewBinding:ActivityViewImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding= ActivityViewImageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        /*val imgByteArray: ByteArray? = intent.getByteArrayExtra("byteArray")

        val imgBitmap: Bitmap? = BitmapFactory.decodeByteArray(imgByteArray,0,imgByteArray!!.size)
        viewBinding.imageView.setImageBitmap(imgBitmap)*/
        val imgFile= File(intent.getStringExtra("filepath"))
        if(imgFile.exists()) run {
            var myBitmap: Bitmap = BitmapFactory.decodeFile(imgFile.absolutePath)
            viewBinding.imageView.setImageBitmap(myBitmap)
        }

    }
}