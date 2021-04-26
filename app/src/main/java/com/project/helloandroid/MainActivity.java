package com.project.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.project.helloandroid.model.DataItem;
import com.project.helloandroid.sample.SampleDataProvider;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> itemNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* textView = (TextView) findViewById(R.id.textView);
         textView.setText("");

        Collections.sort(dataItemList, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });

         */

        for (DataItem item: dataItemList) {
            // textView.append(item.getItemName() + "\n");
            itemNames.add(item.getItemName());
        }
        Collections.sort(itemNames);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemNames);
        ListView listView = findViewById(android.R.id.list);
        listView.setAdapter(adapter);
    }
}