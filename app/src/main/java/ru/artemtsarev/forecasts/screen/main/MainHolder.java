package ru.artemtsarev.forecasts.screen.main;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.artemtsarev.forecasts.R;
import ru.artemtsarev.forecasts.model.Event;


class MainHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvTitle)
    TextView mTvTitle;

    @BindView(R.id.tvCoefficient)
    TextView mTvCoefficient;

    @BindView(R.id.tvTime)
    TextView mTvTime;

    @BindView(R.id.tvPlace)
    TextView mTvPlace;

    @BindView(R.id.tvPreview)
    TextView mTvPreview;

    MainHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(Event event) {

        String title = event.getTitle();
        String coefficient = event.getCoefficient();
        String time = event.getTime();
        String place = event.getPlace();
        String preview = event.getPreview();

        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(coefficient)) {
            mTvCoefficient.setText(coefficient);
        }
        if (!TextUtils.isEmpty(time)) {
            mTvTime.setText(time);
        }
        if (!TextUtils.isEmpty(place)) {
            mTvPlace.setText(place);
        }
        if (!TextUtils.isEmpty(preview)) {
            mTvPreview.setText(preview);
        }


    }
}
