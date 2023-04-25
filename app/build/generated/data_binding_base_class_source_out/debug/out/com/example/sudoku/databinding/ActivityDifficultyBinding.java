// Generated by view binder compiler. Do not edit!
package com.example.sudoku.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.sudoku.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDifficultyBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonDifficultyEasy;

  @NonNull
  public final Button buttonDifficultyHard;

  @NonNull
  public final Button buttonDifficultyMedium;

  @NonNull
  public final GridLayout gridLayout;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  private ActivityDifficultyBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonDifficultyEasy, @NonNull Button buttonDifficultyHard,
      @NonNull Button buttonDifficultyMedium, @NonNull GridLayout gridLayout,
      @NonNull TextView textView, @NonNull TextView textView2) {
    this.rootView = rootView;
    this.buttonDifficultyEasy = buttonDifficultyEasy;
    this.buttonDifficultyHard = buttonDifficultyHard;
    this.buttonDifficultyMedium = buttonDifficultyMedium;
    this.gridLayout = gridLayout;
    this.textView = textView;
    this.textView2 = textView2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDifficultyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDifficultyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_difficulty, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDifficultyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_difficultyEasy;
      Button buttonDifficultyEasy = ViewBindings.findChildViewById(rootView, id);
      if (buttonDifficultyEasy == null) {
        break missingId;
      }

      id = R.id.button_difficultyHard;
      Button buttonDifficultyHard = ViewBindings.findChildViewById(rootView, id);
      if (buttonDifficultyHard == null) {
        break missingId;
      }

      id = R.id.button_difficultyMedium;
      Button buttonDifficultyMedium = ViewBindings.findChildViewById(rootView, id);
      if (buttonDifficultyMedium == null) {
        break missingId;
      }

      id = R.id.gridLayout;
      GridLayout gridLayout = ViewBindings.findChildViewById(rootView, id);
      if (gridLayout == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      return new ActivityDifficultyBinding((ConstraintLayout) rootView, buttonDifficultyEasy,
          buttonDifficultyHard, buttonDifficultyMedium, gridLayout, textView, textView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}