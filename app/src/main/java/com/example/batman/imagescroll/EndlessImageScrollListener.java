package com.example.batman.imagescroll;

import android.widget.AbsListView;

/**
 * Created by Batman on 6/1/16.
 */
public abstract class EndlessImageScrollListener implements AbsListView.OnScrollListener {
    private static int PAGINATION_BOUND_TRIGGER = 4;

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
    {
        if ((totalItemCount - visibleItemCount) <= (firstVisibleItem + PAGINATION_BOUND_TRIGGER)) {
            onLoadMore(totalItemCount);
        }
    }

    public abstract void onLoadMore(int totalItemsCount);

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {}
}
