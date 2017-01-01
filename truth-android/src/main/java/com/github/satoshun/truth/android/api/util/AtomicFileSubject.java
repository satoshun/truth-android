package com.github.satoshun.truth.android.api.util;

import android.annotation.TargetApi;
import android.util.AtomicFile;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.io.File;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

@TargetApi(JELLY_BEAN_MR1)
public class AtomicFileSubject extends BaseSubject<AtomicFileSubject, AtomicFile> {

  public static final AtomicFileSubjectFactory FACTORY = new AtomicFileSubjectFactory();

  public AtomicFileSubject(FailureStrategy failureStrategy, AtomicFile actual) {
    super(failureStrategy, actual);
  }

  public AtomicFileSubject isBaseFile(File file) {
    isNotNull();
    check().withFailureMessage("is base file")
        .that(actual().getBaseFile())
        .isEqualTo(file);
    return this;
  }

  private static class AtomicFileSubjectFactory extends SubjectFactory<AtomicFileSubject, AtomicFile> {
    @Override
    public AtomicFileSubject getSubject(FailureStrategy fs, AtomicFile that) {
      return new AtomicFileSubject(fs, that);
    }
  }
}
