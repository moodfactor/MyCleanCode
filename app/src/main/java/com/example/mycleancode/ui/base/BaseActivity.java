package com.example.mycleancode.ui.base;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mycleancode.utils.ProgressLoader;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import de.mateware.snacky.Snacky;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private ProgressLoader loader;

    public abstract int contentView();

    public abstract void onCreated();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loader = new ProgressLoader(this);
        setContentView(contentView());
        ButterKnife.bind(this);
        onCreated();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    protected String intentValue(String key) {
        return getIntent().getStringExtra(key);
    }

    protected void showBackBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void onError(int resId) {
        onError(getString(resId));
    }

    protected void onInfo(String message) {
        Snacky.builder()
                .setActivity(this)
                .setText(message)
                .setDuration(Snacky.LENGTH_LONG)
                .info()
                .show();
    }

    protected void onError(String message) {
        Snacky.builder()
                .setActivity(this)
                .setText(message)
                .setDuration(Snacky.LENGTH_LONG)
                .error()
                .show();
    }

    protected void onNotify(String message) {
        Snacky.builder()
                .setActivity(this)
                .setText(message)
                .setDuration(Snacky.LENGTH_SHORT)
                .success()
                .show();
    }

    @Override
    public void onShowLoading() {
        loader.show();
    }

    @Override
    public void onHideLoading() {
        loader.hide();
    }
}
