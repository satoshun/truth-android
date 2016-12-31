package com.github.satoshun.truth.android.api.widget;

import android.view.View;
import android.widget.ViewAnimator;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class ViewAnimatorSubject<S extends ViewAnimatorSubject<S, T>, T extends ViewAnimator>
    extends FrameLayoutSubject<S, T> {

  public static final ViewAnimatorSubjectFactory FACTORY = new ViewAnimatorSubjectFactory();

  public ViewAnimatorSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isDisplayedChild(View view) {
    isNotNull();
    check().withFailureMessage("is displayed child")
        .that(getDisplayedView())
        .isSameAs(view);
    return myself();
  }

  public S hasDisplayedChildId(int id) {
    isNotNull();
    check().withFailureMessage("has displayed child id")
        .that(getDisplayedView().getId())
        .isEqualTo(id);
    return myself();
  }

  public S hasDisplayedChild(int index) {
    isNotNull();
    check().withFailureMessage("has displayed child")
        .that(actual().getDisplayedChild())
        .isEqualTo(index);
    return myself();
  }

  private View getDisplayedView() {
    return actual().getChildAt(actual().getDisplayedChild());
  }

  private static class ViewAnimatorSubjectImpl extends ViewAnimatorSubject<ViewAnimatorSubjectImpl, ViewAnimator> {
    ViewAnimatorSubjectImpl(FailureStrategy failureStrategy, ViewAnimator actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ViewAnimatorSubjectFactory extends SubjectFactory<ViewAnimatorSubjectImpl, ViewAnimator> {
    @Override
    public ViewAnimatorSubjectImpl getSubject(FailureStrategy fs, ViewAnimator that) {
      return new ViewAnimatorSubjectImpl(fs, that);
    }
  }
}
