package com.github.satoshun.truth.android.api.content;

import android.annotation.TargetApi;
import android.content.AsyncTaskLoader;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

@TargetApi(HONEYCOMB)
public class AsyncTaskLoaderSubject extends LoaderSubject<AsyncTaskLoaderSubject, AsyncTaskLoader> {

  public static final AsyncTaskLoaderSubjectFactory FACTORY = new AsyncTaskLoaderSubjectFactory();

  public AsyncTaskLoaderSubject(FailureStrategy failureStrategy, AsyncTaskLoader actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN)
  public AsyncTaskLoaderSubject isLoadInBackgroundCancelled() {
    isNotNull();
    check().withFailureMessage("is load in background cancelled")
        .that(actual().isLoadInBackgroundCanceled())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AsyncTaskLoaderSubject hasLoadInBackgroundNotCancelled() {
    isNotNull();
    check().withFailureMessage("is load in background not cancelled")
        .that(actual().isLoadInBackgroundCanceled())
        .isFalse();
    return this;
  }

  private static class AsyncTaskLoaderSubjectFactory extends SubjectFactory<AsyncTaskLoaderSubject, AsyncTaskLoader> {
    @Override
    public AsyncTaskLoaderSubject getSubject(FailureStrategy fs, AsyncTaskLoader that) {
      return new AsyncTaskLoaderSubject(fs, that);
    }
  }
}
