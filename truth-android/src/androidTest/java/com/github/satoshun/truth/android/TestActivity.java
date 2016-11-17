package com.github.satoshun.truth.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class TestActivity extends Activity {

  public FrameLayout root;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    root = new FrameLayout(this);
    setContentView(root);
  }
}
