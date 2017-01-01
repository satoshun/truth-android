package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.PendingIntent;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

public class PendingIntentSubject extends BaseSubject<PendingIntentSubject, PendingIntent> {

  public static final PendingIntentSubjectFactory FACTORY = new PendingIntentSubjectFactory();

  public PendingIntentSubject(FailureStrategy failureStrategy, PendingIntent actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public PendingIntentSubject isCreatorPackage(String packageName) {
    isNotNull();
    check().withFailureMessage("is creator package")
        .that(actual().getCreatorPackage())
        .isEqualTo(packageName);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public PendingIntentSubject isCreatorUid(int uid) {
    isNotNull();
    check().withFailureMessage("is creator uid")
        .that(actual().getCreatorUid())
        .isEqualTo(uid);
    return this;
  }

  public PendingIntentSubject isTargetPackage(String targetPackage) {
    isNotNull();
    check().withFailureMessage("is target package")
        .that(actual().getTargetPackage())
        .isEqualTo(targetPackage);
    return this;
  }

  private static class PendingIntentSubjectFactory extends SubjectFactory<PendingIntentSubject, PendingIntent> {
    @Override
    public PendingIntentSubject getSubject(FailureStrategy fs, PendingIntent that) {
      return new PendingIntentSubject(fs, that);
    }
  }
}
