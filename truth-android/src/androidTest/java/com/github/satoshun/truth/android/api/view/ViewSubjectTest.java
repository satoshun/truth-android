package com.github.satoshun.truth.android.api.view;

import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.github.satoshun.truth.android.api.TruthAndroid;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static com.google.common.truth.TruthJUnit.assume;

@RunWith(AndroidJUnit4.class)
public class ViewSubjectTest {

  @Rule public UiThreadTestRule uiThreadTestRule = new UiThreadTestRule();

  private View view;

  @Before
  public void setUp() throws Exception {
    view = new View(InstrumentationRegistry.getTargetContext());
  }

  @UiThreadTest @Test
  public void isSameAlpha_success() throws Exception {
    assumeVersion(HONEYCOMB);
    view.setAlpha((float) 0.45);
    TruthAndroid.assertThat(view)
            .isSameAlpha((float) 0.45);
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void isSameAlpha_failure() throws Exception {
    assumeVersion(HONEYCOMB);
    view.setAlpha((float) 0.45);
    TruthAndroid.assertThat(view)
            .isSameAlpha((float) 0.451);
  }

  @UiThreadTest @Test
  public void isVisible_success() throws Exception {
    view.setVisibility(View.VISIBLE);
    TruthAndroid.assertThat(view)
            .isVisible();
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void isVisible_failure() throws Exception {
    view.setVisibility(View.INVISIBLE);
    TruthAndroid.assertThat(view)
            .isVisible();
  }

  @UiThreadTest @Test
  public void isNotVisible_success() throws Exception {
    view.setVisibility(View.GONE);
    TruthAndroid.assertThat(view)
            .isNotVisible();
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void isNotVisible_failure() throws Exception {
    view.setVisibility(View.VISIBLE);
    TruthAndroid.assertThat(view)
            .isNotVisible();
  }

  private static void assumeVersion(int versionCode) {
    assume().that(Build.VERSION.SDK_INT)
            .isGreaterThan(versionCode);
  }
}