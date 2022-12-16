package com.google.android.ads.nativetemplates;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* loaded from: manager-1.0.4.aar:classes.jar:com/google/android/ads/nativetemplates/NativeTemplateStyle.class */
public class NativeTemplateStyle {
    private Typeface callToActionTextTypeface;
    private float callToActionTextSize;
    private int callToActionTypefaceColor;
    private ColorDrawable callToActionBackgroundColor;
    private Typeface primaryTextTypeface;
    private float primaryTextSize;
    private int primaryTextTypefaceColor;
    private ColorDrawable primaryTextBackgroundColor;
    private Typeface secondaryTextTypeface;
    private float secondaryTextSize;
    private int secondaryTextTypefaceColor;
    private ColorDrawable secondaryTextBackgroundColor;
    private Typeface tertiaryTextTypeface;
    private float tertiaryTextSize;
    private int tertiaryTextTypefaceColor;
    private ColorDrawable tertiaryTextBackgroundColor;
    private ColorDrawable mainBackgroundColor;

    public Typeface getCallToActionTextTypeface() {
        return this.callToActionTextTypeface;
    }

    public float getCallToActionTextSize() {
        return this.callToActionTextSize;
    }

    public int getCallToActionTypefaceColor() {
        return this.callToActionTypefaceColor;
    }

    public ColorDrawable getCallToActionBackgroundColor() {
        return this.callToActionBackgroundColor;
    }

    public Typeface getPrimaryTextTypeface() {
        return this.primaryTextTypeface;
    }

    public float getPrimaryTextSize() {
        return this.primaryTextSize;
    }

    public int getPrimaryTextTypefaceColor() {
        return this.primaryTextTypefaceColor;
    }

    public ColorDrawable getPrimaryTextBackgroundColor() {
        return this.primaryTextBackgroundColor;
    }

    public Typeface getSecondaryTextTypeface() {
        return this.secondaryTextTypeface;
    }

    public float getSecondaryTextSize() {
        return this.secondaryTextSize;
    }

    public int getSecondaryTextTypefaceColor() {
        return this.secondaryTextTypefaceColor;
    }

    public ColorDrawable getSecondaryTextBackgroundColor() {
        return this.secondaryTextBackgroundColor;
    }

    public Typeface getTertiaryTextTypeface() {
        return this.tertiaryTextTypeface;
    }

    public float getTertiaryTextSize() {
        return this.tertiaryTextSize;
    }

    public int getTertiaryTextTypefaceColor() {
        return this.tertiaryTextTypefaceColor;
    }

    public ColorDrawable getTertiaryTextBackgroundColor() {
        return this.tertiaryTextBackgroundColor;
    }

    public ColorDrawable getMainBackgroundColor() {
        return this.mainBackgroundColor;
    }

    /* loaded from: manager-1.0.4.aar:classes.jar:com/google/android/ads/nativetemplates/NativeTemplateStyle$Builder.class */
    public static class Builder {
        private NativeTemplateStyle styles = new NativeTemplateStyle();

        @CanIgnoreReturnValue
        public Builder withCallToActionTextTypeface(Typeface callToActionTextTypeface) {
            this.styles.callToActionTextTypeface = callToActionTextTypeface;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withCallToActionTextSize(float callToActionTextSize) {
            this.styles.callToActionTextSize = callToActionTextSize;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withCallToActionTypefaceColor(int callToActionTypefaceColor) {
            this.styles.callToActionTypefaceColor = callToActionTypefaceColor;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withCallToActionBackgroundColor(ColorDrawable callToActionBackgroundColor) {
            this.styles.callToActionBackgroundColor = callToActionBackgroundColor;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withPrimaryTextTypeface(Typeface primaryTextTypeface) {
            this.styles.primaryTextTypeface = primaryTextTypeface;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withPrimaryTextSize(float primaryTextSize) {
            this.styles.primaryTextSize = primaryTextSize;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withPrimaryTextTypefaceColor(int primaryTextTypefaceColor) {
            this.styles.primaryTextTypefaceColor = primaryTextTypefaceColor;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withPrimaryTextBackgroundColor(ColorDrawable primaryTextBackgroundColor) {
            this.styles.primaryTextBackgroundColor = primaryTextBackgroundColor;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withSecondaryTextTypeface(Typeface secondaryTextTypeface) {
            this.styles.secondaryTextTypeface = secondaryTextTypeface;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withSecondaryTextSize(float secondaryTextSize) {
            this.styles.secondaryTextSize = secondaryTextSize;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withSecondaryTextTypefaceColor(int secondaryTextTypefaceColor) {
            this.styles.secondaryTextTypefaceColor = secondaryTextTypefaceColor;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withSecondaryTextBackgroundColor(ColorDrawable secondaryTextBackgroundColor) {
            this.styles.secondaryTextBackgroundColor = secondaryTextBackgroundColor;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withTertiaryTextTypeface(Typeface tertiaryTextTypeface) {
            this.styles.tertiaryTextTypeface = tertiaryTextTypeface;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withTertiaryTextSize(float tertiaryTextSize) {
            this.styles.tertiaryTextSize = tertiaryTextSize;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withTertiaryTextTypefaceColor(int tertiaryTextTypefaceColor) {
            this.styles.tertiaryTextTypefaceColor = tertiaryTextTypefaceColor;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withTertiaryTextBackgroundColor(ColorDrawable tertiaryTextBackgroundColor) {
            this.styles.tertiaryTextBackgroundColor = tertiaryTextBackgroundColor;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder withMainBackgroundColor(ColorDrawable mainBackgroundColor) {
            this.styles.mainBackgroundColor = mainBackgroundColor;
            return this;
        }

        public NativeTemplateStyle build() {
            return this.styles;
        }
    }
}