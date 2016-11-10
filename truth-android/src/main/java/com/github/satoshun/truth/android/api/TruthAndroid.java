package com.github.satoshun.truth.android.api;

import android.view.View;

import com.github.satoshun.truth.android.api.view.ViewSubject;
import com.google.common.truth.Truth;

public class TruthAndroid {
  public static ViewSubject assertThat(View target) {
    return Truth.assertAbout(ViewSubject.FACTORY).that(target);
  }
}
