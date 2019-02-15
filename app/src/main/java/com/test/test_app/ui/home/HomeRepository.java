package com.test.test_app.ui.home;

import com.test.test_app.data.model.InfoModel;

import java.util.ArrayList;
import java.util.List;

public class HomeRepository {
  
  public List<InfoModel> getInfoModels() {
    List<InfoModel> infoModels = new ArrayList<>();
    
    infoModels.add(new InfoModel("Гамак",
        "Хороший гамак.",
        "https://s01.cdn-pegast.net/get/ef/2e/b8/a2457d1f31c08d861989a6111cdba36e9620d5a2d78ebaada3dce5fa2d/maldives1.jpg"));
    
    infoModels.add(new InfoModel("Вода",
        "Хорошая вода.",
        "https://kot.sh/sites/default/files/styles/large/public/articles-image/29-es-water-preview_0_0.jpg"));
    infoModels.add(new InfoModel("Пляж",
        "Хороший пляж.",
        "https://brjunetka.ru/wp-content/uploads/2013/04/Letniy-otdyih-na-more-vse-chto-nuzhno-znat-foto.jpg"));
    
    return infoModels;
  }
}
