package com.github.satoshun.truth.android.api.widget;

import android.widget.TextView;

import com.github.satoshun.truth.android.api.view.ViewSubject;
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

  public S isText(CharSequence text) {
    isNotNull();
    check().withFailureMessage("is text")
        .that(actual().getText())
        .isEqualTo(text);
    return myself();
  }

  public S isEmpty() {
    isNotNull();
    check().withFailureMessage("is empty")
        .that(actual().getText())
        .isEqualTo("");
    return myself();
  }

  public S isNotEmpty() {
    isNotNull();
    check().withFailureMessage("is not empty")
        .that(actual().getText())
        .isNotEqualTo("");
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
