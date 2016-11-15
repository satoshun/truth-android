package com.github.satoshun.truth.android.api.widget;

import android.widget.AbsoluteLayout;

import com.github.satoshun.truth.android.api.view.ViewGroupSubject;
import com.google.common.truth.FailureStrategy;

public abstract class AbsoluteLayoutSubject<S extends ViewGroupSubject<S, T>, T extends AbsoluteLayout> extends ViewGroupSubject<S, T> {

  public AbsoluteLayoutSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }
}
