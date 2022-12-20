package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editeCorreo;
    private EditText editecontra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editeCorreo = (EditText) findViewById(R.id.edtCorreo);
        editecontra = (EditText) findViewById(R.id.edtPassword);
    }


        /*@Override*/
        public void clickBon(View view) {
     //       Intent inten = new Intent(this, menuActivity.class);
            String usuario = editeCorreo.getText().toString();
            String contras = editecontra.getText().toString();

            Toast toast1 = Toast.makeText(getApplicationContext(),"El programa dice: "+usuario+" con la contraseña: "+contras, Toast.LENGTH_SHORT);
            toast1.show();
        }

}