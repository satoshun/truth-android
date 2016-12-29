package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.TextureView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;

@TargetApi(ICE_CREAM_SANDWICH)
public class TextureViewSubject extends BaseSubject<TextureViewSubject, TextureView> {

  public static final TextureViewSubjectFactory FACTORY = new TextureViewSubjectFactory();

  public TextureViewSubject(FailureStrategy failureStrategy, TextureView actual) {
    super(failureStrategy, actual);
  }

  public TextureViewSubject isAvailable() {
    isNotNull();
    check().withFailureMessage("is available")
        .that(actual().isAvailable())
        .isTrue();
    return this;
  }

  public TextureViewSubject isNotAvailable() {
    isNotNull();
    check().withFailureMessage("is not available")
        .that(actual().isAvailable())
        .isFalse();
    return this;
  }

  private static class TextureViewSubjectFactory extends SubjectFactory<TextureViewSubject, TextureView> {
    @Override
    public TextureViewSubject getSubject(FailureStrategy fs, TextureView that) {
      return new TextureViewSubject(fs, that);
    }
  }
}
