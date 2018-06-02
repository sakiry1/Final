package com.example.breysi.biblio_virtual;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by alumne on 06/02/18.
 */


public class Usuario implements Parcelable {

    private String apellido;
    private String clave;
    private String codigo;
    private String curso;
    private String dni;
    private String email;
    private String fechaNacimiento;
    private String nombre;
    private String poblacion;
    private String provincia;
    private String telefono;

    public Usuario() {
    }
    /*
        public Usuario(String apellido, String codigo, String curso, String dni, String email, Date fechaNacimiento, String nombre, String poblacion, String provincia, String telefono) {
            this.apellido = apellido;
            this.clave = codigo;
            this.curso = curso;
            this.dni = dni;
            this.email = email;
            this.fechaNacimiento = fechaNacimiento;
            this.nombre = nombre;
            this.poblacion = poblacion;
            this.provincia = provincia;
            this.telefono = telefono;
        }*/
    protected Usuario(Parcel in) {
        this.apellido = in.readString();
        this.clave = in.readString();
        this.codigo=in.readString();
        this.curso = in.readString();
        this.dni = in.readString();
        this.email = in.readString();
        this.fechaNacimiento=in.readString();
        //this.fechaNacimiento=(java.util.Date)in.readSerializable();/////
        //this.fechaNacimiento = new Date(in.readLong());///read Long and pass to Date constructor to getDate
        this.nombre = in.readString();
        this.poblacion = in.readString();
        this.provincia = in.readString();
        this.telefono = in.readString();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(apellido);
        dest.writeString(clave);
        dest.writeString(codigo);
        dest.writeString(curso);
        dest.writeString(dni);
        dest.writeString(email);
        dest.writeString(fechaNacimiento);
        //dest.writeSerializable(fechaNacimiento);
        // dest.writeLong(fechaNacimiento.getTime());/////convert date into long while writing
        dest.writeString(nombre);
        dest.writeString(poblacion);
        dest.writeString(provincia);
        dest.writeString(telefono);
    }
}










/*public class Usuario implements Serializable {
    private String apellido;
    private String clave;
    private String curso;
    private String dni;
    private String email;
    private Date fechaNacimiento;
    private String nombre;
    private String poblacion;
    private String provincia;
    private String telefono;


    public Usuario(String apellido, String codigo, String curso, String dni, String email, Date fechaNacimiento, String nombre, String poblacion, String provincia, String telefono) {
        this.apellido = apellido;
        this.clave = codigo;
        this.curso = curso;
        this.dni = dni;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.telefono = telefono;
    }

    public Usuario() {
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String codigo) {
        this.clave = codigo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}*/
