package com.example.batman.imagescroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView imageList;
    private List list;
    private ImageListAdapter imageListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList();

        buildList(0);

        imageListAdapter = new ImageListAdapter((LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE), list);
        imageList = (ListView) findViewById(R.id.image_list);
        imageList.setAdapter(imageListAdapter);

        imageList.setOnScrollListener(new EndlessImageScrollListener() {
            @Override
            public void onLoadMore(final int totalItemsCount) {
                buildList(totalItemsCount + 1);
                imageListAdapter.updateList(list);
                imageListAdapter.notifyDataSetChanged();
            }
        });
    }

    private void buildList(int startingPoint) {
        for (int i=startingPoint; i<startingPoint+20; i++) {
            list.add("http://dummyimage.com/300&text=["+i+"]");
        }
    }
}
