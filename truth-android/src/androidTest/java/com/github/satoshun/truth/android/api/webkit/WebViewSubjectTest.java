package com.github.satoshun.truth.android.api.webkit;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.satoshun.truth.android.TestActivity;
import com.github.satoshun.truth.android.api.Subjects;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class WebViewSubjectTest {

  @Rule
  public ActivityTestRule<TestActivity> activityRule = new ActivityTestRule<>(TestActivity.class);
  private UiThreadTestRule uiThreadTestRule = new UiThreadTestRule();

  private WebView view;
  private Runnable onPageFinished;

  public void setUp() {
    view = new WebView(InstrumentationRegistry.getTargetContext());
    view.setWebViewClient(new WebViewClient() {
      @Override public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (onPageFinished != null) {
          onPageFinished.run();
        }
      }
    });
    view.setWebChromeClient(new WebChromeClient());
    activityRule.getActivity().root.addView(view);

    onPageFinished = null;
  }

  @Test
  public void canGoBack_success() throws Throwable {
    // todo
  }

  @Test(expected = AssertionError.class)
  public void canGoBack_failure() throws Exception {
    Subjects.assertThat(view)
        .canGoBack();
  }
}
