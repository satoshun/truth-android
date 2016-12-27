# truth Android

[![Build Status](https://travis-ci.org/satoshun/truth-android.svg?branch=master)](https://travis-ci.org/satoshun/truth-android)
[![codecov](https://codecov.io/gh/satoshun/truth-android/branch/master/graph/badge.svg)](https://codecov.io/gh/satoshun/truth-android)

this project inspired by [assertj-android](https://github.com/square/assertj-android).


## Examples

```java
Subjects.assertThat(view).isGone();
```

```java
Subjects.assertThat(view)
    .isGone()
    .sameAsWidth(100)
    .sameAsHeight(200);
```


## Limitations

truth Android is beta now
