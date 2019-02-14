package com.test.test_app.ui.home;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.test.test_app.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

public class InfoDialogFragment extends DialogFragment {

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fr_home_info_dialog, container, false);

    Toolbar toolbar = view.findViewById(R.id.tb_info_dialog_toolbar);
    toolbar.setNavigationIcon(R.drawable.ic_close_24px);
    toolbar.setNavigationOnClickListener(v -> dismiss());
    toolbar.setTitle("Информация");
    return view;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    Dialog dialog = super.onCreateDialog(savedInstanceState);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    return dialog;
  }

  public static InfoDialogFragment newInstance() {
    return new InfoDialogFragment();
  }
}
