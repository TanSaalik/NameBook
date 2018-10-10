package com.example.tan.namebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    private EditText txtName, txtPhone, txtEmail, txtText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtName = findViewById(R.id.showName);
        txtPhone = findViewById(R.id.showPhone);
        txtEmail = findViewById(R.id.showEmail);
        txtText = findViewById(R.id.showShortText);

        Person person = (Person)getIntent().getSerializableExtra("person");
        txtName.setText(person.getName());
        txtPhone.setText(person.getPhone());
        txtEmail.setText(person.getEmail());
        txtText.setText(person.getText());
    }
}
