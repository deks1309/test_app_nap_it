package com.test.test_app.ui.home;

import android.os.Bundle;

import com.test.test_app.R;
import com.test.test_app.common.BaseActivity;
import com.test.test_app.databinding.HomeBinding;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

public class HomeActivity extends BaseActivity {

  private HomeViewModel homeViewModel;
  private HomeBinding homeBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Toolbar toolbar = findViewById(R.id.tb_home_toolbar);
    setSupportActionBar(toolbar);

    homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    homeViewModel.setOnInfoButtonClickListener(view -> {
      openInfoDialogFragment();
    });

    homeBinding = DataBindingUtil.setContentView(this, getLayout());
    homeBinding.setVm(homeViewModel);
  }

  private void openInfoDialogFragment() {
    FragmentManager fragmentManager = getSupportFragmentManager();
    InfoDialogFragment infoDialogFragment = new InfoDialogFragment();

    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    transaction.add(android.R.id.content, infoDialogFragment)
        .addToBackStack(null)
        .commit();
  }

  @Override
  protected int getLayout() {
    return R.layout.ac_home;
  }
}
