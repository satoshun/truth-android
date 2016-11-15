package com.github.satoshun.truth.android.api.view;

import android.widget.TextView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for TextView subject
 */
public abstract class TextViewSubject<S extends TextViewSubject<S, T>, T extends TextView> extends ViewSubject<S, T> {

  public static final TextViewSubjectFactory FACTORY = new TextViewSubjectFactory();

  TextViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S sameAsText(CharSequence text) {
    isNotNull();
    if (!actual().getText().equals(text)) {
      fail("is text", actual().isClickable());
    }
    return myself();
  }

  public S isEmpty() {
    isNotNull();
    if (!actual().getText().equals("")) {
      fail("is empty");
    }
    return myself();
  }

  public S isNotEmpty() {
    isNotNull();
    if (actual().getText().equals("")) {
      fail("is not empty", actual().isClickable());
    }
    return myself();
  }

  private static class TextViewSubjectImpl extends TextViewSubject<TextViewSubjectImpl, TextView> {
    TextViewSubjectImpl(FailureStrategy failureStrategy, TextView actual) {
      super(failureStrategy, actual);
    }
  }

  private static class TextViewSubjectFactory extends SubjectFactory<TextViewSubjectImpl, TextView> {
    @Override
    public TextViewSubjectImpl getSubject(FailureStrategy fs, TextView that) {
      return new TextViewSubjectImpl(fs, that);
    }
  }
}
