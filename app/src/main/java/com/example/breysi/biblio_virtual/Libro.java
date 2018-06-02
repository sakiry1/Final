package com.example.breysi.biblio_virtual;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by breysi on 23/03/2018.
 */



class Libro implements Parcelable {
    private String autor;
    private String añoEdicion;
    private String editorial;
    private String genero;
    private String id;
    private String idioma;
    private String npaginas;
    private String portada;
    private String titulo;

    public Libro() {
    }

    /*  public Libro(String titulo, String autor, String anyEdicion, String editorial, String genero, String idioma, String npaginas, String portada, int id) {
          this.titulo = titulo;
          this.autor = autor;
          this.anyEdicion = anyEdicion;
          this.editorial = editorial;
          this.genero = genero;
          this.idioma = idioma;
          this.npaginas = npaginas;
          this.portada = portada;
          this.id = id;
      }*/
    public Libro(Parcel in) {

        this.autor = in.readString();
        this.añoEdicion = in.readString();
        this.editorial = in.readString();
        this.genero = in.readString();
        this.id = in.readString();
        this.idioma = in.readString();
        this.npaginas = in.readString();
        this.portada = in.readString();
        this.titulo = in.readString();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAñoEdicion() {
        return añoEdicion;
    }

    public void setAñoEdicion(String añoEdicion) {
        this.añoEdicion = añoEdicion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getNpaginas() {
        return npaginas;
    }

    public void setNpaginas(String npaginas) {
        this.npaginas = npaginas;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static final Parcelable.Creator<Libro> CREATOR = new Parcelable.Creator<Libro>() {
        @Override
        public Libro createFromParcel(Parcel in) {
            return new Libro(in);
        }

        @Override
        public Libro[] newArray(int size) {
            return new Libro[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(autor);
        dest.writeString(añoEdicion);
        dest.writeString(editorial);
        dest.writeString(genero);
        dest.writeString(id);
        dest.writeString(idioma);
        dest.writeString(npaginas);
        dest.writeString(portada);
        dest.writeString(titulo);
    }
}
/*    public Libro() {
    }
    public Libro(String titulo, String autor, String anyEdicion, String editorial, String genero, String idioma, String npaginas, String portada) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyEdicion = anyEdicion;
        this.editorial = editorial;
        this.genero = genero;
        this.idioma = idioma;
        this.npaginas = npaginas;
        this.portada = portada;
    }





/*
class Libro {

private String titulo;
private String autor;
private String anyEdicion;
private String editorial;
private String genero;
private String idioma;
private String npaginas;
private String portada;

    public Libro(String titulo, String autor, String anyEdicion, String editorial, String genero, String idioma, String npaginas, String portada) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyEdicion = anyEdicion;
        this.editorial = editorial;
        this.genero = genero;
        this.idioma = idioma;
        this.npaginas = npaginas;
        this.portada = portada;
    }

    public Libro(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getañoEdicion() {
        return anyEdicion;
    }

    public void setAnyEdicion(String anyEdicion) {
        this.anyEdicion = anyEdicion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getNpaginas() {
        return npaginas;
    }

    public void setNpaginas(String npaginas) {
        this.npaginas = npaginas;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
*/