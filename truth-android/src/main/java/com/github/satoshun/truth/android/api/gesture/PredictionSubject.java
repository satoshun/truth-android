package com.github.satoshun.truth.android.api.gesture;

import android.gesture.Prediction;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class PredictionSubject extends BaseSubject<PredictionSubject, Prediction> {

  public static final PredictionSubjectFactory FACTORY = new PredictionSubjectFactory();

  public PredictionSubject(FailureStrategy failureStrategy, Prediction actual) {
    super(failureStrategy, actual);
  }

  public PredictionSubject isName(String name) {
    isNotNull();
    check().withFailureMessage("is name")
        .that(actual().name)
        .isEqualTo(name);
    return this;
  }

  public PredictionSubject isScore(double score) {
    isNotNull();
    check().withFailureMessage("is score")
        .that(actual().score)
        .isEqualTo(score);
    return this;
  }

  private static class PredictionSubjectFactory extends SubjectFactory<PredictionSubject, Prediction> {
    @Override
    public PredictionSubject getSubject(FailureStrategy fs, Prediction that) {
      return new PredictionSubject(fs, that);
    }
  }
}
