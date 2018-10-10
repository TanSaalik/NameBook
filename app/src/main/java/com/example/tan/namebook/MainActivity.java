package com.example.tan.namebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private People people;
    private EditText txtName, txtPhone, txtEmail, txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadPeople();

        txtName = findViewById(R.id.editTextName);
        txtPhone = findViewById(R.id.editTextPhone);
        txtEmail = findViewById(R.id.editTextEmail);
        txtText = findViewById(R.id.editTextShortText);

    }

    public void onClear(View view) {
        clear();
    }

    public void onSave(View view) {
        String name = txtName.getText().toString().trim();
        String phone = txtPhone.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String text = txtText.getText().toString().trim();

        if(name.length() > 0){
            try{
                people.save(new Person(name, phone, email, text));
                Toast.makeText(this, getResources().getString(R.string.msg_save),
                        Toast.LENGTH_SHORT).show();
                clear();
            }
            catch (Exception ex){}
        }
    }

    public void onShow(View view) {
        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        intent.putExtra("persons", people);
        startActivity(intent);
    }

    public void clear(){
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtText.setText("");
    }

    private void loadPeople(){
        try{
            people = new People(this);
        }
        catch (Exception ex){
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.addCategory(Intent.CATEGORY_HOME);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(home);
        }
    }
}
