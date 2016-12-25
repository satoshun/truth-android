package com.github.satoshun.recyclerview.v7.api;

import android.support.v7.widget.RecyclerView;

import com.github.satoshun.recyclerview.v7.api.widget.RecyclerViewAdapterSubject;
import com.github.satoshun.recyclerview.v7.api.widget.RecyclerViewSubject;
import com.google.common.truth.Truth;

public final class Subjects {

  public static RecyclerViewSubject assertThat(RecyclerView target) {
    return Truth.assertAbout(RecyclerViewSubject.FACTORY).that(target);
  }

  public static <VH extends RecyclerView.ViewHolder> RecyclerViewAdapterSubject assertThat(RecyclerView.Adapter<VH> target) {
    return (RecyclerViewAdapterSubject) Truth.assertAbout(RecyclerViewAdapterSubject.FACTORY).that(target);
  }
}
