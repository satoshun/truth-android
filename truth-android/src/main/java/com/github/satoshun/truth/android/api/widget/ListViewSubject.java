package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.ListView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.KITKAT;

/**
 * Propositions for ListView subject
 */
public abstract class ListViewSubject<S extends ListViewSubject<S, T>, T extends ListView>
    extends AbsListViewSubject<S, T> {

  public static final ListViewSubjectFactory FACTORY = new ListViewSubjectFactory();

  public ListViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isDivider(Drawable divider) {
    isNotNull();
    check().withFailureMessage("is divider")
        .that(actual().getDivider())
        .isSameAs(divider);
    return myself();
  }

  public S isDividerHeight(int height) {
    isNotNull();
    check().withFailureMessage("is divider height")
        .that(actual().getDividerHeight())
        .isEqualTo(height);
    return myself();
  }

  public S isFooterViewsCount(int count) {
    isNotNull();
    check().withFailureMessage("is footer views count")
        .that(actual().getFooterViewsCount())
        .isEqualTo(count);
    return myself();
  }

  public S isHeaderViewsCount(int count) {
    isNotNull();
    check().withFailureMessage("is header views count")
        .that(actual().getHeaderViewsCount())
        .isEqualTo(count);
    return myself();
  }

  public S isOverscrollFooter(Drawable footer) {
    isNotNull();
    check().withFailureMessage("is overscroll footer")
        .that(actual().getOverscrollFooter())
        .isSameAs(footer);
    return myself();
  }

  public S isOverscrollHeader(Drawable header) {
    isNotNull();
    check().withFailureMessage("is overscroll header")
        .that(actual().getOverscrollHeader())
        .isSameAs(header);
    return myself();
  }

  @TargetApi(KITKAT)
  public S isFooterDividersEnabled() {
    isNotNull();
    check().withFailureMessage("is footer dividers enabled")
        .that(actual().areFooterDividersEnabled())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isFooterDividersDisabled() {
    isNotNull();
    check().withFailureMessage("is footer dividers disabled")
        .that(actual().areFooterDividersEnabled())
        .isFalse();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isHeaderDividersEnabled() {
    isNotNull();
    check().withFailureMessage("is header dividers enabled")
        .that(actual().areHeaderDividersEnabled())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isHeaderDividersDisabled() {
    isNotNull();
    check().withFailureMessage("is header dividers disabled")
        .that(actual().areHeaderDividersEnabled())
        .isFalse();
    return myself();
  }

  private static class ListViewSubjectImpl extends ListViewSubject<ListViewSubjectImpl, ListView> {
    ListViewSubjectImpl(FailureStrategy failureStrategy, ListView actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ListViewSubjectFactory extends SubjectFactory<ListViewSubjectImpl, ListView> {
    @Override
    public ListViewSubjectImpl getSubject(FailureStrategy fs, ListView that) {
      return new ListViewSubjectImpl(fs, that);
    }
  }
}
