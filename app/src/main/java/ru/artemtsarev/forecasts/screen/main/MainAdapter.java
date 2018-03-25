package ru.artemtsarev.forecasts.screen.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.artemtsarev.forecasts.R;
import ru.artemtsarev.forecasts.model.Event;


class MainAdapter extends RecyclerView.Adapter<MainHolder> {

    private final List<Event> mEventList;
    private final OnItemClick mOnItemClick;

    private final View.OnClickListener mInternalListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String article = (String) view.getTag();
            mOnItemClick.onItemClick(article);
        }
    };

    MainAdapter(OnItemClick onItemClick) {
        mEventList = new ArrayList<>();
        mOnItemClick = onItemClick;

    }

    void changeDataSet(List<Event> eventList) {
        mEventList.clear();
        mEventList.addAll(eventList);
        notifyDataSetChanged();
        notifyItemChanged(1);
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_event, parent, false);
        return new MainHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        Event event = mEventList.get(position);
        holder.bind(event);
        holder.itemView.setTag(event.getArticle());
        holder.itemView.setOnClickListener(mInternalListener);
    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }

    interface OnItemClick {

        void onItemClick(String id);

    }
}
