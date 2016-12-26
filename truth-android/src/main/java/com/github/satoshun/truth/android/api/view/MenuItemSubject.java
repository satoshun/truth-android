package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;

public class MenuItemSubject extends BaseSubject<MenuItemSubject, MenuItem> {

  public static final MenuItemSubjectFactory FACTORY = new MenuItemSubjectFactory();

  public MenuItemSubject(FailureStrategy failureStrategy, MenuItem actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB)
  public MenuItemSubject isActionView(View view) {
    isNotNull();
    check().withFailureMessage("is action view")
        .that(actual().getActionView())
        .isSameAs(view);
    return myself();
  }

  public MenuItemSubject isAlphabeticShortcut(char shortcut) {
    isNotNull();
    check().withFailureMessage("is alphabetic shortcut")
        .that(actual().getAlphabeticShortcut())
        .isEqualTo(shortcut);
    return myself();
  }

  public MenuItemSubject isGroupId(int id) {
    isNotNull();
    check().withFailureMessage("is group id")
        .that(actual().getGroupId())
        .isEqualTo(id);
    return myself();
  }

  public MenuItemSubject isIcon(Drawable icon) {
    isNotNull();
    check().withFailureMessage("is icon")
        .that(actual().getIcon())
        .isSameAs(icon);
    return myself();
  }

  public MenuItemSubject isIntent(Intent intent) {
    isNotNull();
    check().withFailureMessage("is intent")
        .that(actual().getIntent())
        .isEqualTo(intent);
    return myself();
  }

  public MenuItemSubject isItemId(int id) {
    isNotNull();
    check().withFailureMessage("is item id ")
        .that(actual().getItemId())
        .isEqualTo(id);
    return myself();
  }

  public MenuItemSubject isNumericShortcut(char shortcut) {
    isNotNull();
    check().withFailureMessage("is numeric shortcut")
        .that(actual().getNumericShortcut())
        .isEqualTo(shortcut);
    return myself();
  }

  public MenuItemSubject isOrder(int order) {
    isNotNull();
    check().withFailureMessage("is order")
        .that(actual().getOrder())
        .isEqualTo(order);
    return myself();
  }

  public MenuItemSubject isTitle(CharSequence title) {
    isNotNull();
    check().withFailureMessage("is title")
        .that(actual().getTitle())
        .isEqualTo(title);
    return myself();
  }

  public MenuItemSubject isTitleCondensed(CharSequence title) {
    isNotNull();
    check().withFailureMessage("is title condensed")
        .that(actual().getTitleCondensed())
        .isEqualTo(title);
    return myself();
  }

  public MenuItemSubject hasSubMenu() {
    isNotNull();
    check().withFailureMessage("has sub menu")
        .that(actual().hasSubMenu())
        .isTrue();
    return myself();
  }

  public MenuItemSubject hasNoSubMenu() {
    isNotNull();
    check().withFailureMessage("has no sub menu")
        .that(actual().hasSubMenu())
        .isFalse();
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public MenuItemSubject isActionViewExpanded() {
    isNotNull();
    check().withFailureMessage("is action view expanded")
        .that(actual().isActionViewExpanded())
        .isTrue();
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public MenuItemSubject isActionViewCollapsed() {
    isNotNull();
    check().withFailureMessage("is action view collapsed")
        .that(actual().isActionViewExpanded())
        .isFalse();
    return myself();
  }

  public MenuItemSubject isCheckable() {
    isNotNull();
    check().withFailureMessage("is checkable")
        .that(actual().isCheckable())
        .isTrue();
    return myself();
  }

  public MenuItemSubject isNotCheckable() {
    isNotNull();
    check().withFailureMessage("is not checkable")
        .that(actual().isCheckable())
        .isFalse();
    return myself();
  }

  public MenuItemSubject isChecked() {
    isNotNull();
    check().withFailureMessage("is checked")
        .that(actual().isChecked())
        .isTrue();
    return myself();
  }

  public MenuItemSubject isNotChecked() {
    isNotNull();
    check().withFailureMessage("is not checked")
        .that(actual().isChecked())
        .isFalse();
    return myself();
  }

  public MenuItemSubject isEnabled() {
    isNotNull();
    check().withFailureMessage("is enabled")
        .that(actual().isEnabled())
        .isTrue();
    return myself();
  }

  public MenuItemSubject isDisabled() {
    isNotNull();
    check().withFailureMessage("is disabled")
        .that(actual().isEnabled())
        .isFalse();
    return myself();
  }

  public MenuItemSubject isVisible() {
    isNotNull();
    check().withFailureMessage("is visible")
        .that(actual().isVisible())
        .isTrue();
    return myself();
  }

  public MenuItemSubject isNotVisible() {
    isNotNull();
    check().withFailureMessage("is not visible")
        .that(actual().isVisible())
        .isFalse();
    return myself();
  }

  private static class MenuItemSubjectFactory extends SubjectFactory<MenuItemSubject, MenuItem> {
    @Override
    public MenuItemSubject getSubject(FailureStrategy fs, MenuItem that) {
      return new MenuItemSubject(fs, that);
    }
  }
}
