package com.github.satoshun.truth.android.api.app;

import android.app.Activity;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.app.Instrumentation.ActivityMonitor;

public class ActivityMonitorSubject extends BaseSubject<ActivityMonitorSubject, ActivityMonitor> {

  public static final ActivityMonitorSubjectFactory FACTORY = new ActivityMonitorSubjectFactory();

  public ActivityMonitorSubject(FailureStrategy failureStrategy, ActivityMonitor actual) {
    super(failureStrategy, actual);
  }

  public ActivityMonitorSubject isHits(int hits) {
    isNotNull();
    check().withFailureMessage("is hits")
        .that(actual().getHits())
        .isEqualTo(hits);
    return this;
  }

  public ActivityMonitorSubject isLastActivity(Activity activity) {
    isNotNull();
    check().withFailureMessage("is last activity")
        .that(actual().getLastActivity())
        .isSameAs(activity);
    return this;
  }

  private static class ActivityMonitorSubjectFactory extends SubjectFactory<ActivityMonitorSubject, ActivityMonitor> {
    @Override
    public ActivityMonitorSubject getSubject(FailureStrategy fs, ActivityMonitor that) {
      return new ActivityMonitorSubject(fs, that);
    }
  }
}
