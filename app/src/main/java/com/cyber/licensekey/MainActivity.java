package com.cyber.licensekey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText license_text;
    Button validate;
    String license;
    TextView licenseStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        license_text = (EditText) findViewById(R.id.licenseKey);
        validate = (Button) findViewById(R.id.validate);
        licenseStatus = (TextView) findViewById(R.id.licenseStatus);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                license = license_text.getText().toString();
                if (CheckLicense.checkLicense(license)){
                    licenseStatus.setText("Valid!");
                    licenseStatus.setVisibility(View.VISIBLE);
                    Log.e("License", "OK");
                    launchLicensedctivity();
                }else {
                    licenseStatus.setVisibility(View.VISIBLE);
                    licenseStatus.setText("Invalid!");
                    Log.e("License", "Fail");
                }
            }
        });
    }

    public void launchLicensedctivity() {
        Log.d("New Activity", "Button clicked!");
        Intent intent = new Intent(this, LicensedActivity.class);
        startActivity(intent);
    }
}
