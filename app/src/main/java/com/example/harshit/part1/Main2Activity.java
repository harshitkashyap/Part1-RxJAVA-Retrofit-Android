package com.example.harshit.part1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String s = getIntent().getStringExtra("yoo");
        String[] arr=s.split("<>");

        ImageView im=(ImageView)findViewById(R.id.imageView);
        Picasso.with(getApplicationContext()).load(arr[1]).into(im);

        TextView t1=(TextView)findViewById(R.id.editText);
        t1.setText("Population:"+arr[2]);


    }
}
