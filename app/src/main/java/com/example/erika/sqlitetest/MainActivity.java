package com.example.erika.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.erika.sqlitetest.Helpers.SqliteHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqliteHelper connection = new SqliteHelper(this, "test1", null, 0);
    }
}
