package com.github.satoshun.truth.android.api.os;

import android.os.AsyncTask;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class AsyncTaskSubject extends BaseSubject<AsyncTaskSubject, AsyncTask> {

  public static final AsyncTaskSubjectFactory FACTORY = new AsyncTaskSubjectFactory();

  public AsyncTaskSubject(FailureStrategy failureStrategy, AsyncTask actual) {
    super(failureStrategy, actual);
  }

  public AsyncTaskSubject isStatus(AsyncTask.Status status) {
    isNotNull();
    check().withFailureMessage("is status")
        .that(actual().getStatus())
        .isEqualTo(status);
    return this;
  }

  public AsyncTaskSubject isCancelled() {
    isNotNull();
    check().withFailureMessage("is cancelled")
        .that(actual().isCancelled())
        .isTrue();
    return this;
  }

  public AsyncTaskSubject isNotCancelled() {
    isNotNull();
    check().withFailureMessage("is not cancelled")
        .that(actual().isCancelled())
        .isFalse();
    return this;
  }

  private static class AsyncTaskSubjectFactory extends SubjectFactory<AsyncTaskSubject, AsyncTask> {
    @Override
    public AsyncTaskSubject getSubject(FailureStrategy fs, AsyncTask that) {
      return new AsyncTaskSubject(fs, that);
    }
  }
}
