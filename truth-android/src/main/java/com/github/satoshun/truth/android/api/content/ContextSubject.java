package com.github.satoshun.truth.android.api.content;


import android.content.Context;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

// TODO
public abstract class ContextSubject<S extends ContextSubject<S, T>, T extends Context>
    extends BaseSubject<S, T> {

  public static final ContextSubjectFactory FACTORY = new ContextSubjectFactory();

  public ContextSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  private static class ContextSubjectImpl extends ContextSubject<ContextSubjectImpl, Context> {
    ContextSubjectImpl(FailureStrategy failureStrategy, Context actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ContextSubjectFactory extends SubjectFactory<ContextSubjectImpl, Context> {
    @Override
    public ContextSubjectImpl getSubject(FailureStrategy fs, Context that) {
      return new ContextSubjectImpl(fs, that);
    }
  }
}
