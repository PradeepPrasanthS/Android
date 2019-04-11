package com.example.magicidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID1;
    Button btnSubmit1;
    TextView tvResults1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID1 = findViewById(R.id.etID);
        btnSubmit1 = findViewById(R.id.btnSubmit);
        tvResults1 = findViewById(R.id.tvResults);

        tvResults1.setVisibility(View.GONE);

       btnSubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idNumber = etID1.getText().toString().trim();

                String dob =idNumber.substring(0,6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;

                if(gender<5)
                    sGender = getString(R.string.female);
                else
                    sGender = getString(R.string.male);

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;

                if(nationality == 0)
                    sNationality = getString(R.string.sacit);
                else
                    sNationality = getString(R.string.permanentresident);

                String text = getString(R.string.dob) + dob + getString(R.string.newline) +
                        getString(R.string.gender) + sGender + getString(R.string.newline) +
                        getString(R.string.nationality) + sNationality;

                tvResults1.setText(text);

                tvResults1.setVisibility(View.VISIBLE);
            }
        });
    }
}
