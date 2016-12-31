package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.widget.CursorAdapter;
import android.widget.SearchView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

@TargetApi(HONEYCOMB)
public class SearchViewSubject extends BaseSubject<SearchViewSubject, SearchView> {

  public static final SearchViewSubjectFactory FACTORY = new SearchViewSubjectFactory();

  public SearchViewSubject(FailureStrategy failureStrategy, SearchView actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN)
  public SearchViewSubject isImeOptions(int options) {
    isNotNull();
    check().withFailureMessage("is ime options")
        .that(actual().getImeOptions())
        .isEqualTo(options);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SearchViewSubject isInputType(int type) {
    isNotNull();
    check().withFailureMessage("is input type")
        .that(actual().getInputType())
        .isEqualTo(type);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SearchViewSubject isMaximumWidth(int width) {
    isNotNull();
    check().withFailureMessage("is maximum width")
        .that(actual().getMaxWidth())
        .isEqualTo(width);
    return this;
  }

  public SearchViewSubject isQuery(CharSequence query) {
    isNotNull();
    check().withFailureMessage("is query")
        .that(actual().getQuery())
        .isEqualTo(query);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SearchViewSubject isQueryHint(CharSequence hint) {
    isNotNull();
    check().withFailureMessage("is query hint")
        .that(actual().getQueryHint())
        .isEqualTo(hint);
    return this;
  }

  public SearchViewSubject isQueryHint(int resId) {
    isNotNull();
    return isQueryHint(actual().getContext().getString(resId));
  }

  public SearchViewSubject isSuggestionsAdapter(CursorAdapter adapter) {
    isNotNull();
    check().withFailureMessage("is suggestion adapter")
        .that(actual().getSuggestionsAdapter())
        .isSameAs(adapter);
    return this;
  }

  public SearchViewSubject isIconifiedByDefault() {
    isNotNull();
    check().withFailureMessage("is iconified by default")
        .that(actual().isIconfiedByDefault())
        .isTrue();
    return this;
  }

  public SearchViewSubject isNotIconifiedByDefault() {
    isNotNull();
    check().withFailureMessage("is not iconified by default")
        .that(actual().isIconfiedByDefault())
        .isFalse();
    return this;
  }

  public SearchViewSubject isIconified() {
    isNotNull();
    check().withFailureMessage("is iconfied")
        .that(actual().isIconified())
        .isTrue();
    return this;
  }

  public SearchViewSubject isNotIconified() {
    isNotNull();
    check().withFailureMessage("is not iconified")
        .that(actual().isIconified())
        .isFalse();
    return this;
  }

  public SearchViewSubject isQueryRefinementEnabled() {
    isNotNull();
    check().withFailureMessage("is query refinement enabled")
        .that(actual().isQueryRefinementEnabled())
        .isTrue();
    return this;
  }

  public SearchViewSubject isQueryRefinementDisabled() {
    isNotNull();
    check().withFailureMessage("is query refinement disabled")
        .that(actual().isQueryRefinementEnabled())
        .isFalse();
    return this;
  }

  public SearchViewSubject isSubmitButtonEnabled() {
    isNotNull();
    check().withFailureMessage("is submit button enabled")
        .that(actual().isSubmitButtonEnabled())
        .isTrue();
    return this;
  }

  public SearchViewSubject isSubmitButtonDisabled() {
    isNotNull();
    check().withFailureMessage("is submit button disabled")
        .that(actual().isSubmitButtonEnabled())
        .isFalse();
    return this;
  }

  private static class SearchViewSubjectFactory extends SubjectFactory<SearchViewSubject, SearchView> {
    @Override
    public SearchViewSubject getSubject(FailureStrategy fs, SearchView that) {
      return new SearchViewSubject(fs, that);
    }
  }
}
