package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.widget.RelativeLayout;

import com.github.satoshun.truth.android.api.view.ViewSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public abstract class RelativeLayoutSubject<S extends RelativeLayoutSubject<S, T>, T extends RelativeLayout>
    extends ViewSubject<S, T> {

  public static final RelativeLayoutSubjectFactory FACTORY = new RelativeLayoutSubjectFactory();

  public RelativeLayoutSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN)
  public S isGravity(int gravity) {
    isNotNull();
    check().withFailureMessage("is gravity")
        .that(actual().getGravity())
        .isEqualTo(gravity);
    return myself();
  }

  private static class RelativeLayoutSubjectImpl extends RelativeLayoutSubject<RelativeLayoutSubjectImpl, RelativeLayout> {
    RelativeLayoutSubjectImpl(FailureStrategy failureStrategy, RelativeLayout actual) {
      super(failureStrategy, actual);
    }
  }

  private static class RelativeLayoutSubjectFactory extends SubjectFactory<RelativeLayoutSubjectImpl, RelativeLayout> {
    @Override
    public RelativeLayoutSubjectImpl getSubject(FailureStrategy fs, RelativeLayout that) {
      return new RelativeLayoutSubjectImpl(fs, that);
    }
  }
}
