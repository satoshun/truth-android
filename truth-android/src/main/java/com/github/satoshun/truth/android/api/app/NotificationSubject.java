package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.GINGERBREAD;
import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.KITKAT_WATCH;

public class NotificationSubject extends BaseSubject<NotificationSubject, Notification> {

  public static final NotificationSubjectFactory FACTORY = new NotificationSubjectFactory();

  public NotificationSubject(FailureStrategy failureStrategy, Notification actual) {
    super(failureStrategy, actual);
  }

  public NotificationSubject isContentIntent(PendingIntent intent) {
    isNotNull();
    check().withFailureMessage("is content intent")
        .that(actual().contentIntent)
        .isEqualTo(intent);
    return this;
  }

  public NotificationSubject isDefaults(int defaults) {
    isNotNull();
    check().withFailureMessage("is defaults")
        .that(actual().defaults)
        .isEqualTo(defaults);
    return this;
  }

  public NotificationSubject isDeleteIntent(PendingIntent intent) {
    isNotNull();
    check().withFailureMessage("is delete intent")
        .that(actual().deleteIntent)
        .isEqualTo(intent);
    return this;
  }

  public NotificationSubject isFlags(int flags) {
    isNotNull();
    check().withFailureMessage("is flags")
        .that(actual().flags & flags)
        .isEqualTo(flags);
    return this;
  }

  public NotificationSubject isOnlyFlags(int flags) {
    isNotNull();
    check().withFailureMessage("is only flags")
        .that(actual().flags)
        .isEqualTo(flags);
    return this;
  }

  @TargetApi(GINGERBREAD)
  public NotificationSubject isFullScreenIntent(PendingIntent intent) {
    isNotNull();
    check().withFailureMessage("is full screen intent")
        .that(actual().fullScreenIntent)
        .isEqualTo(intent);
    return this;
  }

  @TargetApi(KITKAT_WATCH)
  public NotificationSubject isGroup(String group) {
    isNotNull();
    check().withFailureMessage("is group")
        .that(actual().getGroup())
        .isEqualTo(group);
    return this;
  }

  public NotificationSubject isIcon(int resId) {
    isNotNull();
    check().withFailureMessage("is icon")
        .that(actual().icon)
        .isEqualTo(resId);
    return this;
  }

  public NotificationSubject hasIconLevel(int level) {
    isNotNull();
    check().withFailureMessage("is icon level")
        .that(actual().iconLevel)
        .isEqualTo(level);
    return this;
  }

  @TargetApi(HONEYCOMB)
  public NotificationSubject isLargeIcon(Bitmap bitmap) {
    isNotNull();
    check().withFailureMessage("is large icon")
        .that(actual().largeIcon)
        .isEqualTo(bitmap);
    return this;
  }

  public NotificationSubject isLedColor(int color) {
    isNotNull();
    check().withFailureMessage("is led color")
        .that(actual().ledARGB)
        .isEqualTo(color);
    return this;
  }

  public NotificationSubject isLedOffMs(int length) {
    isNotNull();
    check().withFailureMessage("is led off ms")
        .that(actual().ledOffMS)
        .isEqualTo(length);
    return this;
  }

  public NotificationSubject isLedOnMs(int length) {
    isNotNull();
    check().withFailureMessage("is led on ms")
        .that(actual().ledOnMS)
        .isEqualTo(length);
    return this;
  }

  public NotificationSubject isNumber(int number) {
    isNotNull();
    check().withFailureMessage("is number")
        .that(actual().number)
        .isEqualTo(number);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public NotificationSubject isPriority(int priority) {
    isNotNull();
    check().withFailureMessage("is priority")
        .that(actual().priority)
        .isEqualTo(priority);
    return this;
  }

  @TargetApi(KITKAT_WATCH)
  public NotificationSubject isSortKey(String sortKey) {
    isNotNull();
    check().withFailureMessage("is sort key")
        .that(actual().getSortKey())
        .isEqualTo(sortKey);
    return this;
  }

  public NotificationSubject isTickerText(CharSequence text) {
    isNotNull();
    check().withFailureMessage("is ticker text")
        .that(actual().tickerText)
        .isEqualTo(text);
    return this;
  }

  public NotificationSubject isVibration(long[] vibration) {
    isNotNull();
    check().withFailureMessage("is vibration")
        .that(actual().vibrate)
        .isEqualTo(vibration);
    return this;
  }

  public NotificationSubject isWhen(long when) {
    isNotNull();
    check().withFailureMessage("is when")
        .that(actual().when)
        .isEqualTo(when);
    return this;
  }

  private static class NotificationSubjectFactory extends SubjectFactory<NotificationSubject, Notification> {
    @Override
    public NotificationSubject getSubject(FailureStrategy fs, Notification that) {
      return new NotificationSubject(fs, that);
    }
  }
}
