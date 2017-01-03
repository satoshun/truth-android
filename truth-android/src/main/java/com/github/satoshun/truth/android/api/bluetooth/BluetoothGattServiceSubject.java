package com.github.satoshun.truth.android.api.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattService;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.UUID;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

@TargetApi(JELLY_BEAN_MR2)
public class BluetoothGattServiceSubject extends BaseSubject<BluetoothGattServiceSubject, BluetoothGattService> {

  public static final BluetoothGattServiceSubjectFactory FACTORY = new BluetoothGattServiceSubjectFactory();

  public BluetoothGattServiceSubject(FailureStrategy failureStrategy, BluetoothGattService actual) {
    super(failureStrategy, actual);
  }

  public BluetoothGattServiceSubject isInstanceId(int id) {
    isNotNull();
    check().withFailureMessage("is instance id")
        .that(actual().getInstanceId())
        .isEqualTo(id);
    return this;
  }

  public BluetoothGattServiceSubject isType(int type) {
    isNotNull();
    check().withFailureMessage("is type")
        .that(actual().getType())
        .isEqualTo(type);
    return this;
  }

  public BluetoothGattServiceSubject hasUuid(UUID uuid) {
    isNotNull();
    check().withFailureMessage("is uuid")
        .that(actual().getUuid())
        .isEqualTo(uuid);
    return this;
  }

  private static class BluetoothGattServiceSubjectFactory extends SubjectFactory<BluetoothGattServiceSubject, BluetoothGattService> {
    @Override
    public BluetoothGattServiceSubject getSubject(FailureStrategy fs, BluetoothGattService that) {
      return new BluetoothGattServiceSubject(fs, that);
    }
  }
}
