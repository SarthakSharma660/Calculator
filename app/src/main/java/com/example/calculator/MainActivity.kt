package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button1 = findViewById(R.id.button1) as Button
        var button2 = findViewById(R.id.button2) as Button
        var button3 = findViewById(R.id.button3) as Button
        var button4 = findViewById(R.id.button4) as Button
        var button5 = findViewById(R.id.button5) as Button
        var button6 = findViewById(R.id.button6) as Button
        var button7 = findViewById(R.id.button7) as Button
        var button8 = findViewById(R.id.button8) as Button
        var button9 = findViewById(R.id.button9) as Button
        var button0 = findViewById(R.id.button0) as Button
        var buttonPlus = findViewById(R.id.button10) as Button
        var buttonMinus = findViewById(R.id.button11) as Button
        var buttonMulti = findViewById(R.id.button12) as Button
        var buttonDivide = findViewById(R.id.button13) as Button
        var buttonEqu = findViewById(R.id.buttonEqual) as Button
        var buttonReset = findViewById(R.id.buttonreset) as Button


        //      creating methods
        var textBox=findViewById(R.id.textInputEditText) as TextView
        var textBoxop=findViewById(R.id.output) as TextView
        fun appendOnClick(clear: Boolean, string: String){

            if (clear){
                textBoxop.text=""
                textBox.append(string)
            }else{
                textBox.append(textBoxop.text)
                textBox.append(string)
                textBoxop.text=""


            }

        }
        fun clear(){

            textBox.text=" "
            textBoxop.text=""

        }
        fun calculate(){
            try {

                val input=ExpressionBuilder(textBox.text.toString()).build()
                val output=input.evaluate()
                val longOutput=output.toLong()
                if(output==longOutput.toDouble()){
                    textBox.text=longOutput.toString()
                }else{
                    textBox.text=output.toString()
                }

            }catch (e:Exception){
                Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
            }
        }


//        number listeners

        button1.setOnClickListener{appendOnClick(true,"1")}
        button2.setOnClickListener{appendOnClick(true,"2")}
        button3.setOnClickListener{appendOnClick(true,"3")}
        button4.setOnClickListener{appendOnClick(true,"4")}
        button5.setOnClickListener{appendOnClick(true,"5")}
        button6.setOnClickListener{appendOnClick(true,"6")}
        button7.setOnClickListener{appendOnClick(true,"7")}
        button8.setOnClickListener{appendOnClick(true,"8")}
        button9.setOnClickListener{appendOnClick(true,"9")}
        button0.setOnClickListener{appendOnClick(true,"0")}
//        operator listener
        buttonPlus.setOnClickListener{appendOnClick(false,"+")}
        buttonMinus.setOnClickListener{appendOnClick(false,"-")}
        buttonMulti.setOnClickListener{appendOnClick(false,"*")}
        buttonDivide.setOnClickListener{appendOnClick(false,"/")}
        buttonEqu.setOnClickListener{calculate()}
        buttonReset.setOnClickListener{clear()}




    }

}