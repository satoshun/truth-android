package com.github.satoshun.truth.android.api.util;

import android.util.SparseBooleanArray;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class SparseBooleanArraySubject extends BaseSubject<SparseBooleanArraySubject, SparseBooleanArray> {

  public static final SparseBooleanArraySubjectFactory FACTORY = new SparseBooleanArraySubjectFactory();

  public SparseBooleanArraySubject(FailureStrategy failureStrategy, SparseBooleanArray actual) {
    super(failureStrategy, actual);
  }

  public SparseBooleanArraySubject keyIsTrue(int key) {
    isNotNull();
    check().withFailureMessage("key is true")
        .that(actual().get(key))
        .isTrue();
    return this;
  }

  public SparseBooleanArraySubject keyIsFalse(int key) {
    isNotNull();
    check().withFailureMessage("key is false")
        .that(actual().get(key))
        .isFalse();
    return this;
  }

  public SparseBooleanArraySubject hasKey(int key) {
    isNotNull();
    check().withFailureMessage("has key")
        .that(actual().indexOfKey(key))
        .isGreaterThan(0);
    return this;
  }

  public SparseBooleanArraySubject doesNotHaveKey(int key) {
    isNotNull();
    check().withFailureMessage("does not have key")
        .that(actual().indexOfKey(key))
        .isLessThan(0);
    return this;
  }

  public SparseBooleanArraySubject isSize(int size) {
    isNotNull();
    check().withFailureMessage("is size")
        .that(actual().size())
        .isEqualTo(size);
    return this;
  }

  private static class SparseBooleanArraySubjectFactory extends SubjectFactory<SparseBooleanArraySubject, SparseBooleanArray> {
    @Override
    public SparseBooleanArraySubject getSubject(FailureStrategy fs, SparseBooleanArray that) {
      return new SparseBooleanArraySubject(fs, that);
    }
  }
}
