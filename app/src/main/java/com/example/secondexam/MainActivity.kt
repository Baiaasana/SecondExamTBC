package com.example.secondexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.secondexam.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val anagramList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txvAnagramCount.text = "0"

        listeners()
    }

    private fun listeners() {

        binding.btnSave.setOnClickListener {

            addAnagram()

        }

        binding.btnOutput.setOnClickListener {

            groupAnagrams(anagramList.toTypedArray())
            binding.txvAnagramCount.text = groupAnagrams(anagramList.toTypedArray()).toString()

        }
    }

    private fun addAnagram() {

        anagramList.add(binding.edtEnterAnagram.text.toString())
        Toast.makeText(this, "anagram saved", Toast.LENGTH_SHORT).show()
        Log.d("add", anagramList.toString())

    }


    private fun groupAnagrams(strs: Array<String>): Int {
        val resultingMap = mutableMapOf<Map<Char, Int>, List<String>>()

        strs.forEach { str ->
            val key = mutableMapOf<Char, Int>()
            str.forEach {
                key[it] = (key[it] ?: 0) + 1
            }

            resultingMap[key] = (resultingMap[key] ?: listOf<String>()) + str
        }

        return resultingMap.values.toList().size

    }


//    private fun areAnagram(str1: String, str2: String): Boolean {
//
//        if (str1.length != str2.length) {
//            return false
//        }
//
//        val strArray1 = str1.toCharArray()
//        val strArray2 = str2.toCharArray()
//
//        Arrays.sort(strArray1)
//        Arrays.sort(strArray2)
//
//        val sortedStr1 = String(strArray1)
//        val sortedStr2 = String(strArray2)
//
//        return sortedStr1 == sortedStr2
//    }


}

