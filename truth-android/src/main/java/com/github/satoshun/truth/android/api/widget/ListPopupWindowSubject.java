package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ListPopupWindow;
import android.widget.ListView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class ListPopupWindowSubject extends BaseSubject<ListPopupWindowSubject, ListPopupWindow> {

  public static final ListPopupWindowSubjectFactory FACTORY = new ListPopupWindowSubjectFactory();

  public ListPopupWindowSubject(FailureStrategy failureStrategy, ListPopupWindow actual) {
    super(failureStrategy, actual);
  }

  public ListPopupWindowSubject isAnchorView(View view) {
    isNotNull();
    check().withFailureMessage("is anchor view")
        .that(actual().getAnchorView())
        .isSameAs(view);
    return this;
  }

  public ListPopupWindowSubject isAnimationStyle(int style) {
    isNotNull();
    check().withFailureMessage("is animation style")
        .that(actual().getAnimationStyle())
        .isEqualTo(style);
    return this;
  }

  public ListPopupWindowSubject isBackground(Drawable background) {
    isNotNull();
    check().withFailureMessage("is background")
        .that(actual().getBackground())
        .isSameAs(background);
    return this;
  }

  public ListPopupWindowSubject isHeight(int height) {
    isNotNull();
    check().withFailureMessage("is height")
        .that(actual().getHeight())
        .isEqualTo(height);
    return this;
  }

  public ListPopupWindowSubject isHorizontalOffset(int offset) {
    isNotNull();
    check().withFailureMessage("is horizontal offset")
        .that(actual().getHorizontalOffset())
        .isEqualTo(offset);
    return this;
  }

  public ListPopupWindowSubject isInputMethodMode(int mode) {
    isNotNull();
    check().withFailureMessage("is input method mode")
        .that(actual().getInputMethodMode())
        .isEqualTo(mode);
    return this;
  }

  public ListPopupWindowSubject isListView(ListView view) {
    isNotNull();
    check().withFailureMessage("is list view")
        .that(actual().getListView())
        .isSameAs(view);
    return this;
  }

  public ListPopupWindowSubject isPromptPosition(int position) {
    isNotNull();
    check().withFailureMessage("is prompt position")
        .that(actual().getPromptPosition())
        .isEqualTo(position);
    return this;
  }

  public ListPopupWindowSubject isSelectedItem(Object item) {
    isNotNull();
    check().withFailureMessage("is selected item")
        .that(actual().getSelectedItem())
        .isEqualTo(item);
    return this;
  }

  public ListPopupWindowSubject isSelectedItemId(long id) {
    isNotNull();
    check().withFailureMessage("is selected item id")
        .that(actual().getSelectedItemId())
        .isEqualTo(id);
    return this;
  }

  public ListPopupWindowSubject isSelectedItemPosition(int position) {
    isNotNull();
    check().withFailureMessage("is selected item position")
        .that(actual().getSelectedItemPosition())
        .isEqualTo(position);
    return this;
  }

  public ListPopupWindowSubject isSelectedItemView(View view) {
    isNotNull();
    check().withFailureMessage("is selected item view")
        .that(actual().getSelectedView())
        .isSameAs(view);
    return this;
  }

  public ListPopupWindowSubject isSoftInputMode(int mode) {
    isNotNull();
    check().withFailureMessage("is soft input mode")
        .that(actual().getSoftInputMode())
        .isEqualTo(mode);
    return this;
  }

  public ListPopupWindowSubject isVerticalOffset(int offset) {
    isNotNull();
    check().withFailureMessage("is vertical offset")
        .that(actual().getVerticalOffset())
        .isEqualTo(offset);
    return this;
  }

  public ListPopupWindowSubject isWidth(int width) {
    isNotNull();
    check().withFailureMessage("is width")
        .that(actual().getWidth())
        .isEqualTo(width);
    return this;
  }

  public ListPopupWindowSubject isModal() {
    isNotNull();
    check().withFailureMessage("is modal")
        .that(actual().isModal())
        .isTrue();
    return this;
  }

  public ListPopupWindowSubject isNotModal() {
    isNotNull();
    check().withFailureMessage("is not modal")
        .that(actual().isModal())
        .isFalse();
    return this;
  }

  public ListPopupWindowSubject isShowing() {
    isNotNull();
    check().withFailureMessage("is showing")
        .that(actual().isShowing())
        .isTrue();
    return this;
  }

  public ListPopupWindowSubject isNotShowing() {
    isNotNull();
    check().withFailureMessage("is not showing")
        .that(actual().isShowing())
        .isFalse();
    return this;
  }

  private static class ListPopupWindowSubjectFactory extends SubjectFactory<ListPopupWindowSubject, ListPopupWindow> {
    @Override
    public ListPopupWindowSubject getSubject(FailureStrategy fs, ListPopupWindow that) {
      return new ListPopupWindowSubject(fs, that);
    }
  }
}
