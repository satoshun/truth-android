package com.github.satoshun.truth.android.api.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.animation.Animation;

import com.github.satoshun.truth.android.api.Subjects;

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
  public void sameAsAlpha_success() throws Exception {
    assumeVersion(HONEYCOMB);
    view.setAlpha((float) 0.45);
    Subjects.assertThat(view)
            .isAlpha((float) 0.45);
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void sameAsAlpha_failure() throws Exception {
    assumeVersion(HONEYCOMB);
    view.setAlpha((float) 0.45);
    Subjects.assertThat(view)
            .isAlpha((float) 0.451);
  }

  @UiThreadTest @Test
  public void sameAsAnimation_success() throws Exception {
    Animation animation = new Animation() {
    };
    view.setAnimation(animation);
    Subjects.assertThat(view)
            .isAnimation(animation);
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void sameAsAnimation_failure() throws Exception {
    view.setAnimation(new Animation() {
    });
    Subjects.assertThat(view)
            .isAnimation(new Animation() {
            });
  }

  @UiThreadTest @Test
  public void sameAsBackground_success() throws Exception {
    BitmapDrawable background = new BitmapDrawable();
    view.setBackgroundDrawable(background);
    Subjects.assertThat(view)
            .isBackground(background);
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void sameAsBackground_failure() throws Exception {
    view.setBackgroundDrawable(new BitmapDrawable());
    Subjects.assertThat(view)
            .isBackground(new BitmapDrawable());
  }

  @UiThreadTest @Test
  public void sameAsWidth_success() throws Exception {
    assumeVersion(HONEYCOMB);
    view.setRight(100);
    Subjects.assertThat(view)
            .isWidth(100);
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void sameAsWidth_failure() throws Exception {
    assumeVersion(HONEYCOMB);
    view.setRight(101);
    Subjects.assertThat(view)
            .isWidth(100);
  }

  @UiThreadTest @Test
  public void sameAsHeight_success() throws Exception {
    assumeVersion(HONEYCOMB);
    view.setBottom(200);
    Subjects.assertThat(view)
            .isHeight(200);
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void sameAsHeight_failure() throws Exception {
    assumeVersion(HONEYCOMB);
    view.setBottom(200);
    Subjects.assertThat(view)
            .isHeight(201);
  }

  @UiThreadTest @Test
  public void sameAsId_success() throws Exception {
    view.setId(100);
    Subjects.assertThat(view)
            .isId(100);
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void sameAsId_failure() throws Exception {
    assumeVersion(HONEYCOMB);
    view.setId(100);
    Subjects.assertThat(view)
            .isId(101);
  }

  @UiThreadTest @Test
  public void isVisible_success() throws Exception {
    view.setVisibility(View.VISIBLE);
    Subjects.assertThat(view)
            .isVisible();
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void isVisible_failure() throws Exception {
    view.setVisibility(View.INVISIBLE);
    Subjects.assertThat(view)
            .isVisible();
  }

  @UiThreadTest @Test
  public void isNotVisible_success() throws Exception {
    view.setVisibility(View.GONE);
    Subjects.assertThat(view)
            .isNotVisible();
  }

  @UiThreadTest @Test(expected = AssertionError.class)
  public void isNotVisible_failure() throws Exception {
    view.setVisibility(View.VISIBLE);
    Subjects.assertThat(view)
            .isNotVisible();
  }

  private static void assumeVersion(int versionCode) {
    assume().that(Build.VERSION.SDK_INT)
            .isGreaterThan(versionCode);
  }
}