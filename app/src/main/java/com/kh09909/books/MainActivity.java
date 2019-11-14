package com.kh09909.books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_books);
        new FirebaseDatabaseHelper().readBooks(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Book> books, List<String> keys) {

                findViewById(R.id.loading_books_pb).setVisibility(View.GONE);
                new RecyclerView_Config().setConfig(mRecyclerView, MainActivity.this,
                        books, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpadated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}
