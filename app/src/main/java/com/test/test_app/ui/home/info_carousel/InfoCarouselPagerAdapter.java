package com.test.test_app.ui.home.info_carousel;

import com.test.test_app.data.model.InfoModel;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class InfoCarouselPagerAdapter extends FragmentPagerAdapter {
  
  private List<InfoModel> images;
  
  public InfoCarouselPagerAdapter(FragmentManager fragmentManager, List<InfoModel> images) {
    super(fragmentManager);
    this.images = images;
  }
  
  @Override
  public Fragment getItem(int position) {
    return InfoCarouselItemFragment.newInstance(images.get(position));
  }
  
  @Override
  public int getCount() {
    return images.size();
  }
  
}
