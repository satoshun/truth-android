package com.github.satoshun.truth.android.api.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

public class BluetoothDeviceSubject extends BaseSubject<BluetoothDeviceSubject, BluetoothDevice> {

  public static final BluetoothDeviceSubjectFactory FACTORY = new BluetoothDeviceSubjectFactory();

  public BluetoothDeviceSubject(FailureStrategy failureStrategy, BluetoothDevice actual) {
    super(failureStrategy, actual);
  }

  public BluetoothDeviceSubject isAddress(String address) {
    isNotNull();
    check().withFailureMessage("is address")
        .that(actual().getAddress())
        .isEqualTo(address);
    return this;
  }

  public BluetoothDeviceSubject isBondState(int state) {
    isNotNull();
    check().withFailureMessage("is bond state")
        .that(actual().getBondState())
        .isEqualTo(state);
    return this;
  }

  public BluetoothDeviceSubject isName(String name) {
    isNotNull();
    check().withFailureMessage("is name")
        .that(actual().getName())
        .isEqualTo(name);
    return this;
  }


  @TargetApi(JELLY_BEAN_MR2)
  public BluetoothDeviceSubject isType(int type) {
    isNotNull();
    check().withFailureMessage("is type")
        .that(actual().getType())
        .isEqualTo(type);
    return this;
  }

  private static class BluetoothDeviceSubjectFactory extends SubjectFactory<BluetoothDeviceSubject, BluetoothDevice> {
    @Override
    public BluetoothDeviceSubject getSubject(FailureStrategy fs, BluetoothDevice that) {
      return new BluetoothDeviceSubject(fs, that);
    }
  }
}
