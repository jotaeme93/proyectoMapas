package com.izv.dam.newquip.vistas.mapas;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.izv.dam.newquip.R;
import com.izv.dam.newquip.basedatos.LocalizacionAyudante;
import com.izv.dam.newquip.pojo.Localizacion;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

public class VistaMapas extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocalizacionAyudante ayudante = new LocalizacionAyudante(this);
    private List<Localizacion> localizaciones;
    private RuntimeExceptionDao<Localizacion, Integer> simpleDao = ayudante.getDataDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        localizaciones = simpleDao.queryForAll();
        for (Localizacion loca:
             localizaciones) {
            LatLng sitio = new LatLng(loca.getLatitud(),loca.getLongitud());
            mMap.addMarker(new MarkerOptions().position(sitio).title(loca.getNombre()));

        }
        Localizacion ultima = localizaciones.get(localizaciones.size()-1);
        LatLng ultimaNota = new LatLng(ultima.getLatitud(),ultima.getLongitud());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ultimaNota));
    }
}
