package com.github.satoshun.truth.android.api.util;

import android.util.Pair;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class PairSubject<F, S> extends BaseSubject<PairSubject<F, S>, Pair<F, S>> {

  public static final PairSubjectFactory FACTORY = new PairSubjectFactory<>();

  public PairSubject(FailureStrategy failureStrategy, Pair<F, S> actual) {
    super(failureStrategy, actual);
  }

  public PairSubject<F, S> isFirst(F first) {
    isNotNull();
    check().withFailureMessage("is first")
        .that(actual().first)
        .isEqualTo(first);
    return this;
  }

  public PairSubject<F, S> isSecond(S second) {
    isNotNull();
    check().withFailureMessage("is second")
        .that(actual().second)
        .isEqualTo(second);
    return this;
  }

  private static class PairSubjectFactory<F, S> extends SubjectFactory<PairSubject<F, S>, Pair<F, S>> {
    @Override public PairSubject<F, S> getSubject(FailureStrategy fs, Pair<F, S> that) {
      return new PairSubject<>(fs, that);
    }
  }
}
