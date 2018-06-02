package com.example.breysi.biblio_virtual;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by breysi on 20/05/2018.
 */

public class Autor implements Parcelable {

    private String apellido;
    private String  codigo;
    private String curso;
    private String dni;
    private String fechaNacimiento;
    private String nombre;
    private String poblacion;
    private String provincia;

    public Autor() {
    }



    protected Autor(Parcel in) {
        this.apellido = in.readString();
        this.codigo = in.readString();
        this.curso = in.readString();
        this.dni = in.readString();
        this.fechaNacimiento = in.readString();
        this.nombre = in.readString();
        this.poblacion = in.readString();
        this.provincia = in.readString();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }



    public static final Creator<Autor> CREATOR = new Creator<Autor>() {
        @Override
        public Autor createFromParcel(Parcel in) {
            return new Autor(in);
        }

        @Override
        public Autor[] newArray(int size) {
            return new Autor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(apellido);
        dest.writeString(codigo);
        dest.writeString(curso);
        dest.writeString(dni);
        dest.writeString(fechaNacimiento);
        dest.writeString(nombre);
        dest.writeString(poblacion);
        dest.writeString(provincia);
    }
}
