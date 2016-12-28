package com.github.satoshun.truth.android.api.widget;

import android.widget.EditText;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;


public class EditTextSubject<S extends TextViewSubject<S, T>, T extends EditText> extends TextViewSubject<S, T> {

  public static final EditTextSubjectFactory FACTORY = new EditTextSubjectFactory();

  EditTextSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  private static class EditTextSubjectImpl extends EditTextSubject<EditTextSubjectImpl, EditText> {
    EditTextSubjectImpl(FailureStrategy failureStrategy, EditText actual) {
      super(failureStrategy, actual);
    }
  }

  private static class EditTextSubjectFactory extends SubjectFactory<EditTextSubjectImpl, EditText> {
    @Override
    public EditTextSubjectImpl getSubject(FailureStrategy fs, EditText that) {
      return new EditTextSubjectImpl(fs, that);
    }
  }
}
