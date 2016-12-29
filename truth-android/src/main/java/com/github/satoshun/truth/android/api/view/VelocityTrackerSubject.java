package com.github.satoshun.truth.android.api.view;

import android.view.VelocityTracker;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class VelocityTrackerSubject extends BaseSubject<VelocityTrackerSubject, VelocityTracker> {

  public static final VelocityTrackerSubjectFactory FACTORY = new VelocityTrackerSubjectFactory();

  public VelocityTrackerSubject(FailureStrategy failureStrategy, VelocityTracker actual) {
    super(failureStrategy, actual);
  }

  public VelocityTrackerSubject isXVelocity(float velocity) {
    isNotNull();
    check().withFailureMessage("is x velocity")
        .that(actual().getXVelocity())
        .isEqualTo(velocity);
    return this;
  }

  public VelocityTrackerSubject isXVelocity(int id, float velocity) {
    isNotNull();
    check().withFailureMessage("is x velocity with id")
        .that(actual().getXVelocity(id))
        .isEqualTo(velocity);
    return this;
  }

  public VelocityTrackerSubject isYVelocity(float velocity) {
    isNotNull();
    check().withFailureMessage("is y velocity")
        .that(actual().getYVelocity())
        .isEqualTo(velocity);
    return this;
  }

  public VelocityTrackerSubject hasYVelocity(int id, float velocity) {
    isNotNull();
    check().withFailureMessage("is y velocity with id")
        .that(actual().getYVelocity(id))
        .isEqualTo(velocity);
    return this;
  }

  private static class VelocityTrackerSubjectFactory extends SubjectFactory<VelocityTrackerSubject, VelocityTracker> {
    @Override
    public VelocityTrackerSubject getSubject(FailureStrategy fs, VelocityTracker that) {
      return new VelocityTrackerSubject(fs, that);
    }
  }
}
