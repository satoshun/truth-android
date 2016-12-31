package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.widget.NumberPicker;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class NumberPickerSubject extends LinearLayoutSubject<NumberPickerSubject, NumberPicker> {

  public static final NumberPickerSubjectFactory FACTORY = new NumberPickerSubjectFactory();

  public NumberPickerSubject(FailureStrategy failureStrategy, NumberPicker actual) {
    super(failureStrategy, actual);
  }

  public NumberPickerSubject isDisplayedValues(String[] values) {
    isNotNull();
    check().withFailureMessage("is displayed values")
        .that(actual().getDisplayedValues())
        .isEqualTo(values);
    return this;
  }

  public NumberPickerSubject isMaxValue(int value) {
    isNotNull();
    check().withFailureMessage("is max value")
        .that(actual().getMaxValue())
        .isEqualTo(value);
    return this;
  }

  public NumberPickerSubject isMinValue(int value) {
    isNotNull();
    check().withFailureMessage("is min value")
        .that(actual().getMinValue())
        .isEqualTo(value);
    return this;
  }

  public NumberPickerSubject isValue(int value) {
    isNotNull();
    check().withFailureMessage("is value")
        .that(actual().getValue())
        .isEqualTo(value);
    return this;
  }

  public NumberPickerSubject isWrappingSelectorWheel() {
    isNotNull();
    check().withFailureMessage("is wrapping selector wheel")
        .that(actual().getWrapSelectorWheel())
        .isTrue();
    return this;
  }

  public NumberPickerSubject isNotWrappingSelectorWheel() {
    isNotNull();
    check().withFailureMessage("is not wrapping selector wheel")
        .that(actual().getWrapSelectorWheel())
        .isFalse();
    return this;
  }

  private static class NumberPickerSubjectFactory extends SubjectFactory<NumberPickerSubject, NumberPicker> {
    @Override
    public NumberPickerSubject getSubject(FailureStrategy fs, NumberPicker that) {
      return new NumberPickerSubject(fs, that);
    }
  }
}
