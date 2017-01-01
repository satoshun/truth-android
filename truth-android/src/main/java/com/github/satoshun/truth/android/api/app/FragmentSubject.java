package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.Fragment;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.HONEYCOMB_MR2;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;

@TargetApi(HONEYCOMB)
public abstract class FragmentSubject<S extends FragmentSubject<S, T>, T extends Fragment>
    extends BaseSubject<S, T> {

  public static final FragmentSubjectFactory FACTORY = new FragmentSubjectFactory();

  public FragmentSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isId(int id) {
    isNotNull();
    check().withFailureMessage("is id")
        .that(actual().getId())
        .isEqualTo(id);
    return myself();
  }

  public S isTag(String tag) {
    isNotNull();
    check().withFailureMessage("is tag")
        .that(actual().getTag())
        .isEqualTo(tag);
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH_MR1)
  public S isUserVisible() {
    isNotNull();
    check().withFailureMessage("is user visible")
        .that(actual().getUserVisibleHint())
        .isTrue();
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH_MR1)
  public S isNotUserVisible() {
    isNotNull();
    check().withFailureMessage("is not user visible")
        .that(actual().getUserVisibleHint())
        .isFalse();
    return myself();
  }

  public S isAdded() {
    isNotNull();
    check().withFailureMessage("is added")
        .that(actual().isAdded())
        .isTrue();
    return myself();
  }

  public S isNotAdded() {
    isNotNull();
    check().withFailureMessage("is not added")
        .that(actual().isAdded())
        .isFalse();
    return myself();
  }

  @TargetApi(HONEYCOMB_MR2)
  public S isDetached() {
    isNotNull();
    check().withFailureMessage("is detached")
        .that(actual().isDetached())
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB_MR2)
  public S isNotDetached() {
    isNotNull();
    check().withFailureMessage("is not detached")
        .that(actual().isDetached())
        .isFalse();
    return myself();
  }

  public S isHidden() {
    isNotNull();
    check().withFailureMessage("is hidden")
        .that(actual().isHidden())
        .isTrue();
    return myself();
  }

  public S isNotHidden() {
    isNotNull();
    check().withFailureMessage("is not hidden")
        .that(actual().isHidden())
        .isFalse();
    return myself();
  }

  public S isInLayout() {
    isNotNull();
    check().withFailureMessage("is in layout")
        .that(actual().isInLayout())
        .isTrue();
    return myself();
  }

  public S isNotInLayout() {
    isNotNull();
    check().withFailureMessage("is not in layout")
        .that(actual().isInLayout())
        .isFalse();
    return myself();
  }

  public S isRemoving() {
    isNotNull();
    check().withFailureMessage("is removing")
        .that(actual().isRemoving())
        .isTrue();
    return myself();
  }

  public S isNotRemoving() {
    isNotNull();
    check().withFailureMessage("is not removing")
        .that(actual().isRemoving())
        .isFalse();
    return myself();
  }

  public S isResumed() {
    isNotNull();
    check().withFailureMessage("is resumed")
        .that(actual().isResumed())
        .isTrue();
    return myself();
  }

  public S isNotResumed() {
    isNotNull();
    check().withFailureMessage("is not resumed")
        .that(actual().isResumed())
        .isFalse();
    return myself();
  }

  public S isVisible() {
    isNotNull();
    check().withFailureMessage("is visible")
        .that(actual().isVisible())
        .isTrue();
    return myself();
  }

  public S isNotVisible() {
    isNotNull();
    check().withFailureMessage("is not visible")
        .that(actual().isVisible())
        .isFalse();
    return myself();
  }

  private static class FragmentSubjectImpl extends FragmentSubject<FragmentSubjectImpl, Fragment> {
    FragmentSubjectImpl(FailureStrategy failureStrategy, Fragment actual) {
      super(failureStrategy, actual);
    }
  }

  private static class FragmentSubjectFactory extends SubjectFactory<FragmentSubjectImpl, Fragment> {
    @Override
    public FragmentSubjectImpl getSubject(FailureStrategy fs, Fragment that) {
      return new FragmentSubjectImpl(fs, that);
    }
  }
}
