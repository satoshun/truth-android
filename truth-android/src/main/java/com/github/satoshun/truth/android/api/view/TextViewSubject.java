package com.github.satoshun.truth.android.api.view;

import android.widget.TextView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class TextViewSubject extends ViewSubject<TextViewSubject, TextView> {

  public static final TextViewSubjectFactory FACTORY = new TextViewSubjectFactory();

  TextViewSubject(FailureStrategy failureStrategy, TextView actual) {
    super(failureStrategy, actual);
  }


  private static class TextViewSubjectFactory extends SubjectFactory<TextViewSubject, TextView> {
    @Override
    public TextViewSubject getSubject(FailureStrategy fs, TextView that) {
      return new TextViewSubject(fs, that);
    }
  }
}
