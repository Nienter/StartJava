package com.myjava.javatest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fun sum(a: Int, b: Int) = a + b
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    override fun onPause() {
        super.onPause()
    }
   fun  tex(){
       return
   }
}