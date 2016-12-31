package com.github.satoshun.truth.android.api.content;

import android.annotation.TargetApi;
import android.content.CursorLoader;
import android.net.Uri;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.Arrays;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class CursorLoaderSubject extends LoaderSubject<CursorLoaderSubject, CursorLoader> {

  public static final CursorLoaderSubjectFactory FACTORY = new CursorLoaderSubjectFactory();

  public CursorLoaderSubject(FailureStrategy failureStrategy, CursorLoader actual) {
    super(failureStrategy, actual);
  }

  public CursorLoaderSubject isProjection(String... projection) {
    isNotNull();
    check().withFailureMessage("is projection")
        .that(actual().getProjection())
        .isEqualTo(projection);
    return this;
  }

  public CursorLoaderSubject doesNotHaveProjection() {
    isNotNull();
    check().withFailureMessage("is not projection")
        .that(actual().getProjection())
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject projectionContains(String... projection) {
    isNotNull();
    check().withFailureMessage("projection contains")
        .that(actual().getProjection())
        .isIn(Arrays.asList(projection));
    return this;
  }

  public CursorLoaderSubject isSelection(String selection) {
    isNotNull();
    check().withFailureMessage("is selection")
        .that(actual().getSelection())
        .isEqualTo(selection);
    return this;
  }

  public CursorLoaderSubject doesNotHaveSelection() {
    isNotNull();
    check().withFailureMessage("does not have selection")
        .that(actual().getSelection())
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject isSelectionArgs(String... selectionArgs) {
    isNotNull();
    check().withFailureMessage("is selection args")
        .that(actual().getSelectionArgs())
        .isIn(Arrays.asList(selectionArgs));
    return this;
  }

  public CursorLoaderSubject doesNotHaveSelectionArgs() {
    isNotNull();
    check().withFailureMessage("does not have selection args")
        .that(actual().getSelectionArgs())
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject containsSelectionArgs(String... selectionArgs) {
    isNotNull();
    check().withFailureMessage("contains selection args")
        .that(actual().getSelectionArgs())
        .isIn(Arrays.asList(selectionArgs));
    return this;
  }

  public CursorLoaderSubject isSortOrder(String sortOrder) {
    isNotNull();
    check().withFailureMessage("is sort order")
        .that(actual().getSortOrder())
        .isEqualTo(sortOrder);
    return this;
  }

  public CursorLoaderSubject doesNotHaveSortOrder() {
    isNotNull();
    check().withFailureMessage("does not have sort order")
        .that(actual().getSortOrder())
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject isUri(Uri uri) {
    isNotNull();
    check().withFailureMessage("is uri")
        .that(actual().getUri())
        .isEqualTo(uri);
    return this;
  }

  private static class CursorLoaderSubjectFactory extends SubjectFactory<CursorLoaderSubject, CursorLoader> {
    @Override
    public CursorLoaderSubject getSubject(FailureStrategy fs, CursorLoader that) {
      return new CursorLoaderSubject(fs, that);
    }
  }
}
