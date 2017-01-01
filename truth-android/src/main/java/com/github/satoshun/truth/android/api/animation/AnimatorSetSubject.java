package com.github.satoshun.truth.android.api.animation;

import android.animation.AnimatorSet;
import android.annotation.TargetApi;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public class AnimatorSetSubject extends AnimatorSubject<AnimatorSetSubject, AnimatorSet> {

  public static final AnimatorSetSubjectFactory FACTORY = new AnimatorSetSubjectFactory();

  public AnimatorSetSubject(FailureStrategy failureStrategy, AnimatorSet actual) {
    super(failureStrategy, actual);
  }

  public AnimatorSetSubject isAnimatorCount(int count) {
    isNotNull();
    check().withFailureMessage("is animator count")
        .that(actual().getChildAnimations())
        .hasSize(count);
    return myself();
  }

  private static class AnimatorSetSubjectFactory extends SubjectFactory<AnimatorSetSubject, AnimatorSet> {
    @Override
    public AnimatorSetSubject getSubject(FailureStrategy fs, AnimatorSet that) {
      return new AnimatorSetSubject(fs, that);
    }
  }
}
