package com.izv.dam.newquip.vistas.main;

import android.content.Context;
import android.database.Cursor;

import com.izv.dam.newquip.contrato.ContratoMain;
import com.izv.dam.newquip.gestion.GestionNota;
import com.izv.dam.newquip.pojo.Nota;

public class ModeloQuip implements ContratoMain.InterfaceModelo {

    private GestionNota gn = null;
    private Cursor cursor;

    public ModeloQuip(Context c) {
        gn = new GestionNota(c);
    }

    @Override
    public void close() {
        gn.close();
    }

    @Override
    public long deleteNota(Nota n) {
        return gn.delete(n);
    }

    @Override
    public long deleteNota(int position) {
        cursor.moveToPosition(position);
        Nota n = Nota.getNota(cursor);
        return this.deleteNota(n);
    }

    @Override
    public Nota getNota(int position) {
        cursor.moveToPosition(position);
        Nota n = Nota.getNota(cursor);
        return n;
    }

    @Override
    public void loadData(OnDataLoadListener listener) {
        cursor = gn.getCursor();
        listener.setCursor(cursor);
    }
}