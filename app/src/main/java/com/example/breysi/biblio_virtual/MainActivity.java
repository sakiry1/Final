package com.example.breysi.biblio_virtual;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_ingresar;
    AutoCompleteTextView id_usuario;
    EditText id_pass;
    FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener AuthListener;
    private ProgressDialog mProgress;

    private static final String TAG = "CustomAuthActivity";


    public ArrayList<Usuario> listUsuario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_usuario = (AutoCompleteTextView) findViewById(R.id.id_usuario);
        id_pass = (EditText) findViewById(R.id.id_pass);
        btn_ingresar = (Button) findViewById(R.id.btn_ingresar);

        mAuth = FirebaseAuth.getInstance();
        btn_ingresar.setOnClickListener(this);

        mProgress = new ProgressDialog(this);


    }

    @Override
    public void onClick(View view) {

        String usuario, pass;
        usuario = id_usuario.getText().toString().trim();
        pass = id_pass.getText().toString();

        if (usuario.equals("") || pass.equals("")) {
            Toast.makeText(this, "Vacio ", Toast.LENGTH_LONG).show();

        } else {
            this.onStart();
            mProgress.setMessage("Ingresando, por favor espere...");
            mProgress.show();
            autentificar_usuario(usuario, pass);


        }


    }

    @Override
    protected void onStart() {// verifica q el usuario haya accedido
        super.onStart();
        //FirebaseUser user = mAuth.getCurrentUser();
        //updateUI(user);
    }


    String emailUsuario;
    String claveUsuario;

    public void autentificar_usuario(final String auth_email, String auth_password) {
        startSignIn();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        final Query q_email = myRef.child("usuario").orderByChild("email").equalTo(auth_email);
        emailUsuario = auth_email;
        claveUsuario = auth_password;
        //consulta


        q_email.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean claveCorrecta = false;
                if (dataSnapshot.exists()) {
                    Usuario tokenUser = new Usuario();
                    for (DataSnapshot item : dataSnapshot.getChildren()) {
                        tokenUser = item.getValue(Usuario.class);
                        if (tokenUser.getClave().equals(claveUsuario)) {
                            claveCorrecta = true;
                        }
                        listUsuario.add(tokenUser);
                    }
                    if (claveCorrecta) {
                        mProgress.dismiss();
                        Intent intent;
                        intent = new Intent(MainActivity.this, Perfil.class);
                        intent.putExtra("usuarioo", tokenUser);
                        startActivity(intent);
                    } else {
                    }
                } else {
                    mProgress.setMessage("Error al ingresar");
                    mProgress.show();
                    mProgress.cancel();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void startSignIn() {
        //!!!!!!!!!!!!LOGIN!!!!!!!!!!!!!!!!!!!!!!
        String auth_email = "k@gmail.com";
        //  Log.e("email", auth_email);
        String auth_password = "123456";
        //Log.e("pass", auth_password);

        mAuth.signInWithEmailAndPassword(auth_email, auth_password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "Ingreso id Complete:" + task.isSuccessful());

                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful()) {
                    Log.w(TAG, "id incorrecto", task.getException());
                    // Toast.makeText(MainActivity.this, R.string.auth_failed, Toast.LENGTH_SHORT).show();

                }

                // ...
            }
        });

    }


}
