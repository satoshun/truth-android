package com.github.satoshun.truth.android.api.view;

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

@RunWith(AndroidJUnit4.class)
public class ViewSubjectTest {

  @Rule public UiThreadTestRule uiThreadTestRule = new UiThreadTestRule();

  private View view;

  @Before
  public void setUp() throws Exception {
    view = new View(InstrumentationRegistry.getTargetContext());
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
}