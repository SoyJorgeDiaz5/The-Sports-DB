package com.co.soyjorgediaz5.thesportsdb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.co.soyjorgediaz5.thesportsdb.R;
import com.co.soyjorgediaz5.thesportsdb.Utils;
import com.co.soyjorgediaz5.thesportsdb.model.event.Event;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsHolder> {

    private List<Event> eventList;

    public EventsAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventsHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_events, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventsHolder holder, int position) {
        Event eventItem = eventList.get(position);
        holder.tvEventName.setText(eventItem.getStrEvent());
        holder.tvDateEvent.setText(eventItem.getDateEvent());
        holder.tvTimeEvent.setText(eventItem.getStrTime());
        Utils.setGlideImg(eventItem.getStrThumb(), holder.imgEvent.getContext(), holder.imgEvent);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class EventsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_event)
        ImageView imgEvent;
        @BindView(R.id.tv_event_name)
        TextView tvEventName;
        @BindView(R.id.tv_date_event)
        TextView tvDateEvent;
        @BindView(R.id.tv_time_event)
        TextView tvTimeEvent;

        EventsHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
