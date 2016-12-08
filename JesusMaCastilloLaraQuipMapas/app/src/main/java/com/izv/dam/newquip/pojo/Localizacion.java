package com.izv.dam.newquip.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Jotaeme on 08/12/2016.
 */
@DatabaseTable(tableName = "localizacion")
public class Localizacion implements Parcelable{


    @DatabaseField
    private String nombre;
    @DatabaseField(uniqueIndex = true)
    private long id;
    @DatabaseField
    private double latitud;
    @DatabaseField
    private double longitud;

    public Localizacion() {
        this("",0,0,0);
    }

    public Localizacion(String nombre, long id, double latitud, double longitud) {
        this.nombre = nombre;
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    protected Localizacion(Parcel in) {
        nombre = in.readString();
        id = in.readLong();
        latitud = in.readDouble();
        longitud = in.readDouble();
    }

    public static final Creator<Localizacion> CREATOR = new Creator<Localizacion>() {
        @Override
        public Localizacion createFromParcel(Parcel in) {
            return new Localizacion(in);
        }

        @Override
        public Localizacion[] newArray(int size) {
            return new Localizacion[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Localizacion{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeLong(id);
        dest.writeDouble(latitud);
        dest.writeDouble(longitud);
    }
}
