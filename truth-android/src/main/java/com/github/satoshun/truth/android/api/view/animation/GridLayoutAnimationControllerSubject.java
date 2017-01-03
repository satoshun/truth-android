package com.github.satoshun.truth.android.api.view.animation;

import android.view.animation.GridLayoutAnimationController;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class GridLayoutAnimationControllerSubject extends LayoutAnimationControllerSubject<GridLayoutAnimationControllerSubject, GridLayoutAnimationController> {

  public static final GridLayoutAnimationControllerSubjectFactory FACTORY = new GridLayoutAnimationControllerSubjectFactory();

  public GridLayoutAnimationControllerSubject(FailureStrategy failureStrategy, GridLayoutAnimationController actual) {
    super(failureStrategy, actual);
  }

  public GridLayoutAnimationControllerSubject isColumnDelay(float delay) {
    isNotNull();
    check().withFailureMessage("is column delay")
        .that(actual().getColumnDelay())
        .isEqualTo(delay);
    return this;
  }

  public GridLayoutAnimationControllerSubject isDirection(int direction) {
    isNotNull();
    check().withFailureMessage("is direction")
        .that(actual().getDirection())
        .isEqualTo(direction);
    return this;
  }

  public GridLayoutAnimationControllerSubject isDirectionPriority(int priority) {
    isNotNull();
    check().withFailureMessage("is direction priority")
        .that(actual().getDirectionPriority())
        .isEqualTo(priority);
    return this;
  }

  public GridLayoutAnimationControllerSubject isRowDelay(float delay) {
    isNotNull();
    check().withFailureMessage("is row delay")
        .that(actual().getRowDelay())
        .isEqualTo(delay);
    return this;
  }

  private static class GridLayoutAnimationControllerSubjectFactory extends SubjectFactory<GridLayoutAnimationControllerSubject, GridLayoutAnimationController> {
    @Override
    public GridLayoutAnimationControllerSubject getSubject(FailureStrategy fs, GridLayoutAnimationController that) {
      return new GridLayoutAnimationControllerSubject(fs, that);
    }
  }
}
