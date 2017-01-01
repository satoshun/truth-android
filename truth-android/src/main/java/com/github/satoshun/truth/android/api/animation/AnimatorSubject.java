package com.github.satoshun.truth.android.api.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static android.os.Build.VERSION_CODES.KITKAT;

@TargetApi(HONEYCOMB)
public abstract class AnimatorSubject<S extends AnimatorSubject<S, T>, T extends Animator>
    extends BaseSubject<S, T> {

  public static final AnimatorSubjectFactory FACTORY = new AnimatorSubjectFactory();

  public AnimatorSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isDuration(long duration) {
    isNotNull();
    check().withFailureMessage("is duration")
        .that(actual().getDuration())
        .isEqualTo(duration);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isInterpolator(TimeInterpolator interpolator) {
    isNotNull();
    check().withFailureMessage("is interpolator")
        .that(actual().getInterpolator())
        .isEqualTo(interpolator);
    return myself();
  }

  public S isListener(Animator.AnimatorListener listener) {
    isNotNull();
    check().withFailureMessage("is listener")
        .that(actual().getListeners())
        .contains(listener);
    return myself();
  }

  public S isStartDelay(long delay) {
    isNotNull();
    check().withFailureMessage("is start delay")
        .that(actual().getStartDelay())
        .isEqualTo(delay);
    return myself();
  }

  @TargetApi(KITKAT)
  public S isPaused() {
    isNotNull();
    check().withFailureMessage("is paused")
        .that(actual().isPaused())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isNotPaused() {
    check().withFailureMessage("is not paused")
        .that(actual().isPaused())
        .isFalse();
    return myself();
  }

  public S isRunning() {
    isNotNull();
    check().withFailureMessage("is running")
        .that(actual().isRunning())
        .isTrue();
    return myself();
  }

  public S isNotRunning() {
    isNotNull();
    check().withFailureMessage("is not running")
        .that(actual().isRunning())
        .isFalse();
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public S isStarted() {
    isNotNull();
    check().withFailureMessage("is started")
        .that(actual().isStarted())
        .isTrue();
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public S isNotStarted() {
    isNotNull();
    check().withFailureMessage("is not started")
        .that(actual().isStarted())
        .isFalse();
    return myself();
  }

  private static class AnimatorSubjectImpl extends AnimatorSubject<AnimatorSubjectImpl, Animator> {
    AnimatorSubjectImpl(FailureStrategy failureStrategy, Animator actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AnimatorSubjectFactory extends SubjectFactory<AnimatorSubjectImpl, Animator> {
    @Override
    public AnimatorSubjectImpl getSubject(FailureStrategy fs, Animator that) {
      return new AnimatorSubjectImpl(fs, that);
    }
  }
}
