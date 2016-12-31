package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.CalendarView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;


public class CalendarViewSubject extends FrameLayoutSubject<CalendarViewSubject, CalendarView> {

  public static final CalendarViewSubjectFactory FACTORY = new CalendarViewSubjectFactory();

  public CalendarViewSubject(FailureStrategy failureStrategy, CalendarView actual) {
    super(failureStrategy, actual);
  }

  public CalendarViewSubject isDate(long date) {
    isNotNull();
    check().withFailureMessage("is date")
        .that(actual().getDate())
        .isEqualTo(date);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject isDateTextAppearance(int resId) {
    isNotNull();
    check().withFailureMessage("is date text appearance")
        .that(actual().getDateTextAppearance())
        .isEqualTo(resId);
    return this;
  }

  public CalendarViewSubject isFirstDayOfWeek(int day) {
    isNotNull();
    check().withFailureMessage("is first day of week")
        .that(actual().getFirstDayOfWeek())
        .isEqualTo(day);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject isFocusedMonthDateColor(int color) {
    isNotNull();
    check().withFailureMessage("is focused month date color")
        .that(actual().getFocusedMonthDateColor())
        .isEqualTo(color);
    return this;
  }

  public CalendarViewSubject isMaxDate(long date) {
    isNotNull();
    check().withFailureMessage("is max date")
        .that(actual().getMaxDate())
        .isEqualTo(date);
    return this;
  }

  public CalendarViewSubject isMinDate(long date) {
    isNotNull();
    check().withFailureMessage("is min date")
        .that(actual().getMinDate())
        .isEqualTo(date);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject isSelectedDateVerticalBar(Drawable drawable) {
    isNotNull();
    check().withFailureMessage("is selected date vertical bar")
        .that(actual().getSelectedDateVerticalBar())
        .isSameAs(drawable);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject isSelectedWeekBackgroundColor(int color) {
    isNotNull();
    check().withFailureMessage("is selected week background color")
        .that(actual().getSelectedWeekBackgroundColor())
        .isEqualTo(color);
    return this;
  }

  public CalendarViewSubject isShowingWeekNumber() {
    isNotNull();
    check().withFailureMessage("is showing week number")
        .that(actual().getShowWeekNumber())
        .isTrue();
    return this;
  }

  public CalendarViewSubject isNotShowingWeekNumber() {
    isNotNull();
    check().withFailureMessage("is not showing week number")
        .that(actual().getShowWeekNumber())
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject isShownWeekCount(int count) {
    isNotNull();
    check().withFailureMessage("is shown week count")
        .that(actual().getShownWeekCount())
        .isEqualTo(count);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject isUnfocusedMonthDateColor(int color) {
    isNotNull();
    check().withFailureMessage("is unfocused month date color")
        .that(actual().getUnfocusedMonthDateColor())
        .isEqualTo(color);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject isWeekDayTextAppearance(int resId) {
    isNotNull();
    check().withFailureMessage("is week day text appearance")
        .that(actual().getWeekDayTextAppearance())
        .isEqualTo(resId);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject isWeekNumberColor(int color) {
    isNotNull();
    check().withFailureMessage("is week number color")
        .that(actual().getWeekNumberColor())
        .isEqualTo(color);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject isWeekSeparatorLineColor(int color) {
    isNotNull();
    check().withFailureMessage("is week separator line color")
        .that(actual().getWeekSeparatorLineColor())
        .isEqualTo(color);
    return this;
  }

  private static class CalendarViewSubjectFactory extends SubjectFactory<CalendarViewSubject, CalendarView> {
    @Override
    public CalendarViewSubject getSubject(FailureStrategy fs, CalendarView that) {
      return new CalendarViewSubject(fs, that);
    }
  }
}
