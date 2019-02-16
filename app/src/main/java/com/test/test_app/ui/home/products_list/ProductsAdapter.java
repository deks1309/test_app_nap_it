package com.test.test_app.ui.home.products_list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.test.test_app.data.model.ProductModel;
import com.test.test_app.databinding.ProductBinding;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

  private List<ProductModel> products = new LinkedList<>();

  @NonNull
  @Override
  public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    ProductBinding binding = ProductBinding.inflate(inflater, parent, false);
    return new ProductViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
    holder.bind(products.get(position));
  }

  @Override
  public int getItemCount() {
    return products.size();
  }

  public void setData(List<ProductModel> products) {
    this.products.clear();
    this.products = products;
  }
}
