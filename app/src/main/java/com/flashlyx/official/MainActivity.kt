package com.flashlyx.official

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

private lateinit var cameraManager: CameraManager
private lateinit var cameraId: String
private var isFlashOn = false

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)

val flashButton = findViewById<ImageButton>(R.id.btnFlash)
val statusText = findViewById<TextView>(R.id.statusText)

cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
cameraId = cameraManager.cameraIdList[0]

flashButton.setOnClickListener {
isFlashOn = !isFlashOn
cameraManager.setTorchMode(cameraId, isFlashOn)

statusText.text = if (isFlashOn) "ON" else "OFF"
statusText.setTextColor(
if (isFlashOn) 0xFF00FF99.toInt() else 0xFF9AA0A6.toInt()
)
}
}
}