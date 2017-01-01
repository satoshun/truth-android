package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.DialogFragment;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class DialogFragmentSubject extends FragmentSubject<DialogFragmentSubject, DialogFragment> {

  public static final DialogFragmentSubjectFactory FACTORY = new DialogFragmentSubjectFactory();

  public DialogFragmentSubject(FailureStrategy failureStrategy, DialogFragment actual) {
    super(failureStrategy, actual);
  }

  public DialogFragmentSubject isCancelable() {
    isNotNull();
    check().withFailureMessage("is cancelable")
        .that(actual().isCancelable())
        .isTrue();
    return this;
  }

  public DialogFragmentSubject isNotCancelable() {
    isNotNull();
    check().withFailureMessage("is not cancelable")
        .that(actual().isCancelable())
        .isFalse();
    return this;
  }

  private static class DialogFragmentSubjectFactory extends SubjectFactory<DialogFragmentSubject, DialogFragment> {
    @Override
    public DialogFragmentSubject getSubject(FailureStrategy fs, DialogFragment that) {
      return new DialogFragmentSubject(fs, that);
    }
  }
}
