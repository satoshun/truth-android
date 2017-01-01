package com.github.satoshun.truth.android.api.util;

import android.annotation.TargetApi;
import android.util.SparseLongArray;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

@TargetApi(JELLY_BEAN_MR2)
public class SparseLongArraySubject extends BaseSubject<SparseLongArraySubject, SparseLongArray> {

  public static final SparseLongArraySubjectFactory FACTORY = new SparseLongArraySubjectFactory();

  public SparseLongArraySubject(FailureStrategy failureStrategy, SparseLongArray actual) {
    super(failureStrategy, actual);
  }

  public SparseLongArraySubject hasKey(int key) {
    isNotNull();
    check().withFailureMessage("has key")
        .that(actual().indexOfKey(key))
        .isGreaterThan(0);
    return this;
  }

  public SparseLongArraySubject doesNotHaveKey(int key) {
    isNotNull();
    check().withFailureMessage("does not have key")
        .that(actual().indexOfKey(key))
        .isLessThan(0);
    return this;
  }

  public SparseLongArraySubject isSize(int size) {
    isNotNull();
    check().withFailureMessage("is size")
        .that(actual().size())
        .isEqualTo(size);
    return this;
  }

  private static class SparseLongArraySubjectFactory extends SubjectFactory<SparseLongArraySubject, SparseLongArray> {
    @Override
    public SparseLongArraySubject getSubject(FailureStrategy fs, SparseLongArray that) {
      return new SparseLongArraySubject(fs, that);
    }
  }
}
