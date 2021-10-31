package com.rustan.calculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.rustan.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btn_input()


    }

    private fun btn_input() = with(binding) {
        button0.setOnClickListener { setTextField("0") }
        button1.setOnClickListener { setTextField("1") }
        button2.setOnClickListener { setTextField("2") }
        button3.setOnClickListener { setTextField("3") }
        button4.setOnClickListener { setTextField("4") }
        button5.setOnClickListener { setTextField("5") }
        button6.setOnClickListener { setTextField("6") }
        button7.setOnClickListener { setTextField("7") }
        button8.setOnClickListener { setTextField("8") }
        button9.setOnClickListener { setTextField("9") }
        minus.setOnClickListener { setTextField("-") }
        plus.setOnClickListener { setTextField("+") }
        umno.setOnClickListener { setTextField("*") }
        delity.setOnClickListener { setTextField("/") }

        back.setOnClickListener {
            val str = tabTab.text.toString()
            if (str.isNotEmpty()) {
                tabTab.text = str.substring(0, str.length - 1)
                back.text = ""
            }
        }
        rovno.setOnClickListener {
            try {
                val ex = ExpressionBuilder(tabTab.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble()) {
                    otvet.text = longRes.toString()
                } else {
                    otvet.text = result.toString()
                }

            } catch (e: Exception) {
                Log.d("Banana", "$e")

            }

        }

    }

    fun setTextField(str: String) {
        binding.tabTab.append(str)
    }


}