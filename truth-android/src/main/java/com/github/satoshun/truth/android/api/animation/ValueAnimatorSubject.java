package com.github.satoshun.truth.android.api.animation;


import android.animation.ValueAnimator;
import android.annotation.TargetApi;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.HONEYCOMB_MR1;

@TargetApi(HONEYCOMB)
public abstract class ValueAnimatorSubject<S extends ValueAnimatorSubject<S, T>, T extends ValueAnimator>
    extends AnimatorSubject<S, T> {

  public static final ValueAnimatorSubjectFactory FACTORY = new ValueAnimatorSubjectFactory();

  public ValueAnimatorSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB_MR1)
  public S isAnimatedFraction(float fraction) {
    isNotNull();
    check().withFailureMessage("is animated fraction")
        .that(actual().getAnimatedFraction())
        .isEqualTo(fraction);
    return myself();
  }

  public S isAnimatedValue(Object value) {
    isNotNull();
    check().withFailureMessage("is animated value")
        .that(actual().getAnimatedValue())
        .isEqualTo(value);
    return myself();
  }

  public S isCurrentPlayTime(long time) {
    isNotNull();
    check().withFailureMessage("is current play time")
        .that(actual().getCurrentPlayTime())
        .isEqualTo(time);
    return myself();
  }

  public S isRepeatCount(int count) {
    isNotNull();
    check().withFailureMessage("is repeat count")
        .that(actual().getRepeatCount())
        .isEqualTo(count);
    return myself();
  }

  public S isRepeatMode(int mode) {
    isNotNull();
    check().withFailureMessage("is repeat mode")
        .that(actual().getRepeatMode())
        .isEqualTo(mode);
    return myself();
  }

  private static class ValueAnimatorSubjectImpl extends ValueAnimatorSubject<ValueAnimatorSubjectImpl, ValueAnimator> {
    ValueAnimatorSubjectImpl(FailureStrategy failureStrategy, ValueAnimator actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ValueAnimatorSubjectFactory extends SubjectFactory<ValueAnimatorSubjectImpl, ValueAnimator> {
    @Override
    public ValueAnimatorSubjectImpl getSubject(FailureStrategy fs, ValueAnimator that) {
      return new ValueAnimatorSubjectImpl(fs, that);
    }
  }
}
