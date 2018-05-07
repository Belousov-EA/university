package ru.mgvk.velness.util;

import android.app.Service;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BLEScannerService extends Service {
    private static final String TAG = BLEScannerService.class.getSimpleName();
    private long lastFail = 0;
    private OnBeaconEventListener mBeaconEventListener;
    private LocalBinder mBinder = new LocalBinder();
    private BluetoothLeScanner mBluetoothLeScanner;
    private ScanCallback mScanCallback;
    ArrayList<String> uuids = new ArrayList();

    class C04441 extends ScanCallback {
        private final char[] hexArray = "0123456789ABCDEF".toCharArray();

        C04441() {
        }

        public void onScanResult(int callbackType, ScanResult result) {
            processResult(result);
        }

        public void onScanFailed(int errorCode) {
            BLEScannerService.this.processFailure();
        }

        public void onBatchScanResults(List<ScanResult> results) {
            for (ScanResult result : results) {
                if (processResult(result)) {
                    return;
                }
            }
        }

        public String bytesToHex(byte[] bytes) {
            char[] hexChars = new char[(bytes.length * 2)];
            for (int j = 0; j < bytes.length; j++) {
                int v = bytes[j] & 255;
                hexChars[j * 2] = this.hexArray[v >>> 4];
                hexChars[(j * 2) + 1] = this.hexArray[v & 15];
            }
            return new String(hexChars);
        }

        private boolean processResult(ScanResult result) {
            Log.d(BLEScannerService.TAG, "processResult: " + result.getDevice().getAddress());
            if (result.getDevice().getAddress().contains("F4")) {
                Log.d(BLEScannerService.TAG, "processResult DATA: " + bytesToHex(result.getScanRecord().getBytes()));
            }
            String uuid = bytesToHex(Arrays.copyOfRange(result.getScanRecord().getBytes(), 9, 25));
            Log.d(BLEScannerService.TAG, "processResult uuid:" + uuid);
            Iterator it = BLEScannerService.this.uuids.iterator();
            while (it.hasNext()) {
                if (uuid.equals((String) it.next())) {
                    BLEScannerService.this.processSuccess();
                    return true;
                }
            }
            BLEScannerService.this.processFailure();
            return false;
        }
    }

    public class LocalBinder extends Binder {
        public BLEScannerService getService() {
            return BLEScannerService.this;
        }
    }

    public interface OnBeaconEventListener {
        void onBeaconFound();

        void onError();
    }

    public void onCreate() {
        Throwable e;
        super.onCreate();
        try {
            this.mScanCallback = new C04441();
            this.mBluetoothLeScanner = ((BluetoothManager) getSystemService("bluetooth")).getAdapter().getBluetoothLeScanner();
        } catch (Error e2) {
            e = e2;
            e.printStackTrace();
            if (this.mBluetoothLeScanner == null) {
                startScanning();
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (this.mBluetoothLeScanner == null) {
                startScanning();
            }
        }
        if (this.mBluetoothLeScanner == null) {
            startScanning();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        stopScanning();
    }

    public void addUUID(String uuid) {
        this.uuids.add(uuid);
    }

    public void addUUIDs(ArrayList<String> list) {
        this.uuids.addAll(list);
    }

    public void setBeaconEventListener(OnBeaconEventListener listener) {
        this.mBeaconEventListener = listener;
    }

    private void processFailure() {
        if (this.mBeaconEventListener != null && System.currentTimeMillis() - this.lastFail > 60000) {
            this.lastFail = System.currentTimeMillis();
            this.mBeaconEventListener.onError();
        }
    }

    private void processSuccess() {
        if (this.mBeaconEventListener != null) {
            this.mBeaconEventListener.onBeaconFound();
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    private void startScanning() {
        this.mBluetoothLeScanner.startScan(this.mScanCallback);
        Log.d(TAG, "Scanning started…");
    }

    private void stopScanning() {
        Throwable e;
        try {
            this.mBluetoothLeScanner.stopScan(this.mScanCallback);
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            Log.d(TAG, "Scanning stopped…");
        } catch (Error e3) {
            e = e3;
            e.printStackTrace();
            Log.d(TAG, "Scanning stopped…");
        }
        Log.d(TAG, "Scanning stopped…");
    }
}
