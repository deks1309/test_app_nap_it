package com.test.test_app.ui.home;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
  private MutableLiveData<Boolean> checkedTop10 = new MutableLiveData<>(true);
  private MutableLiveData<Boolean> checkedShops = new MutableLiveData<>(false);
  private MutableLiveData<Boolean> checkedGoods = new MutableLiveData<>(false);


  private View.OnClickListener onInfoButtonClickListener;

  public View.OnClickListener getOnInfoButtonClickListener() {
    return onInfoButtonClickListener;
  }

  public void setOnInfoButtonClickListener(View.OnClickListener onInfoButtonClickListener) {
    this.onInfoButtonClickListener = onInfoButtonClickListener;
  }

  public MutableLiveData<Boolean> getCheckedTop10() {
    return checkedTop10;
  }

  public void setCheckedTop10(MutableLiveData<Boolean> checkedTop10) {
    this.checkedTop10 = checkedTop10;
  }

  public MutableLiveData<Boolean> getCheckedShops() {
    return checkedShops;
  }

  public void setCheckedShops(MutableLiveData<Boolean> checkedShops) {
    this.checkedShops = checkedShops;
  }

  public MutableLiveData<Boolean> getCheckedGoods() {
    return checkedGoods;
  }

  public void setCheckedGoods(MutableLiveData<Boolean> checkedGoods) {
    this.checkedGoods = checkedGoods;
  }
}
