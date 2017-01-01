package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.FragmentManager;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class FragmentManagerSubject extends BaseSubject<FragmentManagerSubject, FragmentManager> {

  public static final FragmentManagerSubjectFactory FACTORY = new FragmentManagerSubjectFactory();

  public FragmentManagerSubject(FailureStrategy failureStrategy, FragmentManager actual) {
    super(failureStrategy, actual);
  }

  public FragmentManagerSubject hasFragmentWithId(int id) {
    isNotNull();
    check().withFailureMessage("has fragment with id")
        .that(actual().findFragmentById(id))
        .isNotNull();
    return this;
  }

  public FragmentManagerSubject doesNotHaveFragmentWithId(int id) {
    isNotNull();
    check().withFailureMessage("does not have fragment with id")
        .that(actual().findFragmentById(id))
        .isNull();
    return this;
  }

  public FragmentManagerSubject hasFragmentWithTag(String tag) {
    isNotNull();
    check().withFailureMessage("has fragment with tag")
        .that(actual().findFragmentByTag(tag))
        .isNotNull();
    return this;
  }

  public FragmentManagerSubject doesNotHaveFragmentWithTag(String tag) {
    isNotNull();
    check().withFailureMessage("does not have fragment with tag")
        .that(actual().findFragmentByTag(tag))
        .isNull();
    return this;
  }

  public FragmentManagerSubject isBackStackEntryCount(int count) {
    isNotNull();
    check().withFailureMessage("is back stack entry count")
        .that(actual().getBackStackEntryCount())
        .isEqualTo(count);
    return this;
  }

  private static class FragmentManagerSubjectFactory extends SubjectFactory<FragmentManagerSubject, FragmentManager> {
    @Override
    public FragmentManagerSubject getSubject(FailureStrategy fs, FragmentManager that) {
      return new FragmentManagerSubject(fs, that);
    }
  }
}
