package com.example.healthcare;

import static java.lang.System.in;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor2);

        CardView exit =findViewById(R.id.CardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity2.this, HomeActivity.class));
            }
        });
        CardView familyphysician=findViewById(R.id.CardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity2.this,DoctorDetailActivity.class);
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });

        CardView dieticine=findViewById(R.id.CardFDDieticine);
        dieticine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity2.this,DoctorDetailActivity.class);
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });

        CardView dentist=findViewById(R.id.CardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity2.this,DoctorDetailActivity.class);
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });

        CardView surgeon=findViewById(R.id.CardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity2.this,DoctorDetailActivity.class);
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });

        CardView cardiologist=findViewById(R.id.CardFDCardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity2.this,DoctorDetailActivity.class);
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });

    }
}