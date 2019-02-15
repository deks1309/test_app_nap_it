package com.test.test_app.ui.home.info_carousel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InfoCarouselItemViewModel extends ViewModel {
  
  private LiveData<String> imageURL;
  private LiveData<String> title;
  private LiveData<String> description;
  
  
  public InfoCarouselItemViewModel(String title, String description, String imageURL) {
    this.imageURL = new MutableLiveData<>(imageURL);
    this.title = new MutableLiveData<>(title);
    this.description = new MutableLiveData<>(description);
  }
  
  public LiveData<String> getImageURL() {
    return imageURL;
  }
  
  public LiveData<String> getTitle() {
    return title;
  }
  
  public LiveData<String> getDescription() {
    return description;
  }
}