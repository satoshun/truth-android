package com.github.satoshun.truth.android.api;

import android.view.View;
import android.widget.TextView;

import com.github.satoshun.truth.android.api.view.TextViewSubject;
import com.github.satoshun.truth.android.api.view.ViewSubject;
import com.google.common.truth.AbstractVerb;
import com.google.common.truth.Truth;

public class TruthAndroid {
  public static ViewSubject assertThat(View target) {
    return Truth.assertAbout(ViewSubject.FACTORY).that(target);
  }

  public static TextViewSubject assertThat(TextView target) {
    return Truth.assertAbout(TextViewSubject.FACTORY).that(target);
  }
}
