package com.github.satoshun.truth.android.api.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.UUID;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

@TargetApi(JELLY_BEAN_MR2)
public class BluetoothGattCharacteristicSubject extends BaseSubject<BluetoothGattCharacteristicSubject, BluetoothGattCharacteristic> {

  public static final BluetoothGattCharacteristicSubjectFactory FACTORY = new BluetoothGattCharacteristicSubjectFactory();

  public BluetoothGattCharacteristicSubject(FailureStrategy failureStrategy, BluetoothGattCharacteristic actual) {
    super(failureStrategy, actual);
  }

  public BluetoothGattCharacteristicSubject isInstanceId(int id) {
    isNotNull();
    check().withFailureMessage("is instance id")
        .that(actual().getInstanceId())
        .isEqualTo(id);
    return this;
  }

  public BluetoothGattCharacteristicSubject isPermissions(int permissions) {
    isNotNull();
    check().withFailureMessage("is permissions")
        .that(actual().getPermissions())
        .isEqualTo(permissions);
    return this;
  }

  public BluetoothGattCharacteristicSubject isProperties(int properties) {
    isNotNull();
    check().withFailureMessage("is properties")
        .that(actual().getProperties())
        .isEqualTo(properties);
    return this;
  }

  public BluetoothGattCharacteristicSubject isUuid(UUID uuid) {
    isNotNull();
    check().withFailureMessage("is uuid")
        .that(actual().getUuid())
        .isEqualTo(uuid);
    return this;
  }

  public BluetoothGattCharacteristicSubject isValue(byte[] value) {
    isNotNull();
    check().withFailureMessage("is value")
        .that(actual().getValue())
        .isEqualTo(value);
    return this;
  }

  public BluetoothGattCharacteristicSubject isWriteType(int writeType) {
    isNotNull();
    check().withFailureMessage("is write type")
        .that(actual().getWriteType())
        .isEqualTo(writeType);
    return this;
  }

  private static class BluetoothGattCharacteristicSubjectFactory extends SubjectFactory<BluetoothGattCharacteristicSubject, BluetoothGattCharacteristic> {
    @Override
    public BluetoothGattCharacteristicSubject getSubject(FailureStrategy fs, BluetoothGattCharacteristic that) {
      return new BluetoothGattCharacteristicSubject(fs, that);
    }
  }
}
