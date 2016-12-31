package com.github.satoshun.truth.android.api.widget;

import android.widget.RadioGroup;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class RadioGroupSubject extends LinearLayoutSubject<RadioGroupSubject, RadioGroup> {

  public static final RadioGroupSubjectFactory FACTORY = new RadioGroupSubjectFactory();

  public RadioGroupSubject(FailureStrategy failureStrategy, RadioGroup actual) {
    super(failureStrategy, actual);
  }

  public RadioGroupSubject isCheckedRadioButtonId(int id) {
    isNotNull();
    check().withFailureMessage("is checked radio button id")
        .that(actual().getCheckedRadioButtonId())
        .isEqualTo(id);
    return this;
  }

  private static class RadioGroupSubjectFactory extends SubjectFactory<RadioGroupSubject, RadioGroup> {
    @Override
    public RadioGroupSubject getSubject(FailureStrategy fs, RadioGroup that) {
      return new RadioGroupSubject(fs, that);
    }
  }
}
