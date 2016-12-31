package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.widget.TimePicker;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.M;

public class TimePickerSubject extends FrameLayoutSubject<TimePickerSubject, TimePicker> {

  public static final TimePickerSubjectFactory FACTORY = new TimePickerSubjectFactory();

  public TimePickerSubject(FailureStrategy failureStrategy, TimePicker actual) {
    super(failureStrategy, actual);
  }

  public TimePickerSubject isCurrentHour(Integer hour) {
    isNotNull();
    check().withFailureMessage("is current hour")
        .that(actual().getCurrentHour())
        .isEqualTo(hour);
    return this;
  }

  public TimePickerSubject isCurrentMinute(Integer minute) {
    isNotNull();
    check().withFailureMessage("is current minute")
        .that(actual().getCurrentMinute())
        .isEqualTo(minute);
    return this;
  }

  @TargetApi(M)
  public TimePickerSubject isHour(int hour) {
    isNotNull();
    check().withFailureMessage("is hour")
        .that(actual().getHour())
        .isEqualTo(hour);
    return this;
  }

  @TargetApi(M)
  public TimePickerSubject isMinute(int minute) {
    isNotNull();
    check().withFailureMessage("is minute")
        .that(actual().getMinute())
        .isEqualTo(minute);
    return this;
  }

  public TimePickerSubject isIn24HourView() {
    isNotNull();
    check().withFailureMessage("is in 24 hour view")
        .that(actual().is24HourView())
        .isTrue();
    return this;
  }

  public TimePickerSubject isNotIn24HourView() {
    isNotNull();
    check().withFailureMessage("is not in 24 hour view")
        .that(actual().is24HourView())
        .isFalse();
    return this;
  }

  private static class TimePickerSubjectFactory extends SubjectFactory<TimePickerSubject, TimePicker> {
    @Override
    public TimePickerSubject getSubject(FailureStrategy fs, TimePicker that) {
      return new TimePickerSubject(fs, that);
    }
  }
}
