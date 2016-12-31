package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;

import com.github.satoshun.truth.android.api.view.ViewSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.regex.Pattern;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

/**
 * Propositions for TextView subject
 */
public abstract class TextViewSubject<S extends TextViewSubject<S, T>, T extends TextView>
    extends ViewSubject<S, T> {

  public static final TextViewSubjectFactory FACTORY = new TextViewSubjectFactory();

  TextViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isAutoLinkMask(int mask) {
    isNotNull();
    check().withFailureMessage("is auto link mask")
        .that(actual().getAutoLinkMask())
        .isEqualTo(mask);
    return myself();
  }

  public S isCompoundDrawablePadding(int padding) {
    isNotNull();
    check().withFailureMessage("is compound drawable padding")
        .that(actual().getCompoundDrawablePadding())
        .isEqualTo(padding);
    return myself();
  }

  public S isCompoundPaddingBottom(int padding) {
    isNotNull();
    check().withFailureMessage("is compound padding bottom")
        .that(actual().getCompoundPaddingBottom())
        .isEqualTo(padding);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isCompoundPaddingEnd(int padding) {
    isNotNull();
    check().withFailureMessage("is compound padding end")
        .that(actual().getCompoundPaddingEnd())
        .isEqualTo(padding);
    return myself();
  }

  public S isCompoundPaddingLeft(int padding) {
    isNotNull();
    check().withFailureMessage("is compound padding left")
        .that(actual().getCompoundPaddingLeft())
        .isEqualTo(padding);
    return myself();
  }

  public S isCompoundPaddingRight(int padding) {
    isNotNull();
    check().withFailureMessage("is compound padding right")
        .that(actual().getCompoundPaddingRight())
        .isEqualTo(padding);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isCompoundPaddingStart(int padding) {
    isNotNull();
    check().withFailureMessage("is compound padding start")
        .that(actual().getCompoundPaddingStart())
        .isEqualTo(padding);
    return myself();
  }

  public S isCompoundPaddingTop(int padding) {
    isNotNull();
    check().withFailureMessage("is compound padding top")
        .that(actual().getCompoundPaddingTop())
        .isEqualTo(padding);
    return myself();
  }

  public S isCurrentHintTextColor(int color) {
    isNotNull();
    check().withFailureMessage("is current hint text color")
        .that(actual().getCurrentHintTextColor())
        .isEqualTo(color);
    return myself();
  }

  public S isCurrentTextColor(int color) {
    isNotNull();
    check().withFailureMessage("is current text color")
        .that(actual().getCurrentTextColor())
        .isEqualTo(color);
    return myself();
  }

  public S isEllipsize(TextUtils.TruncateAt truncation) {
    isNotNull();
    check().withFailureMessage("is ellipsize")
        .that(actual().getEllipsize())
        .isEqualTo(truncation);
    return myself();
  }

  public S hasError() {
    isNotNull();
    check().withFailureMessage("has error")
        .that(actual().getError())
        .isNotNull();
    return myself();
  }

  public S hasNoError() {
    isNotNull();
    check().withFailureMessage("has no error")
        .that(actual().getError())
        .isNull();
    return myself();
  }

  public S isError(CharSequence error) {
    isNotNull();
    check().withFailureMessage("has error")
        .that(actual().getError())
        .isEqualTo(error);
    return myself();
  }

  public S isError(int resId) {
    isNotNull();
    return isError(actual().getContext().getString(resId));
  }

  public S isExtendedPaddingBottom(int padding) {
    isNotNull();
    check().withFailureMessage("is extended padding bottom")
        .that(actual().getExtendedPaddingBottom())
        .isEqualTo(padding);
    return myself();
  }

  public S isExtendedPaddingTop(int padding) {
    isNotNull();
    check().withFailureMessage("is extended padding top")
        .that(actual().getExtendedPaddingTop())
        .isEqualTo(padding);
    return myself();
  }

  public S isFreezesText(boolean freezes) {
    isNotNull();
    check().withFailureMessage("is freezes text")
        .that(actual().getFreezesText())
        .isEqualTo(freezes);
    return myself();
  }

  public S isGravity(int gravity) {
    isNotNull();
    check().withFailureMessage("is gravity")
        .that(actual().getGravity())
        .isEqualTo(gravity);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isHighlightColor(int color) {
    isNotNull();
    check().withFailureMessage("is highlight color")
        .that(actual().getHighlightColor())
        .isEqualTo(color);
    return myself();
  }

  public S isHint(CharSequence hint) {
    isNotNull();
    check().withFailureMessage("is hint")
        .that(actual().getHint())
        .isEqualTo(hint);
    return myself();
  }

  public S isHint(int resId) {
    isNotNull();
    return isHint(actual().getContext().getString(resId));
  }

  public S isImeActionId(int id) {
    isNotNull();
    check().withFailureMessage("is ime action id")
        .that(actual().getImeActionId())
        .isEqualTo(id);
    return myself();
  }

  public S isImeActionLabel(CharSequence label) {
    isNotNull();
    check().withFailureMessage("is ime action label")
        .that(actual().getImeActionLabel())
        .isEqualTo(label);
    return myself();
  }

  public S isImeActionLabel(int resId) {
    isNotNull();
    return isImeActionLabel(actual().getContext().getString(resId));
  }

  public S isImeOptions(int options) {
    isNotNull();
    check().withFailureMessage("is ime options")
        .that(actual().getImeOptions())
        .isEqualTo(options);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isIncludingFontPadding() {
    isNotNull();
    check().withFailureMessage("is including font padding")
        .that(actual().getIncludeFontPadding())
        .isTrue();
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isNotIncludingFontPadding() {
    isNotNull();
    check().withFailureMessage("is not including font padding")
        .that(actual().getIncludeFontPadding())
        .isFalse();
    return myself();
  }

  public S isInputType(int type) {
    isNotNull();
    check().withFailureMessage("is input type")
        .that(actual().getInputType())
        .isEqualTo(type);
    return myself();
  }

  public S isLineCount(int count) {
    isNotNull();
    check().withFailureMessage("is line count")
        .that(actual().getLineCount())
        .isEqualTo(count);
    return myself();
  }

  public S isLineHeight(int height) {
    isNotNull();
    check().withFailureMessage("is line height")
        .that(actual().getLineHeight())
        .isEqualTo(height);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isLineSpacingExtra(float extra) {
    isNotNull();
    check().withFailureMessage("is line spacing extra")
        .that(actual().getLineSpacingExtra())
        .isEqualTo(extra);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isLineSpacingMultiplier(float multiplier) {
    isNotNull();
    check().withFailureMessage("is line spacing multiplier")
        .that(actual().getLineSpacingMultiplier())
        .isEqualTo(multiplier);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMarqueeRepeatLimit(int limit) {
    isNotNull();
    check().withFailureMessage("is marquee repeat limit")
        .that(actual().getMarqueeRepeatLimit())
        .isEqualTo(limit);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMaxEms(int ems) {
    isNotNull();
    check().withFailureMessage("is max ems")
        .that(actual().getMaxEms())
        .isEqualTo(ems);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMaxHeight(int height) {
    isNotNull();
    check().withFailureMessage("is max height")
        .that(actual().getMaxHeight())
        .isEqualTo(height);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMaxLines(int lines) {
    isNotNull();
    check().withFailureMessage("is max lines")
        .that(actual().getMaxLines())
        .isEqualTo(lines);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMaxWidth(int ems) {
    isNotNull();
    check().withFailureMessage("is max width")
        .that(actual().getMaxWidth())
        .isEqualTo(ems);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMinEms(int ems) {
    isNotNull();
    check().withFailureMessage("is min ems")
        .that(actual().getMinEms())
        .isEqualTo(ems);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMinHeight(int height) {
    isNotNull();
    check().withFailureMessage("is min height")
        .that(actual().getMinHeight())
        .isEqualTo(height);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMinLines(int lines) {
    isNotNull();
    check().withFailureMessage("is min lines")
        .that(actual().getMinLines())
        .isEqualTo(lines);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMinWidth(int width) {
    isNotNull();
    check().withFailureMessage("is min width")
        .that(actual().getMinWidth())
        .isEqualTo(width);
    return myself();
  }

  public S isPaintFlags(int flags) {
    isNotNull();
    check().withFailureMessage("is paint flags")
        .that(actual().getPaintFlags())
        .isEqualTo(flags);
    return myself();
  }

  public S isSelectionEnd(int position) {
    isNotNull();
    check().withFailureMessage("is selection end")
        .that(actual().getSelectionEnd())
        .isEqualTo(position);
    return myself();
  }

  public S isSelectionStart(int position) {
    isNotNull();
    check().withFailureMessage("is selection start")
        .that(actual().getSelectionStart())
        .isEqualTo(position);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isShadowColor(int color) {
    isNotNull();
    check().withFailureMessage("is shadow color")
        .that(actual().getShadowColor())
        .isEqualTo(color);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isShadowDx(float dx) {
    isNotNull();
    check().withFailureMessage("is shadow dx")
        .that(actual().getShadowDx())
        .isEqualTo(dx);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isShadowDy(float dy) {
    isNotNull();
    check().withFailureMessage("is shadow dy")
        .that(actual().getShadowDy())
        .isEqualTo(dy);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isShadowRadius(float radius) {
    isNotNull();
    check().withFailureMessage("is shadow radius")
        .that(actual().getShadowRadius())
        .isEqualTo(radius);
    return myself();
  }

  public S isText(CharSequence text) {
    isNotNull();
    check().withFailureMessage("is text")
        .that(actual().getText())
        .isEqualTo(text);
    return myself();
  }

  public S isText(int resId) {
    isNotNull();
    return isText(actual().getContext().getString(resId));
  }

  public S isTextString(String text) {
    isNotNull();
    check().withFailureMessage("is text string")
        .that(actual().getText().toString())
        .isEqualTo(text);
    return myself();
  }

  public S isTextString(int resId) {
    isNotNull();
    return isTextString(actual().getContext().getString(resId));
  }

  public S isEmpty() {
    isNotNull();
    return isTextString("");
  }

  public S isNotEmpty() {
    isNotNull();
    check().withFailureMessage("is not empty")
        .that(actual().getText())
        .isNotEqualTo("");
    return myself();
  }

  public S matches(Pattern pattern) {
    isNotNull();
    check().withFailureMessage("matches")
        .that(pattern.matcher(actual().getText().toString()).matches())
        .isTrue();
    return myself();
  }

  public S doesNotMatch(Pattern pattern) {
    isNotNull();
    check().withFailureMessage("matches")
        .that(pattern.matcher(actual().getText().toString()).matches())
        .isFalse();
    return myself();
  }

  public S containsText(String sequence) {
    isNotNull();
    check().withFailureMessage("contains text")
        .that(actual().getText().toString())
        .contains(sequence);
    return myself();
  }

  public S containsText(int resId) {
    isNotNull();
    return containsText(actual().getContext().getString(resId));
  }

  public S doesNotContainText(String sequence) {
    isNotNull();
    check().withFailureMessage("does not contains text")
        .that(actual().getText().toString())
        .doesNotContain(sequence);
    return myself();
  }

  public S doesNotContainText(int resId) {
    isNotNull();
    return doesNotContainText(actual().getContext().getString(resId));
  }

  public S startsWithText(String sequence) {
    isNotNull();
    check().withFailureMessage("starts with text")
        .that(actual().getText().toString())
        .startsWith(sequence);
    return myself();
  }

  public S startsWithText(int resId) {
    isNotNull();
    return startsWithText(actual().getContext().getString(resId));
  }

  public S endsWithText(String sequence) {
    isNotNull();
    check().withFailureMessage("ends with text")
        .that(actual().getText().toString())
        .endsWith(sequence);
    return myself();
  }

  public S endsWithText(int resId) {
    isNotNull();
    return endsWithText(actual().getContext().getString(resId));
  }

  public S isTextScaleX(float scale) {
    isNotNull();
    check().withFailureMessage("is text scale x")
        .that(actual().getTextScaleX())
        .isEqualTo(scale);
    return myself();
  }

  public S isTextSize(float size) {
    isNotNull();
    check().withFailureMessage("is text size")
        .that(actual().getTextSize())
        .isEqualTo(size);
    return myself();
  }

  public S isTotalPaddingBottom(int padding) {
    isNotNull();
    check().withFailureMessage("is total padding bottom")
        .that(actual().getTotalPaddingBottom())
        .isEqualTo(padding);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isTotalPaddingEnd(int padding) {
    isNotNull();
    check().withFailureMessage("is total padding end")
        .that(actual().getTotalPaddingEnd())
        .isEqualTo(padding);
    return myself();
  }

  public S isTotalPaddingLeft(int padding) {
    isNotNull();
    check().withFailureMessage("is total padding left")
        .that(actual().getTotalPaddingLeft())
        .isEqualTo(padding);
    return myself();
  }

  public S isTotalPaddingRight(int padding) {
    isNotNull();
    check().withFailureMessage("is total padding right")
        .that(actual().getTotalPaddingRight())
        .isEqualTo(padding);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isTotalPaddingStart(int padding) {
    isNotNull();
    check().withFailureMessage("is total padding start")
        .that(actual().getTotalPaddingStart())
        .isEqualTo(padding);
    return myself();
  }

  public S isTotalPaddingTop(int padding) {
    isNotNull();
    check().withFailureMessage("is total padding top")
        .that(actual().getTotalPaddingTop())
        .isEqualTo(padding);
    return myself();
  }

  public S isTypeface(Typeface typeface) {
    isNotNull();
    check().withFailureMessage("is typeface")
        .that(actual().getTypeface())
        .isSameAs(typeface);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isCursorVisible() {
    isNotNull();
    check().withFailureMessage("is cursor visible")
        .that(actual().isCursorVisible())
        .isTrue();
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isCursorNotVisible() {
    isNotNull();
    check().withFailureMessage("is cursor not visible")
        .that(actual().isCursorVisible())
        .isFalse();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isSelectableText() {
    isNotNull();
    check().withFailureMessage("is selectable text")
        .that(actual().isTextSelectable())
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S hasUnselectableText() {
    isNotNull();
    check().withFailureMessage("is unselectable text")
        .that(actual().isTextSelectable())
        .isFalse();
    return myself();
  }

  public S isLength(int length) {
    isNotNull();
    check().withFailureMessage("is length")
        .that(actual().length())
        .isEqualTo(length);
    return myself();
  }

  public S isInputMethodTarget() {
    isNotNull();
    check().withFailureMessage("is input method target")
        .that(actual().isInputMethodTarget())
        .isTrue();
    return myself();
  }

  public S isNotInputMethodTarget() {
    isNotNull();
    check().withFailureMessage("is not input method target")
        .that(actual().isInputMethodTarget())
        .isFalse();
    return myself();
  }

  private static class TextViewSubjectImpl extends TextViewSubject<TextViewSubjectImpl, TextView> {
    TextViewSubjectImpl(FailureStrategy failureStrategy, TextView actual) {
      super(failureStrategy, actual);
    }
  }

  private static class TextViewSubjectFactory extends SubjectFactory<TextViewSubjectImpl, TextView> {
    @Override
    public TextViewSubjectImpl getSubject(FailureStrategy fs, TextView that) {
      return new TextViewSubjectImpl(fs, that);
    }
  }
}
