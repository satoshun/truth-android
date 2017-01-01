package com.github.satoshun.truth.android.api.animation;

import android.animation.Keyframe;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class KeyframeSubject extends BaseSubject<KeyframeSubject, Keyframe> {

  public static final KeyframeSubjectFactory FACTORY = new KeyframeSubjectFactory();

  public KeyframeSubject(FailureStrategy failureStrategy, Keyframe actual) {
    super(failureStrategy, actual);
  }

  public KeyframeSubject isFraction(float fraction) {
    isNotNull();
    check().withFailureMessage("is fraction")
        .that(actual().getFraction())
        .isEqualTo(fraction);
    return this;
  }

  public KeyframeSubject isInterpolator(TimeInterpolator interpolator) {
    isNotNull();
    check().withFailureMessage("is interpolator")
        .that(actual().getInterpolator())
        .isSameAs(interpolator);
    return this;
  }

  public KeyframeSubject isType(Class type) {
    isNotNull();
    check().withFailureMessage("is type")
        .that(actual().getType())
        .isEqualTo(type);
    return this;
  }

  public KeyframeSubject isValue(Object value) {
    isNotNull();
    check().withFailureMessage("is value")
        .that(actual().getValue())
        .isEqualTo(value);
    return this;
  }

  private static class KeyframeSubjectFactory extends SubjectFactory<KeyframeSubject, Keyframe> {
    @Override
    public KeyframeSubject getSubject(FailureStrategy fs, Keyframe that) {
      return new KeyframeSubject(fs, that);
    }
  }
}
