package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.AbsSeekBar;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public abstract class AbsSeekBarSubject<S extends AbsSeekBarSubject<S, T>, T extends AbsSeekBar>
    extends ProgressBarSubject<S, T> {

  public static final AbsSeekBarSubjectFactory FACTORY = new AbsSeekBarSubjectFactory();

  public AbsSeekBarSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isKeyProgressIncrement(int increment) {
    isNotNull();
    check().withFailureMessage("is key progress increment")
        .that(actual().getKeyProgressIncrement())
        .isEqualTo(increment);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isThumb(Drawable drawable) {
    isNotNull();
    check().withFailureMessage("is thumb")
        .that(actual().getThumb())
        .isSameAs(drawable);
    return myself();
  }

  public S isThumbOffset(int offset) {
    isNotNull();
    check().withFailureMessage("is thumb offset")
        .that(actual().getThumbOffset())
        .isEqualTo(offset);
    return myself();
  }

  private static class AbsSeekBarSubjectImpl extends AbsSeekBarSubject<AbsSeekBarSubjectImpl, AbsSeekBar> {
    AbsSeekBarSubjectImpl(FailureStrategy failureStrategy, AbsSeekBar actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AbsSeekBarSubjectFactory extends SubjectFactory<AbsSeekBarSubjectImpl, AbsSeekBar> {
    @Override
    public AbsSeekBarSubjectImpl getSubject(FailureStrategy fs, AbsSeekBar that) {
      return new AbsSeekBarSubjectImpl(fs, that);
    }
  }
}
