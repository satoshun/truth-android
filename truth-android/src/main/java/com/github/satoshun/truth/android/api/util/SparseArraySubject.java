package com.github.satoshun.truth.android.api.util;

import android.util.SparseArray;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class SparseArraySubject<E> extends BaseSubject<SparseArraySubject<E>, SparseArray<E>> {

  public static final SparseArraySubjectFactory FACTORY = new SparseArraySubjectFactory<>();

  public SparseArraySubject(FailureStrategy failureStrategy, SparseArray<E> actual) {
    super(failureStrategy, actual);
  }

  public SparseArraySubject<E> hasKey(int key) {
    isNotNull();
    check().withFailureMessage("has key")
        .that(actual().indexOfKey(key))
        .isGreaterThan(0);
    return this;
  }

  public SparseArraySubject<E> doesNotHaveKey(int key) {
    isNotNull();
    check().withFailureMessage("does not have key")
        .that(actual().indexOfKey(key))
        .isLessThan(0);
    return this;
  }

  public SparseArraySubject<E> isSize(int size) {
    isNotNull();
    check().withFailureMessage("is size")
        .that(actual().size())
        .isEqualTo(size);
    return this;
  }

  private static class SparseArraySubjectFactory<E> extends SubjectFactory<SparseArraySubject<E>, SparseArray<E>> {
    @Override public SparseArraySubject<E> getSubject(FailureStrategy fs, SparseArray<E> that) {
      return new SparseArraySubject<>(fs, that);
    }
  }
}
