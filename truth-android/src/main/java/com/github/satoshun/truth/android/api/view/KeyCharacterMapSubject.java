package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.KeyCharacterMap;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

public class KeyCharacterMapSubject extends BaseSubject<KeyCharacterMapSubject, KeyCharacterMap> {

  public static final KeyCharacterMapSubjectFactory FACTORY = new KeyCharacterMapSubjectFactory();

  public KeyCharacterMapSubject(FailureStrategy failureStrategy, KeyCharacterMap actual) {
    super(failureStrategy, actual);
  }

  public KeyCharacterMapSubject isKeyboardType(int type) {
    isNotNull();
    check().withFailureMessage("is keyboard type")
        .that(actual().getKeyboardType())
        .isEqualTo(type);
    return this;
  }

  @TargetApi(HONEYCOMB)
  public KeyCharacterMapSubject isModifierBehavior(int value) {
    isNotNull();
    check().withFailureMessage("is modifier behavior")
        .that(actual().getModifierBehavior())
        .isEqualTo(value);
    return this;
  }


  private static class KeyCharacterMapSubjectFactory extends SubjectFactory<KeyCharacterMapSubject, KeyCharacterMap> {
    @Override
    public KeyCharacterMapSubject getSubject(FailureStrategy fs, KeyCharacterMap that) {
      return new KeyCharacterMapSubject(fs, that);
    }
  }
}
