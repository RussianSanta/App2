package com.example.app2.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app2.R;

import java.util.List;

public class FilmViewerAdapter extends ArrayAdapter<FilmViewer> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<FilmViewer> viewers;

    public FilmViewerAdapter(Context context, int resource, List<FilmViewer> viewers) {
        super(context, resource, viewers);
        this.viewers = viewers;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView iconView = view.findViewById(R.id.icon);
        TextView nameView = view.findViewById(R.id.name);
        TextView descriptionView = view.findViewById(R.id.description);

        FilmViewer state = viewers.get(position);

        iconView.setImageResource(state.getIconResource());
        nameView.setText(state.getName());
        descriptionView.setText(state.getDescription());

        return view;
    }
}
