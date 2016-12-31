package com.github.satoshun.truth.android.api.content.res;

import android.annotation.TargetApi;
import android.content.res.Configuration;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.content.res.Configuration.MNC_ZERO;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.KITKAT;

public class ConfigurationSubject extends BaseSubject<ConfigurationSubject, Configuration> {

  public static final ConfigurationSubjectFactory FACTORY = new ConfigurationSubjectFactory();

  public ConfigurationSubject(FailureStrategy failureStrategy, Configuration actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public ConfigurationSubject isLayoutDirection(int layoutDirection) {
    isNotNull();
    check().withFailureMessage("is layout direction")
        .that(actual().getLayoutDirection())
        .isEqualTo(layoutDirection);
    return this;
  }

  @TargetApi(KITKAT)
  public ConfigurationSubject isMnc(int mnc) {
    isNotNull();
    check().withFailureMessage("is mnc")
        .that(actual().mnc)
        .isEqualTo(mnc);
    return this;
  }

  @TargetApi(KITKAT)
  public ConfigurationSubject isMncZero() {
    isNotNull();
    check().withFailureMessage("is mnc zero")
        .that(actual().mnc)
        .isEqualTo(MNC_ZERO);
    return this;
  }

  private static class ConfigurationSubjectFactory extends SubjectFactory<ConfigurationSubject, Configuration> {
    @Override
    public ConfigurationSubject getSubject(FailureStrategy fs, Configuration that) {
      return new ConfigurationSubject(fs, that);
    }
  }
}
