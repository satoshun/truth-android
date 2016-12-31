package com.github.satoshun.truth.android.api.widget;

import android.widget.Adapter;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class AdapterSubject<S extends AdapterSubject<S, T>, T extends Adapter>
    extends BaseSubject<S, T> {

  public static final AdapterSubjectFactory FACTORY = new AdapterSubjectFactory();

  public AdapterSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isCount(int count) {
    isNotNull();
    check().withFailureMessage("is count")
        .that(actual().getCount())
        .isEqualTo(count);
    return myself();
  }

  public S isViewTypeCount(int count) {
    isNotNull();
    check().withFailureMessage("is view type count")
        .that(actual().getViewTypeCount())
        .isEqualTo(count);
    return myself();
  }

  public S isStableIds() {
    isNotNull();
    check().withFailureMessage("is stable ids")
        .that(actual().hasStableIds())
        .isTrue();
    return myself();
  }

  public S isUnstableIds() {
    isNotNull();
    check().withFailureMessage("is unstable ids")
        .that(actual().hasStableIds())
        .isFalse();
    return myself();
  }

  public S isEmpty() {
    isNotNull();
    check().withFailureMessage("is empty")
        .that(actual().isEmpty())
        .isTrue();
    return myself();
  }

  public S isNotEmpty() {
    isNotNull();
    check().withFailureMessage("is not empty")
        .that(actual().isEmpty())
        .isFalse();
    return myself();
  }

  public S hasItem(Object expected, int index) {
    isNotNull();
    check().withFailureMessage("has item index")
        .that(actual().getCount())
        .isGreaterThan(index);
    check().withFailureMessage("has item")
        .that(actual().getItem(index))
        .isEqualTo(expected);
    return myself();
  }

  public S doesNotHaveItem(Object notExpected, int index) {
    isNotNull();
    check().withFailureMessage("does not have item index")
        .that(actual().getCount())
        .isGreaterThan(index);
    check().withFailureMessage("does not have item")
        .that(actual().getItem(index))
        .isNotEqualTo(notExpected);
    return myself();
  }

  private static class AdapterSubjectImpl extends AdapterSubject<AdapterSubjectImpl, Adapter> {
    AdapterSubjectImpl(FailureStrategy failureStrategy, Adapter actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AdapterSubjectFactory extends SubjectFactory<AdapterSubjectImpl, Adapter> {
    @Override
    public AdapterSubjectImpl getSubject(FailureStrategy fs, Adapter that) {
      return new AdapterSubjectImpl(fs, that);
    }
  }
}
