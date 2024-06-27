package com.matrix.fragmenttoactivityviceversa

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.matrix.fragmenttoactivityviceversa.databinding.ActivityTextChangeBinding

class ActivityTextChange : AppCompatActivity() {
    var binding: ActivityTextChangeBinding?=null
    var activityInterface:ActivityInterface?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityTextChangeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.btnActivity?.setOnClickListener {
            if (binding?.etActivity?.text.toString().isEmpty()==true){
                binding?.etActivity?.error="Enter Something"
            }
            else{
                activityInterface?.changeFragmentText(binding?.etActivity?.text.toString())
            }
        }
    }
  fun changeActivityText(text: String){
        binding?.btnActivity?.setText(text)

    }


}