package amu.zhcetstudent.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.LineNumberInputStream;

import amu.zhcetstudent.R;
import amu.zhcetstudent.contract.presenter.MainPresenter;
import amu.zhcetstudent.contract.view.MainView;
import amu.zhcetstudent.data.model.Result;
import amu.zhcetstudent.data.model.ResultRepository;
import amu.zhcetstudent.data.model.Subject;
import amu.zhcetstudent.databinding.ActivityMainBinding;
import amu.zhcetstudent.ui.Adapter.SubjectAdapter;
import amu.zhcetstudent.ui.presenter.MainActivityPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity
        implements MainView, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.result)
    RecyclerView recyclerView;
    private Unbinder unbinder;
    private View root;
    private SubjectAdapter subjectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        root = binding.getRoot();

        unbinder = ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        MainPresenter mainPresenter = new MainActivityPresenter(this, new ResultRepository());
        subjectAdapter = new SubjectAdapter();
        recyclerView.setAdapter(subjectAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainPresenter.loadResult("14peb250", "gh0022");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_camera:
                break;
            case R.id.nav_gallery:
                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_manage:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();

        unbinder.unbind();
    }

    @Override
    public void showResult(Result result) {
        this.subjectAdapter.addAllSubjects(result.getResults());
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showProgress(boolean show) {

    }

}
