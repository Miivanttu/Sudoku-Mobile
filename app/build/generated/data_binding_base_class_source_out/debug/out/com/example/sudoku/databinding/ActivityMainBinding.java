// Generated by view binder compiler. Do not edit!
package com.example.sudoku.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.sudoku.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button bottonClear;

  @NonNull
  public final Button buttonEight;

  @NonNull
  public final Button buttonFinish;

  @NonNull
  public final Button buttonFive;

  @NonNull
  public final Button buttonFour;

  @NonNull
  public final Button buttonHint;

  @NonNull
  public final Button buttonNine;

  @NonNull
  public final Button buttonOne;

  @NonNull
  public final Button buttonSeven;

  @NonNull
  public final Button buttonSix;

  @NonNull
  public final Button buttonThree;

  @NonNull
  public final Button buttonTwo;

  @NonNull
  public final GridLayout gridLayout;

  @NonNull
  public final GridLayout gridLayoutPlayfield;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button bottonClear,
      @NonNull Button buttonEight, @NonNull Button buttonFinish, @NonNull Button buttonFive,
      @NonNull Button buttonFour, @NonNull Button buttonHint, @NonNull Button buttonNine,
      @NonNull Button buttonOne, @NonNull Button buttonSeven, @NonNull Button buttonSix,
      @NonNull Button buttonThree, @NonNull Button buttonTwo, @NonNull GridLayout gridLayout,
      @NonNull GridLayout gridLayoutPlayfield) {
    this.rootView = rootView;
    this.bottonClear = bottonClear;
    this.buttonEight = buttonEight;
    this.buttonFinish = buttonFinish;
    this.buttonFive = buttonFive;
    this.buttonFour = buttonFour;
    this.buttonHint = buttonHint;
    this.buttonNine = buttonNine;
    this.buttonOne = buttonOne;
    this.buttonSeven = buttonSeven;
    this.buttonSix = buttonSix;
    this.buttonThree = buttonThree;
    this.buttonTwo = buttonTwo;
    this.gridLayout = gridLayout;
    this.gridLayoutPlayfield = gridLayoutPlayfield;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottonClear;
      Button bottonClear = ViewBindings.findChildViewById(rootView, id);
      if (bottonClear == null) {
        break missingId;
      }

      id = R.id.buttonEight;
      Button buttonEight = ViewBindings.findChildViewById(rootView, id);
      if (buttonEight == null) {
        break missingId;
      }

      id = R.id.buttonFinish;
      Button buttonFinish = ViewBindings.findChildViewById(rootView, id);
      if (buttonFinish == null) {
        break missingId;
      }

      id = R.id.buttonFive;
      Button buttonFive = ViewBindings.findChildViewById(rootView, id);
      if (buttonFive == null) {
        break missingId;
      }

      id = R.id.buttonFour;
      Button buttonFour = ViewBindings.findChildViewById(rootView, id);
      if (buttonFour == null) {
        break missingId;
      }

      id = R.id.buttonHint;
      Button buttonHint = ViewBindings.findChildViewById(rootView, id);
      if (buttonHint == null) {
        break missingId;
      }

      id = R.id.buttonNine;
      Button buttonNine = ViewBindings.findChildViewById(rootView, id);
      if (buttonNine == null) {
        break missingId;
      }

      id = R.id.buttonOne;
      Button buttonOne = ViewBindings.findChildViewById(rootView, id);
      if (buttonOne == null) {
        break missingId;
      }

      id = R.id.buttonSeven;
      Button buttonSeven = ViewBindings.findChildViewById(rootView, id);
      if (buttonSeven == null) {
        break missingId;
      }

      id = R.id.buttonSix;
      Button buttonSix = ViewBindings.findChildViewById(rootView, id);
      if (buttonSix == null) {
        break missingId;
      }

      id = R.id.buttonThree;
      Button buttonThree = ViewBindings.findChildViewById(rootView, id);
      if (buttonThree == null) {
        break missingId;
      }

      id = R.id.buttonTwo;
      Button buttonTwo = ViewBindings.findChildViewById(rootView, id);
      if (buttonTwo == null) {
        break missingId;
      }

      id = R.id.gridLayout;
      GridLayout gridLayout = ViewBindings.findChildViewById(rootView, id);
      if (gridLayout == null) {
        break missingId;
      }

      id = R.id.gridLayoutPlayfield;
      GridLayout gridLayoutPlayfield = ViewBindings.findChildViewById(rootView, id);
      if (gridLayoutPlayfield == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, bottonClear, buttonEight,
          buttonFinish, buttonFive, buttonFour, buttonHint, buttonNine, buttonOne, buttonSeven,
          buttonSix, buttonThree, buttonTwo, gridLayout, gridLayoutPlayfield);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
