package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.KeyEvent;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.GINGERBREAD;
import static android.os.Build.VERSION_CODES.HONEYCOMB;

public class KeyEventSubject extends InputEventSubject<KeyEventSubject, KeyEvent> {

  public static final KeyEventSubjectFactory FACTORY = new KeyEventSubjectFactory();

  public KeyEventSubject(FailureStrategy failureStrategy, KeyEvent actual) {
    super(failureStrategy, actual);
  }

  public KeyEventSubject isAction(int action) {
    isNotNull();
    check().withFailureMessage("is action")
        .that(actual().getAction())
        .isEqualTo(action);
    return myself();
  }

  public KeyEventSubject isDisplayLabel(char label) {
    isNotNull();
    check().withFailureMessage("is display label")
        .that(actual().getDisplayLabel())
        .isEqualTo(label);
    return myself();
  }

  public KeyEventSubject isDownTime(long time) {
    isNotNull();
    check().withFailureMessage("is down time")
        .that(actual().getDownTime())
        .isEqualTo(time);
    return myself();
  }

  public KeyEventSubject isKeyCode(int keyCode) {
    isNotNull();
    check().withFailureMessage("is key code")
        .that(actual().getKeyCode())
        .isEqualTo(keyCode);
    return myself();
  }

  public KeyEventSubject isRepeatCount(int count) {
    isNotNull();
    check().withFailureMessage("is repeat count")
        .that(actual().getRepeatCount())
        .isEqualTo(count);
    return myself();
  }

  @TargetApi(GINGERBREAD)
  public KeyEventSubject isSource(int source) {
    isNotNull();
    check().withFailureMessage("is source")
        .that(actual().getSource())
        .isEqualTo(source);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public KeyEventSubject hasModifiers(int modifiers) {
    isNotNull();
    check().withFailureMessage("has modifiers")
        .that(actual().hasModifiers(modifiers))
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public KeyEventSubject hasNoModifiers() {
    isNotNull();
    check().withFailureMessage("has no modifiers")
        .that(actual().hasNoModifiers())
        .isTrue();
    return myself();
  }

  private static class KeyEventSubjectFactory extends SubjectFactory<KeyEventSubject, KeyEvent> {
    @Override
    public KeyEventSubject getSubject(FailureStrategy fs, KeyEvent that) {
      return new KeyEventSubject(fs, that);
    }
  }
}
