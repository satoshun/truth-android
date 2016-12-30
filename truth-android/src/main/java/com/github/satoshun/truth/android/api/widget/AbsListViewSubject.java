package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.widget.AbsListView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.Arrays;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.KITKAT;

/**
 * Propositions for AbsListView subject
 */
public abstract class AbsListViewSubject<S extends AbsListViewSubject<S, T>, T extends AbsListView>
    extends AdapterViewSubject<S, T> {

  public static final AbsListViewSubjectFactory FACTORY = new AbsListViewSubjectFactory();

  AbsListViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB)
  public S isCheckedItemsCount(int count) {
    isNotNull();
    check().withFailureMessage("is checked items count")
        .that(actual().getCheckedItemCount())
        .isEqualTo(count);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S containsItemIds(long... itemIds) {
    isNotNull();
    check().withFailureMessage("contains item ids")
        .that(actual().getCheckedItemIds())
        .isIn(Arrays.asList(itemIds));
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isCheckedItemPosition(int position) {
    isNotNull();
    check().withFailureMessage("is checked item position")
        .that(actual().getCheckedItemPosition())
        .isEqualTo(position);
    return myself();
  }

  @TargetApi(KITKAT)
  public S canScrollList(int direction) {
    isNotNull();
    check().withFailureMessage("can scroll list")
        .that(actual().canScrollList(direction))
        .isTrue();
    return myself();
  }

  private static class AbsListViewSubjectImpl extends AbsListViewSubject<AbsListViewSubjectImpl, AbsListView> {
    AbsListViewSubjectImpl(FailureStrategy failureStrategy, AbsListView actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AbsListViewSubjectFactory extends SubjectFactory<AbsListViewSubjectImpl, AbsListView> {
    @Override
    public AbsListViewSubjectImpl getSubject(FailureStrategy fs, AbsListView that) {
      return new AbsListViewSubjectImpl(fs, that);
    }
  }
}
