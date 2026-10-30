package com.example.firstform;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars=insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText username=findViewById(R.id.editTextText5);
        EditText fullName=findViewById(R.id.editTextText6);
        EditText country=findViewById(R.id.editTextText7);
        EditText email=findViewById(R.id.editTextTextEmailAddress2);
        EditText phone=findViewById(R.id.editTextPhone2);
        EditText password=findViewById(R.id.editTextTextPassword);

        RadioGroup genderGroup=findViewById(R.id.radioGroupGender);
        CheckBox terms=findViewById(R.id.checkBox3);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(v -> {

            String user=username.getText().toString();
            String name=fullName.getText().toString();
            String userCountry=country.getText().toString();
            String userEmail=email.getText().toString();
            String userPhone=phone.getText().toString();
            String userPassword=password.getText().toString();

            String gender="Not selected";

            int selectedId=genderGroup.getCheckedRadioButtonId();

            if (selectedId!=-1){
                RadioButton selectedGender=findViewById(selectedId);
                gender=selectedGender.getText().toString();
            }

            String acceptedTerms=terms.isChecked() ? "Yes" : "No";

            String details =
                    "Username: " + user +
                            "\nFull Name: " + name +
                            "\nCountry: " + userCountry +
                            "\nEmail: " + userEmail +
                            "\nPhone: " + userPhone +
                            "\nPassword: " + userPassword +
                            "\nGender: " + gender +
                            "\nTerms Accepted: " + acceptedTerms;

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Registration Details")
                    .setMessage(details)
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}