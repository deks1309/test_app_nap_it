package com.test.test_app.data.model;

public class ProductModel {
  private String imageURL;

  private String title;

  private String description;

  private int discount;

  private float price;

  public ProductModel(String title, String description, String imageURL, int discount, float price) {
    this.imageURL = imageURL;
    this.title = title;
    this.description = description;
    this.discount = discount;
    this.price = price;
  }

  public String getPriceWithDiscount() {
    return Float.toString(price * (discount / 100f)) + " Р";
  }

  public String getStringDiscount() {
    return "-" + discount + "%";
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getDiscount() {
    return discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  public String getPrice() {
    return Float.toString(price)  + " Р";
  }

  public void setPrice(float price) {
    this.price = price;
  }
}
