package com.example.breysi.biblio_virtual;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by breysi on 20/05/2018.
 */

public class BuscarPorAutor  extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    ListView listview_autor;
    public static ArrayList<Libro> listaLibro = new ArrayList<>();
    ImageView imageViewlibro;

    EditText tv_buscar;
    ImageButton btn_buscar;
    ArrayAdapter<String> adapter;


    final Query q_autor = myRef.child("libro").orderByChild("autor");
//HOLAAAAAAAAAA

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_autor);


        tv_buscar = (EditText) findViewById(R.id.tv_buscar2);
        imageViewlibro = (ImageView) findViewById(R.id.imageView_libro);
        btn_buscar = (ImageButton) findViewById(R.id.btn_buscar2);
        listview_autor = (ListView) findViewById(R.id.lista_libros_autor);
//        listview_autor.setOnClickListener(this);
        btn_buscar.setOnClickListener(this);


        q_autor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {


                    for (DataSnapshot item : dataSnapshot.getChildren()) {
                        //  Libro libro = new Libro();
                       Libro libro = item.getValue(Libro.class);
                      /*  libro.setTitulo((String) item.child("titulo").getValue());
                        libro.setAutor((String) item.child("autor").getValue());
                        libro.setPortada(item.child("portada").getValue(String.class));*/
                        Toast.makeText(BuscarPorAutor.this,libro.getAutor(),Toast.LENGTH_SHORT).show();

                        listaLibro.add(libro);
                    }
                    Lista ();
                }
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

    }


    private void buscarLibro (String textBuscar) { //ERROR!
        Query q = myRef.child("libro").orderByChild("autor").equalTo(textBuscar);
        q.addValueEventListener(new listenerAutor());

    }


    public class listenerAutor implements ValueEventListener {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                listaLibro.clear();

                for (DataSnapshot item : dataSnapshot.getChildren()) {
                    //  Libro libro = new Libro();
                    Libro libro = item.getValue(Libro.class);
                      /*  libro.setTitulo((String) item.child("titulo").getValue());
                        libro.setAutor((String) item.child("autor").getValue());
                        libro.setPortada(item.child("portada").getValue(String.class));*/
                    Toast.makeText(BuscarPorAutor.this, libro.getTitulo(), Toast.LENGTH_SHORT).show();

                    listaLibro.add(libro);
                }
                Lista();
            }
        }


        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    }


  /*  private void Lista () {

        listview_autor.setAdapter(null); //vacio la lista

        for (final Autor autor : listaAutor) {
            String apellido = autor.getApellido();
            String nombre = autor.getNombre();
            String fechaNacimiento = autor.getFechaNacimiento();



        }
    }*/


    private void Lista () {

        listview_autor.setAdapter(null); //vacio la lista

        for (final Libro libro : listaLibro) {
            String titulo = libro.getTitulo();
            String autor = libro.getAutor();
            String portada = libro.getPortada();


            //MI ADAPTADOR (CLASS)
            ListAdapter adapter = new AdaptadordeListas(
                    BuscarPorAutor.this, listaLibro
            );
            listview_autor.setAdapter(adapter);

            listview_autor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                    final int pos = (position);

                    AlertDialog.Builder alert = new AlertDialog.Builder(BuscarPorAutor.this);
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                    AlertDialog.Builder alert2 = new AlertDialog.Builder(BuscarPorAutor.this);
                    alert2.setMessage(R.string.datos);
                    alert2.setPositiveButton(R.string.si,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //db.modificarVehicle(vehicles.get(pos));
                                    Intent intent1;
                                    //TODO
                                    intent1 = new Intent(BuscarPorAutor.this, MostrarDatosLibro.class);
                                    intent1.putExtra("posicion", pos);
                                    Intent intent2;
                                    intent2 = new Intent(BuscarPorAutor.this, MostrarDatosLibro.class);
                                    intent2.putExtra("imagen", libro.getPortada());
                                    Toast.makeText(BuscarPorAutor.this, "IMAGEN RECOGIDA || " + libro.getPortada(), Toast.LENGTH_LONG).show();
                                    startActivity(intent1);

                                    Toast.makeText(BuscarPorAutor.this, "Libro mostrado", Toast.LENGTH_SHORT).show();
                                }
                            });
                    alert2.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(BuscarPorAutor.this, "Libro no mostrado", Toast.LENGTH_SHORT).show();
                        }
                    });

                    AlertDialog alertDialog2 = alert2.create();
                    alertDialog2.show();
                }
            });
        }
    }



    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.btn_buscar2:
                String textBuscar = tv_buscar.getText().toString();
                buscarLibro(textBuscar);
                break;
        }
    }
}
