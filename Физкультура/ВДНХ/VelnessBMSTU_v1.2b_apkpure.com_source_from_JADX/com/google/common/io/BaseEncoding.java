package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
@Beta
public abstract class BaseEncoding {
    private static final BaseEncoding BASE16 = new StandardBaseEncoding("base16()", "0123456789ABCDEF", null);
    private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
    private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
    private static final BaseEncoding BASE64 = new StandardBaseEncoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
    private static final BaseEncoding BASE64_URL = new StandardBaseEncoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));

    public static final class DecodingException extends IOException {
        DecodingException(String message) {
            super(message);
        }

        DecodingException(Throwable cause) {
            initCause(cause);
        }
    }

    static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;
        private final CharMatcher separatorChars;

        SeparatedBaseEncoding(BaseEncoding delegate, String separator, int afterEveryChars) {
            boolean z;
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(delegate);
            this.separator = (String) Preconditions.checkNotNull(separator);
            this.afterEveryChars = afterEveryChars;
            if (afterEveryChars > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot add a separator after every %s chars", Integer.valueOf(afterEveryChars));
            this.separatorChars = CharMatcher.anyOf(separator).precomputed();
        }

        CharMatcher padding() {
            return this.delegate.padding();
        }

        int maxEncodedSize(int bytes) {
            int unseparatedSize = this.delegate.maxEncodedSize(bytes);
            return (this.separator.length() * IntMath.divide(Math.max(0, unseparatedSize - 1), this.afterEveryChars, RoundingMode.FLOOR)) + unseparatedSize;
        }

        ByteOutput encodingStream(CharOutput output) {
            return this.delegate.encodingStream(BaseEncoding.separatingOutput(output, this.separator, this.afterEveryChars));
        }

        int maxDecodedSize(int chars) {
            return this.delegate.maxDecodedSize(chars);
        }

        ByteInput decodingStream(CharInput input) {
            return this.delegate.decodingStream(BaseEncoding.ignoringInput(input, this.separatorChars));
        }

        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        public BaseEncoding withPadChar(char padChar) {
            return this.delegate.withPadChar(padChar).withSeparator(this.separator, this.afterEveryChars);
        }

        public BaseEncoding withSeparator(String separator, int afterEveryChars) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            return this.delegate.toString() + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
        }
    }

    static final class StandardBaseEncoding extends BaseEncoding {
        private final Alphabet alphabet;
        private transient BaseEncoding lowerCase;
        @Nullable
        private final Character paddingChar;
        private transient BaseEncoding upperCase;

        StandardBaseEncoding(String name, String alphabetChars, @Nullable Character paddingChar) {
            this(new Alphabet(name, alphabetChars.toCharArray()), paddingChar);
        }

        StandardBaseEncoding(Alphabet alphabet, @Nullable Character paddingChar) {
            boolean z;
            this.alphabet = (Alphabet) Preconditions.checkNotNull(alphabet);
            if (paddingChar == null || !alphabet.matches(paddingChar.charValue())) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Padding character %s was already in alphabet", paddingChar);
            this.paddingChar = paddingChar;
        }

        CharMatcher padding() {
            return this.paddingChar == null ? CharMatcher.NONE : CharMatcher.is(this.paddingChar.charValue());
        }

        int maxEncodedSize(int bytes) {
            return this.alphabet.charsPerChunk * IntMath.divide(bytes, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        ByteOutput encodingStream(final CharOutput out) {
            Preconditions.checkNotNull(out);
            return new ByteOutput() {
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int writtenChars = 0;

                public void write(byte b) throws IOException {
                    this.bitBuffer <<= 8;
                    this.bitBuffer |= b & 255;
                    this.bitBufferLength += 8;
                    while (this.bitBufferLength >= StandardBaseEncoding.this.alphabet.bitsPerChar) {
                        out.write(StandardBaseEncoding.this.alphabet.encode((this.bitBuffer >> (this.bitBufferLength - StandardBaseEncoding.this.alphabet.bitsPerChar)) & StandardBaseEncoding.this.alphabet.mask));
                        this.writtenChars++;
                        this.bitBufferLength -= StandardBaseEncoding.this.alphabet.bitsPerChar;
                    }
                }

                public void flush() throws IOException {
                    out.flush();
                }

                public void close() throws IOException {
                    if (this.bitBufferLength > 0) {
                        out.write(StandardBaseEncoding.this.alphabet.encode((this.bitBuffer << (StandardBaseEncoding.this.alphabet.bitsPerChar - this.bitBufferLength)) & StandardBaseEncoding.this.alphabet.mask));
                        this.writtenChars++;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (this.writtenChars % StandardBaseEncoding.this.alphabet.charsPerChunk != 0) {
                                out.write(StandardBaseEncoding.this.paddingChar.charValue());
                                this.writtenChars++;
                            }
                        }
                    }
                    out.close();
                }
            };
        }

        int maxDecodedSize(int chars) {
            return (int) (((((long) this.alphabet.bitsPerChar) * ((long) chars)) + 7) / 8);
        }

        ByteInput decodingStream(final CharInput reader) {
            Preconditions.checkNotNull(reader);
            return new ByteInput() {
                int bitBuffer = 0;
                int bitBufferLength = 0;
                boolean hitPadding = false;
                final CharMatcher paddingMatcher = StandardBaseEncoding.this.padding();
                int readChars = 0;

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public int read() throws java.io.IOException {
                    /*
                    r6 = this;
                    r5 = 1;
                    r2 = -1;
                L_0x0002:
                    r3 = r2;
                    r1 = r3.read();
                    if (r1 != r2) goto L_0x0037;
                L_0x000a:
                    r3 = r6.hitPadding;
                    if (r3 != 0) goto L_0x00e1;
                L_0x000e:
                    r3 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this;
                    r3 = r3.alphabet;
                    r4 = r6.readChars;
                    r3 = r3.isValidPaddingStartPosition(r4);
                    if (r3 != 0) goto L_0x00e1;
                L_0x001c:
                    r2 = new com.google.common.io.BaseEncoding$DecodingException;
                    r3 = new java.lang.StringBuilder;
                    r3.<init>();
                    r4 = "Invalid input length ";
                    r3 = r3.append(r4);
                    r4 = r6.readChars;
                    r3 = r3.append(r4);
                    r3 = r3.toString();
                    r2.<init>(r3);
                    throw r2;
                L_0x0037:
                    r3 = r6.readChars;
                    r3 = r3 + 1;
                    r6.readChars = r3;
                    r0 = (char) r1;
                    r3 = r6.paddingMatcher;
                    r3 = r3.matches(r0);
                    if (r3 == 0) goto L_0x007c;
                L_0x0046:
                    r3 = r6.hitPadding;
                    if (r3 != 0) goto L_0x0079;
                L_0x004a:
                    r3 = r6.readChars;
                    if (r3 == r5) goto L_0x005e;
                L_0x004e:
                    r3 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this;
                    r3 = r3.alphabet;
                    r4 = r6.readChars;
                    r4 = r4 + -1;
                    r3 = r3.isValidPaddingStartPosition(r4);
                    if (r3 != 0) goto L_0x0079;
                L_0x005e:
                    r2 = new com.google.common.io.BaseEncoding$DecodingException;
                    r3 = new java.lang.StringBuilder;
                    r3.<init>();
                    r4 = "Padding cannot start at index ";
                    r3 = r3.append(r4);
                    r4 = r6.readChars;
                    r3 = r3.append(r4);
                    r3 = r3.toString();
                    r2.<init>(r3);
                    throw r2;
                L_0x0079:
                    r6.hitPadding = r5;
                    goto L_0x0002;
                L_0x007c:
                    r3 = r6.hitPadding;
                    if (r3 == 0) goto L_0x00a5;
                L_0x0080:
                    r2 = new com.google.common.io.BaseEncoding$DecodingException;
                    r3 = new java.lang.StringBuilder;
                    r3.<init>();
                    r4 = "Expected padding character but found '";
                    r3 = r3.append(r4);
                    r3 = r3.append(r0);
                    r4 = "' at index ";
                    r3 = r3.append(r4);
                    r4 = r6.readChars;
                    r3 = r3.append(r4);
                    r3 = r3.toString();
                    r2.<init>(r3);
                    throw r2;
                L_0x00a5:
                    r3 = r6.bitBuffer;
                    r4 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this;
                    r4 = r4.alphabet;
                    r4 = r4.bitsPerChar;
                    r3 = r3 << r4;
                    r6.bitBuffer = r3;
                    r3 = r6.bitBuffer;
                    r4 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this;
                    r4 = r4.alphabet;
                    r4 = r4.decode(r0);
                    r3 = r3 | r4;
                    r6.bitBuffer = r3;
                    r3 = r6.bitBufferLength;
                    r4 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this;
                    r4 = r4.alphabet;
                    r4 = r4.bitsPerChar;
                    r3 = r3 + r4;
                    r6.bitBufferLength = r3;
                    r3 = r6.bitBufferLength;
                    r4 = 8;
                    if (r3 < r4) goto L_0x0002;
                L_0x00d4:
                    r2 = r6.bitBufferLength;
                    r2 = r2 + -8;
                    r6.bitBufferLength = r2;
                    r2 = r6.bitBuffer;
                    r3 = r6.bitBufferLength;
                    r2 = r2 >> r3;
                    r2 = r2 & 255;
                L_0x00e1:
                    return r2;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.2.read():int");
                }

                public void close() throws IOException {
                    reader.close();
                }
            };
        }

        public BaseEncoding omitPadding() {
            return this.paddingChar == null ? this : new StandardBaseEncoding(this.alphabet, null);
        }

        public BaseEncoding withPadChar(char padChar) {
            if (8 % this.alphabet.bitsPerChar != 0) {
                return (this.paddingChar == null || this.paddingChar.charValue() != padChar) ? new StandardBaseEncoding(this.alphabet, Character.valueOf(padChar)) : this;
            } else {
                return this;
            }
        }

        public BaseEncoding withSeparator(String separator, int afterEveryChars) {
            Preconditions.checkNotNull(separator);
            Preconditions.checkArgument(padding().or(this.alphabet).matchesNoneOf(separator), "Separator cannot contain alphabet or padding characters");
            return new SeparatedBaseEncoding(this, separator, afterEveryChars);
        }

        public BaseEncoding upperCase() {
            BaseEncoding result = this.upperCase;
            if (result == null) {
                Alphabet upper = this.alphabet.upperCase();
                result = upper == this.alphabet ? this : new StandardBaseEncoding(upper, this.paddingChar);
                this.upperCase = result;
            }
            return result;
        }

        public BaseEncoding lowerCase() {
            BaseEncoding result = this.lowerCase;
            if (result == null) {
                Alphabet lower = this.alphabet.lowerCase();
                result = lower == this.alphabet ? this : new StandardBaseEncoding(lower, this.paddingChar);
                this.lowerCase = result;
            }
            return result;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder("BaseEncoding.");
            builder.append(this.alphabet.toString());
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    builder.append(".omitPadding()");
                } else {
                    builder.append(".withPadChar(").append(this.paddingChar).append(')');
                }
            }
            return builder.toString();
        }
    }

    private static final class Alphabet extends CharMatcher {
        final int bitsPerChar;
        final int bytesPerChunk;
        private final char[] chars;
        final int charsPerChunk;
        private final byte[] decodabet;
        final int mask;
        private final String name;
        private final boolean[] validPadding;

        Alphabet(String name, char[] chars) {
            this.name = (String) Preconditions.checkNotNull(name);
            this.chars = (char[]) Preconditions.checkNotNull(chars);
            try {
                int i;
                this.bitsPerChar = IntMath.log2(chars.length, RoundingMode.UNNECESSARY);
                int gcd = Math.min(8, Integer.lowestOneBit(this.bitsPerChar));
                this.charsPerChunk = 8 / gcd;
                this.bytesPerChunk = this.bitsPerChar / gcd;
                this.mask = chars.length - 1;
                byte[] decodabet = new byte[128];
                Arrays.fill(decodabet, (byte) -1);
                for (i = 0; i < chars.length; i++) {
                    boolean z;
                    char c = chars[i];
                    Preconditions.checkArgument(CharMatcher.ASCII.matches(c), "Non-ASCII character: %s", Character.valueOf(c));
                    if (decodabet[c] == (byte) -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "Duplicate character: %s", Character.valueOf(c));
                    decodabet[c] = (byte) i;
                }
                this.decodabet = decodabet;
                boolean[] validPadding = new boolean[this.charsPerChunk];
                for (i = 0; i < this.bytesPerChunk; i++) {
                    validPadding[IntMath.divide(i * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
                }
                this.validPadding = validPadding;
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException("Illegal alphabet length " + chars.length, e);
            }
        }

        char encode(int bits) {
            return this.chars[bits];
        }

        boolean isValidPaddingStartPosition(int index) {
            return this.validPadding[index % this.charsPerChunk];
        }

        int decode(char ch) throws IOException {
            if (ch <= Ascii.MAX && this.decodabet[ch] != (byte) -1) {
                return this.decodabet[ch];
            }
            throw new DecodingException("Unrecognized character: " + ch);
        }

        private boolean hasLowerCase() {
            for (char c : this.chars) {
                if (Ascii.isLowerCase(c)) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasUpperCase() {
            for (char c : this.chars) {
                if (Ascii.isUpperCase(c)) {
                    return true;
                }
            }
            return false;
        }

        Alphabet upperCase() {
            if (!hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] upperCased = new char[this.chars.length];
            for (int i = 0; i < this.chars.length; i++) {
                upperCased[i] = Ascii.toUpperCase(this.chars[i]);
            }
            return new Alphabet(this.name + ".upperCase()", upperCased);
        }

        Alphabet lowerCase() {
            if (!hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] lowerCased = new char[this.chars.length];
            for (int i = 0; i < this.chars.length; i++) {
                lowerCased[i] = Ascii.toLowerCase(this.chars[i]);
            }
            return new Alphabet(this.name + ".lowerCase()", lowerCased);
        }

        public boolean matches(char c) {
            return CharMatcher.ASCII.matches(c) && this.decodabet[c] != (byte) -1;
        }

        public String toString() {
            return this.name;
        }
    }

    abstract ByteInput decodingStream(CharInput charInput);

    abstract ByteOutput encodingStream(CharOutput charOutput);

    @CheckReturnValue
    public abstract BaseEncoding lowerCase();

    abstract int maxDecodedSize(int i);

    abstract int maxEncodedSize(int i);

    @CheckReturnValue
    public abstract BaseEncoding omitPadding();

    abstract CharMatcher padding();

    @CheckReturnValue
    public abstract BaseEncoding upperCase();

    @CheckReturnValue
    public abstract BaseEncoding withPadChar(char c);

    @CheckReturnValue
    public abstract BaseEncoding withSeparator(String str, int i);

    BaseEncoding() {
    }

    public String encode(byte[] bytes) {
        return encode((byte[]) Preconditions.checkNotNull(bytes), 0, bytes.length);
    }

    public final String encode(byte[] bytes, int off, int len) {
        Preconditions.checkNotNull(bytes);
        Preconditions.checkPositionIndexes(off, off + len, bytes.length);
        CharOutput result = GwtWorkarounds.stringBuilderOutput(maxEncodedSize(len));
        ByteOutput byteOutput = encodingStream(result);
        int i = 0;
        while (i < len) {
            try {
                byteOutput.write(bytes[off + i]);
                i++;
            } catch (IOException e) {
                throw new AssertionError("impossible");
            }
        }
        byteOutput.close();
        return result.toString();
    }

    @GwtIncompatible("Writer,OutputStream")
    public final OutputStream encodingStream(Writer writer) {
        return GwtWorkarounds.asOutputStream(encodingStream(GwtWorkarounds.asCharOutput(writer)));
    }

    @GwtIncompatible("ByteSink,CharSink")
    public final ByteSink encodingSink(final CharSink encodedSink) {
        Preconditions.checkNotNull(encodedSink);
        return new ByteSink() {
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(encodedSink.openStream());
            }
        };
    }

    private static byte[] extract(byte[] result, int length) {
        if (length == result.length) {
            return result;
        }
        byte[] trunc = new byte[length];
        System.arraycopy(result, 0, trunc, 0, length);
        return trunc;
    }

    public final byte[] decode(CharSequence chars) {
        try {
            return decodeChecked(chars);
        } catch (DecodingException badInput) {
            throw new IllegalArgumentException(badInput);
        }
    }

    final byte[] decodeChecked(CharSequence chars) throws DecodingException {
        chars = padding().trimTrailingFrom(chars);
        ByteInput decodedInput = decodingStream(GwtWorkarounds.asCharInput(chars));
        byte[] tmp = new byte[maxDecodedSize(chars.length())];
        try {
            int i = decodedInput.read();
            int index = 0;
            while (i != -1) {
                int index2 = index + 1;
                tmp[index] = (byte) i;
                i = decodedInput.read();
                index = index2;
            }
            return extract(tmp, index);
        } catch (DecodingException badInput) {
            throw badInput;
        } catch (IOException impossible) {
            throw new AssertionError(impossible);
        }
    }

    @GwtIncompatible("Reader,InputStream")
    public final InputStream decodingStream(Reader reader) {
        return GwtWorkarounds.asInputStream(decodingStream(GwtWorkarounds.asCharInput(reader)));
    }

    @GwtIncompatible("ByteSource,CharSource")
    public final ByteSource decodingSource(final CharSource encodedSource) {
        Preconditions.checkNotNull(encodedSource);
        return new ByteSource() {
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(encodedSource.openStream());
            }
        };
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    static CharInput ignoringInput(final CharInput delegate, final CharMatcher toIgnore) {
        Preconditions.checkNotNull(delegate);
        Preconditions.checkNotNull(toIgnore);
        return new CharInput() {
            public int read() throws IOException {
                int readChar;
                do {
                    readChar = delegate.read();
                    if (readChar == -1) {
                        break;
                    }
                } while (toIgnore.matches((char) readChar));
                return readChar;
            }

            public void close() throws IOException {
                delegate.close();
            }
        };
    }

    static CharOutput separatingOutput(final CharOutput delegate, final String separator, final int afterEveryChars) {
        Preconditions.checkNotNull(delegate);
        Preconditions.checkNotNull(separator);
        Preconditions.checkArgument(afterEveryChars > 0);
        return new CharOutput() {
            int charsUntilSeparator = afterEveryChars;

            public void write(char c) throws IOException {
                if (this.charsUntilSeparator == 0) {
                    for (int i = 0; i < separator.length(); i++) {
                        delegate.write(separator.charAt(i));
                    }
                    this.charsUntilSeparator = afterEveryChars;
                }
                delegate.write(c);
                this.charsUntilSeparator--;
            }

            public void flush() throws IOException {
                delegate.flush();
            }

            public void close() throws IOException {
                delegate.close();
            }
        };
    }
}
