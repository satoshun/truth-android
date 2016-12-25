package com.github.satoshun.recyclerview.v7.api.widget;

import android.support.v7.widget.RecyclerView;

import com.github.satoshun.truth.android.api.view.ViewGroupSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class RecyclerViewSubject<S extends RecyclerViewSubject<S, T>, T extends RecyclerView>
    extends ViewGroupSubject<S, T> {

  public static final RecyclerViewSubjectFactory FACTORY = new RecyclerViewSubjectFactory();

  public RecyclerViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public <VH extends RecyclerView.ViewHolder> S isAdapter(RecyclerView.Adapter<VH> adapter) {
    isNotNull();
    check().withFailureMessage("is adapter")
        .that(adapter)
        .isEqualTo(actual().getAdapter());
    return myself();
  }

  public S isItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
    isNotNull();
    check().withFailureMessage("is item animator")
        .that(itemAnimator)
        .isEqualTo(actual().getItemAnimator());
    return myself();
  }

  public S isLayoutManager(RecyclerView.LayoutManager layoutManager) {
    isNotNull();
    check().withFailureMessage("is layout manager")
        .that(layoutManager)
        .isEqualTo(actual().getLayoutManager());
    return myself();
  }

  public S isRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
    isNotNull();
    check().withFailureMessage("is recycled view pool")
        .that(recycledViewPool)
        .isEqualTo(actual().getRecycledViewPool());
    return myself();
  }

  public S isScrollState(int scrollState) {
    isNotNull();
    check().withFailureMessage("is scroll state")
        .that(scrollState)
        .isEqualTo(actual().getScrollState());
    return myself();
  }

  public S hasFixedSize() {
    isNotNull();
    check().withFailureMessage("has fixed size")
        .that(actual().hasFixedSize())
        .isTrue();
    return myself();
  }

  public S doesNotHaveFixedSize() {
    isNotNull();
    check().withFailureMessage("does not have fixed size")
        .that(actual().hasFixedSize())
        .isFalse();
    return myself();
  }

    private static class RecyclerViewSubjectImpl extends RecyclerViewSubject<RecyclerViewSubjectImpl, RecyclerView> {
      RecyclerViewSubjectImpl(FailureStrategy failureStrategy, RecyclerView actual) {
        super(failureStrategy, actual);
      }
    }

    private static class RecyclerViewSubjectFactory extends SubjectFactory<RecyclerViewSubjectImpl, RecyclerView> {
      @Override
      public RecyclerViewSubjectImpl getSubject(FailureStrategy fs, RecyclerView that) {
        return new RecyclerViewSubjectImpl(fs, that);
      }
    }
}
