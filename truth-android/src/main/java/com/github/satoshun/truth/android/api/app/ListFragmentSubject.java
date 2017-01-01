package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.ListFragment;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class ListFragmentSubject extends FragmentSubject<ListFragmentSubject, ListFragment> {

  public static final ListFragmentSubjectFactory FACTORY = new ListFragmentSubjectFactory();

  public ListFragmentSubject(FailureStrategy failureStrategy, ListFragment actual) {
    super(failureStrategy, actual);
  }

  public ListFragmentSubject isSelectedItemId(long id) {
    isNotNull();
    check().withFailureMessage("is selected item id")
        .that(actual().getSelectedItemId())
        .isEqualTo(id);
    return this;
  }

  public ListFragmentSubject isSelectedItemPosition(int position) {
    isNotNull();
    check().withFailureMessage("is selected item position")
        .that(actual().getSelectedItemPosition())
        .isEqualTo(position);
    return this;
  }

  private static class ListFragmentSubjectFactory extends SubjectFactory<ListFragmentSubject, ListFragment> {
    @Override
    public ListFragmentSubject getSubject(FailureStrategy fs, ListFragment that) {
      return new ListFragmentSubject(fs, that);
    }
  }
}
