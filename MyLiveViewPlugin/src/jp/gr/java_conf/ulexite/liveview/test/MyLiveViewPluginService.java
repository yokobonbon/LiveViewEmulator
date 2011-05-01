package jp.gr.java_conf.ulexite.liveview.test;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.sonyericsson.extras.liveview.plugins.AbstractPluginService;
import com.sonyericsson.extras.liveview.plugins.PluginConstants;
import com.sonyericsson.extras.liveview.plugins.PluginUtils;

public class MyLiveViewPluginService extends AbstractPluginService {
	private static final String TAG = "MyLiveViewPlugin";

	@Override
	protected boolean isSandboxPlugin() {
		return true;
	}

	@Override
	protected void onServiceConnectedExtended(ComponentName className,
			IBinder service) {
		Log.d(TAG, "onServiceConnectedExtended");						
	}

	@Override
	protected void onServiceDisconnectedExtended(ComponentName className) {
		Log.d(TAG, "onServiceDisconnectedExtended");								
	}

	@Override
	protected void onSharedPreferenceChangedExtended(SharedPreferences pref,
			String key) {
		Log.d(TAG, "onSharedPreferenceChangedExtended");								
	}

	@Override
	protected void startWork() {
		Log.d(TAG, "startWork");
		PluginUtils.sendTextBitmap(mLiveViewAdapter, mPluginId, "start", 128, 30);
	}

	@Override
	protected void stopWork() {
		Log.d(TAG, "stopWork");
	}

	@Override
	protected void startPlugin() {
		Log.d(TAG, "startPlugin");
		startWork();
	}

	@Override
	protected void stopPlugin() {
		Log.d(TAG, "stopPlugin");
		stopWork();
	}

	@Override
	protected void button(String buttonType, boolean doublepress,
			boolean longpress) {
		Log.d(TAG, "buttonType = " + buttonType + " doublepress = " + String.valueOf(doublepress) 
				+ " longpress = " + String.valueOf(longpress));
		PluginUtils.sendTextBitmap(mLiveViewAdapter, mPluginId, buttonType, 128, 30);
	}

	@Override
	protected void displayCaps(int displayWidthPx, int displayHeigthPx) {
		Log.d(TAG, "displayCaps width = " + String.valueOf(displayWidthPx) + " height = " 
				+ String.valueOf(displayHeigthPx));
	}

	@Override
	protected void onUnregistered() throws RemoteException {
		Log.d(TAG, "onUnregistered");
	}

	@Override
	protected void openInPhone(String openInPhoneAction) {
		Log.d(TAG, "openInPhone openInPhoneAction = " + String.valueOf(openInPhoneAction));		
	}

	@Override
	protected void screenMode(int mode) {
		Log.d(TAG, "screenMode mode = " + String.valueOf(mode));				
	}
}
