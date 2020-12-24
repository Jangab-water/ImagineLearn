package com.nhw.jdbctest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Fairytale extends AppCompatActivity {

    private RecyclerView mView;
    private Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private int max = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fairytale);

        mView = findViewById(R.id.rv_tale);

        ArrayList<book> books = new ArrayList<>();

        books.add(new book(R.drawable.cindy, "신데렐라"));
        books.add(new book(R.drawable.hensel, "헨젤과 그레텔"));
        books.add(new book(R.drawable.match, "성냥팔이 소녀"));
        books.add(new book(R.drawable.boots, "장화신은 고양이"));
        books.add(new book(R.drawable.snow, "백설공주"));

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mView.setLayoutManager(mLayoutManager);

        mAdapter = new Adapter(getApplicationContext());

        mAdapter.setBooks(books);

        mView.setAdapter(mAdapter);




    }
}