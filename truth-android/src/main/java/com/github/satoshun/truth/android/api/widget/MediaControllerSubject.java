package com.github.satoshun.truth.android.api.widget;

import android.widget.MediaController;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class MediaControllerSubject extends FrameLayoutSubject<MediaControllerSubject, MediaController> {

  public static final MediaControllerSubjectFactory FACTORY = new MediaControllerSubjectFactory();

  public MediaControllerSubject(FailureStrategy failureStrategy, MediaController actual) {
    super(failureStrategy, actual);
  }

  public MediaControllerSubject isShowing() {
    isNotNull();
    check().withFailureMessage("is showing")
        .that(actual().isShowing())
        .isTrue();
    return this;
  }

  public MediaControllerSubject isNotShowing() {
    isNotNull();
    check().withFailureMessage("is not showing")
        .that(actual().isShowing())
        .isFalse();
    return this;
  }

  private static class MediaControllerSubjectFactory extends SubjectFactory<MediaControllerSubject, MediaController> {
    @Override
    public MediaControllerSubject getSubject(FailureStrategy fs, MediaController that) {
      return new MediaControllerSubject(fs, that);
    }
  }
}
