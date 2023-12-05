package com.example.hesap_makinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener, View.OnClickListener {
    TextView sonuc;
    Button toplama;
    Button cikarma;
    Button bolme;
    Button carpma;
    EditText birinciSayi;
    EditText ikinciSayi;

    double birinci;
    double ikinci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sonuc = (TextView) findViewById(R.id.textViewSonuc);
        toplama = (Button) findViewById(R.id.buttonToplama);
        cikarma = (Button) findViewById(R.id.buttonCikarma);
        bolme = (Button) findViewById(R.id.buttonBolme);
        carpma = (Button) findViewById(R.id.buttonCarpma);
        birinciSayi = (EditText) findViewById(R.id.editTextBirinci);
        ikinciSayi = (EditText) findViewById(R.id.editTextIkinci);

        birinciSayi.setOnEditorActionListener(this);
        ikinciSayi.setOnEditorActionListener(this);

        toplama.setOnClickListener(this);
        cikarma.setOnClickListener(this);
        bolme.setOnClickListener(this);
        carpma.setOnClickListener(this);

    }
    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (textView.getId()==birinciSayi.getId()){
            birinci = Double.parseDouble(birinciSayi.getText().toString());
        }else {
            ikinci = Double.parseDouble(ikinciSayi.getText().toString());
        }
        return false;
    }
    @Override
    public void onClick(View view) {
        Hesapla hesapla = new Hesapla();
        if (view.getId()==toplama.getId()){
            sonuc.setText(String.valueOf(hesapla.topla(Double.parseDouble(birinciSayi.getText().toString()),
                    Double.parseDouble(ikinciSayi.getText().toString()))));
        }
        else if (view.getId()==cikarma.getId()) {
            sonuc.setText(String.valueOf(hesapla.cikar(Double.parseDouble(birinciSayi.getText().toString()),
                    Double.parseDouble(ikinciSayi.getText().toString()))));
        }
        else if (view.getId()==bolme.getId()) {
            if (Double.parseDouble(ikinciSayi.getText().toString())==0)
                sonuc.setText("payda sifir olamaz");
            else
                sonuc.setText(String.valueOf(hesapla.bol(Double.parseDouble(birinciSayi.getText().toString()),
                        Double.parseDouble(ikinciSayi.getText().toString()))));
        }
        else if (view.getId()==carpma.getId()) {
            sonuc.setText(String.valueOf(hesapla.carp(Double.parseDouble(birinciSayi.getText().toString()),
                    Double.parseDouble(ikinciSayi.getText().toString()))));
        }
        else
            System.out.println("sanırım bir hata oldu");
    }

}