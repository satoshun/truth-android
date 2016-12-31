package com.github.satoshun.truth.android.api;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.accounts.Account;
import android.gesture.GestureOverlayView;
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
import android.widget.AbsSpinner;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HeaderViewListAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.VideoView;
import android.widget.ViewAnimator;
import android.widget.ViewFlipper;
import android.widget.WrapperListAdapter;

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
import com.github.satoshun.truth.android.api.widget.AbsSpinnerSubject;
import com.github.satoshun.truth.android.api.widget.AdapterSubject;
import com.github.satoshun.truth.android.api.widget.AdapterViewSubject;
import com.github.satoshun.truth.android.api.widget.ArrayAdapterSubject;
import com.github.satoshun.truth.android.api.widget.CalendarViewSubject;
import com.github.satoshun.truth.android.api.widget.CompoundButtonSubject;
import com.github.satoshun.truth.android.api.widget.CursorAdapterSubject;
import com.github.satoshun.truth.android.api.widget.DatePickerSubject;
import com.github.satoshun.truth.android.api.widget.EditTextSubject;
import com.github.satoshun.truth.android.api.widget.FrameLayoutSubject;
import com.github.satoshun.truth.android.api.widget.GestureOverlayViewSubject;
import com.github.satoshun.truth.android.api.widget.GridViewSubject;
import com.github.satoshun.truth.android.api.widget.HeaderViewListAdapterSubject;
import com.github.satoshun.truth.android.api.widget.HorizontalScrollViewSubject;
import com.github.satoshun.truth.android.api.widget.ImageViewSubject;
import com.github.satoshun.truth.android.api.widget.LinearLayoutSubject;
import com.github.satoshun.truth.android.api.widget.ListAdapterSubject;
import com.github.satoshun.truth.android.api.widget.ListPopupWindowSubject;
import com.github.satoshun.truth.android.api.widget.ListViewSubject;
import com.github.satoshun.truth.android.api.widget.MediaControllerSubject;
import com.github.satoshun.truth.android.api.widget.ProgressBarSubject;
import com.github.satoshun.truth.android.api.widget.RatingBarSubject;
import com.github.satoshun.truth.android.api.widget.ScrollViewSubject;
import com.github.satoshun.truth.android.api.widget.SearchViewSubject;
import com.github.satoshun.truth.android.api.widget.SimpleCursorAdapterSubject;
import com.github.satoshun.truth.android.api.widget.SpinnerSubject;
import com.github.satoshun.truth.android.api.widget.SwitchSubject;
import com.github.satoshun.truth.android.api.widget.TabHostSubject;
import com.github.satoshun.truth.android.api.widget.TabWidgetSubject;
import com.github.satoshun.truth.android.api.widget.TableLayoutSubject;
import com.github.satoshun.truth.android.api.widget.TableRowSubject;
import com.github.satoshun.truth.android.api.widget.TextViewSubject;
import com.github.satoshun.truth.android.api.widget.TimePickerSubject;
import com.github.satoshun.truth.android.api.widget.ToastSubject;
import com.github.satoshun.truth.android.api.widget.ToggleButtonSubject;
import com.github.satoshun.truth.android.api.widget.VideoViewSubject;
import com.github.satoshun.truth.android.api.widget.ViewAnimatorSubject;
import com.github.satoshun.truth.android.api.widget.ViewFlipperSubject;
import com.github.satoshun.truth.android.api.widget.WrapperListAdapterSubject;
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

  public static ImageViewSubject assertThat(ImageView target) {
    return Truth.assertAbout(ImageViewSubject.FACTORY).that(target);
  }

  public static LinearLayoutSubject assertThat(LinearLayout target) {
    return Truth.assertAbout(LinearLayoutSubject.FACTORY).that(target);
  }

  public static AdapterSubject assertThat(Adapter target) {
    return Truth.assertAbout(AdapterSubject.FACTORY).that(target);
  }

  public static ListAdapterSubject assertThat(ListAdapter target) {
    return Truth.assertAbout(ListAdapterSubject.FACTORY).that(target);
  }

  public static ArrayAdapterSubject assertThat(ArrayAdapter target) {
    return Truth.assertAbout(ArrayAdapterSubject.FACTORY).that(target);
  }

  public static CursorAdapterSubject assertThat(CursorAdapter target) {
    return Truth.assertAbout(CursorAdapterSubject.FACTORY).that(target);
  }

  public static SimpleCursorAdapterSubject assertThat(SimpleCursorAdapter target) {
    return Truth.assertAbout(SimpleCursorAdapterSubject.FACTORY).that(target);
  }

  public static WrapperListAdapterSubject assertThat(WrapperListAdapter target) {
    return Truth.assertAbout(WrapperListAdapterSubject.FACTORY).that(target);
  }

  public static HeaderViewListAdapterSubject assertThat(HeaderViewListAdapter target) {
    return Truth.assertAbout(HeaderViewListAdapterSubject.FACTORY).that(target);
  }

  public static ListPopupWindowSubject assertThat(ListPopupWindow target) {
    return Truth.assertAbout(ListPopupWindowSubject.FACTORY).that(target);
  }

  public static FrameLayoutSubject assertThat(FrameLayout target) {
    return Truth.assertAbout(FrameLayoutSubject.FACTORY).that(target);
  }

  public static CalendarViewSubject assertThat(CalendarView target) {
    return Truth.assertAbout(CalendarViewSubject.FACTORY).that(target);
  }

  public static DatePickerSubject assertThat(DatePicker target) {
    return Truth.assertAbout(DatePickerSubject.FACTORY).that(target);
  }

  public static GestureOverlayViewSubject assertThat(GestureOverlayView target) {
    return Truth.assertAbout(GestureOverlayViewSubject.FACTORY).that(target);
  }

  public static ScrollViewSubject assertThat(ScrollView target) {
    return Truth.assertAbout(ScrollViewSubject.FACTORY).that(target);
  }

  public static TabHostSubject assertThat(TabHost target) {
    return Truth.assertAbout(TabHostSubject.FACTORY).that(target);
  }

  public static TimePickerSubject assertThat(TimePicker target) {
    return Truth.assertAbout(TimePickerSubject.FACTORY).that(target);
  }

  public static MediaControllerSubject assertThat(MediaController target) {
    return Truth.assertAbout(MediaControllerSubject.FACTORY).that(target);
  }

  public static HorizontalScrollViewSubject assertThat(HorizontalScrollView target) {
    return Truth.assertAbout(HorizontalScrollViewSubject.FACTORY).that(target);
  }

  public static AbsListViewSubject assertThat(AbsListView target) {
    return Truth.assertAbout(AbsListViewSubject.FACTORY).that(target);
  }

  public static ListViewSubject assertThat(ListView target) {
    return Truth.assertAbout(ListViewSubject.FACTORY).that(target);
  }

  public static <T extends Adapter> AdapterViewSubject assertThat(AdapterView<T> target) {
    return Truth.assertAbout(AdapterViewSubject.FACTORY).that(target);
  }

  public static TableLayoutSubject assertThat(TableLayout target) {
    return Truth.assertAbout(TableLayoutSubject.FACTORY).that(target);
  }

  public static VideoViewSubject assertThat(VideoView target) {
    return Truth.assertAbout(VideoViewSubject.FACTORY).that(target);
  }

  public static ViewAnimatorSubject assertThat(ViewAnimator target) {
    return Truth.assertAbout(ViewAnimatorSubject.FACTORY).that(target);
  }

  public static ViewFlipperSubject assertThat(ViewFlipper target) {
    return Truth.assertAbout(ViewFlipperSubject.FACTORY).that(target);
  }

  public static ToastSubject assertThat(Toast target) {
    return Truth.assertAbout(ToastSubject.FACTORY).that(target);
  }

  public static TabWidgetSubject assertThat(TabWidget target) {
    return Truth.assertAbout(TabWidgetSubject.FACTORY).that(target);
  }

  public static TableRowSubject assertThat(TableRow target) {
    return Truth.assertAbout(TableRowSubject.FACTORY).that(target);
  }

  public static AbsSpinnerSubject assertThat(AbsSpinner target) {
    return Truth.assertAbout(AbsSpinnerSubject.FACTORY).that(target);
  }

  public static SpinnerSubject assertThat(Spinner target) {
    return Truth.assertAbout(SpinnerSubject.FACTORY).that(target);
  }

  public static SearchViewSubject assertThat(SearchView target) {
    return Truth.assertAbout(SearchViewSubject.FACTORY).that(target);
  }
}
