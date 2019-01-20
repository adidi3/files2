package com.example.adipe.files2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

        ListView lv;
        HelperDb hlp;
        SQLiteDatabase db;
        Cursor c;
        Spinner spi;
        ArrayAdapter adp;
      String [] which={"name","age"};
      ArrayList<String>data=new  ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spi= (Spinner) findViewById(R.id.spin);
        lv = (ListView) findViewById(R.id.list1);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, which);
        spi.setAdapter(adp);
        spi.setOnItemSelectedListener(this);

        hlp = new HelperDb(this);




}


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        db = hlp.getWritableDatabase();
        data.clear();
        if (position == 0) {
            c = db.query(Name.TABLE_USERS, null, null, null, null, null, null);
            int[] col = new int[3];
            col[0] = c.getColumnIndex("_id");
            col[1] = c.getColumnIndex("Fname");
            col[2] = c.getColumnIndex("Lname");
            c.moveToFirst();
            while (!c.isAfterLast()) {
                //int Pid = c.getInt(col1);
                String ID1 = c.getString(col[1]);
                String Class1 = c.getString(col[2]);
                String temp = ID1 + ", " + Class1;
                data.add(temp);
                c.moveToNext();
                adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
                lv.setAdapter(adp);
            }
        }
        else{
                c = db.query(Age.TABLE_AGE, null, null, null, null, null, null);
                int[] col = new int[4];
                col[0] = c.getColumnIndex("_idAge");
                col[1] = c.getColumnIndex("Age");
                col[2] = c.getColumnIndex("brothers");
                col[3]= c.getColumnIndex("Class");
                c.moveToFirst();

                while (!c.isAfterLast()) {
                    int age = c.getInt(col[1]);
                    int siblings = c.getInt(col[2]);
                    String clas = c.getString(col[3]);
                    String temp = age + ", " + siblings + ", " + clas;
                    data.add(temp);
                    c.moveToNext();
                    adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
                    lv.setAdapter(adp);
                }
            }
        c.close();
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

