package com.github.satoshun.truth.android.api.content;

import android.content.SharedPreferences;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.Set;

public class SharedPreferencesSubject extends BaseSubject<SharedPreferencesSubject, SharedPreferences> {

  public static final SharedPreferencesSubjectFactory FACTORY = new SharedPreferencesSubjectFactory();

  public SharedPreferencesSubject(FailureStrategy failureStrategy, SharedPreferences actual) {
    super(failureStrategy, actual);
  }

  public SharedPreferencesSubject hasKey(String key) {
    isNotNull();
    check().withFailureMessage("has key")
        .that(actual().contains(key))
        .isTrue();
    return myself();
  }

  public SharedPreferencesSubject doesNotHaveKey(String key) {
    isNotNull();
    check().withFailureMessage("does not have key")
        .that(actual().contains(key))
        .isFalse();
    return myself();
  }

  public SharedPreferencesSubject contains(String key, String value) {
    isNotNull();
    check().withFailureMessage("contains")
        .that(actual().getAll())
        .containsEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject doesNotContain(String key, String value) {
    isNotNull();
    check().withFailureMessage("does not contains")
        .that(actual().getAll())
        .doesNotContainEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject contains(String key, int value) {
    isNotNull();
    check().withFailureMessage("contains")
        .that(actual().getAll())
        .containsEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject doesNotContain(String key, int value) {
    isNotNull();
    check().withFailureMessage("does not contains")
        .that(actual().getAll())
        .doesNotContainEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject contains(String key, boolean value) {
    isNotNull();
    check().withFailureMessage("contains")
        .that(actual().getAll())
        .containsEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject doesNotContain(String key, boolean value) {
    isNotNull();
    check().withFailureMessage("does not contains")
        .that(actual().getAll())
        .doesNotContainEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject contains(String key, float value) {
    isNotNull();
    check().withFailureMessage("contains")
        .that(actual().getAll())
        .containsEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject doesNotContain(String key, float value) {
    isNotNull();
    check().withFailureMessage("does not contains")
        .that(actual().getAll())
        .doesNotContainEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject contains(String key, long value) {
    isNotNull();
    check().withFailureMessage("contains")
        .that(actual().getAll())
        .containsEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject doesNotContain(String key, long value) {
    isNotNull();
    check().withFailureMessage("does not contains")
        .that(actual().getAll())
        .doesNotContainEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject contains(String key, Set<String> value) {
    isNotNull();
    check().withFailureMessage("contains")
        .that(actual().getAll())
        .containsEntry(key, value);
    return myself();
  }

  public SharedPreferencesSubject doesNotContain(String key, Set<String> value) {
    isNotNull();
    check().withFailureMessage("does not contains")
        .that(actual().getAll())
        .doesNotContainEntry(key, value);
    return myself();
  }

  private static class SharedPreferencesSubjectFactory extends SubjectFactory<SharedPreferencesSubject, SharedPreferences> {
    @Override
    public SharedPreferencesSubject getSubject(FailureStrategy fs, SharedPreferences that) {
      return new SharedPreferencesSubject(fs, that);
    }
  }
}
