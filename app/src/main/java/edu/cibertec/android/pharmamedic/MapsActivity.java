package edu.cibertec.android.pharmamedic;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleApiClient apiClient;
    private GoogleMap mMap;
    private Button btnOpciones;
    private Button btnMover;
    private Button btnAnimar;
    private Button btnPosicion;
    private Button btnMarcador;
    private Button btnRegresar;
    private TextView lblLatitud;
    private TextView lblLongitud;
    private ToggleButton btnActualizar;
    private static final String LOGTAG = "android-localizacion";
    private static final int PETICION_PERMISO_LOCALIZACION = 101;
    private Marker miMarker;
    double lat = 0.0;
    double lng = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnOpciones = (Button) findViewById(R.id.btnOpciones);
        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Nos mostrará la vista Híbrida
                // de Lima en el mapa,al momento de tocar el
                //botón Opciones
                cambiarOpciones();
            }
        });

        btnMover = (Button) findViewById(R.id.btnMover);
        btnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Nos llevará a la ubicación de Lima en el mapa,al momento de tocar el
                //botón Mover
                moverLima();
            }
        });

        //Nos aproximará al punto de venta
        btnAnimar = (Button) findViewById(R.id.btnAnimar);
        btnAnimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animarPuntoDeVenta();
            }
        });

        //Nos mostrará la posición en la que nos encontramos
        btnPosicion = (Button) findViewById(R.id.btnPosicion);
        btnPosicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerPosicion();
            }
        });

        //Obtener la localizacion del punto de venta
        btnMarcador = (Button) findViewById(R.id.btnMarcador);
        btnMarcador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarMarcador();
            }
        });
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana=new Intent(getBaseContext(),MyMenu.class);
                finish();
            }
        });

    /*    apiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();*/

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
        miUbicacion();

        //Nos mostrará la ubicación donde el usuario dió click
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            public void onMapClick(LatLng point) {

                Projection proj = mMap.getProjection();
                Point coord = proj.toScreenLocation(point);

                Toast.makeText(
                        MapsActivity.this,
                        "Click\n" +
                                "Lat :\n+" + point.latitude +
                                "\nLng :\n" + point.longitude +
                                "\nX :" + coord.x + " -Y: " + coord.y,
                        Toast.LENGTH_SHORT).show();
            }
        });

        //Nos mostrará latitud,longitud,zoom,orientacion y angulo acorde nos
        //desplazemos en el mapa
        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                Toast.makeText(
                        MapsActivity.this,
                        "Cambio Cámara\n" +
                                "Lat :" + cameraPosition.target.latitude + "\n" +
                                "Lng :" + cameraPosition.target.longitude + "\n" +
                                "Zoom:" + cameraPosition.zoom + "\n" +
                                "Orientación:" + cameraPosition.bearing + "\n" +
                                "Ängulo :" + cameraPosition.tilt,
                        Toast.LENGTH_SHORT).show();
            }

        });
        mMap.getUiSettings().setMapToolbarEnabled(false);

        //Cada vez que demos click en el marker nos mostrará la información de esta
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(
                        MapsActivity.this,
                        "Pharmamedic:\n" +
                                marker.getTitle(),
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });

    }

    private void cambiarOpciones() {
        //Cambiamos el modo de vista del mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //Agregamos los botones para el zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    private void moverLima() {
        CameraUpdate camUpd1 =
                CameraUpdateFactory
                        .newLatLngZoom(new LatLng(-12.0453, -77.0311), 11);

        mMap.moveCamera(camUpd1);
    }

    private void animarPuntoDeVenta() {
        LatLng lima = new LatLng(-12.0620374,-77.01975290000001);

        CameraPosition camPos = new CameraPosition.Builder()
                .target(lima) //Centramos el mapa en Lima
                .zoom(19)     //Establecemos el zoom en 19
                .bearing(45)  //Establecemos la oritentación
                .tilt(70)     //Establecemos el ángulo de visión
                .build();
        CameraUpdate camUpd3 =
                CameraUpdateFactory
                        .newCameraPosition(camPos);

        mMap.moveCamera(camUpd3);
    }

    private void obtenerPosicion() {
        CameraPosition camPos = mMap.getCameraPosition();

        LatLng coordenadas = camPos.target;
        double latitud = coordenadas.latitude;
        double longitud = coordenadas.longitude;

        Toast.makeText(this, "Lat: " + latitud + " | Long: " + longitud, Toast.LENGTH_SHORT).show();
    }

    private void insertarMarcador() {
        mMap.addMarker(new MarkerOptions()

                .position(new LatLng(-12.0620374,-77.01975290000001))
                .title("Llámenos ahora:3237845")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.phama4)));
    }

    //obtener nuestra coordenada
    private void agregarMiMarcador(double lat, double lng) {
        LatLng misCoordenadas = new LatLng(lat, lng);
        float a= (float) 10.70;
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(misCoordenadas,a);
        if (miMarker != null) miMarker.remove();
        miMarker = mMap.addMarker(new MarkerOptions()
                .position(misCoordenadas)
                .title("Mi Posicion Actual")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        mMap.animateCamera(miUbicacion);

    }
    ///actualizamos el marcador
    private void actualizarUbicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            agregarMiMarcador(lat, lng);
        }
    }

    //un listener del tipo location para que este atengto a los cambios
    LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };
    //actualizamos dinamicamente nuestra localizacion cada 15 segundos
    private void miUbicacion() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,15000,0,locListener);
    }
}
