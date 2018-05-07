package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public abstract class ByteSink implements OutputSupplier<OutputStream> {

    private final class AsCharSink extends CharSink {
        private final Charset charset;

        private AsCharSink(Charset charset) {
            this.charset = (Charset) Preconditions.checkNotNull(charset);
        }

        public Writer openStream() throws IOException {
            return new OutputStreamWriter(ByteSink.this.openStream(), this.charset);
        }

        public String toString() {
            return ByteSink.this.toString() + ".asCharSink(" + this.charset + ")";
        }
    }

    public abstract OutputStream openStream() throws IOException;

    protected ByteSink() {
    }

    public CharSink asCharSink(Charset charset) {
        return new AsCharSink(charset);
    }

    @Deprecated
    public final OutputStream getOutput() throws IOException {
        return openStream();
    }

    public OutputStream openBufferedStream() throws IOException {
        OutputStream out = openStream();
        return out instanceof BufferedOutputStream ? (BufferedOutputStream) out : new BufferedOutputStream(out);
    }

    public void write(byte[] bytes) throws IOException {
        Preconditions.checkNotNull(bytes);
        Closer closer = Closer.create();
        try {
            OutputStream out = (OutputStream) closer.register(openStream());
            out.write(bytes);
            out.flush();
            closer.close();
        } catch (Throwable th) {
            closer.close();
        }
    }

    public long writeFrom(InputStream input) throws IOException {
        Preconditions.checkNotNull(input);
        Closer closer = Closer.create();
        try {
            OutputStream out = (OutputStream) closer.register(openStream());
            long written = ByteStreams.copy(input, out);
            out.flush();
            closer.close();
            return written;
        } catch (Throwable th) {
            closer.close();
        }
    }
}
