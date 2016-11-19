package com.github.satoshun.truth.android.api.net;

import android.net.Uri;

import com.github.satoshun.truth.android.api.TruthAndroid;

import org.junit.Before;
import org.junit.Test;

public class UriSubjectTest {

  private Uri uri;

  @Before
  public void setUp() throws Exception {
    uri = Uri.parse("http://google.com/hoge/fuga");
  }

  @Test public void sameAsPath_success() throws Exception {
    TruthAndroid.assertThat(uri)
        .sameAsPath("/hoge/fuga");
  }

  @Test(expected = AssertionError.class) public void sameAsPath_failure() throws Exception {
    TruthAndroid.assertThat(uri)
        .sameAsPath("/hoge");
  }
}
