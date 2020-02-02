package com.lhq.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fahrenhei, celsius;;
    Button f2c, c2f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fahrenhei = (EditText)findViewById(R.id.fahrenheit);
        celsius = (EditText)findViewById(R.id.celsius);
        f2c = (Button)findViewById(R.id.f2c);
        c2f = (Button)findViewById(R.id.c2f);

        f2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String F = fahrenhei.getText().toString();
                Log.i("Info", "String of farenheit = " + F);

                if (F.length() == 0) {
                    Toast.makeText(v.getContext(),
                            "ERROR: Input value for fahrenheit degree is empty!",
                            Toast.LENGTH_LONG).show();
                    Log.e("Error", "String of F is empty!");
                    return;
                }

                double valF = 32.0;
                try {
                    valF = Double.parseDouble(F);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.e("Error", "String of txtF is not parsable!");
                    Toast.makeText(v.getContext(),
                            "ERROR: Input value for F degree is invalid!",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                double valC = (valF - 32)*5/9;

                String strC = Double.toString(valC);

                Log.i("Info", "String of Celsius = " + strC);

                celsius.setText(strC);
            }
        });

        c2f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String C = celsius.getText().toString();
                Log.i("Info", "String of celsius = " + C);

                if (C.length() == 0) {
                    Toast.makeText(v.getContext(),
                            "ERROR: Input value for C degree is empty!",
                            Toast.LENGTH_LONG).show();
                    Log.e("Error", "String of txtC is empty!");
                    return;
                }

                double valC = 32.0;
                try {
                    valC = Double.parseDouble(C);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.e("Error", "String of txtC is not parsable!");
                    Toast.makeText(v.getContext(),
                            "ERROR: Input value for C degree is invalid!!!",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                double valF = (valC * 9/5 + 32);

                String strF = Double.toString(valF);

                Log.i("Info", "String of fahrenheit = " + strF);

                fahrenhei.setText(strF);
            }
        });
    }

}
