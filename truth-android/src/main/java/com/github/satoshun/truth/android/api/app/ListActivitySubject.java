package com.github.satoshun.truth.android.api.app;


import android.app.ListActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class ListActivitySubject<S extends ListActivitySubject<S, T>, T extends ListActivity>
    extends ActivitySubject<S, T> {

  public static final ListActivitySubjectFactory FACTORY = new ListActivitySubjectFactory();

  public ListActivitySubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isListAdapter(ListAdapter adapter) {
    isNotNull();
    check().withFailureMessage("is list adapter")
        .that(actual().getListAdapter())
        .isSameAs(adapter);
    return myself();
  }

  public S isListView(ListView listView) {
    isNotNull();
    check().withFailureMessage("is list view")
        .that(actual().getListView())
        .isSameAs(listView);
    return myself();
  }

  public S isSelectedItemId(long id) {
    isNotNull();
    check().withFailureMessage("is selected item id")
        .that(actual().getSelectedItemId())
        .isEqualTo(id);
    return myself();
  }

  public S isSelectedItemPosition(int position) {
    isNotNull();
    check().withFailureMessage("is selected item position")
        .that(actual().getSelectedItemPosition())
        .isEqualTo(position);
    return myself();
  }

  private static class ListActivitySubjectImpl extends ListActivitySubject<ListActivitySubjectImpl, ListActivity> {
    ListActivitySubjectImpl(FailureStrategy failureStrategy, ListActivity actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ListActivitySubjectFactory extends SubjectFactory<ListActivitySubjectImpl, ListActivity> {
    @Override
    public ListActivitySubjectImpl getSubject(FailureStrategy fs, ListActivity that) {
      return new ListActivitySubjectImpl(fs, that);
    }
  }
}
