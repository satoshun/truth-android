package com.github.satoshun.truth.android.api.animation;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class ObjectAnimatorSubject extends ValueAnimatorSubject<ObjectAnimatorSubject, ObjectAnimator> {

  public static final ObjectAnimatorSubjectFactory FACTORY = new ObjectAnimatorSubjectFactory();

  public ObjectAnimatorSubject(FailureStrategy failureStrategy, ObjectAnimator actual) {
    super(failureStrategy, actual);
  }

  public ObjectAnimatorSubject isPropertyName(String name) {
    isNotNull();
    check().withFailureMessage("is property name")
        .that(actual().getPropertyName())
        .isEqualTo(name);
    return this;
  }

  public ObjectAnimatorSubject isTarget(Object target) {
    isNotNull();
    check().withFailureMessage("is target")
        .that(actual().getTarget())
        .isSameAs(target);
    return this;
  }

  private static class ObjectAnimatorSubjectFactory extends SubjectFactory<ObjectAnimatorSubject, ObjectAnimator> {
    @Override
    public ObjectAnimatorSubject getSubject(FailureStrategy fs, ObjectAnimator that) {
      return new ObjectAnimatorSubject(fs, that);
    }
  }
}
