package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.DragEvent;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class DragEventSubject extends BaseSubject<DragEventSubject, DragEvent> {

  public static final DragEventSubjectFactory FACTORY = new DragEventSubjectFactory();

  public DragEventSubject(FailureStrategy failureStrategy, DragEvent actual) {
    super(failureStrategy, actual);
  }

  public DragEventSubject isAction(int action) {
    isNotNull();
    check().withFailureMessage("is action")
        .that(actual().getAction())
        .isEqualTo(action);
    return this;
  }

  public DragEventSubject isLocalState(Object localState) {
    isNotNull();
    check().withFailureMessage("is local state")
        .that(actual().getLocalState())
        .isEqualTo(localState);
    return this;
  }

  public DragEventSubject isSuccessfulResult() {
    isNotNull();
    check().withFailureMessage("is successful result")
        .that(actual().getResult())
        .isTrue();
    return this;
  }

  public DragEventSubject isUnsuccessfulResult() {
    isNotNull();
    check().withFailureMessage("is unsuccessful result")
        .that(actual().getResult())
        .isFalse();
    return this;
  }

  public DragEventSubject isX(float x) {
    isNotNull();
    check().withFailureMessage("is x")
        .that(actual().getX())
        .isEqualTo(x);
    return this;
  }

  public DragEventSubject hasY(float y) {
    isNotNull();
    check().withFailureMessage("is y")
        .that(actual().getY())
        .isEqualTo(y);
    return this;
  }

  private static class DragEventSubjectFactory extends SubjectFactory<DragEventSubject, DragEvent> {
    @Override
    public DragEventSubject getSubject(FailureStrategy fs, DragEvent that) {
      return new DragEventSubject(fs, that);
    }
  }
}
