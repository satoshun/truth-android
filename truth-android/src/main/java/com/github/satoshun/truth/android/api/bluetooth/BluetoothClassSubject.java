package com.github.satoshun.truth.android.api.bluetooth;

import android.bluetooth.BluetoothClass;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class BluetoothClassSubject extends BaseSubject<BluetoothClassSubject, BluetoothClass> {

  public static final BluetoothClassSubjectFactory FACTORY = new BluetoothClassSubjectFactory();

  public BluetoothClassSubject(FailureStrategy failureStrategy, BluetoothClass actual) {
    super(failureStrategy, actual);
  }

  public BluetoothClassSubject isDeviceClass(int deviceClass) {
    isNotNull();
    check().withFailureMessage("is device class")
        .that(actual().getDeviceClass())
        .isEqualTo(deviceClass);
    return this;
  }

  public BluetoothClassSubject isMajorDeviceClass(int majorDeviceClass) {
    isNotNull();
    check().withFailureMessage("is major device class")
        .that(actual().getMajorDeviceClass())
        .isEqualTo(majorDeviceClass);
    return this;
  }

  public BluetoothClassSubject isService(int service) {
    isNotNull();
    check().withFailureMessage("is service")
        .that(actual().hasService(service))
        .isTrue();
    return this;
  }

  public BluetoothClassSubject isNotService(int service) {
    isNotNull();
    check().withFailureMessage("is not service")
        .that(actual().hasService(service))
        .isFalse();
    return this;
  }

  private static class BluetoothClassSubjectFactory extends SubjectFactory<BluetoothClassSubject, BluetoothClass> {
    @Override
    public BluetoothClassSubject getSubject(FailureStrategy fs, BluetoothClass that) {
      return new BluetoothClassSubject(fs, that);
    }
  }
}
