package com.github.satoshun.truth.android.api;

import android.accounts.Account;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.github.satoshun.truth.android.api.accounts.AccountSubject;
import com.github.satoshun.truth.android.api.net.UriSubject;
import com.github.satoshun.truth.android.api.view.EditTextSubject;
import com.github.satoshun.truth.android.api.view.TextViewSubject;
import com.github.satoshun.truth.android.api.view.ViewGroupSubject;
import com.github.satoshun.truth.android.api.view.ViewSubject;
import com.github.satoshun.truth.android.api.view.ViewTreeObserverSubject;
import com.github.satoshun.truth.android.api.view.WindowSubject;
import com.github.satoshun.truth.android.api.webkit.WebViewSubject;
import com.github.satoshun.truth.android.api.widget.AbsListViewSubject;
import com.github.satoshun.truth.android.api.widget.AdapterViewSubject;
import com.github.satoshun.truth.android.api.widget.ListViewSubject;
import com.google.common.truth.Truth;

public class Subjects {
  public static ViewSubject assertThat(View target) {
    return Truth.assertAbout(ViewSubject.FACTORY).that(target);
  }

  public static TextViewSubject assertThat(TextView target) {
    return Truth.assertAbout(TextViewSubject.FACTORY).that(target);
  }

  public static EditTextSubject assertThat(EditText target) {
    return Truth.assertAbout(EditTextSubject.FACTORY).that(target);
  }

  public static ViewGroupSubject assertThat(ViewGroup target) {
    return Truth.assertAbout(ViewGroupSubject.FACTORY).that(target);
  }

  public static <T extends Adapter> AdapterViewSubject assertThat(AdapterView<T> target) {
    return Truth.assertAbout(AdapterViewSubject.FACTORY).that(target);
  }

  public static AbsListViewSubject assertThat(AbsListView target) {
    return Truth.assertAbout(AbsListViewSubject.FACTORY).that(target);
  }

  public static ListViewSubject assertThat(ListView target) {
    return Truth.assertAbout(ListViewSubject.FACTORY).that(target);
  }

  public static WebViewSubject assertThat(WebView target) {
    return Truth.assertAbout(WebViewSubject.FACTORY).that(target);
  }

  public static UriSubject assertThat(Uri target) {
    return Truth.assertAbout(UriSubject.FACTORY).that(target);
  }

  public static AccountSubject assertThat(Account target) {
    return Truth.assertAbout(AccountSubject.FACTORY).that(target);
  }

  public static ViewTreeObserverSubject assertThat(ViewTreeObserver target) {
    return Truth.assertAbout(ViewTreeObserverSubject.FACTORY).that(target);
  }

  public static WindowSubject assertThat(Window target) {
    return Truth.assertAbout(WindowSubject.FACTORY).that(target);
  }
}
