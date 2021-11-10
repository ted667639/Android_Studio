package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import  androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity","onCreate")

        val adapter = ViewPagerAdapter(supportFragmentManager)
        findViewById<ViewPager>(R.id.viewPager).adapter = adapter
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity","onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity","onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.e("MainActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity","onStop")
    }

    fun onDestory() {
        super.onDestroy()
        Log.e("MainActivity","onDestory")
    }

}
class ViewPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm){
    override fun getItem(position: Int):Fragment {
        when (position) {
            0 -> return FirstFragment()
            1 -> return SecondFragment()
            else -> return  ThirdFragment()
        }
    }
        override fun getCount() = 3
}
