package com.github.satoshun.truth.android.api.webkit;

import android.net.http.SslCertificate;
import android.webkit.WebView;

import com.github.satoshun.truth.android.api.widget.AbsoluteLayoutSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;
import com.google.common.truth.TestVerb;
import com.google.common.truth.Truth;

public abstract class WebViewSubject<S extends WebViewSubject<S, T>, T extends WebView> extends AbsoluteLayoutSubject<S, T> {

  public static final WebViewSubjectFactory FACTORY = new WebViewSubjectFactory();

  private static final TestVerb ASSERT = Truth.assert_();

  public WebViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S canGoBack() {
    isNotNull();
    ASSERT.withFailureMessage("can go back")
            .that(actual().canGoBack())
            .isTrue();
    return myself();
  }

  public S canNotGoBack() {
    isNotNull();
    ASSERT.withFailureMessage("can not go back")
            .that(actual().canGoBack())
            .isFalse();
    return myself();
  }

  public S canGoForward() {
    isNotNull();
    if (!actual().canGoForward()) {
      fail("can go forward", actual().canGoForward());
    }
    return myself();
  }

  public S canNotGoForward() {
    isNotNull();
    if (actual().canGoForward()) {
      fail("can not go forward", actual().canGoForward());
    }
    return myself();
  }

  public S sameAsCertificate(SslCertificate certificate) {
    isNotNull();
    if (!certificate.equals(actual().getCertificate())) {
      fail("same as certificate", actual().getCertificate());
    }
    return myself();
  }

  public S sameAsOriginalUrl(String url) {
    isNotNull();
    if (url == null) {
      if (actual().getOriginalUrl() != null) {
        fail("same as originalUrl", actual().getOriginalUrl());
      }
      return myself();
    }
    Truth.assertThat(url).isEqualTo("");
    if (!url.equals(actual().getOriginalUrl())) {
      fail("same as originalUrl", actual().getOriginalUrl());
    }
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
