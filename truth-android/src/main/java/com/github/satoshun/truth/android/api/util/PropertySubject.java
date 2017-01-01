package com.github.satoshun.truth.android.api.util;

import android.util.Property;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class PropertySubject<T, V> extends BaseSubject<PropertySubject<T, V>, Property<T, V>> {

  public static final PropertySubjectFactory FACTORY = new PropertySubjectFactory<>();

  public PropertySubject(FailureStrategy failureStrategy, Property<T, V> actual) {
    super(failureStrategy, actual);
  }

  public PropertySubject<T, V> isName(String name) {
    isNotNull();
    check().withFailureMessage("is name")
        .that(actual().getName())
        .isEqualTo(name);
    return this;
  }

  public PropertySubject<T, V> isType(Class<?> type) {
    isNotNull();
    check().withFailureMessage("is type")
        .that(actual().getType())
        .isEqualTo(type);
    return this;
  }

  public PropertySubject<T, V> isReadOnly() {
    isNotNull();
    check().withFailureMessage("is read only")
        .that(actual().isReadOnly())
        .isTrue();
    return this;
  }

  public PropertySubject<T, V> isNotReadOnly() {
    isNotNull();
    check().withFailureMessage("is not read only")
        .that(actual().isReadOnly())
        .isFalse();
    return this;
  }

  private static class PropertySubjectFactory<T, V> extends SubjectFactory<PropertySubject<T, V>, Property<T, V>> {
    @Override public PropertySubject<T, V> getSubject(FailureStrategy fs, Property<T, V> that) {
      return new PropertySubject<>(fs, that);
    }
  }
}
