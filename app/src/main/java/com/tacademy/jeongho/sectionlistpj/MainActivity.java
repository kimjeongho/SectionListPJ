package com.tacademy.jeongho.sectionlistpj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    MyAdapter myAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

        initData();

    }

    public void initData() {


        for(int i = 0 ; i < 4; i++){
           GroupItem gi = new GroupItem();
            gi.groupName = "Group:"+i;
            myAdapter.add(gi);
            for (int j = 0; j <4; j++){
               ChildItem ci = new ChildItem();
                ci.childName= gi.groupName+"Child"+j;
                myAdapter.add(ci);
            }
        }

    }
}
