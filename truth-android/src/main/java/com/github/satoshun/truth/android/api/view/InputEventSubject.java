package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.InputEvent;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public abstract class InputEventSubject<S extends InputEventSubject<S, T>, T extends InputEvent>
    extends BaseSubject<S, T> {

  public static final InputEventSubjectFactory FACTORY = new InputEventSubjectFactory();

  public InputEventSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isDeviceId(int id) {
    isNotNull();
    check().withFailureMessage("is device id")
        .that(actual().getDeviceId())
        .isEqualTo(id);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isEventTime(long time) {
    isNotNull();
    check().withFailureMessage("is event time")
        .that(actual().getEventTime())
        .isEqualTo(time);
    return myself();
  }

  public S isSource(int source) {
    isNotNull();
    check().withFailureMessage("is source")
        .that(actual().getSource())
        .isEqualTo(source);
    return myself();
  }

  private static class InputEventSubjectImpl extends InputEventSubject<InputEventSubjectImpl, InputEvent> {
    InputEventSubjectImpl(FailureStrategy failureStrategy, InputEvent actual) {
      super(failureStrategy, actual);
    }
  }

  private static class InputEventSubjectFactory extends SubjectFactory<InputEventSubjectImpl, InputEvent> {
    @Override
    public InputEventSubjectImpl getSubject(FailureStrategy fs, InputEvent that) {
      return new InputEventSubjectImpl(fs, that);
    }
  }
}
