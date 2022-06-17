package com.example.camerasample

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import java.io.ByteArrayOutputStream
import java.io.File

class RecyclerViewAdapter(var imgStringList:MutableList<File>):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {



    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener{

        private var view: View=v
        private lateinit var imageView : ImageView

        private lateinit var imageFile: File

        init {
            imageView = view.findViewById(R.id.image_view)

            v.setOnClickListener(this)
        }

        fun bind(image: Bitmap) {
            imageView.setImageBitmap(image)

        }

        fun set(image:File){
            imageFile=image
        }

        override fun onClick(v: View?) {
            var context=itemView.context

            //val drawable=imageView.drawable
            //val img=
           // adapterPosition
            //val bitmapDrawable=drawable.toBitmap()

            //val bs:ByteArrayOutputStream= ByteArrayOutputStream()
            //bitmapDrawable.compress(Bitmap.CompressFormat.PNG, 50, bs)



            val intent:Intent=Intent(context,ViewImageActivity::class.java)
            intent.putExtra("filepath",imageFile.absolutePath)
            Log.d("path","path is ${imageFile.absolutePath}")
            context.startActivity(intent)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val context = viewGroup.context
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false

        val view = inflater.inflate(R.layout.recycler_view_item, viewGroup, shouldAttachToParentImmediately)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var imgFile:File=imgStringList[position]
        if(imgFile.exists()) run {
            var myBitmap: Bitmap = BitmapFactory.decodeFile(imgFile.absolutePath)
            holder.set(imgFile)
            holder.bind(myBitmap)
        }


    }

    override fun getItemCount(): Int {
        return imgStringList.size
    }

}