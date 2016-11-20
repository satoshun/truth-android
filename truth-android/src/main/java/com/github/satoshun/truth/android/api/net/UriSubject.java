package com.github.satoshun.truth.android.api.net;

import android.net.Uri;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class UriSubject<S extends UriSubject<S, T>, T extends Uri> extends BaseSubject<S, T> {

  public static final UriSubjectFactory FACTORY = new UriSubjectFactory();

  public UriSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isPath(String path) {
    isNotNull();
    String actualPath = actual().getPath();
    check().withFailureMessage("is path")
        .that(actualPath)
        .isEqualTo(path);
    return myself();
  }

  public S isNotPath(String path) {
    isNotNull();
    String actualPath = actual().getPath();
    check().withFailureMessage("is not path")
        .that(actualPath)
        .isNotEqualTo(path);
    return myself();
  }

  public S isPort(int port) {
    isNotNull();
    int actualPort = actual().getPort();
    check().withFailureMessage("is port")
        .that(actualPort)
        .isEqualTo(port);
    return myself();
  }

  public S isHost(String host) {
    isNotNull();
    String actualHost = actual().getHost();
    check().withFailureMessage("is host")
        .that(actualHost)
        .isEqualTo(host);
    return myself();
  }

  public S isFragment(String fragment) {
    isNotNull();
    String actualFragment = actual().getFragment();
    check().withFailureMessage("is fragment")
        .that(actualFragment)
        .isEqualTo(fragment);
    return myself();
  }

  public S fragmentIsNull() {
    isNotNull();
    String actualFragment = actual().getFragment();
    check().withFailureMessage("fragment is null")
        .that(actualFragment)
        .isNull();
    return myself();
  }

  public S isQuery(String query) {
    isNotNull();
    String actualQuery = actual().getQuery();
    check().withFailureMessage("is query")
        .that(actualQuery)
        .isEqualTo(query);
    return myself();
  }

  public S queryIsNull() {
    isNotNull();
    String actualQuery = actual().getQuery();
    check().withFailureMessage("query is null")
        .that(actualQuery)
        .isNull();
    return myself();
  }

  public S isScheme(String scheme) {
    isNotNull();
    String actualScheme = actual().getScheme();
    check().withFailureMessage("is scheme")
        .that(actualScheme)
        .isEqualTo(scheme);
    return myself();
  }

  public S isUserInfo(String userInfo) {
    isNotNull();
    String actualUserInfo = actual().getUserInfo();
    check().withFailureMessage("is userinfo")
        .that(actualUserInfo)
        .isEqualTo(userInfo);
    return myself();
  }

  public S userInfoIsNull() {
    isNotNull();
    String actualUserInfo = actual().getUserInfo();
    check().withFailureMessage("userinfo is null")
        .that(actualUserInfo)
        .isNull();
    return myself();
  }

  private static class UriSubjectImpl extends UriSubject<UriSubjectImpl, Uri> {
    UriSubjectImpl(FailureStrategy failureStrategy, Uri actual) {
      super(failureStrategy, actual);
    }
  }

  private static class UriSubjectFactory extends SubjectFactory<UriSubjectImpl, Uri> {
    @Override
    public UriSubjectImpl getSubject(FailureStrategy fs, Uri that) {
      return new UriSubjectImpl(fs, that);
    }
  }
}
