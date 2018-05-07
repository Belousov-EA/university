package ru.mgvk.velness.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import ru.mgvk.velness.DBWorker;
import ru.mgvk.velness.DBWorker.EventLoadingResult;
import ru.mgvk.velness.EventActivity;
import ru.mgvk.velness.UI.Event;
import ru.mgvk.velness.UI.Event.EventData;
import ru.mgvk.velness.UI.Event.OnClickListener;
import ru.mgvk.wellness.R;

public class EventsFragment extends Fragment implements OnClickListener {
    private LinearLayout mainLayout;

    class C08441 implements EventLoadingResult {

        class C04401 implements Runnable {
            C04401() {
            }

            public void run() {
                Toast.makeText(EventsFragment.this.getContext(), "Произошла ошибка при загрузке данных", 0).show();
            }
        }

        C08441() {
        }

        public void OnFinishLoading(ArrayList<EventData> events) {
            EventsFragment.this.showEvents(events);
        }

        public void onError() {
            EventsFragment.this.getActivity().runOnUiThread(new C04401());
        }
    }

    public static EventsFragment newInstance() {
        return new EventsFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        this.mainLayout = (LinearLayout) rootView.findViewById(R.id.main_layout);
        return rootView;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void loadEvents() {
        DBWorker.requestEvents(new C08441());
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
        loadEvents();
    }

    private void showEvents(ArrayList<EventData> events) {
        if (this.mainLayout != null) {
            Iterator it = events.iterator();
            while (it.hasNext()) {
                this.mainLayout.addView(new Event(getContext(), (EventData) it.next(), this));
            }
        }
    }

    public void onClick(Event event, EventData data) {
        if (data != null) {
            startActivity(new Intent(getActivity(), EventActivity.class).putExtra("eventIndex", data.getIndex()));
        }
    }
}
