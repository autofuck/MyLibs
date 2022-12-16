package com.google.android.ads.nativetemplates;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.pay.ad.manager.R;

/* loaded from: manager-1.0.4.aar:classes.jar:com/google/android/ads/nativetemplates/TemplateView.class */
public class TemplateView extends FrameLayout {
    private int templateType;
    private NativeTemplateStyle styles;
    private NativeAd nativeAd;
    private NativeAdView nativeAdView;
    private TextView primaryView;
    private TextView secondaryView;
    private RatingBar ratingBar;
    private TextView tertiaryView;
    private ImageView iconView;
    private MediaView mediaView;
    private Button callToActionView;
    private ConstraintLayout background;
    private static final String MEDIUM_TEMPLATE = "medium_template";
    private static final String SMALL_TEMPLATE = "small_template";

    public TemplateView(Context context) {
        super(context);
    }

    public TemplateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public TemplateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    public TemplateView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
    }

    public void setStyles(NativeTemplateStyle styles) {
        this.styles = styles;
        applyStyles();
    }

    public NativeAdView getNativeAdView() {
        return this.nativeAdView;
    }

    private void applyStyles() {
        Drawable mainBackground = this.styles.getMainBackgroundColor();
        if (mainBackground != null) {
            this.background.setBackground(mainBackground);
            if (this.primaryView != null) {
                this.primaryView.setBackground(mainBackground);
            }
            if (this.secondaryView != null) {
                this.secondaryView.setBackground(mainBackground);
            }
            if (this.tertiaryView != null) {
                this.tertiaryView.setBackground(mainBackground);
            }
        }
        Typeface primary = this.styles.getPrimaryTextTypeface();
        if (primary != null && this.primaryView != null) {
            this.primaryView.setTypeface(primary);
        }
        Typeface secondary = this.styles.getSecondaryTextTypeface();
        if (secondary != null && this.secondaryView != null) {
            this.secondaryView.setTypeface(secondary);
        }
        Typeface tertiary = this.styles.getTertiaryTextTypeface();
        if (tertiary != null && this.tertiaryView != null) {
            this.tertiaryView.setTypeface(tertiary);
        }
        Typeface ctaTypeface = this.styles.getCallToActionTextTypeface();
        if (ctaTypeface != null && this.callToActionView != null) {
            this.callToActionView.setTypeface(ctaTypeface);
        }
        int primaryTypefaceColor = this.styles.getPrimaryTextTypefaceColor();
        if (primaryTypefaceColor > 0 && this.primaryView != null) {
            this.primaryView.setTextColor(primaryTypefaceColor);
        }
        int secondaryTypefaceColor = this.styles.getSecondaryTextTypefaceColor();
        if (secondaryTypefaceColor > 0 && this.secondaryView != null) {
            this.secondaryView.setTextColor(secondaryTypefaceColor);
        }
        int tertiaryTypefaceColor = this.styles.getTertiaryTextTypefaceColor();
        if (tertiaryTypefaceColor > 0 && this.tertiaryView != null) {
            this.tertiaryView.setTextColor(tertiaryTypefaceColor);
        }
        int ctaTypefaceColor = this.styles.getCallToActionTypefaceColor();
        if (ctaTypefaceColor > 0 && this.callToActionView != null) {
            this.callToActionView.setTextColor(ctaTypefaceColor);
        }
        float ctaTextSize = this.styles.getCallToActionTextSize();
        if (ctaTextSize > 0.0f && this.callToActionView != null) {
            this.callToActionView.setTextSize(ctaTextSize);
        }
        float primaryTextSize = this.styles.getPrimaryTextSize();
        if (primaryTextSize > 0.0f && this.primaryView != null) {
            this.primaryView.setTextSize(primaryTextSize);
        }
        float secondaryTextSize = this.styles.getSecondaryTextSize();
        if (secondaryTextSize > 0.0f && this.secondaryView != null) {
            this.secondaryView.setTextSize(secondaryTextSize);
        }
        float tertiaryTextSize = this.styles.getTertiaryTextSize();
        if (tertiaryTextSize > 0.0f && this.tertiaryView != null) {
            this.tertiaryView.setTextSize(tertiaryTextSize);
        }
        Drawable ctaBackground = this.styles.getCallToActionBackgroundColor();
        if (ctaBackground != null && this.callToActionView != null) {
            this.callToActionView.setBackground(ctaBackground);
        }
        Drawable primaryBackground = this.styles.getPrimaryTextBackgroundColor();
        if (primaryBackground != null && this.primaryView != null) {
            this.primaryView.setBackground(primaryBackground);
        }
        Drawable secondaryBackground = this.styles.getSecondaryTextBackgroundColor();
        if (secondaryBackground != null && this.secondaryView != null) {
            this.secondaryView.setBackground(secondaryBackground);
        }
        Drawable tertiaryBackground = this.styles.getTertiaryTextBackgroundColor();
        if (tertiaryBackground != null && this.tertiaryView != null) {
            this.tertiaryView.setBackground(tertiaryBackground);
        }
        invalidate();
        requestLayout();
    }

    private boolean adHasOnlyStore(NativeAd nativeAd) {
        String store = nativeAd.getStore();
        String advertiser = nativeAd.getAdvertiser();
        return !TextUtils.isEmpty(store) && TextUtils.isEmpty(advertiser);
    }

    public void setNativeAd(NativeAd nativeAd) {
        String secondaryText;
        this.nativeAd = nativeAd;
        String store = nativeAd.getStore();
        String advertiser = nativeAd.getAdvertiser();
        String headline = nativeAd.getHeadline();
        String body = nativeAd.getBody();
        String cta = nativeAd.getCallToAction();
        Double starRating = nativeAd.getStarRating();
        NativeAd.Image icon = nativeAd.getIcon();
        this.nativeAdView.setCallToActionView(this.callToActionView);
        this.nativeAdView.setHeadlineView(this.primaryView);
        this.nativeAdView.setMediaView(this.mediaView);
        this.secondaryView.setVisibility(0);
        if (adHasOnlyStore(nativeAd)) {
            this.nativeAdView.setStoreView(this.secondaryView);
            secondaryText = store;
        } else if (!TextUtils.isEmpty(advertiser)) {
            this.nativeAdView.setAdvertiserView(this.secondaryView);
            secondaryText = advertiser;
        } else {
            secondaryText = "";
        }
        this.primaryView.setText(headline);
        this.callToActionView.setText(cta);
        if (starRating != null && starRating.doubleValue() > 0.0d) {
            this.secondaryView.setVisibility(8);
            this.ratingBar.setVisibility(0);
            this.ratingBar.setRating(starRating.floatValue());
            this.nativeAdView.setStarRatingView(this.ratingBar);
        } else {
            this.secondaryView.setText(secondaryText);
            this.secondaryView.setVisibility(0);
            this.ratingBar.setVisibility(8);
        }
        if (icon != null) {
            this.iconView.setVisibility(0);
            this.iconView.setImageDrawable(icon.getDrawable());
        } else {
            this.iconView.setVisibility(8);
        }
        if (this.tertiaryView != null) {
            this.tertiaryView.setText(body);
            this.nativeAdView.setBodyView(this.tertiaryView);
        }
        this.nativeAdView.setNativeAd(nativeAd);
    }

    public void destroyNativeAd() {
        this.nativeAd.destroy();
    }

    public String getTemplateTypeName() {
        if (this.templateType == R.layout.gnt_medium_template_view) {
            return MEDIUM_TEMPLATE;
        }
        if (this.templateType == R.layout.gnt_small_template_view) {
            return SMALL_TEMPLATE;
        }
        return "";
    }

    private void initView(Context context, AttributeSet attributeSet) {
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TemplateView, 0, 0);
        try {
            this.templateType = attributes.getResourceId(R.styleable.TemplateView_gnt_template_type, R.layout.gnt_medium_template_view);
            attributes.recycle();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
            inflater.inflate(this.templateType, this);
        } catch (Throwable th) {
            attributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.nativeAdView = findViewById(R.id.native_ad_view);
        this.primaryView = (TextView) findViewById(R.id.primary);
        this.secondaryView = (TextView) findViewById(R.id.secondary);
        this.tertiaryView = (TextView) findViewById(R.id.body);
        this.ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        this.ratingBar.setEnabled(false);
        this.callToActionView = (Button) findViewById(R.id.cta);
        this.iconView = (ImageView) findViewById(R.id.icon);
        this.mediaView = findViewById(R.id.media_view);
        this.background = findViewById(R.id.background);
    }
}