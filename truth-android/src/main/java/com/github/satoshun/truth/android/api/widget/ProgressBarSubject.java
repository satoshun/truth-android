package com.github.satoshun.truth.android.api.widget;

import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

import com.github.satoshun.truth.android.api.view.ViewSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class ProgressBarSubject<S extends ProgressBarSubject<S, T>, T extends ProgressBar>
    extends ViewSubject<S, T> {

  public static final ProgressBarSubjectFactory FACTORY = new ProgressBarSubjectFactory();

  public ProgressBarSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isIndeterminateDrawable(Drawable drawable) {
    isNotNull();
    check().withFailureMessage("is indeterminate drawable")
        .that(actual().getIndeterminateDrawable())
        .isSameAs(drawable);
    return myself();
  }

  public S isInterpolator(Interpolator interpolator) {
    isNotNull();
    check().withFailureMessage("is interpolator")
        .that(actual().getInterpolator())
        .isSameAs(interpolator);
    return myself();
  }

  public S isMaximum(int maximum) {
    isNotNull();
    check().withFailureMessage("is maximum")
        .that(actual().getMax())
        .isEqualTo(maximum);
    return myself();
  }

  public S isProgress(int progress) {
    isNotNull();
    check().withFailureMessage("is progress")
        .that(actual().getProgress())
        .isEqualTo(progress);
    return myself();
  }

  public S isProgressDrawable(Drawable drawable) {
    isNotNull();
    check().withFailureMessage("is progress drawable")
        .that(actual().getProgressDrawable())
        .isSameAs(drawable);
    return myself();
  }

  public S isSecondaryProgress(int progress) {
    isNotNull();
    check().withFailureMessage("is secondary progress")
        .that(actual().getSecondaryProgress())
        .isEqualTo(progress);
    return myself();
  }

  public S isIndeterminate() {
    isNotNull();
    check().withFailureMessage("is indeterminate")
        .that(actual().isIndeterminate())
        .isTrue();
    return myself();
  }

  public S isNotIndeterminate() {
    isNotNull();
    check().withFailureMessage("is not indeterminate")
        .that(actual().isIndeterminate())
        .isFalse();
    return myself();
  }

  private static class ProgressBarSubjectImpl extends ProgressBarSubject<ProgressBarSubjectImpl, ProgressBar> {
    ProgressBarSubjectImpl(FailureStrategy failureStrategy, ProgressBar actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ProgressBarSubjectFactory extends SubjectFactory<ProgressBarSubjectImpl, ProgressBar> {
    @Override
    public ProgressBarSubjectImpl getSubject(FailureStrategy fs, ProgressBar that) {
      return new ProgressBarSubjectImpl(fs, that);
    }
  }
}
