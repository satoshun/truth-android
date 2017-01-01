package com.github.satoshun.truth.android.api.animation;

import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class PropertyValuesHolderSubject extends BaseSubject<PropertyValuesHolderSubject, PropertyValuesHolder> {

  public static final PropertyValuesHolderSubjectFactory FACTORY = new PropertyValuesHolderSubjectFactory();

  public PropertyValuesHolderSubject(FailureStrategy failureStrategy, PropertyValuesHolder actual) {
    super(failureStrategy, actual);
  }

  public PropertyValuesHolderSubject hasPropertyName(String name) {
    isNotNull();
    check().withFailureMessage("is property name")
        .that(actual().getPropertyName())
        .isEqualTo(name);
    return this;
  }

  private static class PropertyValuesHolderSubjectFactory extends SubjectFactory<PropertyValuesHolderSubject, PropertyValuesHolder> {
    @Override
    public PropertyValuesHolderSubject getSubject(FailureStrategy fs, PropertyValuesHolder that) {
      return new PropertyValuesHolderSubject(fs, that);
    }
  }
}
