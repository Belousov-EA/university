package com.google.android.gms.internal;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

final class zzele {
    private final Random random = new Random();
    private final Thread zzndy = zzeku.getThreadFactory().newThread(new zzelf(this));
    private zzeku zznep;
    private volatile boolean zznes = false;
    private BlockingQueue<ByteBuffer> zznet;
    private boolean zzneu = false;
    private WritableByteChannel zznev;

    zzele(zzeku com_google_android_gms_internal_zzeku, String str, int i) {
        zzeku.zzcas().zza(this.zzndy, new StringBuilder(String.valueOf(str).length() + 18).append(str).append("Writer-").append(i).toString());
        this.zznep = com_google_android_gms_internal_zzeku;
        this.zznet = new LinkedBlockingQueue();
    }

    private final void zzcbb() throws InterruptedException, IOException {
        this.zznev.write((ByteBuffer) this.zznet.take());
    }

    private final void zzcbd() {
        while (!this.zznes && !Thread.interrupted()) {
            try {
                zzcbb();
            } catch (Throwable e) {
                this.zznep.zzb(new zzela("IO Exception", e));
                return;
            } catch (InterruptedException e2) {
                return;
            }
        }
        for (int i = 0; i < this.zznet.size(); i++) {
            zzcbb();
        }
    }

    final synchronized void zza(byte b, boolean z, byte[] bArr) throws IOException {
        synchronized (this) {
            int i = 6;
            int length = bArr.length;
            if (length >= TransportMediator.KEYCODE_MEDIA_PLAY) {
                i = length <= SupportMenu.USER_MASK ? 8 : 14;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i + bArr.length);
            allocate.put((byte) (b | -128));
            if (length < TransportMediator.KEYCODE_MEDIA_PLAY) {
                allocate.put((byte) (length | 128));
            } else if (length <= SupportMenu.USER_MASK) {
                allocate.put((byte) -2);
                allocate.putShort((short) length);
            } else {
                allocate.put((byte) -1);
                allocate.putInt(0);
                allocate.putInt(length);
            }
            byte[] bArr2 = new byte[4];
            this.random.nextBytes(bArr2);
            allocate.put(bArr2);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                allocate.put((byte) (bArr[i2] ^ bArr2[i2 % 4]));
            }
            allocate.flip();
            if (!this.zznes || (!this.zzneu && b == (byte) 8)) {
                if (b == (byte) 8) {
                    this.zzneu = true;
                }
                this.zznet.add(allocate);
            } else {
                throw new zzela("Shouldn't be sending");
            }
        }
    }

    final void zzb(OutputStream outputStream) {
        this.zznev = Channels.newChannel(outputStream);
    }

    final void zzcbc() {
        this.zznes = true;
    }

    final Thread zzcbe() {
        return this.zzndy;
    }
}
