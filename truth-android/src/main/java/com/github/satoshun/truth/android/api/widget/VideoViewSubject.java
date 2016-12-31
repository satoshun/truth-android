package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.widget.VideoView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

public class VideoViewSubject extends BaseSubject<VideoViewSubject, VideoView> {

  public static final VideoViewSubjectFactory FACTORY = new VideoViewSubjectFactory();

  public VideoViewSubject(FailureStrategy failureStrategy, VideoView actual) {
    super(failureStrategy, actual);
  }

  public VideoViewSubject isPausable() {
    isNotNull();
    check().withFailureMessage("is pausable")
        .that(actual().canPause())
        .isTrue();
    return this;
  }

  public VideoViewSubject isNotPausable() {
    isNotNull();
    check().withFailureMessage("is not pausable")
        .that(actual().canPause())
        .isFalse();
    return this;
  }

  public VideoViewSubject isSeekableBackward() {
    isNotNull();
    check().withFailureMessage("is seekable backward")
        .that(actual().canSeekBackward())
        .isTrue();
    return this;
  }

  public VideoViewSubject isNotSeekableBackward() {
    isNotNull();
    check().withFailureMessage("is not seekable backward")
        .that(actual().canSeekBackward())
        .isFalse();
    return this;
  }

  public VideoViewSubject isSeekableForward() {
    isNotNull();
    check().withFailureMessage("is seekable forward")
        .that(actual().canSeekForward())
        .isTrue();
    return this;
  }

  public VideoViewSubject isNotSeekableForward() {
    isNotNull();
    check().withFailureMessage("is not seekable forward")
        .that(actual().canSeekForward())
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public VideoViewSubject isAudioSessionId(int id) {
    isNotNull();
    check().withFailureMessage("is audio session id")
        .that(actual().getAudioSessionId())
        .isEqualTo(id);
    return this;
  }

  public VideoViewSubject isBufferPercentage(int percentage) {
    isNotNull();
    check().withFailureMessage("is buffer percentage")
        .that(actual().getBufferPercentage())
        .isEqualTo(percentage);
    return this;
  }

  public VideoViewSubject isCurrentPosition(int position) {
    isNotNull();
    check().withFailureMessage("is current position")
        .that(actual().getCurrentPosition())
        .isEqualTo(position);
    return this;
  }

  public VideoViewSubject isDuration(int duration) {
    isNotNull();
    check().withFailureMessage("is duration")
        .that(actual().getDuration())
        .isEqualTo(duration);
    return this;
  }

  public VideoViewSubject isPlaying() {
    isNotNull();
    check().withFailureMessage("is playing")
        .that(actual().isPlaying())
        .isTrue();
    return this;
  }

  public VideoViewSubject isNotPlaying() {
    isNotNull();
    check().withFailureMessage("is not playing")
        .that(actual().isPlaying())
        .isFalse();
    return this;
  }

  private static class VideoViewSubjectFactory extends SubjectFactory<VideoViewSubject, VideoView> {
    @Override
    public VideoViewSubject getSubject(FailureStrategy fs, VideoView that) {
      return new VideoViewSubject(fs, that);
    }
  }
}
