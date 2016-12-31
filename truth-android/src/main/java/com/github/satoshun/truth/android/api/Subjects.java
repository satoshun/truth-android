package com.github.satoshun.truth.android.api;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.accounts.Account;
import android.net.Uri;
import android.text.BidiFormatter;
import android.view.ActionMode;
import android.view.ActionProvider;
import android.view.Display;
import android.view.DragEvent;
import android.view.InputEvent;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AbsSeekBar;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.github.satoshun.truth.android.api.accessibilityservice.AccessibilityServiceInfoSubject;
import com.github.satoshun.truth.android.api.accounts.AccountSubject;
import com.github.satoshun.truth.android.api.net.UriSubject;
import com.github.satoshun.truth.android.api.text.BidiFormatterSubject;
import com.github.satoshun.truth.android.api.view.ActionModeSubject;
import com.github.satoshun.truth.android.api.view.ActionProviderSubject;
import com.github.satoshun.truth.android.api.view.DisplaySubject;
import com.github.satoshun.truth.android.api.view.DragEventSubject;
import com.github.satoshun.truth.android.api.view.InputEventSubject;
import com.github.satoshun.truth.android.api.view.KeyCharacterMapSubject;
import com.github.satoshun.truth.android.api.view.KeyEventSubject;
import com.github.satoshun.truth.android.api.view.MenuItemSubject;
import com.github.satoshun.truth.android.api.view.MenuSubject;
import com.github.satoshun.truth.android.api.view.OrientationEventListenerSubject;
import com.github.satoshun.truth.android.api.view.ScaleGestureDetectorSubject;
import com.github.satoshun.truth.android.api.view.SurfaceSubject;
import com.github.satoshun.truth.android.api.view.TextureViewSubject;
import com.github.satoshun.truth.android.api.view.VelocityTrackerSubject;
import com.github.satoshun.truth.android.api.view.ViewConfigurationSubject;
import com.github.satoshun.truth.android.api.view.ViewGroupLayoutParamsSubject;
import com.github.satoshun.truth.android.api.view.ViewGroupSubject;
import com.github.satoshun.truth.android.api.view.ViewPropertyAnimatorSubject;
import com.github.satoshun.truth.android.api.view.ViewStubSubject;
import com.github.satoshun.truth.android.api.view.ViewSubject;
import com.github.satoshun.truth.android.api.view.ViewTreeObserverSubject;
import com.github.satoshun.truth.android.api.view.WindowSubject;
import com.github.satoshun.truth.android.api.webkit.WebViewSubject;
import com.github.satoshun.truth.android.api.widget.AbsListViewSubject;
import com.github.satoshun.truth.android.api.widget.AbsSeekBarSubject;
import com.github.satoshun.truth.android.api.widget.AdapterViewSubject;
import com.github.satoshun.truth.android.api.widget.CompoundButtonSubject;
import com.github.satoshun.truth.android.api.widget.EditTextSubject;
import com.github.satoshun.truth.android.api.widget.GridViewSubject;
import com.github.satoshun.truth.android.api.widget.ListViewSubject;
import com.github.satoshun.truth.android.api.widget.ProgressBarSubject;
import com.github.satoshun.truth.android.api.widget.RatingBarSubject;
import com.github.satoshun.truth.android.api.widget.SwitchSubject;
import com.github.satoshun.truth.android.api.widget.TextViewSubject;
import com.github.satoshun.truth.android.api.widget.ToggleButtonSubject;
import com.google.common.truth.Truth;

public class Subjects {

  public static AccessibilityServiceInfoSubject assertThat(AccessibilityServiceInfo target) {
    return Truth.assertAbout(AccessibilityServiceInfoSubject.FACTORY).that(target);
  }

  public static ViewSubject assertThat(View target) {
    return Truth.assertAbout(ViewSubject.FACTORY).that(target);
  }

  public static ViewGroupSubject assertThat(ViewGroup target) {
    return Truth.assertAbout(ViewGroupSubject.FACTORY).that(target);
  }

  public static <T extends Adapter> AdapterViewSubject assertThat(AdapterView<T> target) {
    return Truth.assertAbout(AdapterViewSubject.FACTORY).that(target);
  }

  public static AbsListViewSubject assertThat(AbsListView target) {
    return Truth.assertAbout(AbsListViewSubject.FACTORY).that(target);
  }

  public static ListViewSubject assertThat(ListView target) {
    return Truth.assertAbout(ListViewSubject.FACTORY).that(target);
  }

  public static WebViewSubject assertThat(WebView target) {
    return Truth.assertAbout(WebViewSubject.FACTORY).that(target);
  }

  public static UriSubject assertThat(Uri target) {
    return Truth.assertAbout(UriSubject.FACTORY).that(target);
  }

  public static AccountSubject assertThat(Account target) {
    return Truth.assertAbout(AccountSubject.FACTORY).that(target);
  }

  public static ViewPropertyAnimatorSubject assertThat(ViewPropertyAnimator target) {
    return Truth.assertAbout(ViewPropertyAnimatorSubject.FACTORY).that(target);
  }

  public static ViewTreeObserverSubject assertThat(ViewTreeObserver target) {
    return Truth.assertAbout(ViewTreeObserverSubject.FACTORY).that(target);
  }

  public static WindowSubject assertThat(Window target) {
    return Truth.assertAbout(WindowSubject.FACTORY).that(target);
  }

  public static MenuSubject assertThat(Menu target) {
    return Truth.assertAbout(MenuSubject.FACTORY).that(target);
  }

  public static MenuItemSubject assertThat(MenuItem target) {
    return Truth.assertAbout(MenuItemSubject.FACTORY).that(target);
  }

  public static InputEventSubject assertThat(InputEvent target) {
    return Truth.assertAbout(InputEventSubject.FACTORY).that(target);
  }

  public static KeyEventSubject assertThat(KeyEvent target) {
    return Truth.assertAbout(KeyEventSubject.FACTORY).that(target);
  }

  public static OrientationEventListenerSubject assertThat(OrientationEventListener target) {
    return Truth.assertAbout(OrientationEventListenerSubject.FACTORY).that(target);
  }

  public static ViewGroupLayoutParamsSubject assertThat(ViewGroup.LayoutParams target) {
    return Truth.assertAbout(ViewGroupLayoutParamsSubject.FACTORY).that(target);
  }

  public static SurfaceSubject assertThat(Surface target) {
    return Truth.assertAbout(SurfaceSubject.FACTORY).that(target);
  }

  public static ViewStubSubject assertThat(ViewStub target) {
    return Truth.assertAbout(ViewStubSubject.FACTORY).that(target);
  }

  public static ViewConfigurationSubject assertThat(ViewConfiguration target) {
    return Truth.assertAbout(ViewConfigurationSubject.FACTORY).that(target);
  }

  public static VelocityTrackerSubject assertThat(VelocityTracker target) {
    return Truth.assertAbout(VelocityTrackerSubject.FACTORY).that(target);
  }

  public static TextureViewSubject assertThat(TextureView target) {
    return Truth.assertAbout(TextureViewSubject.FACTORY).that(target);
  }

  public static ScaleGestureDetectorSubject assertThat(ScaleGestureDetector target) {
    return Truth.assertAbout(ScaleGestureDetectorSubject.FACTORY).that(target);
  }

  public static KeyCharacterMapSubject assertThat(KeyCharacterMap target) {
    return Truth.assertAbout(KeyCharacterMapSubject.FACTORY).that(target);
  }

  public static DragEventSubject assertThat(DragEvent target) {
    return Truth.assertAbout(DragEventSubject.FACTORY).that(target);
  }

  public static ActionModeSubject assertThat(ActionMode target) {
    return Truth.assertAbout(ActionModeSubject.FACTORY).that(target);
  }

  public static ActionProviderSubject assertThat(ActionProvider target) {
    return Truth.assertAbout(ActionProviderSubject.FACTORY).that(target);
  }

  public static DisplaySubject assertThat(Display target) {
    return Truth.assertAbout(DisplaySubject.FACTORY).that(target);
  }

  public static BidiFormatterSubject assertThat(BidiFormatter target) {
    return Truth.assertAbout(BidiFormatterSubject.FACTORY).that(target);
  }

  // widget

  public static TextViewSubject assertThat(TextView target) {
    return Truth.assertAbout(TextViewSubject.FACTORY).that(target);
  }

  public static EditTextSubject assertThat(EditText target) {
    return Truth.assertAbout(EditTextSubject.FACTORY).that(target);
  }

  public static ProgressBarSubject assertThat(ProgressBar target) {
    return Truth.assertAbout(ProgressBarSubject.FACTORY).that(target);
  }

  public static AbsSeekBarSubject assertThat(AbsSeekBar target) {
    return Truth.assertAbout(AbsSeekBarSubject.FACTORY).that(target);
  }

  public static RatingBarSubject assertThat(RatingBar target) {
    return Truth.assertAbout(RatingBarSubject.FACTORY).that(target);
  }

  public static CompoundButtonSubject assertThat(CompoundButton target) {
    return Truth.assertAbout(CompoundButtonSubject.FACTORY).that(target);
  }

  public static ToggleButtonSubject assertThat(ToggleButton target) {
    return Truth.assertAbout(ToggleButtonSubject.FACTORY).that(target);
  }

  public static SwitchSubject assertThat(Switch target) {
    return Truth.assertAbout(SwitchSubject.FACTORY).that(target);
  }

  public static GridViewSubject assertThat(GridView target) {
    return Truth.assertAbout(GridViewSubject.FACTORY).that(target);
  }
}
