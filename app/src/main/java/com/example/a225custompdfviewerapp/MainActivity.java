package com.example.a225custompdfviewerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView = findViewById(R.id.pdfView);

        pdfView.setVisibility(View.GONE);


        pdfView.fromAsset("my_pdf.pdf")
                .onLoad(new OnLoadCompleteListener(){
                    @Override
                    public Void loadComplet(int nbPages){
                        pdfView.setVisibility(View.VISIBLE);

                        Toast.makeText(MainActivity.this,"Loaded",Toast.LENGTH_LONG).show();

                    }
                })
                .load();

    }
}