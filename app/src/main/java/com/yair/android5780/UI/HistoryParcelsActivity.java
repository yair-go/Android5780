package com.yair.android5780.UI;

import android.os.Bundle;

import com.yair.android5780.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryParcelsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_parcels);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

    }
}
