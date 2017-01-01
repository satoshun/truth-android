package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.Activity;

import com.github.satoshun.truth.android.api.content.ContextSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

public abstract class ActivitySubject<S extends ActivitySubject<S, T>, T extends Activity>
    extends ContextSubject<S, T> {

  public static final ActivitySubjectFactory FACTORY = new ActivitySubjectFactory();

  public ActivitySubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isRequestedOrientation( int orientation) {
    isNotNull();
    check().withFailureMessage("is requested orientation")
        .that(actual().getRequestedOrientation())
        .isEqualTo(orientation);
    return myself();
  }

  public S isTitle(CharSequence title) {
    isNotNull();
    check().withFailureMessage("is title")
        .that(actual().getTitle())
        .isEqualTo(title);
    return myself();
  }

  public S isTitle(int resId) {
    isNotNull();
    return isTitle(actual().getString(resId));
  }

  public S isTitleColor(int color) {
    isNotNull();
    check().withFailureMessage("is title color")
        .that(actual().getTitleColor())
        .isEqualTo(color);
    return myself();
  }

  public S hasWindowFocus() {
    isNotNull();
    check().withFailureMessage("is window focus")
        .that(actual().hasWindowFocus())
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isChangingConfigurations() {
    isNotNull();
    check().withFailureMessage("is changing configurations")
        .that(actual().isChangingConfigurations())
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isNotChangingConfigurations() {
    isNotNull();
    check().withFailureMessage("is not changing configurations")
        .that(actual().isChangingConfigurations())
        .isFalse();
    return myself();
  }

  public S isChild() {
    isNotNull();
    check().withFailureMessage("is child")
        .that(actual().isChild())
        .isTrue();
    return myself();
  }

  public S isNotChild() {
    isNotNull();
    check().withFailureMessage("is not child")
        .that(actual().isChild())
        .isFalse();
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isDestroyed() {
    isNotNull();
    check().withFailureMessage("is destroyed")
        .that(actual().isDestroyed())
        .isTrue();
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isNotDestroyed() {
    isNotNull();
    check().withFailureMessage("is not destroyed")
        .that(actual().isDestroyed())
        .isFalse();
    return myself();
  }

  public S isFinishing() {
    isNotNull();
    check().withFailureMessage("is finishing")
        .that(actual().isDestroyed())
        .isTrue();
    return myself();
  }

  public S isNotFinishing() {
    isNotNull();
    check().withFailureMessage("is not finishing")
        .that(actual().isDestroyed())
        .isFalse();
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isImmersive() {
    isNotNull();
    check().withFailureMessage("is immersive")
        .that(actual().isImmersive())
        .isTrue();
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isNotImmersive() {
    isNotNull();
    check().withFailureMessage("is not immersive")
        .that(actual().isImmersive())
        .isFalse();
    return myself();
  }

  public S isTaskRoot() {
    isNotNull();
    check().withFailureMessage("is task root")
        .that(actual().isTaskRoot())
        .isTrue();
    return myself();
  }

  public S isNotTaskRoot() {
    isNotNull();
    check().withFailureMessage("is not task root")
        .that(actual().isTaskRoot())
        .isFalse();
    return myself();
  }

  private static class ActivitySubjectImpl extends ActivitySubject<ActivitySubjectImpl, Activity> {
    ActivitySubjectImpl(FailureStrategy failureStrategy, Activity actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ActivitySubjectFactory extends SubjectFactory<ActivitySubjectImpl, Activity> {
    @Override
    public ActivitySubjectImpl getSubject(FailureStrategy fs, Activity that) {
      return new ActivitySubjectImpl(fs, that);
    }
  }
}
