package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.widget.DatePicker;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

public class DatePickerSubject extends FrameLayoutSubject<DatePickerSubject, DatePicker> {

  public static final DatePickerSubjectFactory FACTORY = new DatePickerSubjectFactory();

  public DatePickerSubject(FailureStrategy failureStrategy, DatePicker actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB)
  public DatePickerSubject isShowingCalendarView() {
    isNotNull();
    check().withFailureMessage("is showing calendar view")
        .that(actual().getCalendarViewShown())
        .isTrue();
    return this;
  }

  @TargetApi(HONEYCOMB)
  public DatePickerSubject isNotShowingCalendarView() {
    isNotNull();
    check().withFailureMessage("is not showing calendar view")
        .that(actual().getCalendarViewShown())
        .isFalse();
    return this;
  }

  public DatePickerSubject isDayOfMonth(int day) {
    isNotNull();
    check().withFailureMessage("is day of month")
        .that(actual().getDayOfMonth())
        .isEqualTo(day);
    return this;
  }

  @TargetApi(HONEYCOMB)
  public DatePickerSubject isMaxDate(long date) {
    isNotNull();
    check().withFailureMessage("is max date")
        .that(actual().getMaxDate())
        .isEqualTo(date);
    return this;
  }

  @TargetApi(HONEYCOMB)
  public DatePickerSubject isMinDate(long date) {
    isNotNull();
    check().withFailureMessage("is min date")
        .that(actual().getMinDate())
        .isEqualTo(date);
    return this;
  }

  public DatePickerSubject isMonth(int month) {
    isNotNull();
    check().withFailureMessage("is month")
        .that(actual().getMonth())
        .isEqualTo(month);
    return this;
  }

  @TargetApi(HONEYCOMB)
  public DatePickerSubject isShowingSpinners() {
    isNotNull();
    check().withFailureMessage("is showing spinners")
        .that(actual().getSpinnersShown())
        .isTrue();
    return this;
  }

  @TargetApi(HONEYCOMB)
  public DatePickerSubject isNotShowingSpinners() {
    isNotNull();
    check().withFailureMessage("is not showing spinners")
        .that(actual().getSpinnersShown())
        .isFalse();
    return this;
  }

  public DatePickerSubject isYear(int year) {
    isNotNull();
    check().withFailureMessage("is year")
        .that(actual().getYear())
        .isEqualTo(year);
    return this;
  }

  private static class DatePickerSubjectFactory extends SubjectFactory<DatePickerSubject, DatePicker> {
    @Override
    public DatePickerSubject getSubject(FailureStrategy fs, DatePicker that) {
      return new DatePickerSubject(fs, that);
    }
  }
}
