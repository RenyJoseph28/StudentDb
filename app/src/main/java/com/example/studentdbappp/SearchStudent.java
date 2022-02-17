package com.example.studentdbappp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchStudent extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton b1,b2;
String getAdd,getname,getroll,getcol;
DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);
        dbHelper=new DatabaseHelper(this);
        dbHelper.getWritableDatabase();
        ed1=(EditText)findViewById(R.id.adn);
        ed2=(EditText) findViewById(R.id.nam);
        ed3=(EditText) findViewById(R.id.roll);
        ed4=(EditText) findViewById(R.id.col);
        b1=(AppCompatButton) findViewById(R.id.sea);
        b2=(AppCompatButton) findViewById(R.id.bac);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAdd=ed1.getText().toString();
                Cursor c= dbHelper.Search(getAdd);
                if(c.getCount()==0)
                {
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    Toast.makeText(getApplicationContext(), "invalid admission number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (c.moveToNext())
                    {
                       getname=c.getString(1) ;
                       getroll=c.getString(2);
                       getcol=c.getString(4);
                    }
                    ed2.setText(getname);
                    ed3.setText(getroll);
                    ed4.setText(getcol);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}