package com.test.test_app.ui.home;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.test.test_app.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ac_home);
    Toolbar toolbar = findViewById(R.id.tb_home_toolbar);
    setSupportActionBar(toolbar);
  }
}
