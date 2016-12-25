package com.github.satoshun.recyclerview.v7.api.widget;

import android.support.v7.widget.RecyclerView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class RecyclerViewAdapterSubject<VH extends RecyclerView.ViewHolder> extends BaseSubject<RecyclerViewAdapterSubject<VH>, RecyclerView.Adapter<VH>> {

  public static final RecyclerViewAdapterSubjectFactory FACTORY = new RecyclerViewAdapterSubjectFactory();

  public RecyclerViewAdapterSubject(FailureStrategy failureStrategy, RecyclerView.Adapter<VH> actual) {
    super(failureStrategy, actual);
  }

  public RecyclerViewAdapterSubject isItemCount(int count) {
    isNotNull();
    check().withFailureMessage("is item count")
        .that(count)
        .isEqualTo(actual().getItemCount());
    return myself();
  }

  public RecyclerViewAdapterSubject hasStableIds() {
    isNotNull();
    check().withFailureMessage("has stable ids")
        .that(actual().hasStableIds())
        .isTrue();
    return myself();
  }

  public RecyclerViewAdapterSubject doesNotHaveStableIds() {
    isNotNull();
    check().withFailureMessage("does not have stable ids")
        .that(actual().hasStableIds())
        .isFalse();
    return myself();
  }

  public RecyclerViewAdapterSubject hasObservers() {
    isNotNull();
    check().withFailureMessage("has observers")
        .that(actual().hasObservers())
        .isTrue();
    return myself();
  }

  public RecyclerViewAdapterSubject doesNotHaveObservers() {
    isNotNull();
    check().withFailureMessage("does not have observers")
        .that(actual().hasObservers())
        .isFalse();
    return myself();
  }

  private static class RecyclerViewAdapterSubjectFactory<VH extends RecyclerView.ViewHolder> extends SubjectFactory<RecyclerViewAdapterSubject<VH>, RecyclerView.Adapter<VH>> {
    @Override
    public RecyclerViewAdapterSubject<VH> getSubject(FailureStrategy fs, RecyclerView.Adapter<VH> that) {
      return new RecyclerViewAdapterSubject<>(fs, that);
    }
  }
}
