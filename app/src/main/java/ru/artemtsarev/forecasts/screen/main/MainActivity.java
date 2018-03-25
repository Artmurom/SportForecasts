package ru.artemtsarev.forecasts.screen.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.artemtsarev.forecasts.R;
import ru.artemtsarev.forecasts.model.Result;
import ru.artemtsarev.forecasts.screen.person.ArticleActivity;

public class MainActivity extends AppCompatActivity implements MainView, MainAdapter.OnItemClick, SwipeRefreshLayout.OnRefreshListener {

    private static String FOOTBALL = "football";
    private static String HOCKEY = "hockey";
    private static String TENNIS = "tennis";
    private static String BASKETBALL = "basketball";
    private static String VOLLEYBALL = "volleyball";
    private static String CYBERSPORT = "cybersport";


    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout mSwipeRefreshLayout;


    private MainPresenter mMainPresenter;
    private MainAdapter mAdapter;

    private String mCategory;


    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCategory = FOOTBALL;

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        AppCompatSpinner spinner = mToolbar.findViewById(R.id.spinner);

        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.main_category_list, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mCategory = FOOTBALL;
                        break;
                    case 1:
                        mCategory = HOCKEY;
                        break;
                    case 2:
                        mCategory = TENNIS;
                        break;
                    case 3:
                        mCategory = BASKETBALL;
                        break;
                    case 4:
                        mCategory = VOLLEYBALL;
                        break;
                    case 5:
                        mCategory = CYBERSPORT;
                        break;
                }
                mMainPresenter.init(mCategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL));


        mMainPresenter = new MainPresenter(this);
        mMainPresenter.init(mCategory);

        mSwipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void showEvents(Result result) {
        if (result != null && result.getEventList() != null && result.getEventList().size() > 0) {
            mAdapter.changeDataSet(result.getEventList());
        } else {
            showError();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.main_error_loading, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void onRefresh() {
        mMainPresenter.init(mCategory);
        new Handler().postDelayed(() ->
                        mSwipeRefreshLayout.setRefreshing(false)
                , 1000);
    }

    @Override
    public void onItemClick(@NonNull String id) {
        startActivity(ArticleActivity.makeIntent(this, id));
    }
}
