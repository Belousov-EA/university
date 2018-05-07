package com.google.android.gms.common.images;

public final class Size {
    private final int zzalv;
    private final int zzalw;

    public Size(int i, int i2) {
        this.zzalv = i;
        this.zzalw = i2;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(120);
        }
        if (indexOf < 0) {
            throw zzgd(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (NumberFormatException e) {
            throw zzgd(str);
        }
    }

    private static NumberFormatException zzgd(String str) {
        throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 16).append("Invalid Size: \"").append(str).append("\"").toString());
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.zzalv == size.zzalv && this.zzalw == size.zzalw;
    }

    public final int getHeight() {
        return this.zzalw;
    }

    public final int getWidth() {
        return this.zzalv;
    }

    public final int hashCode() {
        return this.zzalw ^ ((this.zzalv << 16) | (this.zzalv >>> 16));
    }

    public final String toString() {
        int i = this.zzalv;
        return i + "x" + this.zzalw;
    }
}
