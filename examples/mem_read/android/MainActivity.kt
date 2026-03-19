package com.example.testndk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.testndk.databinding.ActivityMainBinding
import java.nio.ByteBuffer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()

        val secret = "SECRET_ABC_123\u0000".toByteArray(Charsets.UTF_8)

        val buf = ByteBuffer.allocateDirect(secret.size)
        buf.put(secret)
        buf.flip()

        logDirectBufferAddress(buf)

        Log.d("MEMDEMO", "Secret prepared")
    }

    /**
     * A native method that is implemented by the 'testndk' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    private external fun logDirectBufferAddress(buf: ByteBuffer)

    companion object {
        // Used to load the 'testndk' library on application startup.
        init {
            System.loadLibrary("testndk")
        }
    }
}
