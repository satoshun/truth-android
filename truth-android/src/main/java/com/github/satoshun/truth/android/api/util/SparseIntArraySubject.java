package com.github.satoshun.truth.android.api.util;

import android.util.SparseIntArray;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class SparseIntArraySubject extends BaseSubject<SparseIntArraySubject, SparseIntArray> {

  public static final SparseIntArraySubjectFactory FACTORY = new SparseIntArraySubjectFactory();

  public SparseIntArraySubject(FailureStrategy failureStrategy, SparseIntArray actual) {
    super(failureStrategy, actual);
  }

  public SparseIntArraySubject hasKey(int key) {
    isNotNull();
    check().withFailureMessage("has key")
        .that(actual().indexOfKey(key))
        .isGreaterThan(0);
    return this;
  }

  public SparseIntArraySubject doesNotHaveKey(int key) {
    isNotNull();
    check().withFailureMessage("does not have key")
        .that(actual().indexOfKey(key))
        .isLessThan(0);
    return this;
  }

  public SparseIntArraySubject isSize(int size) {
    isNotNull();
    check().withFailureMessage("is size")
        .that(actual().size())
        .isEqualTo(size);
    return this;
  }

  private static class SparseIntArraySubjectFactory extends SubjectFactory<SparseIntArraySubject, SparseIntArray> {
    @Override
    public SparseIntArraySubject getSubject(FailureStrategy fs, SparseIntArray that) {
      return new SparseIntArraySubject(fs, that);
    }
  }
}
