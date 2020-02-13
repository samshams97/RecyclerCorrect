package com.example.testmyself;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText nameE = findViewById(R.id.name);
        EditText familyE = findViewById(R.id.family);
        EditText emailE = findViewById(R.id.email);
        EditText phoneE = findViewById(R.id.phone);

        final TextView tName = findViewById(R.id.tName);
        final TextView tFamily = findViewById(R.id.tFamily);
        final TextView tEmail = findViewById(R.id.tEmail);
        final TextView tPhone = findViewById(R.id.tPhone);
        Button btnSave = findViewById(R.id.btnSave);

        String name1 = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).getString("Name","Nothing");
        tName.setText(name1);
        String family1 = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).getString("Family","Nothing");
        tFamily.setText(family1);
        String email = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).getString("Email","Nothing");
        tEmail.setText(email);
        String phone1 = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).getString("Phone","Nothing");
        tPhone.setText(phone1);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = new AlertDialog.Builder(ProfileActivity.this)
                        .setTitle("Attention")
                        .setMessage("Do you want to save this??")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String name = tName.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("Name",name).apply();
                                String family = tFamily.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("Family",family);
                                String Email = tEmail.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("Email",Email);
                                String phone = tPhone.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("Phone",phone);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ProfileActivity.this,"No clicked",Toast.LENGTH_LONG).show();
                            }
                        }).setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ProfileActivity.this,"Ok clicked",Toast.LENGTH_LONG).show();
                            }
                        }).create();
                dialog.show();
            }
        });

    }
}
