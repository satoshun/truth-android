package com.github.satoshun.truth.android.api.content;

import android.content.ContentValues;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContentValuesSubject extends BaseSubject<ContentValuesSubject, ContentValues> {

  public static final ContentValuesSubjectFactory FACTORY = new ContentValuesSubjectFactory();

  public ContentValuesSubject(FailureStrategy failureStrategy, ContentValues actual) {
    super(failureStrategy, actual);
  }

  public ContentValuesSubject isEmpty() {
    isNotNull();
    check().withFailureMessage("is empty")
        .that(actual().size())
        .isEqualTo(0);
    return this;
  }

  public ContentValuesSubject isNotEmpty() {
    isNotNull();
    check().withFailureMessage("is empty")
        .that(actual().size())
        .isNotEqualTo(0);
    return this;
  }

  public ContentValuesSubject containsKey(String key) {
    isNotNull();
    check().withFailureMessage("contains key")
        .that(actual().containsKey(key))
        .isTrue();
    return this;
  }

  public ContentValuesSubject containsValue(Object expectedValue) {
    isNotNull();
    Set<Map.Entry<String, Object>> entries = actual().valueSet();
    List<Object> values = new ArrayList<>(entries.size());
    for (Map.Entry<String, Object> entry : entries) {
      values.add(entry.getValue());
    }
    check().withFailureMessage("contains value")
        .that(values)
        .contains(expectedValue);
    return this;
  }

  public ContentValuesSubject isSize(int expected) {
    isNotNull();
    check().withFailureMessage("is size")
        .that(actual().size())
        .isEqualTo(expected);
    return this;
  }

  private static class ContentValuesSubjectFactory extends SubjectFactory<ContentValuesSubject, ContentValues> {
    @Override
    public ContentValuesSubject getSubject(FailureStrategy fs, ContentValues that) {
      return new ContentValuesSubject(fs, that);
    }
  }
}
