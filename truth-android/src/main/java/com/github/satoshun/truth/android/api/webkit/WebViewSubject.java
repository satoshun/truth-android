package com.github.satoshun.truth.android.api.webkit;

import android.net.http.SslCertificate;
import android.webkit.WebView;

import com.github.satoshun.truth.android.api.widget.AbsoluteLayoutSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class WebViewSubject<S extends WebViewSubject<S, T>, T extends WebView> extends AbsoluteLayoutSubject<S, T> {

  public static final WebViewSubjectFactory FACTORY = new WebViewSubjectFactory();

  public WebViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S canGoBack() {
    isNotNull();
    check().withFailureMessage("can go back")
        .that(actual().canGoBack())
        .isTrue();
    return myself();
  }

  public S canNotGoBack() {
    isNotNull();
    check().withFailureMessage("can not go back")
        .that(actual().canGoBack())
        .isFalse();
    return myself();
  }

  public S canGoForward() {
    isNotNull();
    check().withFailureMessage("can go forward")
        .that(actual().canGoForward())
        .isTrue();
    return myself();
  }

  public S canNotGoForward() {
    isNotNull();
    check().withFailureMessage("can not go forward")
        .that(actual().canGoForward())
        .isFalse();
    return myself();
  }

  public S isCertificate(SslCertificate certificate) {
    isNotNull();
    check().withFailureMessage("is certificate")
        .that(certificate)
        .isEqualTo(actual().getCertificate());
    return myself();
  }

  public S isContentHeight(int height) {
    isNotNull();
    check().withFailureMessage("is content height")
        .that(height)
        .isEqualTo(actual().getContentHeight());
    return myself();
  }

  public S isOriginalUrl(String url) {
    isNotNull();
    check().withFailureMessage("is original url")
        .that(url)
        .isEqualTo(actual().getOriginalUrl());
    return myself();
  }

  public S isProgress(int progress) {
    isNotNull();
    check().withFailureMessage("is progress")
        .that(progress)
        .isEqualTo(actual().getProgress());
    return myself();
  }

  public S isTitle(String title) {
    isNotNull();
    check().withFailureMessage("is title")
        .that(title)
        .isEqualTo(actual().getTitle());
    return myself();
  }

  public S isUrl(String url) {
    isNotNull();
    check().withFailureMessage("is url")
        .that(url)
        .isEqualTo(actual().getUrl());
    return myself();
  }

  private static class WebViewSubjectImpl extends WebViewSubject<WebViewSubjectImpl, WebView> {
    WebViewSubjectImpl(FailureStrategy failureStrategy, WebView actual) {
      super(failureStrategy, actual);
    }
  }

  private static class WebViewSubjectFactory extends SubjectFactory<WebViewSubjectImpl, WebView> {
    @Override
    public WebViewSubjectImpl getSubject(FailureStrategy fs, WebView that) {
      return new WebViewSubjectImpl(fs, that);
    }
  }
}
