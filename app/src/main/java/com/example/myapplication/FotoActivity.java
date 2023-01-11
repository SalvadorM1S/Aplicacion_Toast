package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FotoActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        imageView=(ImageView) findViewById(R.id.imgView);

    }

    final int Captura_Imagen=1;

    public void tomarFoto(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if (intent.resolveActivity(this.getPackageManager())!=null){
            startActivityForResult(intent, Captura_Imagen);
        //}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
     if (requestCode==Captura_Imagen && resultCode==RESULT_OK){

        Bundle bundle=data.getExtras();

        Bitmap imagen=(Bitmap)bundle.get("data");

        imageView.setImageBitmap(imagen);

        try{
            FileOutputStream fos = openFileOutput(crearNombreArchivoJPG(), Context.MODE_PRIVATE);
            imagen.compress(Bitmap.CompressFormat.JPEG,100,fos);
            fos.close();
        }catch (Exception e){

        }
    }
}

    private String crearNombreArchivoJPG() {
        String fecha =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return fecha+".jpg";
    }



}