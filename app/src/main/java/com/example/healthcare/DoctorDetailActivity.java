package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.healthcare.R;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {
    String[][] doctorDetailList1 = {
            {"Doctor Name: Anuj Gayakwad", "Hospital Adderss: Pimpri","Exp: 5yrs", "Contact: 5678901234","400" },
            {"Doctor Name: Manoj Patil", "Hospital Adderss: Hijawdi","Exp: 6yrs", "Contact: 4578901234","700" },
            {"Doctor Name: Sanket Rahane", "Hospital Adderss: Pimpri","Exp: 7yrs", "Contact: 9978901234","900" },
            {"Doctor Name: Yash Patil", "Hospital Adderss: Hijawdi","Exp: 3yrs", "Contact: 6678901234","300" }
    };
    String[][] doctorDetailList2 = {
            {"Doctor Name: Anuj Gayakwad", "Hospital Adderss: Pimpri","Exp: 5yrs", "Contact: 5678901234","400" },
            {"Doctor Name: Manoj Patil", "Hospital Adderss: Hijawdi","Exp: 6yrs", "Contact: 4578901234","700" },
            {"Doctor Name: Sanket Rahane", "Hospital Adderss: Pimpri","Exp: 7yrs", "Contact: 9978901234","900" },
            {"Doctor Name: Yash Patil", "Hospital Adderss: Hijawdi","Exp: 3yrs", "Contact: 6678901234","300" }
    };
    String[][] doctorDetailList3 = {
            {"Doctor Name: Anuj Gayakwad", "Hospital Adderss: Pimpri","Exp: 5yrs", "Contact: 5678901234","400" },
            {"Doctor Name: Manoj Patil", "Hospital Adderss: Hijawdi","Exp: 6yrs", "Contact: 4578901234","700" },
            {"Doctor Name: Sanket Rahane", "Hospital Adderss: Pimpri","Exp: 7yrs", "Contact: 9978901234","900" },
            {"Doctor Name: Yash Patil", "Hospital Adderss: Hijawdi","Exp: 3yrs", "Contact: 6678901234","300" }
    };
    String[][] doctorDetailList4 = {
            {"Doctor Name: Anuj Gayakwad", "Hospital Adderss: Pimpri","Exp: 5yrs", "Contact: 5678901234","400" },
            {"Doctor Name: Manoj Patil", "Hospital Adderss: Hijawdi","Exp: 6yrs", "Contact: 4578901234","700" },
            {"Doctor Name: Sanket Rahane", "Hospital Adderss: Pimpri","Exp: 7yrs", "Contact: 9978901234","900" },
            {"Doctor Name: Yash Patil", "Hospital Adderss: Hijawdi","Exp: 3yrs", "Contact: 6678901234","300" }
    };
    String[][] doctorDetailList5 = {
            {"Doctor Name: Anuj Gayakwad", "Hospital Adderss: Pimpri","Exp: 5yrs", "Contact: 5678901234","400" },
            {"Doctor Name: Manoj Patil", "Hospital Adderss: Hijawdi","Exp: 6yrs", "Contact: 4578901234","700" },
            {"Doctor Name: Sanket Rahane", "Hospital Adderss: Pimpri","Exp: 7yrs", "Contact: 9978901234","900" },
            {"Doctor Name: Yash Patil", "Hospital Adderss: Hijawdi","Exp: 3yrs", "Contact: 6678901234","300" }
    };

    TextView tv;
    Button btn;
    String[][] doctorDetail = {};
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv = findViewById(R.id.textviewDDtitle);
        btn = findViewById(R.id.buttonDDback);
        ListView lst = findViewById(R.id.ListViewDD);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        switch (title) {
            case "Family Physician":
                doctorDetail = doctorDetailList1;
                break;
            case "Dietician":
                doctorDetail = doctorDetailList2;
                break;
            case "Dentist":
                doctorDetail = doctorDetailList3;
                break;
            case "Surgeon":
                doctorDetail = doctorDetailList4;
                break;
            case "Cardiologist":
                doctorDetail = doctorDetailList5;
                break;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailActivity.this, FindDoctorActivity2.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < doctorDetail.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("List1", doctorDetail[i][0]);
            item.put("List2", doctorDetail[i][1]);
            item.put("List3", doctorDetail[i][2]);
            item.put("List4", doctorDetail[i][3]);
            item.put("List5", "Cons Fees=" + doctorDetail[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,
                list,
                R.layout.multi_lines,
                new String[]{"List1", "List2", "List3", "List4", "List5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);


    }
}
