package com.github.satoshun.truth.android.api.util;

import android.annotation.TargetApi;
import android.util.LongSparseArray;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

@TargetApi(JELLY_BEAN)
public class LongSparseArraySubject extends BaseSubject<LongSparseArraySubject, LongSparseArray> {

  public static final LongSparseArraySubjectFactory FACTORY = new LongSparseArraySubjectFactory();

  public LongSparseArraySubject(FailureStrategy failureStrategy, LongSparseArray actual) {
    super(failureStrategy, actual);
  }

  public LongSparseArraySubject hasKey(int key) {
    isNotNull();
    check().withFailureMessage("has key")
        .that(actual().indexOfKey(key))
        .isGreaterThan(0);
    return this;
  }

  public LongSparseArraySubject doesNotHaveKey(int key) {
    isNotNull();
    check().withFailureMessage("does not have key")
        .that(actual().indexOfKey(key))
        .isLessThan(0);
    return this;
  }

  public LongSparseArraySubject isSize(int size) {
    isNotNull();
    check().withFailureMessage("is size")
        .that(actual().size())
        .isEqualTo(size);
    return this;
  }

  private static class LongSparseArraySubjectFactory extends SubjectFactory<LongSparseArraySubject, LongSparseArray> {
    @Override
    public LongSparseArraySubject getSubject(FailureStrategy fs, LongSparseArray that) {
      return new LongSparseArraySubject(fs, that);
    }
  }
}
