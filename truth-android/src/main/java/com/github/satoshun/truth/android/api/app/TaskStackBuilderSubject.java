package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.TaskStackBuilder;
import android.content.Intent;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.Arrays;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

@TargetApi(JELLY_BEAN)
public class TaskStackBuilderSubject extends BaseSubject<TaskStackBuilderSubject, TaskStackBuilder> {

  public static final TaskStackBuilderSubjectFactory FACTORY = new TaskStackBuilderSubjectFactory();

  public TaskStackBuilderSubject(FailureStrategy failureStrategy, TaskStackBuilder actual) {
    super(failureStrategy, actual);
  }

  public TaskStackBuilderSubject isIntentCount(int count) {
    isNotNull();
    check().withFailureMessage("is intent count")
        .that(actual().getIntentCount())
        .isEqualTo(count);
    return this;
  }

  public TaskStackBuilderSubject containsIntents(Intent... intents) {
    isNotNull();
    check().withFailureMessage("containts intents")
        .that(actual().getIntents())
        .asList().contains(Arrays.asList(intents));
    return this;
  }

  private static class TaskStackBuilderSubjectFactory extends SubjectFactory<TaskStackBuilderSubject, TaskStackBuilder> {
    @Override
    public TaskStackBuilderSubject getSubject(FailureStrategy fs, TaskStackBuilder that) {
      return new TaskStackBuilderSubject(fs, that);
    }
  }
}
