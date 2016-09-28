package com.phatinya.traffic;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Create ListView
        createListView();
    }//main method
    private void createListView(){
        MyData objMyData = new MyData();
        int[] intIcon = objMyData.icon();
        String[] strTitle = objMyData.title();
        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this,intIcon,strTitle);
        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(objMyAdapter);

        //Activity When Click LisView
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                myIntentToDetail(i);

            }
        });




    } //createListView

    private void myIntentToDetail (int intClick) {
        Intent objIntent =new Intent(MainActivity.this, showDetailActivity.class);
        objIntent.putExtra("click",intClick);
        startActivity(objIntent);


    }
    public void ClickAboutMe (View view){
        Intent objIntent = new Intent(Intent.ACTION_VIEW);
        objIntent.setData(Uri.parse("http://www.expertlab.ssru.ac.th"));
        startActivity(objIntent);
    } //click
}
