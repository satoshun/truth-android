package com.github.satoshun.truth.android.api.database;

import android.annotation.TargetApi;
import android.database.AbstractCursor;
import android.net.Uri;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

public abstract class AbstractCursorSubject<S extends AbstractCursorSubject<S, T>, T extends AbstractCursor>
    extends CursorSubject<S, T> {

  public static final AbstractCursorSubjectFactory FACTORY = new AbstractCursorSubjectFactory();

  public AbstractCursorSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB)
  public S isNotificationUri(Uri uri) {
    isNotNull();
    check().withFailureMessage("is notification uri")
        .that(actual().getNotificationUri())
        .isEqualTo(uri);
    return myself();
  }

  private static class AbstractCursorSubjectImpl extends AbstractCursorSubject<AbstractCursorSubjectImpl, AbstractCursor> {
    AbstractCursorSubjectImpl(FailureStrategy failureStrategy, AbstractCursor actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AbstractCursorSubjectFactory extends SubjectFactory<AbstractCursorSubjectImpl, AbstractCursor> {
    @Override
    public AbstractCursorSubjectImpl getSubject(FailureStrategy fs, AbstractCursor that) {
      return new AbstractCursorSubjectImpl(fs, that);
    }
  }
}
