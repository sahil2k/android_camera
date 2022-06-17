package com.example.camerasample

import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.camerasample.databinding.ActivityGalleryBinding
import java.io.File


class GalleryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var layoutManager: GridLayoutManager
    private lateinit var viewBinding: ActivityGalleryBinding
    //lateinit var imgStringList:MutableList<String>
    lateinit var fileList:MutableList<File>

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        viewBinding= ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        //imgStringList= mutableListOf()

        getFileList()

        recyclerView=viewBinding.recyclerView
        adapter= RecyclerViewAdapter(fileList)
        layoutManager= GridLayoutManager(this,3)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=layoutManager
    }


    private fun getFileList(){
        val path = Environment.getExternalStorageDirectory().toString() + "/Pictures/CameraX-Image"
        Log.d("Files", "Path: $path")
        val directory = File(path)
        fileList= directory.listFiles().toMutableList()
        Log.d("Files", "Size: " + fileList.size)
        for (i in fileList.indices) {
            Log.d("Files", "FileName:" + fileList[i].getName())
        }
    }
}