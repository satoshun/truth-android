package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

import com.github.satoshun.truth.android.api.view.ViewGroupSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public abstract class FrameLayoutSubject<S extends FrameLayoutSubject<S, T>, T extends FrameLayout>
    extends ViewGroupSubject<S, T> {

  public static final FrameLayoutSubjectFactory FACTORY = new FrameLayoutSubjectFactory();

  public FrameLayoutSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isForeground(Drawable drawable) {
    isNotNull();
    check().withFailureMessage("is foreground")
        .that(actual().getForeground())
        .isSameAs(drawable);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isForegroundGravity(int gravity) {
    isNotNull();
    check().withFailureMessage("is foreground gravity")
        .that(actual().getForegroundGravity())
        .isEqualTo(gravity);
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public S isMeasuringAllChildren() {
    isNotNull();
    check().withFailureMessage("is measuring all children")
        .that(actual().getMeasureAllChildren())
        .isTrue();
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public S isNotMeasuringAllChildren() {
    isNotNull();
    check().withFailureMessage("is not measuring all children")
        .that(actual().getMeasureAllChildren())
        .isFalse();
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public S isDelayingChildPressedState() {
    isNotNull();
    check().withFailureMessage("is delaying child pressed state")
        .that(actual().shouldDelayChildPressedState())
        .isTrue();
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public S isNotDelayingChildPressedState() {
    isNotNull();
    check().withFailureMessage("is not delaying child pressed state")
        .that(actual().shouldDelayChildPressedState())
        .isFalse();
    return myself();
  }

  private static class FrameLayoutSubjectImpl extends FrameLayoutSubject<FrameLayoutSubjectImpl, FrameLayout> {
    FrameLayoutSubjectImpl(FailureStrategy failureStrategy, FrameLayout actual) {
      super(failureStrategy, actual);
    }
  }

  private static class FrameLayoutSubjectFactory extends SubjectFactory<FrameLayoutSubjectImpl, FrameLayout> {
    @Override
    public FrameLayoutSubjectImpl getSubject(FailureStrategy fs, FrameLayout that) {
      return new FrameLayoutSubjectImpl(fs, that);
    }
  }
}
