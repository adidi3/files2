package com.example.adipe.files2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.solver.widgets.Helper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    HelperDb hlp;
    String stFNAME, stLNAME, stCLASS, stBRO, stAGE;
    EditText etFNAME, etLNAME, etCLASS, etBRO, etAGE;
    Intent t;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFNAME = (EditText) findViewById(R.id.editText);
        etCLASS = (EditText) findViewById(R.id.editText4);
        etLNAME = (EditText) findViewById(R.id.editText22);
        etBRO = (EditText) findViewById(R.id.editText5);
        etAGE = (EditText) findViewById(R.id.editText3);


    }

    public void b1(View view) {
        hlp = new HelperDb(this);
        db = hlp.getWritableDatabase();
        stFNAME = etFNAME.getText().toString();
        stLNAME = etLNAME.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(Name.FNAME, stFNAME);
        cv.put(Name.LNAME, stLNAME);
        db.insert(Name.TABLE_USERS, null, cv);
        db.close();

    }


    public void b2(View view) {
        hlp = new HelperDb(this);
        db=hlp.getWritableDatabase();
        ContentValues cv = new ContentValues();
        stAGE = etAGE.getText().toString();
        stCLASS = etCLASS.getText().toString();
        stBRO = etBRO.getText().toString();
        cv.put(Age.AGE, stAGE);
        cv.put(Age.BRSI, stBRO);
        cv.put(Age.CLASS, stCLASS);
        db.insert(Age.TABLE_AGE, null, cv);
        db.close();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuCred) {
            Toast.makeText(this, "the app created by Adi Eisenberg ", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.tab) {
            t = new Intent(this, Main2Activity.class);
            startActivity(t);

        }
        return super.onOptionsItemSelected(item);
    }
}



