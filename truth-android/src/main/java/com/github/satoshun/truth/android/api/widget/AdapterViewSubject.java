package com.github.satoshun.truth.android.api.widget;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.github.satoshun.truth.android.api.view.ViewGroupSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for AdapterView subject
 */
public abstract class AdapterViewSubject<S extends ViewGroupSubject<S, T>, T extends AdapterView>
    extends ViewGroupSubject<S, T> {

  public static final AdapterViewSubjectFactory FACTORY = new AdapterViewSubjectFactory();

  AdapterViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isAdapter(Adapter adapter) {
    isNotNull();
    check().withFailureMessage("is adapter")
        .that(actual().getAdapter())
        .isSameAs(adapter);
    return myself();
  }

  public S isCount(int count) {
    isNotNull();
    check().withFailureMessage("is count")
        .that(actual().getCount())
        .isEqualTo(count);
    return myself();
  }

  public S isFirstVisiblePosition(int position) {
    isNotNull();
    check().withFailureMessage("is first visible position")
        .that(actual().getFirstVisiblePosition())
        .isEqualTo(position);
    return myself();
  }

  public S isItemAtPosition(int position, Object item) {
    isNotNull();
    check().withFailureMessage("is item at position")
        .that(actual().getItemAtPosition(position))
        .isEqualTo(item);
    return myself();
  }

  public S isItemIdAtPosition(int position, long id) {
    isNotNull();
    check().withFailureMessage("is item id at position")
        .that(actual().getItemIdAtPosition(position))
        .isEqualTo(id);
    return myself();
  }

  public S isLastVisiblePosition(int position) {
    isNotNull();
    check().withFailureMessage("is last visible position")
        .that(actual().getLastVisiblePosition())
        .isEqualTo(position);
    return myself();
  }

  public S isPositionForView(View view, int position) {
    isNotNull();
    check().withFailureMessage("is position for view")
        .that(actual().getPositionForView(view))
        .isEqualTo(position);
    return myself();
  }

  public S isSelectedItem(Object item) {
    isNotNull();
    check().withFailureMessage("is selected item")
        .that(actual().getSelectedItem())
        .isEqualTo(item);
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

  public S isSelectedView(View view) {
    isNotNull();
    check().withFailureMessage("is selected view")
        .that(actual().getSelectedView())
        .isEqualTo(view);
    return myself();
  }

  private static class AdapterViewSubjectImpl extends AdapterViewSubject<AdapterViewSubjectImpl, AdapterView> {
    AdapterViewSubjectImpl(FailureStrategy failureStrategy, AdapterView actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AdapterViewSubjectFactory extends SubjectFactory<AdapterViewSubjectImpl, AdapterView> {
    @Override
    public AdapterViewSubjectImpl getSubject(FailureStrategy fs, AdapterView that) {
      return new AdapterViewSubjectImpl(fs, that);
    }
  }
}
