package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {


    private String[][] packages={
            {"Package1: Full Body Checkup","","","","900"},
            {"Package2: Blood Glucose Fasting","","","","400"},
            {"Package3: Covid-19 Antibody-IgG","","","","500"},
            {"Package4: Thyroid Check","","","","300"},
            {"Package5: Immunity Check","","","","600"}
    };

    private String[][] packagedetails = {
            { "Blood Glucose fasting\n"+
                    "Complete Hemogram\n"+
                    "HbA1c\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "LDH Lactate Dehydrogenase+ Serum\n"+
                    "Lipid Profile\n"+
                    "Liver Function Test"},
    { "Blood Glucose Fasting"},
    {"Covid-19 Antibody - IgG"},
    {"Thyroid Profile Total"},
            {"Complete Hemogram\n"+ "CRP Quantitative\n"+" Serum\n"+ "Iron Studies\n"+ "Kidney Function Test\n"+ "Lipid Profile"}
    };
HashMap<String,String> item;
ArrayList list;
SimpleAdapter sa;
Button  btnback;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);


        btnback=findViewById(R.id.buttonBMback);
        listView=findViewById(R.id.ListViewBM);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list=new ArrayList();
        for (int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("List1",packages[i][0]);
            item.put("List2",packages[i][1]);
            item.put("List3",packages[i][2]);
            item.put("List4",packages[i][3]);
            item.put("List5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,
                list,
                R.layout.multi_lines,
                new String[]{"List1", "List2", "List3", "List4", "List5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);




    }
}