package com.github.satoshun.truth.android.api;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

public abstract class BaseSubject<S extends BaseSubject<S, T>, T> extends Subject<S, T> {

  public BaseSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  @SuppressWarnings("unchecked")
  protected S myself() {
    return (S) this;
  }
}
