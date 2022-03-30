package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app2.entity.FilmViewer;
import com.example.app2.entity.FilmViewerAdapter;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private String filmName;
    private ArrayList<FilmViewer> filmViewers = new ArrayList<>();
    private ListView filmViewersList;
    private FilmViewer selectedViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.filmNameTextView);
        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            filmName = arguments.get("filmName").toString();
            textView.setText(filmName);
        }

        setInitialData();
        filmViewersList = findViewById(R.id.filmViewersList);
        FilmViewerAdapter stateAdapter = new FilmViewerAdapter(this, R.layout.list_item, filmViewers);
        filmViewersList.setAdapter(stateAdapter);
        AdapterView.OnItemClickListener itemListener = (parent, v, position, id) -> {
            selectedViewer = (FilmViewer) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "Был выбран сервис " + selectedViewer.getName(),
                    Toast.LENGTH_SHORT).show();
        };
        filmViewersList.setOnItemClickListener(itemListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Создана активити " + this.getLocalClassName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Активити приостановлена " + this.getLocalClassName(), Toast.LENGTH_SHORT).show();
    }

    private void setInitialData(){

        filmViewers.add(new FilmViewer ("Кинопоиск", "Российский стриминг", R.drawable.kinopoisk));
        filmViewers.add(new FilmViewer ("Нетфликс", "Дорогая подписка", R.drawable.netflix));
        filmViewers.add(new FilmViewer ("Иви", "Давно забытый", R.drawable.ivi));
    }

    public void nextClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ThirdActivity.class);
        intent.putExtra("filmName",filmName);
        intent.putExtra("filmViewer",selectedViewer);
        startActivity(intent);
    }

    public void backClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}