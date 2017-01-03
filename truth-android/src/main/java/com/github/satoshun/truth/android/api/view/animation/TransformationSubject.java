package com.github.satoshun.truth.android.api.view.animation;

import android.graphics.Matrix;
import android.view.animation.Transformation;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class TransformationSubject extends BaseSubject<TransformationSubject, Transformation> {

  public static final TransformationSubjectFactory FACTORY = new TransformationSubjectFactory();

  public TransformationSubject(FailureStrategy failureStrategy, Transformation actual) {
    super(failureStrategy, actual);
  }

  public TransformationSubject isAlpha(float alpha) {
    isNotNull();
    check().withFailureMessage("is alpha")
        .that(actual().getAlpha())
        .isEqualTo(alpha);
    return this;
  }

  public TransformationSubject isMatrix(Matrix matrix) {
    isNotNull();
    check().withFailureMessage("is matrix")
        .that(actual().getMatrix())
        .isEqualTo(matrix);
    return this;
  }

  public TransformationSubject isTransformationType(int type) {
    isNotNull();
    check().withFailureMessage("is transformation type")
        .that(actual().getTransformationType())
        .isEqualTo(type);
    return this;
  }

  private static class TransformationSubjectFactory extends SubjectFactory<TransformationSubject, Transformation> {
    @Override
    public TransformationSubject getSubject(FailureStrategy fs, Transformation that) {
      return new TransformationSubject(fs, that);
    }
  }
}
