package com.github.satoshun.truth.android.api.widget;


import android.widget.Filter;
import android.widget.HeaderViewListAdapter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class HeaderViewListAdapterSubject extends WrapperListAdapterSubject<HeaderViewListAdapterSubject, HeaderViewListAdapter> {

  public static final HeaderViewListAdapterSubjectFactory FACTORY = new HeaderViewListAdapterSubjectFactory();

  public HeaderViewListAdapterSubject(FailureStrategy failureStrategy, HeaderViewListAdapter actual) {
    super(failureStrategy, actual);
  }

  public HeaderViewListAdapterSubject isFootersCount(int count) {
    isNotNull();
    check().withFailureMessage("is footers count")
        .that(actual().getFootersCount())
        .isEqualTo(count);
    return this;
  }

  public HeaderViewListAdapterSubject isHeadersCount(int count) {
    isNotNull();
    check().withFailureMessage("is headers count")
        .that(actual().getHeadersCount())
        .isEqualTo(count);
    return this;
  }

  public HeaderViewListAdapterSubject isFilter(Filter filter) {
    isNotNull();
    check().withFailureMessage("is filter")
        .that(actual().getFilter())
        .isSameAs(filter);
    return this;
  }

  private static class HeaderViewListAdapterSubjectFactory extends SubjectFactory<HeaderViewListAdapterSubject, HeaderViewListAdapter> {
    @Override
    public HeaderViewListAdapterSubject getSubject(FailureStrategy fs, HeaderViewListAdapter that) {
      return new HeaderViewListAdapterSubject(fs, that);
    }
  }
}
