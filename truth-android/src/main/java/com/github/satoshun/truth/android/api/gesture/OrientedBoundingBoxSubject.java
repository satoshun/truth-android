package com.github.satoshun.truth.android.api.gesture;

import android.gesture.OrientedBoundingBox;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class OrientedBoundingBoxSubject extends BaseSubject<OrientedBoundingBoxSubject, OrientedBoundingBox> {

  public static final OrientedBoundingBoxSubjectFactory FACTORY = new OrientedBoundingBoxSubjectFactory();

  public OrientedBoundingBoxSubject(FailureStrategy failureStrategy, OrientedBoundingBox actual) {
    super(failureStrategy, actual);
  }

  public OrientedBoundingBoxSubject isCenterX(float centerX) {
    isNotNull();
    check().withFailureMessage("is center x")
        .that(actual().centerX)
        .isEqualTo(centerX);
    return this;
  }

  public OrientedBoundingBoxSubject isCenterY(float centerY) {
    isNotNull();
    check().withFailureMessage("is center y")
        .that(actual().centerY)
        .isEqualTo(centerY);
    return this;
  }

  public OrientedBoundingBoxSubject isHeight(float height) {
    isNotNull();
    check().withFailureMessage("is height")
        .that(actual().height)
        .isEqualTo(height);
    return this;
  }

  public OrientedBoundingBoxSubject isOrientation(float orientation) {
    isNotNull();
    check().withFailureMessage("is orientation")
        .that(actual().orientation)
        .isEqualTo(orientation);
    return this;
  }

  public OrientedBoundingBoxSubject isSquareness(float squareness) {
    isNotNull();
    check().withFailureMessage("is squareness")
        .that(actual().squareness)
        .isEqualTo(squareness);
    return this;
  }

  public OrientedBoundingBoxSubject isWidth(float width) {
    isNotNull();
    check().withFailureMessage("is width")
        .that(actual().width)
        .isEqualTo(width);
    return this;
  }

  private static class OrientedBoundingBoxSubjectFactory extends SubjectFactory<OrientedBoundingBoxSubject, OrientedBoundingBox> {
    @Override
    public OrientedBoundingBoxSubject getSubject(FailureStrategy fs, OrientedBoundingBox that) {
      return new OrientedBoundingBoxSubject(fs, that);
    }
  }
}
