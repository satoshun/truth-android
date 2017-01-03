package com.github.satoshun.truth.android.api.view.animation;

import android.annotation.TargetApi;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB_MR1;

public abstract class AnimationSubject<S extends AnimationSubject<S, T>, T extends Animation>
    extends BaseSubject<S, T> {

  public static final AnimationSubjectFactory FACTORY = new AnimationSubjectFactory();

  public AnimationSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB_MR1)
  public S isBackgroundColor(int color) {
    isNotNull();
    check().withFailureMessage("is background color")
        .that(actual().getBackgroundColor())
        .isEqualTo(color);
    return myself();
  }

  public S isDuration(long duration) {
    isNotNull();
    check().withFailureMessage("is duration")
        .that(actual().getDuration())
        .isEqualTo(duration);
    return myself();
  }

  public S isFillingAfter() {
    isNotNull();
    check().withFailureMessage("is filling after")
        .that(actual().getFillAfter())
        .isTrue();
    return myself();
  }

  public S isNotFillingAfter() {
    isNotNull();
    check().withFailureMessage("is not filling after")
        .that(actual().getFillAfter())
        .isFalse();
    return myself();
  }

  public S isFillingBefore() {
    isNotNull();
    check().withFailureMessage("is filling before")
        .that(actual().getFillBefore())
        .isTrue();
    return myself();
  }

  public S isNotFillingBefore() {
    isNotNull();
    check().withFailureMessage("is not filling before")
        .that(actual().getFillBefore())
        .isFalse();
    return myself();
  }

  public S isInterpolator(Interpolator interpolator) {
    isNotNull();
    check().withFailureMessage("is interpolator")
        .that(actual().getInterpolator())
        .isSameAs(interpolator);
    return myself();
  }

  public S isRepeatCount(int count) {
    isNotNull();
    check().withFailureMessage("is repeat count")
        .that(actual().getInterpolator())
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

  public S isStartOffset(long offset) {
    isNotNull();
    check().withFailureMessage("is start offset")
        .that(actual().getStartOffset())
        .isEqualTo(offset);
    return myself();
  }

  public S isStartTime(long time) {
    isNotNull();
    check().withFailureMessage("is start time")
        .that(actual().getStartTime())
        .isEqualTo(time);
    return myself();
  }

  public S isZAdjustment(int adjustment) {
    isNotNull();
    check().withFailureMessage("is z adjustment")
        .that(actual().getZAdjustment())
        .isEqualTo(adjustment);
    return myself();
  }

  public S hasEnded() {
    isNotNull();
    check().withFailureMessage("has ended")
        .that(actual().hasEnded())
        .isTrue();
    return myself();
  }

  public S doesNotHaveEnded() {
    isNotNull();
    check().withFailureMessage("does not have ended")
        .that(actual().hasEnded())
        .isFalse();
    return myself();
  }

  public S hasStarted() {
    isNotNull();
    check().withFailureMessage("has started")
        .that(actual().hasStarted())
        .isTrue();
    return myself();
  }

  public S doesNotHaveStarted() {
    isNotNull();
    check().withFailureMessage("does not have started")
        .that(actual().hasStarted())
        .isFalse();
    return myself();
  }

  public S isFillEnabled() {
    isNotNull();
    check().withFailureMessage("is fill enabled")
        .that(actual().isFillEnabled())
        .isTrue();
    return myself();
  }

  public S isFillDisabled() {
    isNotNull();
    check().withFailureMessage("is fill disabled")
        .that(actual().isFillEnabled())
        .isFalse();
    return myself();
  }

  public S isInitialized() {
    isNotNull();
    check().withFailureMessage("is initialized")
        .that(actual().isInitialized())
        .isTrue();
    return myself();
  }

  public S isNotInitialized() {
    isNotNull();
    check().withFailureMessage("is not initialized")
        .that(actual().isInitialized())
        .isFalse();
    return myself();
  }

  public S isChangingBounds() {
    isNotNull();
    check().withFailureMessage("is changing bounds")
        .that(actual().willChangeBounds())
        .isTrue();
    return myself();
  }

  public S isNotChangingBounds() {
    isNotNull();
    check().withFailureMessage("is not changing bounds")
        .that(actual().willChangeBounds())
        .isFalse();
    return myself();
  }

  public S isChangingTransformationMatrix() {
    isNotNull();
    check().withFailureMessage("is changing transformation matrix")
        .that(actual().willChangeTransformationMatrix())
        .isTrue();
    return myself();
  }

  public S isNotChangingTransformationMatrix() {
    isNotNull();
    check().withFailureMessage("is not changing transformation matrix")
        .that(actual().willChangeTransformationMatrix())
        .isFalse();
    return myself();
  }

  private static class AnimationSubjectImpl extends AnimationSubject<AnimationSubjectImpl, Animation> {
    AnimationSubjectImpl(FailureStrategy failureStrategy, Animation actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AnimationSubjectFactory extends SubjectFactory<AnimationSubjectImpl, Animation> {
    @Override
    public AnimationSubjectImpl getSubject(FailureStrategy fs, Animation that) {
      return new AnimationSubjectImpl(fs, that);
    }
  }
}
