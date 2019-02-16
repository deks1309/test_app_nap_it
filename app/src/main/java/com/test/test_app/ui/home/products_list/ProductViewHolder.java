package com.test.test_app.ui.home.products_list;

import android.graphics.Paint;
import android.widget.TextView;

import com.test.test_app.R;
import com.test.test_app.data.model.ProductModel;
import com.test.test_app.databinding.ProductBinding;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {

  private ProductBinding binding;

  public ProductViewHolder(@NonNull ProductBinding binding) {
    super(binding.getRoot());
    this.binding = binding;
  }

  public void bind(ProductModel product) {
    binding.setProductVM(new ProductViewModel(product));
    TextView tv = binding.getRoot().findViewById(R.id.tv_product_price);
    tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
  }
}
