package com.github.satoshun.truth.android.api.util;

import android.util.ArrayMap;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ArrayMapSubject<K, V> extends BaseSubject<ArrayMapSubject<K, V>, ArrayMap<K, V>> {

  public static final ArrayMapSubjectFactory FACTORY = new ArrayMapSubjectFactory<>();

  public ArrayMapSubject(FailureStrategy failureStrategy, ArrayMap actual) {
    super(failureStrategy, actual);
  }

  public ArrayMapSubject<K, V> hasKeyAt(int index, K key) {
    isNotNull();
    check().withFailureMessage("has key at")
        .that(actual().keyAt(index))
        .isEqualTo(key);
    return this;
  }

  public ArrayMapSubject<K, V> hasValueAt(int index, V value) {
    isNotNull();
    check().withFailureMessage("has value at")
        .that(actual().valueAt(index))
        .isEqualTo(value);
    return this;
  }

  private static class ArrayMapSubjectFactory<K, V> extends SubjectFactory<ArrayMapSubject<K, V>, ArrayMap<K, V>> {
    @Override public ArrayMapSubject<K, V> getSubject(FailureStrategy fs, ArrayMap<K, V> that) {
      return new ArrayMapSubject<>(fs, that);
    }
  }
}
