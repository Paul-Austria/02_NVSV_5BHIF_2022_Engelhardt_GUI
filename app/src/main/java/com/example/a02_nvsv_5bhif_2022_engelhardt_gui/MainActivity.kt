package com.example.a02_nvsv_5bhif_2022_engelhardt_gui

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var countryList = arrayOf("India", "China", "australia", "Portugle", "America", "NewZealand")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayAdapter: ArrayAdapter<*>
        val regions = arrayOf(
            "Hokkaido", "Honshu", "Shikoku",
            "Kyushu"
        )

        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.JapanLocations)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, regions);
        mListView.adapter = arrayAdapter;

        mListView.onItemClickListener  = AdapterView.OnItemClickListener {parent, view, position, id ->
            val builder = AlertDialog.Builder(this)
            val value = regions.get(id.toInt());
            val intent = Intent(this, SubRegions::class.java);
            val b = Bundle();
            b.putSerializable("Island", value);
            intent.putExtras(b);
            startActivity(intent);
   /*         builder.setTitle(value);
            builder.setMessage("We have a message")
            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
            }
            builder.show();

    */
        }
    }
}