# 02_NVSV_5BHIF_2022_Engelhardt_GUI

## Goal

The goal is to create a overview of japanese island prefactures and attractions.
The way this is done is by having tables with content that lead to a more specfic location until we end by an attraction

![](https://github.com/Paul-Austria/02_NVSV_5BHIF_2022_Engelhardt_GUI/blob/main/Images/Path.png)

For example we start at the top which is currently very simple and looks like this:

![](https://github.com/Paul-Austria/02_NVSV_5BHIF_2022_Engelhardt_GUI/blob/main/Images/TopImage)

by follwing the table path we end up at the bottom,which shows us a list of attractions in fukushima.

![](https://github.com/Paul-Austria/02_NVSV_5BHIF_2022_Engelhardt_GUI/blob/main/Images/Bottom)

## Solution

Navigation is done similar like in the first Homework. When clicking on a list item we search the respective element in the given list

```kt
      mListView.onItemClickListener  = AdapterView.OnItemClickListener { parent, view, position, id ->
            val builder = AlertDialog.Builder(this)
            val value = list.get(id.toInt());
            val intent = Intent(this, PrefactureList::class.java);
            val b = Bundle();
            b.putSerializable("Region", value.toString());
            intent.putExtras(b);
            startActivity(intent);

        }
```

There we pass the data intoa serializable. In this case we go from the Region activty to the Prefacture activity.

Inside this one we have json file that has the following data:
```kt
         val prefactures = """
            {  
              "Tohoku":["Akita", "Aomori", "Fukushima", "Iwate", "Miyagi", "Yamagata"]
              "Hokkaido":["Hokkaido"]
            }
        """.trimIndent()
                val jsonObject = JSONObject(prefactures);

```

There we put the data inside the list:


```
 val list = jsonObject[dataFromMainActivity.toString()] as JSONArray;

        val newList = Array(list.length()){
            list.getString(it);
        }

        val arrayAdapter: ArrayAdapter<*>
        var mListView = findViewById<ListView>(R.id.prefactures)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, newList);
        mListView.adapter = arrayAdapter;
```
The same procedure is repeated for the follwing pages
```
