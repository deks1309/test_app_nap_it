package com.test.test_app.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import com.test.test_app.R;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.ItemTouchHelper.ACTION_STATE_SWIPE;
import static androidx.recyclerview.widget.ItemTouchHelper.LEFT;

public class SwipeController extends ItemTouchHelper.Callback {
  private Context context;
  private boolean swipeBack = false;
  private ButtonsState buttonShowedState = ButtonsState.GONE;
  private RectF buttonInstance = null;
  private RecyclerView.ViewHolder currentItemViewHolder = null;

  private int iconDrawableID;

  private int buttonWidth;

  private OnButtonsClickListener listener;

  public SwipeController(Context context, int buttonWidth, int iconDrawableID, OnButtonsClickListener listener) {
    this.context = context;
    this.iconDrawableID = iconDrawableID;
    this.listener = listener;
    this.buttonWidth = buttonWidth;
  }

  @Override
  public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
    return makeMovementFlags(0, LEFT);
  }

  @Override
  public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
    return false;
  }

  @Override
  public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

  }

  @Override
  public int convertToAbsoluteDirection(int flags, int layoutDirection) {
    if (swipeBack) {
      swipeBack = buttonShowedState != ButtonsState.GONE;
      return 0;
    }
    return super.convertToAbsoluteDirection(flags, layoutDirection);
  }

  @Override
  public void onChildDraw(Canvas c,
                          RecyclerView recyclerView,
                          RecyclerView.ViewHolder viewHolder,
                          float dX, float dY,
                          int actionState, boolean isCurrentlyActive) {

    if (actionState == ACTION_STATE_SWIPE) {
      if (buttonShowedState != ButtonsState.GONE) {
        dX = Math.min(dX, -buttonWidth);
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
      } else {
        setTouchListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
      }
    }

    currentItemViewHolder = viewHolder;
  }

  public void onDraw(Canvas c) {
    if (currentItemViewHolder != null) {
      drawButtons(c, currentItemViewHolder);
    }
  }

  @SuppressLint("ClickableViewAccessibility")
  private void setTouchListener(Canvas c,
                                RecyclerView recyclerView,
                                RecyclerView.ViewHolder viewHolder,
                                float dX, float dY,
                                int actionState, boolean isCurrentlyActive) {

    recyclerView.setOnTouchListener((v, event) -> {
      swipeBack = event.getAction() == MotionEvent.ACTION_CANCEL || event.getAction() == MotionEvent.ACTION_UP;

      if (swipeBack) {
        if (dX < -buttonWidth) buttonShowedState = ButtonsState.RIGHT_VISIBLE;

        if (buttonShowedState != ButtonsState.GONE) {
          setTouchDownListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
      }
      return false;
    });
  }

  @SuppressLint("ClickableViewAccessibility")
  private void setTouchDownListener(final Canvas c,
                                    final RecyclerView recyclerView,
                                    final RecyclerView.ViewHolder viewHolder,
                                    final float dX, final float dY,
                                    final int actionState, final boolean isCurrentlyActive) {
    recyclerView.setOnTouchListener((v, event) -> {
      if (event.getAction() == MotionEvent.ACTION_DOWN) {
        setTouchUpListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
      }
      return false;
    });
  }

  @SuppressLint("ClickableViewAccessibility")
  private void setTouchUpListener(final Canvas c,
                                  final RecyclerView recyclerView,
                                  final RecyclerView.ViewHolder viewHolder,
                                  final float dX, final float dY,
                                  final int actionState, final boolean isCurrentlyActive) {
    recyclerView.setOnTouchListener((v, event) -> {
      if (event.getAction() == MotionEvent.ACTION_UP) {
        SwipeController.super.onChildDraw(c, recyclerView, viewHolder, 0F, dY, actionState, isCurrentlyActive);
        recyclerView.setOnTouchListener((v1, event1) -> false);

        swipeBack = false;

        if(buttonInstance != null && buttonInstance.contains(event.getX(), event.getY())) {
          if(buttonShowedState == ButtonsState.RIGHT_VISIBLE) {
            listener.onRightButtonClick(viewHolder.getAdapterPosition());
          }
        }

        buttonShowedState = ButtonsState.GONE;
        currentItemViewHolder = null;
      }
      return false;
    });
  }

  private void drawButtons(Canvas c, RecyclerView.ViewHolder viewHolder) {
    View itemView = viewHolder.itemView;
    Paint p = new Paint();

    RectF button = new RectF(itemView.getRight() - buttonWidth, itemView.getTop(), itemView.getRight(), itemView.getBottom());
    p.setColor(Color.RED);
    c.drawRect(button, p);

    Drawable drawable = context.getDrawable(iconDrawableID);
    Bitmap icon = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

    Canvas canvas = new Canvas(icon);
    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
    DrawableCompat.setTint(drawable, context.getColor(R.color.colorWhite));
    drawable.draw(canvas);
    c.drawBitmap(icon, button.centerX()-(icon.getWidth()/2), button.centerY()-(icon.getHeight()/2), p);

    buttonInstance = buttonShowedState == ButtonsState.RIGHT_VISIBLE ? button : null;
  }


  public interface OnButtonsClickListener {
    void onRightButtonClick(int position);
  }

  enum ButtonsState {
    GONE,
    RIGHT_VISIBLE
  }
}
