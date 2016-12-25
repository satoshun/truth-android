package com.github.satoshun.truth.android.api.view;

import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import com.github.satoshun.truth.android.api.Subjects;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TextViewSubjectTest {

  @Rule public UiThreadTestRule uiThreadTestRule = new UiThreadTestRule();

  private TextView view;

  @Before
  public void setUp() throws Exception {
    view = new TextView(InstrumentationRegistry.getTargetContext());
  }

  @UiThreadTest @Test
  public void sameAsText_success() throws Exception {
    view.setText("hoge");
    Subjects.assertThat(view).sameAsText("hoge");
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void sameAsText_failure() throws Exception {
    view.setText("hoge");
    Subjects.assertThat(view).sameAsText("fuga");
  }
}
