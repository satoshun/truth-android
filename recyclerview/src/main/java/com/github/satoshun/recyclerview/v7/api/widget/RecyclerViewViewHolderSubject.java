package com.github.satoshun.recyclerview.v7.api.widget;

import android.support.v7.widget.RecyclerView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class RecyclerViewViewHolderSubject extends BaseSubject<RecyclerViewViewHolderSubject, RecyclerView.ViewHolder> {

  public static final RecyclerViewViewHolderSubjectFactory FACTORY = new RecyclerViewViewHolderSubjectFactory();

  public RecyclerViewViewHolderSubject(FailureStrategy failureStrategy, RecyclerView.ViewHolder actual) {
    super(failureStrategy, actual);
  }

  public RecyclerViewViewHolderSubject isPosition(int position) {
    isNotNull();
    check().withFailureMessage("is position")
        .that(position)
        .isEqualTo(actual().getPosition());
    return myself();
  }

  public RecyclerViewViewHolderSubject isItemId(long itemId) {
    isNotNull();
    check().withFailureMessage("is item id")
        .that(itemId)
        .isEqualTo(actual().getItemId());
    return myself();
  }

  public RecyclerViewViewHolderSubject isItemViewType(int itemViewType) {
    isNotNull();
    check().withFailureMessage("is item view type")
        .that(itemViewType)
        .isEqualTo(actual().getItemViewType());
    return myself();
  }

  public RecyclerViewViewHolderSubject isRecyclable() {
    isNotNull();
    check().withFailureMessage("is recyclable")
        .that(actual().isRecyclable())
        .isTrue();
    return myself();
  }

  public RecyclerViewViewHolderSubject isNotRecyclable() {
    isNotNull();
    check().withFailureMessage("is not recyclable")
        .that(actual().isRecyclable())
        .isFalse();
    return myself();
  }

  private static class RecyclerViewViewHolderSubjectFactory extends SubjectFactory<RecyclerViewViewHolderSubject, RecyclerView.ViewHolder> {
    @Override
    public RecyclerViewViewHolderSubject getSubject(FailureStrategy fs, RecyclerView.ViewHolder that) {
      return new RecyclerViewViewHolderSubject(fs, that);
    }
  }
}
