package com.example.studentdbappp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1,b2;
    String getName,getAdd,getRoll,getClg;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        dbhelper=new DatabaseHelper(this);
        dbhelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.nam);
        ed2=(EditText) findViewById(R.id.ad);
        ed3=(EditText) findViewById(R.id.roll);
        ed4=(EditText) findViewById(R.id.col);
        b1=(AppCompatButton) findViewById(R.id.bt1);
        b2=(AppCompatButton) findViewById(R.id.bt2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=ed1.getText().toString();
                getAdd=ed2.getText().toString();
                getRoll=ed3.getText().toString();
                getClg=ed4.getText().toString();
               boolean result=dbhelper.insertData(getName,getRoll,getAdd,getClg);
               if(result==true){
                   ed1.setText("");
                   ed2.setText("");
                   ed3.setText("");
                   ed4.setText("");
                   Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(), "failed to insert", Toast.LENGTH_SHORT).show();
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