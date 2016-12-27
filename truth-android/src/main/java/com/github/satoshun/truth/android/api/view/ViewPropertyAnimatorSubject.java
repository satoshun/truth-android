package com.github.satoshun.truth.android.api.view;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.view.ViewPropertyAnimator;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB_MR1;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

@TargetApi(HONEYCOMB_MR1)
public class ViewPropertyAnimatorSubject extends BaseSubject<ViewPropertyAnimatorSubject, ViewPropertyAnimator> {

  public static final ViewPropertyAnimatorSubjectFactory FACTORY = new ViewPropertyAnimatorSubjectFactory();

  public ViewPropertyAnimatorSubject(FailureStrategy failureStrategy, ViewPropertyAnimator actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public ViewPropertyAnimatorSubject isDuration(long duration) {
    isNotNull();
    check().withFailureMessage("is duration")
        .that(actual().getDuration())
        .isEqualTo(duration);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public ViewPropertyAnimatorSubject isInterpolator(TimeInterpolator interpolator) {
    isNotNull();
    check().withFailureMessage("is interpolator")
        .that(actual().getInterpolator())
        .isEqualTo(interpolator);
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public ViewPropertyAnimatorSubject isStartDelay(long delay) {
    isNotNull();
    check().withFailureMessage("is start delay")
        .that(actual().getStartDelay())
        .isEqualTo(delay);
    return myself();
  }

  private static class ViewPropertyAnimatorSubjectFactory extends SubjectFactory<ViewPropertyAnimatorSubject, ViewPropertyAnimator> {
    @Override
    public ViewPropertyAnimatorSubject getSubject(FailureStrategy fs, ViewPropertyAnimator that) {
      return new ViewPropertyAnimatorSubject(fs, that);
    }
  }
}
