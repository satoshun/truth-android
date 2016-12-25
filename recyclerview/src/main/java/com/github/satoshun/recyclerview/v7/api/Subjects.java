package com.github.satoshun.recyclerview.v7.api;

import android.support.v7.widget.RecyclerView;

import com.github.satoshun.recyclerview.v7.api.widget.RecyclerViewAdapterSubject;
import com.github.satoshun.recyclerview.v7.api.widget.RecyclerViewItemAnimatorSubject;
import com.github.satoshun.recyclerview.v7.api.widget.RecyclerViewLayoutManagerSubject;
import com.github.satoshun.recyclerview.v7.api.widget.RecyclerViewLayoutSubject;
import com.github.satoshun.recyclerview.v7.api.widget.RecyclerViewSmoothScrollerActionSubject;
import com.github.satoshun.recyclerview.v7.api.widget.RecyclerViewSubject;
import com.github.satoshun.recyclerview.v7.api.widget.RecyclerViewViewHolderSubject;
import com.google.common.truth.Truth;

public final class Subjects {

  public static RecyclerViewSubject assertThat(RecyclerView target) {
    return Truth.assertAbout(RecyclerViewSubject.FACTORY).that(target);
  }

  public static <VH extends RecyclerView.ViewHolder> RecyclerViewAdapterSubject<VH> assertThat(RecyclerView.Adapter<VH> target) {
    return (RecyclerViewAdapterSubject<VH>) Truth.assertAbout(RecyclerViewAdapterSubject.FACTORY).that(target);
  }

  public static RecyclerViewViewHolderSubject assertThat(RecyclerView.ViewHolder target) {
    return Truth.assertAbout(RecyclerViewViewHolderSubject.FACTORY).that(target);
  }

  public static RecyclerViewLayoutSubject assertThat(RecyclerView.LayoutParams target) {
    return Truth.assertAbout(RecyclerViewLayoutSubject.FACTORY).that(target);
  }

  public static RecyclerViewLayoutManagerSubject assertThat(RecyclerView.LayoutManager target) {
    return Truth.assertAbout(RecyclerViewLayoutManagerSubject.FACTORY).that(target);
  }

  public static RecyclerViewItemAnimatorSubject assertThat(RecyclerView.ItemAnimator target) {
    return Truth.assertAbout(RecyclerViewItemAnimatorSubject.FACTORY).that(target);
  }

  public static RecyclerViewSmoothScrollerActionSubject assertThat(RecyclerView.SmoothScroller.Action target) {
    return Truth.assertAbout(RecyclerViewSmoothScrollerActionSubject.FACTORY).that(target);
  }
}
