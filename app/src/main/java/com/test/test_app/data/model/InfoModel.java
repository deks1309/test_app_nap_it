package com.test.test_app.data.model;

public class InfoModel  {
  
  private String imageURL;
  
  private String title;
  
  private String description;
  
  public InfoModel(String title, String description, String imageURL) {
    this.imageURL = imageURL;
    this.title = title;
    this.description = description;
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
}
