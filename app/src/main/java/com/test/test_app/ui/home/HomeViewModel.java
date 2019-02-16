package com.test.test_app.ui.home;

import android.view.View;

import com.test.test_app.data.model.InfoModel;
import com.test.test_app.data.model.ProductModel;
import com.test.test_app.widget.SwipeController;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
  private HomeRepository homeRepository;
  
  private MutableLiveData<Boolean> checkedTop10 = new MutableLiveData<>(true);
  private MutableLiveData<Boolean> checkedShops = new MutableLiveData<>(false);
  private MutableLiveData<Boolean> checkedGoods = new MutableLiveData<>(false);

  private LiveData<List<ProductModel>> products;
  
  private View.OnClickListener onInfoButtonClickListener;
  private SwipeController.OnButtonsClickListener onProductListItemButtonsClickListener =
      new SwipeController.OnButtonsClickListener() {
        @Override
        public void onRightButtonClick(int position) {
          // DO SMTHNG
        }
      };
  
  public HomeViewModel() {
    this.homeRepository = new HomeRepository();
    products = new MutableLiveData<>(homeRepository.getProducts());
  }
  
  public List<InfoModel> getInfoModels() {
    return homeRepository.getInfoModels();
  }
  
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

  public LiveData<List<ProductModel>> getProducts() {
    return products;
  }

  public SwipeController.OnButtonsClickListener getOnProductListItemButtonsClickListener() {
    return onProductListItemButtonsClickListener;
  }
}
