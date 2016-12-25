package com.github.satoshun.recyclerview.v7.api.widget;

import android.support.v7.widget.RecyclerView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class RecyclerViewAdapterSubject<VH extends RecyclerView.ViewHolder, S extends RecyclerViewAdapterSubject<VH, S, T>, T extends RecyclerView.Adapter<VH>>
    extends BaseSubject<S, T> {

  public static final RecyclerViewAdapterSubjectFactory FACTORY = new RecyclerViewAdapterSubjectFactory();

  public RecyclerViewAdapterSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isItemCount(int count) {
    isNotNull();
    check().withFailureMessage("is item count")
        .that(count)
        .isEqualTo(actual().getItemCount());
    return myself();
  }

  public S hasStableIds() {
    isNotNull();
    check().withFailureMessage("has stable ids")
        .that(actual().hasStableIds())
        .isTrue();
    return myself();
  }

  public S doesNotHaveStableIds() {
    isNotNull();
    check().withFailureMessage("does not have stable ids")
        .that(actual().hasStableIds())
        .isFalse();
    return myself();
  }

  public S hasObservers() {
    isNotNull();
    check().withFailureMessage("has observers")
        .that(actual().hasObservers())
        .isTrue();
    return myself();
  }

  public S doesNotHaveObservers() {
    isNotNull();
    check().withFailureMessage("does not have observers")
        .that(actual().hasObservers())
        .isFalse();
    return myself();
  }

  private static class RecyclerViewAdapterSubjectImpl<VH extends RecyclerView.ViewHolder>  extends RecyclerViewAdapterSubject<VH, RecyclerViewAdapterSubjectImpl<VH>, RecyclerView.Adapter<VH>> {
    public RecyclerViewAdapterSubjectImpl(FailureStrategy failureStrategy, RecyclerView.Adapter<VH> actual) {
      super(failureStrategy, actual);
    }
  }

  private static class RecyclerViewAdapterSubjectFactory<VH extends RecyclerView.ViewHolder> extends SubjectFactory<RecyclerViewAdapterSubjectImpl<VH>, RecyclerView.Adapter<VH>> {
    @Override
    public RecyclerViewAdapterSubjectImpl<VH> getSubject(FailureStrategy fs, RecyclerView.Adapter<VH> that) {
      return new RecyclerViewAdapterSubjectImpl<>(fs, that);
    }
  }
}
