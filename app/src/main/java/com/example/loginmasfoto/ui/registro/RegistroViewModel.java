package com.example.loginmasfoto.ui.registro;

import static android.app.Activity.RESULT_OK;
import static com.example.loginmasfoto.Request.ApiClient.guardar;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.loginmasfoto.Modelos.Usuario;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegistroViewModel extends AndroidViewModel {
    private Context contexto;

    private MutableLiveData<Bitmap> foto;

    public RegistroViewModel(@NonNull Application application) {
        super(application);
    }

    public void registro(String nombre, String apellido, String email, String password, Long dni) {
        Usuario usuario = null;
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setDni(dni);
        guardar(contexto, usuario);
    }



    public LiveData<Bitmap> getFoto(){
        if(foto==null){
            foto=new MutableLiveData<>();
        }
        return foto;
    }

    public void cargar() {
        File archivo =new File(contexto.getFilesDir(),"foto1.png");


        Bitmap imageBitmap= BitmapFactory.decodeFile(archivo.getAbsolutePath());
        if(imageBitmap!=null) {

            foto.setValue(imageBitmap);
        }


    }
    public void respuetaDeCamara(int requestCode, int resultCode, @Nullable Intent data, int REQUEST_IMAGE_CAPTURE){

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Recupero los datos provenientes de la camara.
            Bundle extras = data.getExtras();
            //Casteo a bitmap lo obtenido de la camara.
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            //Rutina para optimizar la foto,
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
            foto.setValue(imageBitmap);



            //Rutina para convertir a un arreglo de byte los datos de la imagen
            byte [] b=baos.toByteArray();


            //Aquí podría ir la rutina para llamar al servicio que recibe los bytes.
            File archivo =new File(contexto.getFilesDir(),"foto1.png");
            if(archivo.exists()){
                archivo.delete();
            }
            try {
                FileOutputStream fo=new FileOutputStream(archivo);
                BufferedOutputStream bo=new BufferedOutputStream(fo);
                bo.write(b);
                bo.flush();
                bo.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
