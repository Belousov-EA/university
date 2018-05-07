package ru.mgvk.velness.UI;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.maps.model.LatLng;
import ru.mgvk.wellness.R;

public class Event extends FrameLayout {
    EventData data;
    TextView headerView;
    private OnClickListener onClickListener;
    TextView placeView;
    TextView timeView;

    class C04391 implements android.view.View.OnClickListener {
        C04391() {
        }

        public void onClick(View view) {
            if (Event.this.onClickListener != null) {
                Event.this.onClickListener.onClick(Event.this, Event.this.data);
            }
        }
    }

    public static class EventData {
        private String date = "";
        private String header = "";
        private int index = 0;
        private double latitude = 0.0d;
        private double longitude = 0.0d;
        private String place = "";
        private String time = "";

        public EventData(String place, String time, String header) {
            this.place = place;
            this.time = time;
            this.header = header;
        }

        public EventData(int i) {
            this.index = i;
        }

        public static EventData newInstance() {
            return new EventData();
        }

        public double getLongitude() {
            return this.longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = Double.parseDouble(longitude);
        }

        public double getLatitude() {
            return this.latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = Double.parseDouble(latitude);
        }

        public String getDate() {
            return this.date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getPlace() {
            return this.place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getTime() {
            return this.time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getHeader() {
            return this.header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public void setName(String name) {
            setHeader(name);
        }

        public int getIndex() {
            return this.index;
        }

        public LatLng getLatLng() {
            return new LatLng(getLatitude(), getLongitude());
        }
    }

    public interface OnClickListener {
        void onClick(Event event, EventData eventData);
    }

    public Event(Context context) {
        super(context);
    }

    public Event(Context context, EventData data, OnClickListener onClickListener) {
        super(context);
        this.data = data;
        this.onClickListener = onClickListener;
        inflate(getContext(), R.layout.event, this);
        initViews();
    }

    private void initViews() {
        this.headerView = (TextView) findViewById(R.id.header);
        this.headerView.setText(this.data.getHeader());
        this.timeView = (TextView) findViewById(R.id.time);
        this.timeView.setText(this.data.getDate() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.data.getTime());
        this.placeView = (TextView) findViewById(R.id.place);
        this.placeView.setText(this.data.getPlace());
        super.setOnClickListener(new C04391());
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
