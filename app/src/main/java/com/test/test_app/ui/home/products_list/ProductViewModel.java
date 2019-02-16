package com.test.test_app.ui.home.products_list;

import com.test.test_app.data.model.ProductModel;

public class ProductViewModel {

  private ProductModel product;

  public ProductViewModel(ProductModel product) {
    this.product = product;
  }

  public ProductModel getProduct() {
    return product;
  }
}
