package com.example.loginmasfoto.ui.Login;

import static androidx.core.content.ContextCompat.startActivity;
import static com.example.loginmasfoto.Request.ApiClient.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.loginmasfoto.Modelos.Usuario;
import com.example.loginmasfoto.ui.registro.RegistroActivity;

public class MainActivityViewModel extends AndroidViewModel {
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public void loguearse(Context contexto, String email, String password){
        if(email.length() == 0 || password.length() == 0){
            pasar();
        }else {
            Usuario usuario = login(contexto, email, password);
            Bundle bundle = new Bundle();
            bundle.putSerializable("usuario", usuario);
            Intent intent = new Intent(contexto, RegistroActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtras(bundle);
            contexto.startActivity(intent);
        }
    }

    public void registro(Context contexto, String email, String password){
        pasar();
    }

    public void pasar(){
        Intent intent = new Intent(getApplication(), RegistroActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intent);
    }
}
