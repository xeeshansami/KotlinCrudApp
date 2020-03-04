package com.paxees.kotlinlearner

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    internal var dbHelper = DBHelper(this)
    val list: ArrayList<mForm> = ArrayList()
    override fun onClick(v: View) {
        when (v.id) {
            R.id.add -> {
                insert()
            }
            R.id.delete -> {
                delete()
            }
            R.id.search -> {
                search()
            }
            R.id.update -> {
                update()
            }
            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }
    }

    fun insert() {
        try {
            dbHelper.insertData(name.text.toString(), number.text.toString())
            clearEditText()
        } catch (e: Exception) {
            showDialogBox(e.message.toString(), "Error")
        }
    }

    fun delete() {
        try {
            dbHelper.deleteDate(id.text.toString())
            clearEditText()
        } catch (e: Exception) {
            showDialogBox(e.message.toString(), "Error")
        }
    }

    fun search() {
        val res = dbHelper.allData
        if (res.count == 0) {
            showDialogBox("No Data Found", "Error")
        }
        while (res.moveToNext()) {
            var myForm = mForm()
            myForm.id = res.getString(0)
            myForm.name = res.getString(1)
            myForm.number = res.getString(2)
            list.add(myForm)
        }
        val bundle = Bundle()
        bundle.putSerializable("ARRAYLIST", list)
        var intent = Intent(this, ListActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)

    }

    fun update() {
        try {
            dbHelper.updateData(id.text.toString(), name.text.toString(), number.text.toString())
        } catch (e: Exception) {
            showDialogBox(e.message.toString(), "Error")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add.setOnClickListener(this)
        update.setOnClickListener(this)
        delete.setOnClickListener(this)
        search.setOnClickListener(this)


    }

    fun showDialogBox(text: String, title: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(text)
        builder.show()
    }

    fun showToast(text: String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
    }

    fun clearEditText() {
        add.setText("")
        delete.setText("")
        search.setText("")
        update.setText("")
    }
}
