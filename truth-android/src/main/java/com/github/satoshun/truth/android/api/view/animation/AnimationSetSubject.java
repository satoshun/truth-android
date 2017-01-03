package com.github.satoshun.truth.android.api.view.animation;

import android.view.animation.AnimationSet;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class AnimationSetSubject extends AnimationSubject<AnimationSetSubject, AnimationSet> {

  public static final AnimationSetSubjectFactory FACTORY = new AnimationSetSubjectFactory();

  public AnimationSetSubject(FailureStrategy failureStrategy, AnimationSet actual) {
    super(failureStrategy, actual);
  }

  public AnimationSetSubject isDurationHint(long duration) {
    isNotNull();
    check().withFailureMessage("is duration hint")
        .that(actual().computeDurationHint())
        .isEqualTo(duration);
    return this;
  }

  public AnimationSetSubject isAnimationCount(int count) {
    isNotNull();
    check().withFailureMessage("is animation count")
        .that(actual().getAnimations().size())
        .isEqualTo(count);
    return this;
  }

  private static class AnimationSetSubjectFactory extends SubjectFactory<AnimationSetSubject, AnimationSet> {
    @Override
    public AnimationSetSubject getSubject(FailureStrategy fs, AnimationSet that) {
      return new AnimationSetSubject(fs, that);
    }
  }
}
