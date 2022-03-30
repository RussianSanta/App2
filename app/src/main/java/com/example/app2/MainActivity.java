package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.translation.TranslationCapability;
import android.view.translation.TranslationManager;
import android.view.translation.TranslationRequest;
import android.view.translation.TranslationSpec;
import android.view.translation.UiTranslationManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app2.entity.FilmViewer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void nextClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        EditText text = findViewById(R.id.editTextTextPersonName);
        intent.putExtra("filmName",text.getText().toString());
        startActivity(intent);
    }
}