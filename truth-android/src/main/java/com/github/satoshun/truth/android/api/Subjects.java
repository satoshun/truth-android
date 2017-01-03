package com.github.satoshun.truth.android.api;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.accounts.Account;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ExpandableListActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Instrumentation;
import android.app.KeyguardManager;
import android.app.ListActivity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.app.UiModeManager;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.AsyncTaskLoader;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.gesture.GestureOverlayView;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.text.BidiFormatter;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.Property;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
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
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AbsSeekBar;
import android.widget.AbsSpinner;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;
import android.widget.CheckedTextView;
import android.widget.Chronometer;
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
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
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
import com.github.satoshun.truth.android.api.animation.AnimatorSetSubject;
import com.github.satoshun.truth.android.api.animation.AnimatorSubject;
import com.github.satoshun.truth.android.api.animation.KeyframeSubject;
import com.github.satoshun.truth.android.api.animation.ObjectAnimatorSubject;
import com.github.satoshun.truth.android.api.animation.PropertyValuesHolderSubject;
import com.github.satoshun.truth.android.api.animation.ValueAnimatorSubject;
import com.github.satoshun.truth.android.api.app.ActionBarSubject;
import com.github.satoshun.truth.android.api.app.ActivityMonitorSubject;
import com.github.satoshun.truth.android.api.app.ActivityResultSubject;
import com.github.satoshun.truth.android.api.app.ActivitySubject;
import com.github.satoshun.truth.android.api.app.DialogFragmentSubject;
import com.github.satoshun.truth.android.api.app.DialogSubject;
import com.github.satoshun.truth.android.api.app.ExpandableListActivitySubject;
import com.github.satoshun.truth.android.api.app.FragmentManagerSubject;
import com.github.satoshun.truth.android.api.app.FragmentSubject;
import com.github.satoshun.truth.android.api.app.FragmentTransactionSubject;
import com.github.satoshun.truth.android.api.app.KeyguardManagerSubject;
import com.github.satoshun.truth.android.api.app.ListActivitySubject;
import com.github.satoshun.truth.android.api.app.ListFragmentSubject;
import com.github.satoshun.truth.android.api.app.LoaderManagerSubject;
import com.github.satoshun.truth.android.api.app.NotificationSubject;
import com.github.satoshun.truth.android.api.app.PendingIntentSubject;
import com.github.satoshun.truth.android.api.app.ProgressDialogSubject;
import com.github.satoshun.truth.android.api.app.ServiceSubject;
import com.github.satoshun.truth.android.api.app.TaskStackBuilderSubject;
import com.github.satoshun.truth.android.api.app.UiModeManagerSubject;
import com.github.satoshun.truth.android.api.bluetooth.BluetoothClassSubject;
import com.github.satoshun.truth.android.api.bluetooth.BluetoothDeviceSubject;
import com.github.satoshun.truth.android.api.content.AsyncTaskLoaderSubject;
import com.github.satoshun.truth.android.api.content.ContentValuesSubject;
import com.github.satoshun.truth.android.api.content.ContextSubject;
import com.github.satoshun.truth.android.api.content.CursorLoaderSubject;
import com.github.satoshun.truth.android.api.content.IntentSubject;
import com.github.satoshun.truth.android.api.content.LoaderSubject;
import com.github.satoshun.truth.android.api.content.SharedPreferencesSubject;
import com.github.satoshun.truth.android.api.content.res.ConfigurationSubject;
import com.github.satoshun.truth.android.api.database.AbstractCursorSubject;
import com.github.satoshun.truth.android.api.database.CursorSubject;
import com.github.satoshun.truth.android.api.database.CursorWindowSubject;
import com.github.satoshun.truth.android.api.database.sqlite.SQLiteDatabaseSubject;
import com.github.satoshun.truth.android.api.net.UriSubject;
import com.github.satoshun.truth.android.api.os.AsyncTaskSubject;
import com.github.satoshun.truth.android.api.os.BundleSubject;
import com.github.satoshun.truth.android.api.os.PowerManagerSubject;
import com.github.satoshun.truth.android.api.os.VibratorSubject;
import com.github.satoshun.truth.android.api.text.BidiFormatterSubject;
import com.github.satoshun.truth.android.api.util.ArrayMapSubject;
import com.github.satoshun.truth.android.api.util.AtomicFileSubject;
import com.github.satoshun.truth.android.api.util.AttributeSetSubject;
import com.github.satoshun.truth.android.api.util.DisplayMetricsSubject;
import com.github.satoshun.truth.android.api.util.LongSparseArraySubject;
import com.github.satoshun.truth.android.api.util.PairSubject;
import com.github.satoshun.truth.android.api.util.PropertySubject;
import com.github.satoshun.truth.android.api.util.SparseArraySubject;
import com.github.satoshun.truth.android.api.util.SparseBooleanArraySubject;
import com.github.satoshun.truth.android.api.util.SparseIntArraySubject;
import com.github.satoshun.truth.android.api.util.SparseLongArraySubject;
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
import com.github.satoshun.truth.android.api.view.accessibility.AccessibilityEventSubject;
import com.github.satoshun.truth.android.api.view.accessibility.AccessibilityManagerSubject;
import com.github.satoshun.truth.android.api.view.accessibility.AccessibilityNodeInfoSubject;
import com.github.satoshun.truth.android.api.view.accessibility.AccessibilityRecordSubject;
import com.github.satoshun.truth.android.api.view.animation.AnimationSetSubject;
import com.github.satoshun.truth.android.api.view.animation.AnimationSubject;
import com.github.satoshun.truth.android.api.view.animation.GridLayoutAnimationControllerSubject;
import com.github.satoshun.truth.android.api.view.animation.LayoutAnimationControllerSubject;
import com.github.satoshun.truth.android.api.view.animation.TransformationSubject;
import com.github.satoshun.truth.android.api.webkit.WebViewSubject;
import com.github.satoshun.truth.android.api.widget.AbsListViewSubject;
import com.github.satoshun.truth.android.api.widget.AbsSeekBarSubject;
import com.github.satoshun.truth.android.api.widget.AbsSpinnerSubject;
import com.github.satoshun.truth.android.api.widget.AdapterSubject;
import com.github.satoshun.truth.android.api.widget.AdapterViewSubject;
import com.github.satoshun.truth.android.api.widget.ArrayAdapterSubject;
import com.github.satoshun.truth.android.api.widget.AutoCompleteTextViewSubject;
import com.github.satoshun.truth.android.api.widget.CalendarViewSubject;
import com.github.satoshun.truth.android.api.widget.CheckedTextViewSubject;
import com.github.satoshun.truth.android.api.widget.ChronometerSubject;
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
import com.github.satoshun.truth.android.api.widget.NumberPickerSubject;
import com.github.satoshun.truth.android.api.widget.ProgressBarSubject;
import com.github.satoshun.truth.android.api.widget.RadioGroupSubject;
import com.github.satoshun.truth.android.api.widget.RatingBarSubject;
import com.github.satoshun.truth.android.api.widget.RelativeLayoutSubject;
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

  public static RadioGroupSubject assertThat(RadioGroup target) {
    return Truth.assertAbout(RadioGroupSubject.FACTORY).that(target);
  }

  public static RelativeLayoutSubject assertThat(RelativeLayout target) {
    return Truth.assertAbout(RelativeLayoutSubject.FACTORY).that(target);
  }

  public static NumberPickerSubject assertThat(NumberPicker target) {
    return Truth.assertAbout(NumberPickerSubject.FACTORY).that(target);
  }

  public static CheckedTextViewSubject assertThat(CheckedTextView target) {
    return Truth.assertAbout(CheckedTextViewSubject.FACTORY).that(target);
  }

  public static ChronometerSubject assertThat(Chronometer target) {
    return Truth.assertAbout(ChronometerSubject.FACTORY).that(target);
  }

  public static AutoCompleteTextViewSubject assertThat(AutoCompleteTextView target) {
    return Truth.assertAbout(AutoCompleteTextViewSubject.FACTORY).that(target);
  }

  // content

  public static ContextSubject assertThat(Context target) {
    return Truth.assertAbout(ContextSubject.FACTORY).that(target);
  }

  public static IntentSubject assertThat(Intent target) {
    return Truth.assertAbout(IntentSubject.FACTORY).that(target);
  }

  public static SharedPreferencesSubject assertThat(SharedPreferences target) {
    return Truth.assertAbout(SharedPreferencesSubject.FACTORY).that(target);
  }

  public static ContentValuesSubject assertThat(ContentValues target) {
    return Truth.assertAbout(ContentValuesSubject.FACTORY).that(target);
  }

  public static LoaderSubject assertThat(Loader target) {
    return Truth.assertAbout(LoaderSubject.FACTORY).that(target);
  }

  public static CursorLoaderSubject assertThat(CursorLoader target) {
    return Truth.assertAbout(CursorLoaderSubject.FACTORY).that(target);
  }

  public static AsyncTaskLoaderSubject assertThat(AsyncTaskLoader target) {
    return Truth.assertAbout(AsyncTaskLoaderSubject.FACTORY).that(target);
  }

  //// content.res

  public static ConfigurationSubject assertThat(Configuration target) {
    return Truth.assertAbout(ConfigurationSubject.FACTORY).that(target);
  }

  // database

  public static CursorSubject assertThat(Cursor target) {
    return Truth.assertAbout(CursorSubject.FACTORY).that(target);
  }

  public static AbstractCursorSubject assertThat(AbstractCursor target) {
    return Truth.assertAbout(AbstractCursorSubject.FACTORY).that(target);
  }

  public static CursorWindowSubject assertThat(CursorWindow target) {
    return Truth.assertAbout(CursorWindowSubject.FACTORY).that(target);
  }

  //// database.sqlite

  public static SQLiteDatabaseSubject assertThat(SQLiteDatabase target) {
    return Truth.assertAbout(SQLiteDatabaseSubject.FACTORY).that(target);
  }

  // animation

  public static AnimatorSubject assertThat(Animator target) {
    return Truth.assertAbout(AnimatorSubject.FACTORY).that(target);
  }

  public static ValueAnimatorSubject assertThat(ValueAnimator target) {
    return Truth.assertAbout(ValueAnimatorSubject.FACTORY).that(target);
  }

  public static ObjectAnimatorSubject assertThat(ObjectAnimator target) {
    return Truth.assertAbout(ObjectAnimatorSubject.FACTORY).that(target);
  }

  public static PropertyValuesHolderSubject assertThat(PropertyValuesHolder target) {
    return Truth.assertAbout(PropertyValuesHolderSubject.FACTORY).that(target);
  }

  public static AnimatorSetSubject assertThat(AnimatorSet target) {
    return Truth.assertAbout(AnimatorSetSubject.FACTORY).that(target);
  }

  public static KeyframeSubject assertThat(Keyframe target) {
    return Truth.assertAbout(KeyframeSubject.FACTORY).that(target);
  }

  // app

  public static ActivitySubject assertThat(Activity target) {
    return Truth.assertAbout(ActivitySubject.FACTORY).that(target);
  }

  public static ListActivitySubject assertThat(ListActivity target) {
    return Truth.assertAbout(ListActivitySubject.FACTORY).that(target);
  }

  public static ExpandableListActivitySubject assertThat(ExpandableListActivity target) {
    return Truth.assertAbout(ExpandableListActivitySubject.FACTORY).that(target);
  }

  public static FragmentSubject assertThat(Fragment target) {
    return Truth.assertAbout(FragmentSubject.FACTORY).that(target);
  }

  public static ListFragmentSubject assertThat(ListFragment target) {
    return Truth.assertAbout(ListFragmentSubject.FACTORY).that(target);
  }

  public static FragmentManagerSubject assertThat(FragmentManager target) {
    return Truth.assertAbout(FragmentManagerSubject.FACTORY).that(target);
  }

  public static FragmentTransactionSubject assertThat(FragmentTransaction target) {
    return Truth.assertAbout(FragmentTransactionSubject.FACTORY).that(target);
  }

  public static DialogFragmentSubject assertThat(DialogFragment target) {
    return Truth.assertAbout(DialogFragmentSubject.FACTORY).that(target);
  }

  public static ServiceSubject assertThat(Service target) {
    return Truth.assertAbout(ServiceSubject.FACTORY).that(target);
  }

  public static DialogSubject assertThat(Dialog target) {
    return Truth.assertAbout(DialogSubject.FACTORY).that(target);
  }

  public static ProgressDialogSubject assertThat(ProgressDialog target) {
    return Truth.assertAbout(ProgressDialogSubject.FACTORY).that(target);
  }

  public static ActionBarSubject assertThat(ActionBar target) {
    return Truth.assertAbout(ActionBarSubject.FACTORY).that(target);
  }

  public static ActivityMonitorSubject assertThat(Instrumentation.ActivityMonitor target) {
    return Truth.assertAbout(ActivityMonitorSubject.FACTORY).that(target);
  }

  public static ActivityResultSubject assertThat(Instrumentation.ActivityResult target) {
    return Truth.assertAbout(ActivityResultSubject.FACTORY).that(target);
  }

  public static KeyguardManagerSubject assertThat(KeyguardManager target) {
    return Truth.assertAbout(KeyguardManagerSubject.FACTORY).that(target);
  }

  public static LoaderManagerSubject assertThat(LoaderManager target) {
    return Truth.assertAbout(LoaderManagerSubject.FACTORY).that(target);
  }

  public static NotificationSubject assertThat(Notification target) {
    return Truth.assertAbout(NotificationSubject.FACTORY).that(target);
  }

  public static PendingIntentSubject assertThat(PendingIntent target) {
    return Truth.assertAbout(PendingIntentSubject.FACTORY).that(target);
  }

  public static TaskStackBuilderSubject assertThat(TaskStackBuilder target) {
    return Truth.assertAbout(TaskStackBuilderSubject.FACTORY).that(target);
  }

  public static UiModeManagerSubject assertThat(UiModeManager target) {
    return Truth.assertAbout(UiModeManagerSubject.FACTORY).that(target);
  }

  // os

  public static AsyncTaskSubject assertThat(AsyncTask target) {
    return Truth.assertAbout(AsyncTaskSubject.FACTORY).that(target);
  }

  public static BundleSubject assertThat(Bundle target) {
    return Truth.assertAbout(BundleSubject.FACTORY).that(target);
  }

  public static PowerManagerSubject assertThat(PowerManager target) {
    return Truth.assertAbout(PowerManagerSubject.FACTORY).that(target);
  }

  public static VibratorSubject assertThat(Vibrator target) {
    return Truth.assertAbout(VibratorSubject.FACTORY).that(target);
  }

  // util

  @SuppressWarnings("unchecked")
  public static <K, V> ArrayMapSubject<K, V> assertThat(ArrayMap<K, V> target) {
    return (ArrayMapSubject<K, V>) Truth.assertAbout(ArrayMapSubject.FACTORY).that(target);
  }

  public static AtomicFileSubject assertThat(AtomicFile target) {
    return Truth.assertAbout(AtomicFileSubject.FACTORY).that(target);
  }

  public static AttributeSetSubject assertThat(AttributeSet target) {
    return Truth.assertAbout(AttributeSetSubject.FACTORY).that(target);
  }

  public static DisplayMetricsSubject assertThat(DisplayMetrics target) {
    return Truth.assertAbout(DisplayMetricsSubject.FACTORY).that(target);
  }

  public static LongSparseArraySubject assertThat(LongSparseArray target) {
    return Truth.assertAbout(LongSparseArraySubject.FACTORY).that(target);
  }

  @SuppressWarnings("unchecked")
  public static <F, S> PairSubject<F, S> assertThat(Pair<F, S> target) {
    return (PairSubject<F, S>) Truth.assertAbout(PairSubject.FACTORY).that(target);
  }

  @SuppressWarnings("unchecked")
  public static <T, V> PropertySubject<T, V> assertThat(Property<T, V> target) {
    return (PropertySubject<T, V>) Truth.assertAbout(PropertySubject.FACTORY).that(target);
  }

  @SuppressWarnings("unchecked")
  public static <E> SparseArraySubject<E> assertThat(SparseArray<E> target) {
    return (SparseArraySubject<E>) Truth.assertAbout(SparseArraySubject.FACTORY).that(target);
  }

  public static SparseBooleanArraySubject assertThat(SparseBooleanArray target) {
    return Truth.assertAbout(SparseBooleanArraySubject.FACTORY).that(target);
  }

  public static SparseIntArraySubject assertThat(SparseIntArray target) {
    return Truth.assertAbout(SparseIntArraySubject.FACTORY).that(target);
  }

  public static SparseLongArraySubject assertThat(SparseLongArray target) {
    return Truth.assertAbout(SparseLongArraySubject.FACTORY).that(target);
  }

  //// view.accessibility

  public static AccessibilityRecordSubject assertThat(AccessibilityRecord target) {
    return Truth.assertAbout(AccessibilityRecordSubject.FACTORY).that(target);
  }

  public static AccessibilityEventSubject assertThat(AccessibilityEvent target) {
    return Truth.assertAbout(AccessibilityEventSubject.FACTORY).that(target);
  }

  public static AccessibilityManagerSubject assertThat(AccessibilityManager target) {
    return Truth.assertAbout(AccessibilityManagerSubject.FACTORY).that(target);
  }

  public static AccessibilityNodeInfoSubject assertThat(AccessibilityNodeInfo target) {
    return Truth.assertAbout(AccessibilityNodeInfoSubject.FACTORY).that(target);
  }

  //// view.animation

  public static AnimationSubject assertThat(Animation target) {
    return Truth.assertAbout(AnimationSubject.FACTORY).that(target);
  }

  public static AnimationSetSubject assertThat(AnimationSet target) {
    return Truth.assertAbout(AnimationSetSubject.FACTORY).that(target);
  }

  public static LayoutAnimationControllerSubject assertThat(LayoutAnimationController target) {
    return Truth.assertAbout(LayoutAnimationControllerSubject.FACTORY).that(target);
  }

  public static GridLayoutAnimationControllerSubject assertThat(GridLayoutAnimationController target) {
    return Truth.assertAbout(GridLayoutAnimationControllerSubject.FACTORY).that(target);
  }

  public static TransformationSubject assertThat(Transformation target) {
    return Truth.assertAbout(TransformationSubject.FACTORY).that(target);
  }

  // bluetooth

  public static BluetoothClassSubject assertThat(BluetoothClass target) {
    return Truth.assertAbout(BluetoothClassSubject.FACTORY).that(target);
  }
  
  public static BluetoothDeviceSubject assertThat(BluetoothDevice target) {
    return Truth.assertAbout(BluetoothDeviceSubject.FACTORY).that(target);
  }
}
