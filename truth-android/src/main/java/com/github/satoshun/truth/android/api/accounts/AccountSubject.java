package com.github.satoshun.truth.android.api.accounts;

import android.accounts.Account;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class AccountSubject<S extends AccountSubject<S, T>, T extends Account>
    extends BaseSubject<S, T> {

  public static final AccountSubjectFactory FACTORY = new AccountSubjectFactory();

  public AccountSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public AccountSubject hasName(String name) {
    isNotNull();
    String actual = actual().name;
    check().withFailureMessage("has name")
        .that(name)
        .isEqualTo(actual);
    return myself();
  }

  public AccountSubject hasType(String type) {
    isNotNull();
    String actual = actual().type;
    check().withFailureMessage("has type")
        .that(type)
        .isEqualTo(actual);
    return myself();
  }

  private static class AccountSubjectImpl extends AccountSubject<AccountSubjectImpl, Account> {
    AccountSubjectImpl(FailureStrategy failureStrategy, Account actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AccountSubjectFactory extends SubjectFactory<AccountSubjectImpl, Account> {
    @Override
    public AccountSubjectImpl getSubject(FailureStrategy fs, Account that) {
      return new AccountSubjectImpl(fs, that);
    }
  }
}
