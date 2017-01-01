package com.github.satoshun.truth.android.api.app;

import android.app.Service;

import com.github.satoshun.truth.android.api.content.ContextSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class ServiceSubject<S extends ServiceSubject<S, T>, T extends Service>
    extends ContextSubject<S, T> {

  public static final ServiceSubjectFactory FACTORY = new ServiceSubjectFactory();

  public ServiceSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  private static class ServiceSubjectImpl extends ServiceSubject<ServiceSubjectImpl, Service> {
    ServiceSubjectImpl(FailureStrategy failureStrategy, Service actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ServiceSubjectFactory extends SubjectFactory<ServiceSubjectImpl, Service> {
    @Override
    public ServiceSubjectImpl getSubject(FailureStrategy fs, Service that) {
      return new ServiceSubjectImpl(fs, that);
    }
  }
}
