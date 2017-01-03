package com.github.satoshun.truth.android.api.view.animation;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

public abstract class LayoutAnimationControllerSubject<S extends LayoutAnimationControllerSubject<S, T>, T extends LayoutAnimationController>
    extends BaseSubject<S, T> {

  public static final LayoutAnimationControllerSubjectFactory FACTORY = new LayoutAnimationControllerSubjectFactory();

  public LayoutAnimationControllerSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isAnimation(Animation animation) {
    isNotNull();
    check().withFailureMessage("is animation")
        .that(actual().getAnimation())
        .isSameAs(animation);
    return myself();
  }

  public S isDelay(float delay) {
    isNotNull();
    check().withFailureMessage("is delay")
        .that(actual().getDelay())
        .isEqualTo(delay);
    return myself();
  }

  public S isInterpolator(Interpolator interpolator) {
    isNotNull();
    check().withFailureMessage("is interpolator")
        .that(actual().getInterpolator())
        .isSameAs(interpolator);
    return myself();
  }

  public S isOrder(int order) {
    isNotNull();
    check().withFailureMessage("is order")
        .that(actual().getOrder())
        .isEqualTo(order);
    return myself();
  }

  public S isDone() {
    isNotNull();
    check().withFailureMessage("is done")
        .that(actual().isDone())
        .isTrue();
    return myself();
  }

  public S isNotDone() {
    isNotNull();
    check().withFailureMessage("is not done")
        .that(actual().isDone())
        .isFalse();
    return myself();
  }

  public S isOverlapping() {
    isNotNull();
    check().withFailureMessage("is overlapping")
        .that(actual().willOverlap())
        .isTrue();
    return myself();
  }

  public S isNotOverlapping() {
    isNotNull();
    check().withFailureMessage("is not overlapping")
        .that(actual().willOverlap())
        .isFalse();
    return myself();
  }

  private static class LayoutAnimationControllerSubjectImpl extends LayoutAnimationControllerSubject<LayoutAnimationControllerSubjectImpl, LayoutAnimationController> {
    LayoutAnimationControllerSubjectImpl(FailureStrategy failureStrategy, LayoutAnimationController actual) {
      super(failureStrategy, actual);
    }
  }

  private static class LayoutAnimationControllerSubjectFactory extends SubjectFactory<LayoutAnimationControllerSubjectImpl, LayoutAnimationController> {
    @Override
    public LayoutAnimationControllerSubjectImpl getSubject(FailureStrategy fs, LayoutAnimationController that) {
      return new LayoutAnimationControllerSubjectImpl(fs, that);
    }
  }
}
