package com.test.test_app.widget;

import android.graphics.Canvas;

import com.test.test_app.R;
import com.test.test_app.data.model.ProductModel;
import com.test.test_app.ui.home.products_list.ProductsAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewBindingAdapter {
  @BindingAdapter({"bind:data", "bind:clickListener"})
  public static void configureRecyclerView(RecyclerView recyclerView, List<ProductModel> products, SwipeController.OnButtonsClickListener listener) {
    ProductsAdapter adapter = new ProductsAdapter();
    adapter.setData(products);
    LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
        layoutManager.getOrientation());
    recyclerView.addItemDecoration(dividerItemDecoration);

    SwipeController swipeController = new SwipeController(recyclerView.getContext(), 300, R.drawable.ic_delete_24px, listener);
    ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
    itemTouchHelper.attachToRecyclerView(recyclerView);
    recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
      @Override
      public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        swipeController.onDraw(c);
      }
    });

  }
}
