package com.example.batman.imagescroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Batman on 5/31/16.
 */
public class ImageListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<String> list;

    public ImageListAdapter(LayoutInflater inflater, List list){
        this.inflater = inflater;
        this.list = list;
    }

    public void updateList(List list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        View view = inflater.inflate(R.layout.image_list_view_item, parent, false);
        holder = new ViewHolder(view, inflater.getContext());
        holder.setup(list.get(position));

        return view;
    }

    static class ViewHolder{
        ImageView image;
        Context context;

        public ViewHolder(View view, Context context){
            this.image = (ImageView) view.findViewById(R.id.image);
            this.context = context;
        }

        public void setup(String url) {
            Picasso.with(this.context)
                    .load(url)
                    .into(this.image);
        }
    }
}
