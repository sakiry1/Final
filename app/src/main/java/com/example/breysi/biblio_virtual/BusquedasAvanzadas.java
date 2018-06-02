package com.example.breysi.biblio_virtual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by breysi on 20/05/2018.
 */

public class BusquedasAvanzadas extends AppCompatActivity implements View.OnClickListener{
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    ImageButton btn_autor;
    ImageButton btn_editorial;
    ImageButton btn_genero;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busquedas_avanzadas);

        btn_autor = (ImageButton) findViewById(R.id.btn_autor);
        btn_editorial = (ImageButton) findViewById(R.id.btn_editorial);
        btn_genero = (ImageButton) findViewById(R.id.btn_genero);

        btn_autor.setOnClickListener(this);
        btn_genero.setOnClickListener(this);
        btn_editorial.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        Intent intent1;
        Intent intent2;
        switch (view.getId()) {
            case R.id.btn_genero:
                intent = new Intent(BusquedasAvanzadas.this, LibrosPrestados.class);
              //  intent.putExtra("listaPrestados",listaLibrosPrestados);
                startActivity(intent);
                break;
            case R.id.btn_autor:
                intent1 = new Intent(BusquedasAvanzadas.this, BuscarPorAutor.class);
                startActivity(intent1);
                break;
            case R.id.btn_editorial:
                intent2 = new Intent(BusquedasAvanzadas.this, CuentaUsuario.class);
              //  startActivity(intent2);
                break;

            default:
                Toast.makeText(BusquedasAvanzadas.this, "Error", Toast.LENGTH_LONG).show();
        }
    }
}
