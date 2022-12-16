package com.pay.ad.manager;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.pay.ad.manager.ad.AdManagerInsertPage;
import com.pay.ad.manager.ad.AdManagerInsertVideo;
import com.pay.ad.manager.ad.AdManagerNative;
import com.pay.ad.manager.ad.AdManagerVideo;
import com.pay.ad.manager.ad.BuyListener;
import com.pay.ad.manager.ad.FreeUseListener;
import com.pay.ad.manager.ad.NativeAdListener;
import com.pay.ad.manager.dialog.PackageDialog;
import com.pay.ad.manager.manager.AdShowTimeManager;
import com.pay.ad.manager.manager.VipCheckManager;
import com.pay.ad.manager.manager.VipManager;
import com.pay.ad.manager.sp.SharedPreferencesUtil;
import com.pay.ad.manager.util.ToastUtil;

/* loaded from: manager-1.0.4.aar:classes.jar:com/pay/ad/manager/AdPayManager.class */
public class AdPayManager {
    private static final String TAG = "AdPayManager";
    private static AdPayManager sManager = null;
    private AdConfigInfo mAdConfigInfo = null;
    private Application mApplication = null;
    private VipCheckManager mVipCheckManager = null;

    /* loaded from: manager-1.0.4.aar:classes.jar:com/pay/ad/manager/AdPayManager$ShowListener.class */
    public interface ShowListener {
        void onAdSuccess();

        void onAdFailed();
    }

    public static AdPayManager getInstance() {
        if (sManager == null) {
            synchronized (AdPayManager.class) {
                if (sManager == null) {
                    sManager = new AdPayManager();
                    return sManager;
                }
            }
        }
        return sManager;
    }

    public void init(Application application, AdConfigInfo adKeyInfo) {
        this.mApplication = application;
        this.mAdConfigInfo = adKeyInfo;
        SharedPreferencesUtil.getInstance().init(application);
        ToastUtil.initToast(application);
        MobileAds.initialize(application, new OnInitializationCompleteListener() { // from class: com.pay.ad.manager.AdPayManager.1
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                if (!TextUtils.isEmpty(AdPayManager.this.mAdConfigInfo.mInsertPageKey)) {
                    AdManagerInsertPage.getInstance().onAdSdkInitComplete();
                }
                if (!TextUtils.isEmpty(AdPayManager.this.mAdConfigInfo.mVideoKey) && AdPayManager.this.mAdConfigInfo.mShowFreeUse) {
                    AdManagerVideo.getInstance().onAdSdkInitComplete();
                }
                if (!TextUtils.isEmpty(AdPayManager.this.mAdConfigInfo.mInsertVideoKey)) {
                    AdManagerInsertVideo.getInstance().onAdSdkInitComplete();
                }
                if (!TextUtils.isEmpty(AdPayManager.this.mAdConfigInfo.mNativeKey)) {
                    AdManagerNative.getInstance().onAdSdkInitComplete();
                }
            }
        });
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public AdConfigInfo getAdConfigInfo() {
        return this.mAdConfigInfo;
    }

    public long getLastInsertPageAdTime() {
        return AdShowTimeManager.getInstance().getLastInsertPageAdTime();
    }

    public long getLastInsertVideoAdTime() {
        return AdShowTimeManager.getInstance().getLastInsertVideoAdTime();
    }

    public long getLastVideoAdTime() {
        return AdShowTimeManager.getInstance().getLastVideoAdTime();
    }

    public boolean isVip() {
        return VipManager.getIns().isVip();
    }

    public boolean isBuyVip() {
        return VipManager.getIns().isVip();
    }

    public boolean isAdFreeUseEnable() {
        return AdManagerVideo.getInstance().getFreeUseEnable();
    }

    public void showBuyDialog(FragmentActivity activity, BuyListener showListener) {
        new PackageDialog(activity, showListener).show(activity.getSupportFragmentManager(), "PayDialog");
    }

    public boolean showInsertPageAd(Activity activity) {
        return AdManagerInsertPage.getInstance().show(activity);
    }

    public boolean showInsertVideoAd(Activity activity, ShowListener showListener) {
        return AdManagerInsertVideo.getInstance().showRewardedVideo(activity, showListener);
    }

    public void loadNativeAd(boolean refresh) {
        AdManagerNative.getInstance().loadNativeAd(refresh);
    }

    public boolean hasWatchedVideoAd() {
        return AdShowTimeManager.getInstance().hasWatchVideoAd();
    }

    public void startCheckVip(Activity activity) {
        try {
            releaseVipCheck();
            this.mVipCheckManager = new VipCheckManager();
            this.mVipCheckManager.doCheck(activity);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void releaseVipCheck() {
        if (this.mVipCheckManager != null) {
            this.mVipCheckManager.destory();
            this.mVipCheckManager = null;
        }
    }

    public void setFreeUseListener(FreeUseListener freeUseListener) {
        AdManagerVideo.getInstance().setFreeUseListener(freeUseListener);
    }

    public void setNativeAdListener(NativeAdListener nativeAdListener) {
        AdManagerNative.getInstance().setNativeAdListener(nativeAdListener);
    }
}