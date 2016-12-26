package com.github.satoshun.truth.android.api.view;

import android.view.Menu;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class MenuSubject extends BaseSubject<MenuSubject, Menu> {

  public static final MenuSubjectFactory FACTORY = new MenuSubjectFactory();

  public MenuSubject(FailureStrategy failureStrategy, Menu actual) {
    super(failureStrategy, actual);
  }

  public MenuSubject hasItem(int id) {
    isNotNull();
    check().withFailureMessage("has item")
        .that(actual().findItem(id))
        .isNotNull();
    return myself();
  }

  public MenuSubject hasItemAt(int index) {
    isNotNull();
    check().withFailureMessage("has item at")
        .that(actual().getItem(index))
        .isNotNull();
    return myself();
  }

  public MenuSubject hasVisibleItems() {
    isNotNull();
    check().withFailureMessage("has visible items")
        .that(actual().hasVisibleItems())
        .isTrue();
    return myself();
  }

  public MenuSubject hasNoVisibleItems() {
    isNotNull();
    check().withFailureMessage("has no visible items")
        .that(actual().hasVisibleItems())
        .isFalse();
    return myself();
  }

  public MenuSubject isSize(int size) {
    isNotNull();
    check().withFailureMessage("is size")
        .that(actual().size())
        .isEqualTo(size);
    return myself();
  }

  private static class MenuSubjectFactory extends SubjectFactory<MenuSubject, Menu> {
    @Override
    public MenuSubject getSubject(FailureStrategy fs, Menu that) {
      return new MenuSubject(fs, that);
    }
  }
}
