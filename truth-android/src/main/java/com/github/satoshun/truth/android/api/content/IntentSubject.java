package com.github.satoshun.truth.android.api.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class IntentSubject extends BaseSubject<IntentSubject, Intent> {

  public static final IntentSubjectFactory FACTORY = new IntentSubjectFactory();

  public IntentSubject(FailureStrategy failureStrategy, Intent actual) {
    super(failureStrategy, actual);
  }

  public IntentSubject isAction(String action) {
    isNotNull();
    check().withFailureMessage("is action")
        .that(actual().getAction())
        .isEqualTo(action);
    return this;
  }

  public IntentSubject isType(String type) {
    isNotNull();
    check().withFailureMessage("is type")
        .that(actual().getType())
        .isEqualTo(type);
    return this;
  }

  public IntentSubject hasExtra(String name) {
    isNotNull();
    check().withFailureMessage("has extra")
        .that(actual().hasExtra(name))
        .isTrue();
    return this;
  }

  public IntentSubject hasExtra(String key, Object expectedValue) {
    hasExtra(key);
    check().withFailureMessage("has extra")
        .that(actual().getExtras().get(key))
        .isEqualTo(expectedValue);
    return this;
  }

  public IntentSubject isFlags(int flags) {
    isNotNull();
    check().withFailureMessage("is flags")
        .that(actual().getFlags())
        .isEqualTo(flags);
    return this;
  }

  public IntentSubject isPackage(String packageName) {
    isNotNull();
    check().withFailureMessage("is package")
        .that(actual().getPackage())
        .isEqualTo(packageName);
    return this;
  }

  public IntentSubject hasData(String uri) {
    return hasData(Uri.parse(uri));
  }

  public IntentSubject hasData(Uri uri) {
    isNotNull();
    check().withFailureMessage("has date")
        .that(actual().getData().compareTo(uri))
        .isEqualTo(0);
    return this;
  }

  public IntentSubject isComponent(ComponentName expected) {
    isNotNull();
    check().withFailureMessage("is component")
        .that(actual().getComponent())
        .isEqualTo(expected);
    return this;
  }

  public IntentSubject isComponent(Context context, Class<?> cls) {
    return isComponent(new ComponentName(context, cls.getName()));
  }

  public IntentSubject isComponent(String appPkg, Class<?> cls) {
    return isComponent(new ComponentName(appPkg, cls.getName()));
  }

  private static class IntentSubjectFactory extends SubjectFactory<IntentSubject, Intent> {
    @Override
    public IntentSubject getSubject(FailureStrategy fs, Intent that) {
      return new IntentSubject(fs, that);
    }
  }
}
