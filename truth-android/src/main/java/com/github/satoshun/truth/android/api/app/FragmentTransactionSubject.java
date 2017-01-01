package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.FragmentTransaction;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class FragmentTransactionSubject extends BaseSubject<FragmentTransactionSubject, FragmentTransaction> {

  public static final FragmentTransactionSubjectFactory FACTORY = new FragmentTransactionSubjectFactory();

  public FragmentTransactionSubject(FailureStrategy failureStrategy, FragmentTransaction actual) {
    super(failureStrategy, actual);
  }

  public FragmentTransactionSubject isAddToBackStackAllowed() {
    isNotNull();
    check().withFailureMessage("is add to back stack allowed")
        .that(actual().isAddToBackStackAllowed())
        .isTrue();
    return this;
  }

  public FragmentTransactionSubject isAddToBackStackDisallowed() {
    isNotNull();
    check().withFailureMessage("is add to back stack disallowed")
        .that(actual().isAddToBackStackAllowed())
        .isFalse();
    return this;
  }

  public FragmentTransactionSubject isEmpty() {
    isNotNull();
    check().withFailureMessage("is empty")
        .that(actual().isEmpty())
        .isTrue();
    return this;
  }

  public FragmentTransactionSubject isNotEmpty() {
    isNotNull();
    check().withFailureMessage("is not empty")
        .that(actual().isEmpty())
        .isFalse();
    return this;
  }

  private static class FragmentTransactionSubjectFactory extends SubjectFactory<FragmentTransactionSubject, FragmentTransaction> {
    @Override
    public FragmentTransactionSubject getSubject(FailureStrategy fs, FragmentTransaction that) {
      return new FragmentTransactionSubject(fs, that);
    }
  }
}
