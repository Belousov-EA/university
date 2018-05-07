package ru.mgvk.velness;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import ru.mgvk.velness.UI.Event.EventData;
import ru.mgvk.wellness.R;

public class EventActivity extends AppCompatActivity implements ConnectionCallbacks, OnConnectionFailedListener, LocationListener, OnMapReadyCallback {
    private ActionBar actionBar;
    private GoogleApiClient client;
    private TextView coordinates;
    private TextView date;
    private CameraUpdate eventCameraUpdate;
    EventData eventData;
    private LatLng eventLatLng;
    private TextView header;
    private GoogleMap map;
    private int mapType = 1;
    private LatLng me;
    private TextView place;
    private float radius = 0.0f;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_event);
        int i = getIntent().getIntExtra("eventIndex", -1);
        if (i != -1 && this.eventData == null) {
            try {
                this.eventData = (EventData) DBWorker.getEvents().get(i);
                LatLng latLng = this.eventData.getLatLng();
                this.eventLatLng = latLng;
                this.eventCameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 12.0f);
            } catch (Exception e) {
                this.eventData = EventData.newInstance();
                e.printStackTrace();
                Toast.makeText(this, "При загрузке события произошла ошибка!", 0).show();
            }
        }
        initViews();
        this.client = new Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
    }

    private void initViews() {
        this.actionBar = getSupportActionBar();
        this.header = (TextView) findViewById(R.id.header);
        this.date = (TextView) findViewById(R.id.date);
        this.place = (TextView) findViewById(R.id.place);
        this.coordinates = (TextView) findViewById(R.id.coordinates);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            finish();
        }
        return true;
    }

    protected void onStart() {
        super.onStart();
        if (this.eventData != null) {
            showData();
        }
    }

    private void showData() {
        if (this.actionBar != null) {
            this.actionBar.setDisplayHomeAsUpEnabled(true);
            this.actionBar.setTitle((int) R.string.event_actionbar_titile);
        }
        this.header.setText(this.eventData.getHeader());
        this.date.setText(this.eventData.getDate() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.eventData.getTime());
        this.place.setText(this.eventData.getPlace());
        this.coordinates.setText(this.eventData.getLatitude() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.eventData.getLongitude());
    }

    public void onConnected(@Nullable Bundle bundle) {
        requestLocationUpdates();
        initMap();
    }

    private void initMap() {
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }

    private void requestLocationUpdates() {
        if (VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            LocationServices.FusedLocationApi.requestLocationUpdates(this.client, new LocationRequest().setInterval(3000).setPriority(100), (LocationListener) this);
            return;
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 777);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 777 && permissions[0].equals("android.permission.ACCESS_FINE_LOCATION") && grantResults[0] == 0 && this.client.isConnected()) {
            requestLocationUpdates();
        }
    }

    public void onConnectionSuspended(int i) {
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    public void onLocationChanged(Location location) {
        this.me = new LatLng(location.getLatitude(), location.getLongitude());
        this.radius = location.getAccuracy();
    }

    protected void onResume() {
        super.onResume();
        if (!this.client.isConnected() || !this.client.isConnecting()) {
            this.client.connect();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.client.isConnected() || this.client.isConnecting()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(this.client, (LocationListener) this);
            this.client.disconnect();
        }
    }

    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;
        this.map.setMyLocationEnabled(true);
        this.map.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style));
        if (this.eventLatLng != null) {
            this.map.addMarker(new MarkerOptions().position(this.eventLatLng));
        }
        if (this.eventCameraUpdate != null) {
            this.map.animateCamera(this.eventCameraUpdate);
        }
    }
}
