package net.blueness.androidthreadtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = find(R.id.text)
        val changeText: Button = find(R.id.change_text)
        changeText.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.change_text -> {
                object : Thread(){
                    override fun run() {
                        text?.setText("Nice to meet you.")
                    }
                }.start()
            }
        }
    }
}
