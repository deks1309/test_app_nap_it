package com.test.test_app.ui.home;

import com.test.test_app.data.model.InfoModel;
import com.test.test_app.data.model.ProductModel;

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

  public List<ProductModel> getProducts() {
    List<ProductModel> products = new ArrayList<>();

    ProductModel cheese1 = new ProductModel(
        "Пармезан",
        "Множество рецептов",
        "https://cs10.pikabu.ru/post_img/big/2018/02/02/8/1517577652185134900.jpg",
        50,
        198
    );

    ProductModel cheese2 = new ProductModel(
        "Дор Блю",
        "Множество рецептов",
        "https://foodandhealth.ru/wp-content/uploads/2017/04/dorblyu.jpeg",
        50,
        198
    );

    ProductModel cheese3 = new ProductModel(
        "Гауда",
        "Множество рецептов",
        "https://syrodelie.com/upload/iblock/390/gauda.jpg",
        50,
        198
    );


    products.add(cheese1);
    products.add(cheese2);
    products.add(cheese3);
    products.add(cheese1);
    products.add(cheese2);
    products.add(cheese3);
    products.add(cheese1);
    products.add(cheese2);
    products.add(cheese3);

    return products;
  }
}
