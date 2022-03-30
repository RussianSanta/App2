package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app2.entity.FilmViewer;

public class ThirdActivity extends AppCompatActivity {
    private String filmName;
    private FilmViewer service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Создана активити " + this.getLocalClassName(), Toast.LENGTH_SHORT).show();

        Bundle arguments = getIntent().getExtras();
        TextView nameLabel = findViewById(R.id.nameLabel);
        if(arguments!=null){
            filmName = arguments.get("filmName").toString();
            service = (FilmViewer) arguments.getSerializable("filmViewer");
            if (service == null) nameLabel.setText("Не выбран сервис просмотра, вернитесь на шаг назад");
            else
            nameLabel.setText("Выбран фильм " + filmName + " в сервисе " + service.getName());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Активити приостановлена " + this.getLocalClassName(), Toast.LENGTH_SHORT).show();
    }

    public void nextClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

    public void backClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        intent.putExtra("filmName",filmName);
        startActivity(intent);
    }
}