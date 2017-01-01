package com.github.satoshun.truth.android.api.util;

import android.util.AttributeSet;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class AttributeSetSubject extends BaseSubject<AttributeSetSubject, AttributeSet> {

  public static final AttributeSetSubjectFactory FACTORY = new AttributeSetSubjectFactory();

  public AttributeSetSubject(FailureStrategy failureStrategy, AttributeSet actual) {
    super(failureStrategy, actual);
  }

  public AttributeSetSubject isAttributeCount(int count) {
    isNotNull();
    check().withFailureMessage("is attribute count")
        .that(actual().getAttributeCount())
        .isEqualTo(count);
    return this;
  }

  public AttributeSetSubject isClassAttribute(String value) {
    isNotNull();
    check().withFailureMessage("is class attribute")
        .that(actual().getClassAttribute())
        .isEqualTo(value);
    return this;
  }

  public AttributeSetSubject isIdAttribute(String value) {
    isNotNull();
    check().withFailureMessage("is id attribute")
        .that(actual().getIdAttribute())
        .isEqualTo(value);
    return this;
  }

  public AttributeSetSubject isPositionDescription(String position) {
    isNotNull();
    check().withFailureMessage("is position description")
        .that(actual().getPositionDescription())
        .isEqualTo(position);
    return this;
  }

  public AttributeSetSubject isStyleAttribute(int value) {
    isNotNull();
    check().withFailureMessage("is style attribute")
        .that(actual().getStyleAttribute())
        .isEqualTo(value);
    return this;
  }

  private static class AttributeSetSubjectFactory extends SubjectFactory<AttributeSetSubject, AttributeSet> {
    @Override
    public AttributeSetSubject getSubject(FailureStrategy fs, AttributeSet that) {
      return new AttributeSetSubject(fs, that);
    }
  }
}
