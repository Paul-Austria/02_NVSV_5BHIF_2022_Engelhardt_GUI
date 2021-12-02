package com.example.a02_nvsv_5bhif_2022_engelhardt_gui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class SubRegions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_regions)

        val dataFromMainActivity = intent.getSerializableExtra("Island");

        val subRegions = """
            {  
                    "Hokkaido":["Hokkaido"],
                    "Honshu":["Tohoku", "Kanto", "Chubu", "Kansai", "Chugoku"],
                    "Shikoku":["Shikoku"],
                    "Kyushu": ["Kyushu"]
                
            }
        """.trimIndent()


        val jsonObject = JSONObject(subRegions);

        val list = jsonObject[dataFromMainActivity.toString()] as JSONArray;

        System.out.println(list);
        val newList = Array(list.length()){
            list.getString(it);
        }

        val arrayAdapter: ArrayAdapter<*>
        var mListView = findViewById<ListView>(R.id.subRegions)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, newList);
        mListView.adapter = arrayAdapter;


        mListView.onItemClickListener  = AdapterView.OnItemClickListener { parent, view, position, id ->
            val builder = AlertDialog.Builder(this)
            val value = list.get(id.toInt());
            val intent = Intent(this, PrefactureList::class.java);
            val b = Bundle();
            b.putSerializable("Region", value.toString());
            intent.putExtras(b);
            startActivity(intent);

        }
    }
}