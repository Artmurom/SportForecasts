package ru.artemtsarev.forecasts.screen.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.artemtsarev.forecasts.R;
import ru.artemtsarev.forecasts.model.ArticleDetail;

public class ArticleActivity extends AppCompatActivity implements ArticleView {

    private static final String ARTICLE_KEY = "article";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.cardView)
    CardView mCardView;

    @BindView(R.id.tvTeams)
    TextView mTvTeams;

    @BindView(R.id.tvTime)
    TextView mTvTime;

    @BindView(R.id.tvTournament)
    TextView mTvTournament;

    @BindView(R.id.tvPlace)
    TextView mTvPlace;

    @BindView(R.id.tvHeader1)
    TextView mTvHeader1;

    @BindView(R.id.tvText1)
    TextView mTvText1;

    @BindView(R.id.tvHeader2)
    TextView mTvHeader2;

    @BindView(R.id.tvText2)
    TextView mTvText2;

    @BindView(R.id.tvHeader3)
    TextView mTvHeader3;

    @BindView(R.id.tvText3)
    TextView mTvText3;

    @BindView(R.id.tvPrediction)
    TextView mTvPrediction;


    @NonNull
    public static Intent makeIntent(Activity activity, String article) {
        Intent intent = new Intent(activity, ArticleActivity.class);
        intent.putExtra(ARTICLE_KEY, article);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_card);
        ButterKnife.bind(this);

        String article = getIntent().getStringExtra(ARTICLE_KEY);

        setSupportActionBar(mToolbar);

        ArticlePresenter articlePresenter = new ArticlePresenter(this);
        articlePresenter.init(article);
    }



    @Override
    public void initUI(ArticleDetail articleDetail) {
        if (articleDetail == null || articleDetail.getArticleList() == null || articleDetail.getArticleList().size() == 0
                || articleDetail.getArticleList().get(0) == null || articleDetail.getArticleList().get(1) == null || articleDetail.getArticleList().get(2) == null) {
            showError();
            return;
        }

        mCardView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);

        String team1 = articleDetail.getTeam1();
        String team2 = articleDetail.getTeam2();
        String time = articleDetail.getTime();
        String tournament = articleDetail.getTournament();
        String place = articleDetail.getPlace();
        String header1 = articleDetail.getArticleList().get(0).getHeader();
        String text1 = articleDetail.getArticleList().get(0).getText();
        String header2 = articleDetail.getArticleList().get(1).getHeader();
        String text2 = articleDetail.getArticleList().get(1).getText();
        String header3 = articleDetail.getArticleList().get(2).getHeader();
        String text3 = articleDetail.getArticleList().get(2).getText();
        String prediction = articleDetail.getPrediction();

        if (!TextUtils.isEmpty(team1) && !TextUtils.isEmpty(team2)) {
            String teams = String.format("%s - %s", team1, team2);
            mTvTeams.setText(teams);

            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(teams);
            }
        }

        if (!TextUtils.isEmpty(time)) {
            mTvTime.setText(time);
        }

        if (!TextUtils.isEmpty(tournament)) {
            mTvTournament.setText(tournament);
        }

        if (!TextUtils.isEmpty(place)) {
            mTvPlace.setText(place);
        }

        if (!TextUtils.isEmpty(header1) && !TextUtils.isEmpty(text1)) {
            mTvHeader1.setText(header1);
            mTvText1.setText(text1);
        } else {
            mTvHeader1.setVisibility(View.GONE);
            mTvText1.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(header2) && !TextUtils.isEmpty(text2)) {
            mTvHeader2.setText(header2);
            mTvText2.setText(text2);
        } else {
            mTvHeader2.setVisibility(View.GONE);
            mTvText2.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(header3) && !TextUtils.isEmpty(text3)) {
            mTvHeader3.setText(header3);
            mTvText3.setText(text3);
        } else {
            mTvHeader3.setVisibility(View.GONE);
            mTvText3.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(prediction)) {
            mTvPrediction.setText(prediction);
        }
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.article_error_loading, Toast.LENGTH_LONG).show();
        finish();
    }
}
