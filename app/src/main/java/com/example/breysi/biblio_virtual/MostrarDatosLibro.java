package com.example.breysi.biblio_virtual;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by breysi on 07/05/2018.
 */

public class MostrarDatosLibro extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    public Libro libro ;
    List<Libro> listLibro;
    int posicion, pos;

    TextView tv_titulo;
    TextView tv_autor;
    TextView tv_fecha_publicacion;
    TextView tv_editorial;
    ImageView imagen_libro;

    FloatingActionButton actionButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.datos_del_libro);
        tv_titulo = (TextView) findViewById(R.id.tv_titulo);
        tv_autor = (TextView) findViewById(R.id.tv_autor);
        tv_fecha_publicacion = (TextView) findViewById(R.id.tv_fecha_publicacion);
        tv_editorial = (TextView) findViewById(R.id.tv_editorial);
        imagen_libro = (ImageView) findViewById(R.id.imagen_libro);

        posicion = getIntent().getIntExtra("posicion", 0);//BuscarLibros
        pos = getIntent().getIntExtra("pos", 0);//libroprestado
        //AQUÍ ME HE QUEDADO 07/05/18 --> en pasar una imagen(portada del libro) y aqui lo recogo la informacion, y luego hacer el piccaso.
        //   imagen_libro = getIntent().getAction();

        //BUSCAR LIBRO
        listLibro = BuscarLibros.listaLi;
        libro = listLibro.get(posicion);
        final Query q_libro = myRef.child("libro").orderByChild("titulo").equalTo(libro.getTitulo());
        q_libro.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot item : dataSnapshot.getChildren()) {
                        Libro libros = item.getValue(Libro.class);
                    }
                    tv_titulo.setText(libro.getTitulo());
                    tv_autor.setText(libro.getAutor());
                    tv_editorial.setText(libro.getEditorial());
                    tv_fecha_publicacion.setText(libro.getAñoEdicion());
                    //RECOGE LA IMAGEN DE LA URL
                    Picasso.with(getBaseContext()).load(libro.getPortada()).placeholder(R.mipmap.ic_launcher).into(imagen_libro);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
//RESERVA DE LIBRO
        actionButton = findViewById(R.id.floatingActionButton);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v,"ejem",Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                AlertDialog.Builder alert = new AlertDialog.Builder(MostrarDatosLibro.this);
                AlertDialog alerDialog = alert.create();
                alerDialog.show();
                AlertDialog.Builder alert2 = new AlertDialog.Builder(MostrarDatosLibro.this);
                alert2.setMessage("¿Desea reservar el libro?");
                alert2.setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent;
                                intent = new Intent(MostrarDatosLibro.this, LibrosPrestados.class);
                                intent.putExtra("libroreservado", libro.getClass());
                            }
                        });
                alert2.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog2 = alert2.create();
                alertDialog2.show();

            }
        });
    }


    @Override
    public void onClick(View view) {

    }

    public void Prestadoinfo() {


    }
}
