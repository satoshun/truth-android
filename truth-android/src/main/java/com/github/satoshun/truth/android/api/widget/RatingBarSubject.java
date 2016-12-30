package com.github.satoshun.truth.android.api.widget;

import android.widget.RatingBar;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class RatingBarSubject extends AbsSeekBarSubject<RatingBarSubject, RatingBar> {

  public static final RatingBarSubjectFactory FACTORY = new RatingBarSubjectFactory();

  public RatingBarSubject(FailureStrategy failureStrategy, RatingBar actual) {
    super(failureStrategy, actual);
  }

  public RatingBarSubject isStarCount(int count) {
    isNotNull();
    check().withFailureMessage("is star count")
        .that(actual().getNumStars())
        .isEqualTo(count);
    return this;
  }

  public RatingBarSubject isRating(float rating) {
    isNotNull();
    check().withFailureMessage("is rating")
        .that(actual().getRating())
        .isEqualTo(rating);
    return this;
  }

  public RatingBarSubject isStepSize(float size) {
    isNotNull();
    check().withFailureMessage("is step size")
        .that(actual().getStepSize())
        .isEqualTo(size);
    return this;
  }

  public RatingBarSubject isIndicator() {
    isNotNull();
    check().withFailureMessage("is indicator")
        .that(actual().isIndicator())
        .isTrue();
    return this;
  }

  public RatingBarSubject isNotIndicator() {
    isNotNull();
    check().withFailureMessage("is not indicator")
        .that(actual().isIndicator())
        .isFalse();
    return this;
  }

  private static class RatingBarSubjectFactory extends SubjectFactory<RatingBarSubject, RatingBar> {
    @Override
    public RatingBarSubject getSubject(FailureStrategy fs, RatingBar that) {
      return new RatingBarSubject(fs, that);
    }
  }
}
