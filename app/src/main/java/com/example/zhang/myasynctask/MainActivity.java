package com.example.zhang.myasynctask;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parcelable book1 = new Book(1,"one");
        File file  = new File("file");
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(book1);
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            inputStream.readObject();


        } catch (Exception e) {
            e.printStackTrace();
            //soutsout
        }
    }
}
