package com.github.satoshun.truth.android.api.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattDescriptor;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.UUID;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

@TargetApi(JELLY_BEAN_MR2)
public class BluetoothGattDescriptorSubject extends BaseSubject<BluetoothGattDescriptorSubject, BluetoothGattDescriptor> {

  public static final BluetoothGattDescriptorSubjectFactory FACTORY = new BluetoothGattDescriptorSubjectFactory();

  public BluetoothGattDescriptorSubject(FailureStrategy failureStrategy, BluetoothGattDescriptor actual) {
    super(failureStrategy, actual);
  }

  public BluetoothGattDescriptorSubject isPermissions( int permissions) {
    isNotNull();
    check().withFailureMessage("is permissions")
        .that(actual().getPermissions())
        .isEqualTo(permissions);
    return this;
  }

  public BluetoothGattDescriptorSubject isUuid(UUID uuid) {
    isNotNull();
    check().withFailureMessage("is uuid")
        .that(actual().getUuid())
        .isEqualTo(uuid);
    return this;
  }

  public BluetoothGattDescriptorSubject isValue(byte[] value) {
    isNotNull();
    check().withFailureMessage("is value")
        .that(actual().getValue())
        .isEqualTo(value);
    return this;
  }

  private static class BluetoothGattDescriptorSubjectFactory extends SubjectFactory<BluetoothGattDescriptorSubject, BluetoothGattDescriptor> {
    @Override
    public BluetoothGattDescriptorSubject getSubject(FailureStrategy fs, BluetoothGattDescriptor that) {
      return new BluetoothGattDescriptorSubject(fs, that);
    }
  }
}
