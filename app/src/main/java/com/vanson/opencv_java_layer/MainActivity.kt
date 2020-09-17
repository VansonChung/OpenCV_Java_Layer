package com.vanson.opencv_java_layer

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.opencv.android.Utils
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc
import org.opencv.osgi.OpenCVNativeLoader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val openCVLoader = OpenCVNativeLoader()
        openCVLoader.init()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.google)
        val mat = Mat()
        val grayMat = Mat()
        Utils.bitmapToMat(bitmap, mat)
        Imgproc.cvtColor(mat, grayMat, Imgproc.COLOR_RGB2GRAY)
        Utils.matToBitmap(grayMat, bitmap)
        imageView2.setImageBitmap(bitmap)
    }
}
