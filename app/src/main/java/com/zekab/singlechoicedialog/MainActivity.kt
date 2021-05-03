package com.zekab.singlechoicedialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var mListDataSize: Array<String>
    private lateinit var btnDataSize: TextView
    var mPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
        mListDataSize = resources.getStringArray(R.array.unit_data_size_items)
    }

    private fun initListener() {
        btnDataSize = findViewById(R.id.btnDataSize)
        btnDataSize.setOnClickListener {
            singleChoiceDialog()
        }
    }

    private fun singleChoiceDialog() {

        val builder = AlertDialog.Builder(this, R.style.dialogStyle)

        builder.setTitle("Select Unit")
            .setSingleChoiceItems(
                mListDataSize, mPosition
            ) { dialogInterface: DialogInterface?, i: Int -> mPosition = i }
            .setPositiveButton(
                "Ok"
            ) { dialogInterface: DialogInterface?, i: Int ->
                btnDataSize.text = mListDataSize[mPosition]
            }
            .setNegativeButton(
                "Cancel"
            ) { dialogInterface: DialogInterface?, i: Int -> }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }
}