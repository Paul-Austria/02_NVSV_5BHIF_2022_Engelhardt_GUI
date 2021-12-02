package com.example.a02_nvsv_5bhif_2022_engelhardt_gui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONArray
import org.json.JSONObject

class AttractionsOverview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attractions_overview)

        val dataFromMainActivity = intent.getSerializableExtra("City");



        val attractions = """
            {  
              "Fukushima":["Ksumigajo-Park", "Old Town", "Shinobu Sushi", "Higurashi Restaurant"]
           
            }
        """.trimIndent()


        val jsonObject = JSONObject(attractions);

        val list = jsonObject[dataFromMainActivity.toString()] as JSONArray;

        System.out.println(list);
        val newList = Array(list.length()){
            list.getString(it);
        }

        val arrayAdapter: ArrayAdapter<*>
        var mListView = findViewById<ListView>(R.id.attractions)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            newList
        );
        mListView.adapter = arrayAdapter;
    }
}