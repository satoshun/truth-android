package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.LoaderManager;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class LoaderManagerSubject extends BaseSubject<LoaderManagerSubject, LoaderManager> {

  public static final LoaderManagerSubjectFactory FACTORY = new LoaderManagerSubjectFactory();

  public LoaderManagerSubject(FailureStrategy failureStrategy, LoaderManager actual) {
    super(failureStrategy, actual);
  }

  public LoaderManagerSubject hasLoader(int id) {
    isNotNull();
    check().withFailureMessage("is loader")
        .that(actual().getLoader(id))
        .isNotNull();
    return this;
  }

  private static class LoaderManagerSubjectFactory extends SubjectFactory<LoaderManagerSubject, LoaderManager> {
    @Override
    public LoaderManagerSubject getSubject(FailureStrategy fs, LoaderManager that) {
      return new LoaderManagerSubject(fs, that);
    }
  }
}
