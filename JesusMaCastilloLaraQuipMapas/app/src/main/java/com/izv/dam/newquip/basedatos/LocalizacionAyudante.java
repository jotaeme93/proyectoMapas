package com.izv.dam.newquip.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.izv.dam.newquip.pojo.Localizacion;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Created by dam on 02/12/2016.
 */

public class LocalizacionAyudante extends OrmLiteSqliteOpenHelper{

    private Dao<Localizacion, Integer> simpleDao = null;
    private RuntimeExceptionDao<Localizacion, Integer> simpleRunTimeDao = null;


    public LocalizacionAyudante(Context context) {
        super(context, "ormlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Localizacion.class);
        }catch (java.sql.SQLException e){
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Dao<Localizacion, Integer> getDao() throws java.sql.SQLException {
        if (simpleDao == null){
            simpleDao = getDao(Localizacion.class);
        }
        return simpleDao;
    }

    public RuntimeExceptionDao<Localizacion, Integer> getDataDao(){
        if(simpleRunTimeDao == null){
            simpleRunTimeDao = getRuntimeExceptionDao(Localizacion.class);
        }
        return simpleRunTimeDao;
    }

    public void close(){
        super.close();
        simpleDao = null;
        simpleRunTimeDao = null;
    }
}
