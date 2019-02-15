package com.test.test_app.ui.home.info_carousel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.test_app.data.model.InfoModel;
import com.test.test_app.databinding.CarouselItemBinding;

import androidx.fragment.app.Fragment;

public class InfoCarouselItemFragment extends Fragment {
  public static final String IMAGE_URL_KEY = "IMAGE_URL_KEY";
  public static final String TITLE_KEY = "TITLE_KEY";
  public static final String DESCRIPTION_KEY = "DESCRIPTION_KEY";
  
  public static Fragment newInstance(InfoModel infoModel) {
    Bundle bundle = new Bundle();
    bundle.putString(IMAGE_URL_KEY, infoModel.getImageURL());
    bundle.putString(TITLE_KEY, infoModel.getTitle());
    bundle.putString(DESCRIPTION_KEY, infoModel.getDescription());
    
    InfoCarouselItemFragment fragment = new InfoCarouselItemFragment();
    fragment.setArguments(bundle);
    return fragment;
  }
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    String imageURL = getArguments().getString(IMAGE_URL_KEY);
    String title = getArguments().getString(TITLE_KEY);
    String description = getArguments().getString(DESCRIPTION_KEY);
    
    CarouselItemBinding carouselItemBinding = CarouselItemBinding.inflate(inflater, container, false);
    carouselItemBinding.setVm(new InfoCarouselItemViewModel(title, description, imageURL));
    return carouselItemBinding.getRoot();
  }
}