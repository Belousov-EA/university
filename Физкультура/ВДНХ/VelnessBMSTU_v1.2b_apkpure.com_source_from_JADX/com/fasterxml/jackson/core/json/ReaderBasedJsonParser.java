package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public final class ReaderBasedJsonParser extends ParserBase {
    protected final int _hashSeed;
    protected char[] _inputBuffer;
    protected ObjectCodec _objectCodec;
    protected Reader _reader;
    protected final CharsToNameCanonicalizer _symbols;
    protected boolean _tokenIncomplete = false;

    public ReaderBasedJsonParser(IOContext ctxt, int features, Reader r, ObjectCodec codec, CharsToNameCanonicalizer st) {
        super(ctxt, features);
        this._reader = r;
        this._inputBuffer = ctxt.allocTokenBuffer();
        this._objectCodec = codec;
        this._symbols = st;
        this._hashSeed = st.hashSeed();
    }

    public Version version() {
        return CoreVersion.instance.version();
    }

    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    public void setCodec(ObjectCodec c) {
        this._objectCodec = c;
    }

    public int releaseBuffered(Writer w) throws IOException {
        int count = this._inputEnd - this._inputPtr;
        if (count < 1) {
            return 0;
        }
        w.write(this._inputBuffer, this._inputPtr, count);
        return count;
    }

    public Object getInputSource() {
        return this._reader;
    }

    protected boolean loadMore() throws IOException {
        this._currInputProcessed += (long) this._inputEnd;
        this._currInputRowStart -= this._inputEnd;
        if (this._reader == null) {
            return false;
        }
        int count = this._reader.read(this._inputBuffer, 0, this._inputBuffer.length);
        if (count > 0) {
            this._inputPtr = 0;
            this._inputEnd = count;
            return true;
        }
        _closeInput();
        if (count != 0) {
            return false;
        }
        throw new IOException("Reader returned 0 characters when trying to read " + this._inputEnd);
    }

    protected char getNextChar(String eofMsg) throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(eofMsg);
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return cArr[i];
    }

    protected void _closeInput() throws IOException {
        if (this._reader != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(Feature.AUTO_CLOSE_SOURCE)) {
                this._reader.close();
            }
            this._reader = null;
        }
    }

    protected void _releaseBuffers() throws IOException {
        super._releaseBuffers();
        char[] buf = this._inputBuffer;
        if (buf != null) {
            this._inputBuffer = null;
            this._ioContext.releaseTokenBuffer(buf);
        }
    }

    public String getText() throws IOException, JsonParseException {
        JsonToken t = this._currToken;
        if (t != JsonToken.VALUE_STRING) {
            return _getText2(t);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    public String getValueAsString() throws IOException, JsonParseException {
        if (this._currToken != JsonToken.VALUE_STRING) {
            return super.getValueAsString(null);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    public String getValueAsString(String defValue) throws IOException, JsonParseException {
        if (this._currToken != JsonToken.VALUE_STRING) {
            return super.getValueAsString(defValue);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    protected String _getText2(JsonToken t) {
        if (t == null) {
            return null;
        }
        switch (t) {
            case FIELD_NAME:
                return this._parsingContext.getCurrentName();
            case VALUE_STRING:
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                return this._textBuffer.contentsAsString();
            default:
                return t.asString();
        }
    }

    public char[] getTextCharacters() throws IOException, JsonParseException {
        if (this._currToken == null) {
            return null;
        }
        switch (this._currToken) {
            case FIELD_NAME:
                if (!this._nameCopied) {
                    String name = this._parsingContext.getCurrentName();
                    int nameLen = name.length();
                    if (this._nameCopyBuffer == null) {
                        this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(nameLen);
                    } else if (this._nameCopyBuffer.length < nameLen) {
                        this._nameCopyBuffer = new char[nameLen];
                    }
                    name.getChars(0, nameLen, this._nameCopyBuffer, 0);
                    this._nameCopied = true;
                }
                return this._nameCopyBuffer;
            case VALUE_STRING:
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                    break;
                }
                break;
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                break;
            default:
                return this._currToken.asCharArray();
        }
        return this._textBuffer.getTextBuffer();
    }

    public int getTextLength() throws IOException, JsonParseException {
        if (this._currToken == null) {
            return 0;
        }
        switch (this._currToken) {
            case FIELD_NAME:
                return this._parsingContext.getCurrentName().length();
            case VALUE_STRING:
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                    break;
                }
                break;
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                break;
            default:
                return this._currToken.asCharArray().length;
        }
        return this._textBuffer.size();
    }

    public int getTextOffset() throws IOException, JsonParseException {
        if (this._currToken == null) {
            return 0;
        }
        switch (this._currToken) {
            case VALUE_STRING:
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                    break;
                }
                break;
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                break;
            default:
                return 0;
        }
        return this._textBuffer.getTextOffset();
    }

    public Object getEmbeddedObject() throws IOException, JsonParseException {
        return null;
    }

    public byte[] getBinaryValue(Base64Variant b64variant) throws IOException, JsonParseException {
        if (this._currToken != JsonToken.VALUE_STRING && (this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT || this._binaryValue == null)) {
            _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this._tokenIncomplete) {
            try {
                this._binaryValue = _decodeBase64(b64variant);
                this._tokenIncomplete = false;
            } catch (IllegalArgumentException iae) {
                throw _constructError("Failed to decode VALUE_STRING as base64 (" + b64variant + "): " + iae.getMessage());
            }
        } else if (this._binaryValue == null) {
            ByteArrayBuilder builder = _getByteArrayBuilder();
            _decodeBase64(getText(), builder, b64variant);
            this._binaryValue = builder.toByteArray();
        }
        return this._binaryValue;
    }

    public int readBinaryValue(Base64Variant b64variant, OutputStream out) throws IOException, JsonParseException {
        if (this._tokenIncomplete && this._currToken == JsonToken.VALUE_STRING) {
            byte[] buf = this._ioContext.allocBase64Buffer();
            try {
                int _readBinary = _readBinary(b64variant, out, buf);
                return _readBinary;
            } finally {
                this._ioContext.releaseBase64Buffer(buf);
            }
        } else {
            byte[] b = getBinaryValue(b64variant);
            out.write(b);
            return b.length;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected int _readBinary(com.fasterxml.jackson.core.Base64Variant r11, java.io.OutputStream r12, byte[] r13) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
        r10 = this;
        r5 = 0;
        r7 = r13.length;
        r4 = r7 + -3;
        r3 = 0;
    L_0x0005:
        r7 = r10._inputPtr;
        r8 = r10._inputEnd;
        if (r7 < r8) goto L_0x000e;
    L_0x000b:
        r10.loadMoreGuaranteed();
    L_0x000e:
        r7 = r10._inputBuffer;
        r8 = r10._inputPtr;
        r9 = r8 + 1;
        r10._inputPtr = r9;
        r1 = r7[r8];
        r7 = 32;
        if (r1 <= r7) goto L_0x0005;
    L_0x001c:
        r0 = r11.decodeBase64Char(r1);
        if (r0 >= 0) goto L_0x0038;
    L_0x0022:
        r7 = 34;
        if (r1 != r7) goto L_0x0031;
    L_0x0026:
        r7 = 0;
        r10._tokenIncomplete = r7;
        if (r5 <= 0) goto L_0x0030;
    L_0x002b:
        r3 = r3 + r5;
        r7 = 0;
        r12.write(r13, r7, r5);
    L_0x0030:
        return r3;
    L_0x0031:
        r7 = 0;
        r0 = r10._decodeBase64Escape(r11, r1, r7);
        if (r0 < 0) goto L_0x0005;
    L_0x0038:
        if (r5 <= r4) goto L_0x0040;
    L_0x003a:
        r3 = r3 + r5;
        r7 = 0;
        r12.write(r13, r7, r5);
        r5 = 0;
    L_0x0040:
        r2 = r0;
        r7 = r10._inputPtr;
        r8 = r10._inputEnd;
        if (r7 < r8) goto L_0x004a;
    L_0x0047:
        r10.loadMoreGuaranteed();
    L_0x004a:
        r7 = r10._inputBuffer;
        r8 = r10._inputPtr;
        r9 = r8 + 1;
        r10._inputPtr = r9;
        r1 = r7[r8];
        r0 = r11.decodeBase64Char(r1);
        if (r0 >= 0) goto L_0x005f;
    L_0x005a:
        r7 = 1;
        r0 = r10._decodeBase64Escape(r11, r1, r7);
    L_0x005f:
        r7 = r2 << 6;
        r2 = r7 | r0;
        r7 = r10._inputPtr;
        r8 = r10._inputEnd;
        if (r7 < r8) goto L_0x006c;
    L_0x0069:
        r10.loadMoreGuaranteed();
    L_0x006c:
        r7 = r10._inputBuffer;
        r8 = r10._inputPtr;
        r9 = r8 + 1;
        r10._inputPtr = r9;
        r1 = r7[r8];
        r0 = r11.decodeBase64Char(r1);
        if (r0 >= 0) goto L_0x00e0;
    L_0x007c:
        r7 = -2;
        if (r0 == r7) goto L_0x0097;
    L_0x007f:
        r7 = 34;
        if (r1 != r7) goto L_0x0092;
    L_0x0083:
        r7 = r11.usesPadding();
        if (r7 != 0) goto L_0x0092;
    L_0x0089:
        r2 = r2 >> 4;
        r6 = r5 + 1;
        r7 = (byte) r2;
        r13[r5] = r7;
        r5 = r6;
        goto L_0x0026;
    L_0x0092:
        r7 = 2;
        r0 = r10._decodeBase64Escape(r11, r1, r7);
    L_0x0097:
        r7 = -2;
        if (r0 != r7) goto L_0x00e0;
    L_0x009a:
        r7 = r10._inputPtr;
        r8 = r10._inputEnd;
        if (r7 < r8) goto L_0x00a3;
    L_0x00a0:
        r10.loadMoreGuaranteed();
    L_0x00a3:
        r7 = r10._inputBuffer;
        r8 = r10._inputPtr;
        r9 = r8 + 1;
        r10._inputPtr = r9;
        r1 = r7[r8];
        r7 = r11.usesPaddingChar(r1);
        if (r7 != 0) goto L_0x00d6;
    L_0x00b3:
        r7 = 3;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "expected padding character '";
        r8 = r8.append(r9);
        r9 = r11.getPaddingChar();
        r8 = r8.append(r9);
        r9 = "'";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7 = r10.reportInvalidBase64Char(r11, r1, r7, r8);
        throw r7;
    L_0x00d6:
        r2 = r2 >> 4;
        r6 = r5 + 1;
        r7 = (byte) r2;
        r13[r5] = r7;
        r5 = r6;
        goto L_0x0005;
    L_0x00e0:
        r7 = r2 << 6;
        r2 = r7 | r0;
        r7 = r10._inputPtr;
        r8 = r10._inputEnd;
        if (r7 < r8) goto L_0x00ed;
    L_0x00ea:
        r10.loadMoreGuaranteed();
    L_0x00ed:
        r7 = r10._inputBuffer;
        r8 = r10._inputPtr;
        r9 = r8 + 1;
        r10._inputPtr = r9;
        r1 = r7[r8];
        r0 = r11.decodeBase64Char(r1);
        if (r0 >= 0) goto L_0x0132;
    L_0x00fd:
        r7 = -2;
        if (r0 == r7) goto L_0x011f;
    L_0x0100:
        r7 = 34;
        if (r1 != r7) goto L_0x011a;
    L_0x0104:
        r7 = r11.usesPadding();
        if (r7 != 0) goto L_0x011a;
    L_0x010a:
        r2 = r2 >> 2;
        r6 = r5 + 1;
        r7 = r2 >> 8;
        r7 = (byte) r7;
        r13[r5] = r7;
        r5 = r6 + 1;
        r7 = (byte) r2;
        r13[r6] = r7;
        goto L_0x0026;
    L_0x011a:
        r7 = 3;
        r0 = r10._decodeBase64Escape(r11, r1, r7);
    L_0x011f:
        r7 = -2;
        if (r0 != r7) goto L_0x0132;
    L_0x0122:
        r2 = r2 >> 2;
        r6 = r5 + 1;
        r7 = r2 >> 8;
        r7 = (byte) r7;
        r13[r5] = r7;
        r5 = r6 + 1;
        r7 = (byte) r2;
        r13[r6] = r7;
        goto L_0x0005;
    L_0x0132:
        r7 = r2 << 6;
        r2 = r7 | r0;
        r6 = r5 + 1;
        r7 = r2 >> 16;
        r7 = (byte) r7;
        r13[r5] = r7;
        r5 = r6 + 1;
        r7 = r2 >> 8;
        r7 = (byte) r7;
        r13[r6] = r7;
        r6 = r5 + 1;
        r7 = (byte) r2;
        r13[r5] = r7;
        r5 = r6;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._readBinary(com.fasterxml.jackson.core.Base64Variant, java.io.OutputStream, byte[]):int");
    }

    public JsonToken nextToken() throws IOException, JsonParseException {
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            return _nextAfterName();
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i = _skipWSOrEnd();
        if (i < 0) {
            close();
            this._currToken = null;
            return null;
        }
        this._tokenInputTotal = (this._currInputProcessed + ((long) this._inputPtr)) - 1;
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = (this._inputPtr - this._currInputRowStart) - 1;
        this._binaryValue = null;
        JsonToken jsonToken;
        if (i == 93) {
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i, '}');
            }
            this._parsingContext = this._parsingContext.getParent();
            jsonToken = JsonToken.END_ARRAY;
            this._currToken = jsonToken;
            return jsonToken;
        } else if (i == 125) {
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i, ']');
            }
            this._parsingContext = this._parsingContext.getParent();
            jsonToken = JsonToken.END_OBJECT;
            this._currToken = jsonToken;
            return jsonToken;
        } else {
            if (this._parsingContext.expectComma()) {
                if (i != 44) {
                    _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
                }
                i = _skipWS();
            }
            boolean inObject = this._parsingContext.inObject();
            if (inObject) {
                this._parsingContext.setCurrentName(_parseFieldName(i));
                this._currToken = JsonToken.FIELD_NAME;
                i = _skipWS();
                if (i != 58) {
                    _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
                }
                i = _skipWS();
            }
            switch (i) {
                case 34:
                    this._tokenIncomplete = true;
                    jsonToken = JsonToken.VALUE_STRING;
                    break;
                case 45:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonToken = parseNumberText(i);
                    break;
                case 91:
                    if (!inObject) {
                        this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                    }
                    jsonToken = JsonToken.START_ARRAY;
                    break;
                case 93:
                case 125:
                    _reportUnexpectedChar(i, "expected a value");
                    break;
                case 102:
                    _matchToken("false", 1);
                    jsonToken = JsonToken.VALUE_FALSE;
                    break;
                case 110:
                    _matchToken("null", 1);
                    jsonToken = JsonToken.VALUE_NULL;
                    break;
                case 116:
                    break;
                case 123:
                    if (!inObject) {
                        this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                    }
                    jsonToken = JsonToken.START_OBJECT;
                    break;
                default:
                    jsonToken = _handleUnexpectedValue(i);
                    break;
            }
            _matchToken("true", 1);
            jsonToken = JsonToken.VALUE_TRUE;
            if (inObject) {
                this._nextToken = jsonToken;
                return this._currToken;
            }
            this._currToken = jsonToken;
            return jsonToken;
        }
    }

    private JsonToken _nextAfterName() {
        this._nameCopied = false;
        JsonToken t = this._nextToken;
        this._nextToken = null;
        if (t == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (t == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        this._currToken = t;
        return t;
    }

    public String nextTextValue() throws IOException, JsonParseException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_STRING) {
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                }
                return this._textBuffer.contentsAsString();
            } else if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            } else if (t != JsonToken.START_OBJECT) {
                return null;
            } else {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            }
        } else if (nextToken() == JsonToken.VALUE_STRING) {
            return getText();
        } else {
            return null;
        }
    }

    public int nextIntValue(int defaultValue) throws IOException, JsonParseException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return nextToken() == JsonToken.VALUE_NUMBER_INT ? getIntValue() : defaultValue;
        } else {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_NUMBER_INT) {
                return getIntValue();
            }
            if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return defaultValue;
            } else if (t != JsonToken.START_OBJECT) {
                return defaultValue;
            } else {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return defaultValue;
            }
        }
    }

    public long nextLongValue(long defaultValue) throws IOException, JsonParseException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return nextToken() == JsonToken.VALUE_NUMBER_INT ? getLongValue() : defaultValue;
        } else {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_NUMBER_INT) {
                return getLongValue();
            }
            if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return defaultValue;
            } else if (t != JsonToken.START_OBJECT) {
                return defaultValue;
            } else {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return defaultValue;
            }
        }
    }

    public Boolean nextBooleanValue() throws IOException, JsonParseException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (t == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            } else if (t != JsonToken.START_OBJECT) {
                return null;
            } else {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            }
        }
        switch (nextToken()) {
            case VALUE_TRUE:
                return Boolean.TRUE;
            case VALUE_FALSE:
                return Boolean.FALSE;
            default:
                return null;
        }
    }

    public void close() throws IOException {
        super.close();
        this._symbols.release();
    }

    protected JsonToken parseNumberText(int ch) throws IOException, JsonParseException {
        int ptr;
        boolean negative = ch == 45;
        int i = this._inputPtr;
        int startPtr = i - 1;
        int inputLen = this._inputEnd;
        if (negative) {
            if (i < this._inputEnd) {
                ptr = i + 1;
                ch = this._inputBuffer[i];
                if (ch > 57 || ch < 48) {
                    this._inputPtr = ptr;
                    i = ptr;
                    return _handleInvalidNumberStart(ch, true);
                }
                i = ptr;
            }
            if (negative) {
                startPtr++;
            }
            this._inputPtr = startPtr;
            return parseNumberText2(negative);
        }
        if (ch != 48) {
            int intLen = 1;
            while (i < this._inputEnd) {
                ptr = i + 1;
                ch = this._inputBuffer[i];
                if (ch < 48 || ch > 57) {
                    int fractLen = 0;
                    if (ch == 46) {
                        while (ptr < inputLen) {
                            i = ptr + 1;
                            ch = this._inputBuffer[ptr];
                            if (ch < 48 || ch > 57) {
                                if (fractLen == 0) {
                                    reportUnexpectedNumberChar(ch, "Decimal point not followed by a digit");
                                }
                                ptr = i;
                            } else {
                                fractLen++;
                                ptr = i;
                            }
                        }
                        i = ptr;
                    }
                    int expLen = 0;
                    if (ch == 101 || ch == 69) {
                        if (ptr >= inputLen) {
                            i = ptr;
                        } else {
                            i = ptr + 1;
                            ch = this._inputBuffer[ptr];
                            if (ch != 45 && ch != 43) {
                                ptr = i;
                            } else if (i < inputLen) {
                                ptr = i + 1;
                                ch = this._inputBuffer[i];
                            }
                            while (ch <= 57 && ch >= 48) {
                                expLen++;
                                if (ptr >= inputLen) {
                                    i = ptr;
                                } else {
                                    i = ptr + 1;
                                    ch = this._inputBuffer[ptr];
                                    ptr = i;
                                }
                            }
                            if (expLen == 0) {
                                reportUnexpectedNumberChar(ch, "Exponent indicator not followed by a digit");
                            }
                        }
                    }
                    i = ptr - 1;
                    this._inputPtr = i;
                    this._textBuffer.resetWithShared(this._inputBuffer, startPtr, i - startPtr);
                    return reset(negative, intLen, fractLen, expLen);
                }
                intLen++;
                i = ptr;
            }
        }
        if (negative) {
            startPtr++;
        }
        this._inputPtr = startPtr;
        return parseNumberText2(negative);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fasterxml.jackson.core.JsonToken parseNumberText2(boolean r15) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
        r14 = this;
        r13 = 45;
        r12 = 57;
        r11 = 48;
        r8 = r14._textBuffer;
        r5 = r8.emptyAndGetCurrentSegment();
        r6 = 0;
        if (r15 == 0) goto L_0x0014;
    L_0x000f:
        r7 = r6 + 1;
        r5[r6] = r13;
        r6 = r7;
    L_0x0014:
        r4 = 0;
        r8 = r14._inputPtr;
        r9 = r14._inputEnd;
        if (r8 >= r9) goto L_0x0114;
    L_0x001b:
        r8 = r14._inputBuffer;
        r9 = r14._inputPtr;
        r10 = r9 + 1;
        r14._inputPtr = r10;
        r0 = r8[r9];
    L_0x0025:
        if (r0 != r11) goto L_0x002b;
    L_0x0027:
        r0 = r14._verifyNoLeadingZeroes();
    L_0x002b:
        r1 = 0;
    L_0x002c:
        if (r0 < r11) goto L_0x016f;
    L_0x002e:
        if (r0 > r12) goto L_0x016f;
    L_0x0030:
        r4 = r4 + 1;
        r8 = r5.length;
        if (r6 < r8) goto L_0x003c;
    L_0x0035:
        r8 = r14._textBuffer;
        r5 = r8.finishCurrentSegment();
        r6 = 0;
    L_0x003c:
        r7 = r6 + 1;
        r5[r6] = r0;
        r8 = r14._inputPtr;
        r9 = r14._inputEnd;
        if (r8 < r9) goto L_0x011c;
    L_0x0046:
        r8 = r14.loadMore();
        if (r8 != 0) goto L_0x011c;
    L_0x004c:
        r0 = 0;
        r1 = 1;
    L_0x004e:
        if (r4 != 0) goto L_0x0070;
    L_0x0050:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Missing integer part (next char ";
        r8 = r8.append(r9);
        r9 = com.fasterxml.jackson.core.base.ParserMinimalBase._getCharDesc(r0);
        r8 = r8.append(r9);
        r9 = ")";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r14.reportInvalidNumber(r8);
    L_0x0070:
        r3 = 0;
        r8 = 46;
        if (r0 != r8) goto L_0x016c;
    L_0x0075:
        r6 = r7 + 1;
        r5[r7] = r0;
    L_0x0079:
        r8 = r14._inputPtr;
        r9 = r14._inputEnd;
        if (r8 < r9) goto L_0x0129;
    L_0x007f:
        r8 = r14.loadMore();
        if (r8 != 0) goto L_0x0129;
    L_0x0085:
        r1 = 1;
    L_0x0086:
        if (r3 != 0) goto L_0x008d;
    L_0x0088:
        r8 = "Decimal point not followed by a digit";
        r14.reportUnexpectedNumberChar(r0, r8);
    L_0x008d:
        r2 = 0;
        r8 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r0 == r8) goto L_0x0096;
    L_0x0092:
        r8 = 69;
        if (r0 != r8) goto L_0x0102;
    L_0x0096:
        r8 = r5.length;
        if (r6 < r8) goto L_0x00a0;
    L_0x0099:
        r8 = r14._textBuffer;
        r5 = r8.finishCurrentSegment();
        r6 = 0;
    L_0x00a0:
        r7 = r6 + 1;
        r5[r6] = r0;
        r8 = r14._inputPtr;
        r9 = r14._inputEnd;
        if (r8 >= r9) goto L_0x014a;
    L_0x00aa:
        r8 = r14._inputBuffer;
        r9 = r14._inputPtr;
        r10 = r9 + 1;
        r14._inputPtr = r10;
        r0 = r8[r9];
    L_0x00b4:
        if (r0 == r13) goto L_0x00ba;
    L_0x00b6:
        r8 = 43;
        if (r0 != r8) goto L_0x0169;
    L_0x00ba:
        r8 = r5.length;
        if (r7 < r8) goto L_0x0166;
    L_0x00bd:
        r8 = r14._textBuffer;
        r5 = r8.finishCurrentSegment();
        r6 = 0;
    L_0x00c4:
        r7 = r6 + 1;
        r5[r6] = r0;
        r8 = r14._inputPtr;
        r9 = r14._inputEnd;
        if (r8 >= r9) goto L_0x0152;
    L_0x00ce:
        r8 = r14._inputBuffer;
        r9 = r14._inputPtr;
        r10 = r9 + 1;
        r14._inputPtr = r10;
        r0 = r8[r9];
    L_0x00d8:
        r6 = r7;
    L_0x00d9:
        if (r0 > r12) goto L_0x00fb;
    L_0x00db:
        if (r0 < r11) goto L_0x00fb;
    L_0x00dd:
        r2 = r2 + 1;
        r8 = r5.length;
        if (r6 < r8) goto L_0x00e9;
    L_0x00e2:
        r8 = r14._textBuffer;
        r5 = r8.finishCurrentSegment();
        r6 = 0;
    L_0x00e9:
        r7 = r6 + 1;
        r5[r6] = r0;
        r8 = r14._inputPtr;
        r9 = r14._inputEnd;
        if (r8 < r9) goto L_0x0159;
    L_0x00f3:
        r8 = r14.loadMore();
        if (r8 != 0) goto L_0x0159;
    L_0x00f9:
        r1 = 1;
        r6 = r7;
    L_0x00fb:
        if (r2 != 0) goto L_0x0102;
    L_0x00fd:
        r8 = "Exponent indicator not followed by a digit";
        r14.reportUnexpectedNumberChar(r0, r8);
    L_0x0102:
        if (r1 != 0) goto L_0x010a;
    L_0x0104:
        r8 = r14._inputPtr;
        r8 = r8 + -1;
        r14._inputPtr = r8;
    L_0x010a:
        r8 = r14._textBuffer;
        r8.setCurrentLength(r6);
        r8 = r14.reset(r15, r4, r3, r2);
        return r8;
    L_0x0114:
        r8 = "No digit following minus sign";
        r0 = r14.getNextChar(r8);
        goto L_0x0025;
    L_0x011c:
        r8 = r14._inputBuffer;
        r9 = r14._inputPtr;
        r10 = r9 + 1;
        r14._inputPtr = r10;
        r0 = r8[r9];
        r6 = r7;
        goto L_0x002c;
    L_0x0129:
        r8 = r14._inputBuffer;
        r9 = r14._inputPtr;
        r10 = r9 + 1;
        r14._inputPtr = r10;
        r0 = r8[r9];
        if (r0 < r11) goto L_0x0086;
    L_0x0135:
        if (r0 > r12) goto L_0x0086;
    L_0x0137:
        r3 = r3 + 1;
        r8 = r5.length;
        if (r6 < r8) goto L_0x0143;
    L_0x013c:
        r8 = r14._textBuffer;
        r5 = r8.finishCurrentSegment();
        r6 = 0;
    L_0x0143:
        r7 = r6 + 1;
        r5[r6] = r0;
        r6 = r7;
        goto L_0x0079;
    L_0x014a:
        r8 = "expected a digit for number exponent";
        r0 = r14.getNextChar(r8);
        goto L_0x00b4;
    L_0x0152:
        r8 = "expected a digit for number exponent";
        r0 = r14.getNextChar(r8);
        goto L_0x00d8;
    L_0x0159:
        r8 = r14._inputBuffer;
        r9 = r14._inputPtr;
        r10 = r9 + 1;
        r14._inputPtr = r10;
        r0 = r8[r9];
        r6 = r7;
        goto L_0x00d9;
    L_0x0166:
        r6 = r7;
        goto L_0x00c4;
    L_0x0169:
        r6 = r7;
        goto L_0x00d9;
    L_0x016c:
        r6 = r7;
        goto L_0x008d;
    L_0x016f:
        r7 = r6;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.parseNumberText2(boolean):com.fasterxml.jackson.core.JsonToken");
    }

    private char _verifyNoLeadingZeroes() throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            return '0';
        }
        char ch = this._inputBuffer[this._inputPtr];
        if (ch < '0' || ch > '9') {
            return '0';
        }
        if (!isEnabled(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr++;
        if (ch != '0') {
            return ch;
        }
        do {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                return ch;
            }
            ch = this._inputBuffer[this._inputPtr];
            if (ch < '0' || ch > '9') {
                return '0';
            }
            this._inputPtr++;
        } while (ch == '0');
        return ch;
    }

    protected JsonToken _handleInvalidNumberStart(int ch, boolean negative) throws IOException, JsonParseException {
        double d = Double.NEGATIVE_INFINITY;
        if (ch == 73) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOFInValue();
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            ch = cArr[i];
            String match;
            if (ch == 78) {
                match = negative ? "-INF" : "+INF";
                _matchToken(match, 3);
                if (isEnabled(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!negative) {
                        d = Double.POSITIVE_INFINITY;
                    }
                    return resetAsNaN(match, d);
                }
                _reportError("Non-standard token '" + match + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (ch == 110) {
                match = negative ? "-Infinity" : "+Infinity";
                _matchToken(match, 3);
                if (isEnabled(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!negative) {
                        d = Double.POSITIVE_INFINITY;
                    }
                    return resetAsNaN(match, d);
                }
                _reportError("Non-standard token '" + match + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        reportUnexpectedNumberChar(ch, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    protected String _parseFieldName(int i) throws IOException, JsonParseException {
        if (i != 34) {
            return _handleUnusualFieldName(i);
        }
        int start;
        int ptr = this._inputPtr;
        int hash = this._hashSeed;
        int inputLen = this._inputEnd;
        if (ptr < inputLen) {
            int[] codes = CharTypes.getInputCodeLatin1();
            int maxCode = codes.length;
            do {
                int ch = this._inputBuffer[ptr];
                if (ch >= maxCode || codes[ch] == 0) {
                    hash = (hash * 33) + ch;
                    ptr++;
                } else if (ch == 34) {
                    start = this._inputPtr;
                    this._inputPtr = ptr + 1;
                    return this._symbols.findSymbol(this._inputBuffer, start, ptr - start, hash);
                }
            } while (ptr < inputLen);
        }
        start = this._inputPtr;
        this._inputPtr = ptr;
        return _parseFieldName2(start, hash, 34);
    }

    private String _parseFieldName2(int startPtr, int hash, int endChar) throws IOException, JsonParseException {
        this._textBuffer.resetWithShared(this._inputBuffer, startPtr, this._inputPtr - startPtr);
        char[] outBuf = this._textBuffer.getCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(": was expecting closing '" + ((char) endChar) + "' for name");
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            char i2 = c;
            if (i2 <= '\\') {
                if (i2 == '\\') {
                    c = _decodeEscaped();
                } else if (i2 <= endChar) {
                    if (i2 == endChar) {
                        this._textBuffer.setCurrentLength(outPtr);
                        TextBuffer tb = this._textBuffer;
                        return this._symbols.findSymbol(tb.getTextBuffer(), tb.getTextOffset(), tb.size(), hash);
                    } else if (i2 < ' ') {
                        _throwUnquotedSpace(i2, "name");
                    }
                }
            }
            hash = (hash * 33) + i2;
            int outPtr2 = outPtr + 1;
            outBuf[outPtr] = c;
            if (outPtr2 >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            } else {
                outPtr = outPtr2;
            }
        }
    }

    protected String _handleUnusualFieldName(int i) throws IOException, JsonParseException {
        if (i == 39 && isEnabled(Feature.ALLOW_SINGLE_QUOTES)) {
            return _parseApostropheFieldName();
        }
        int start;
        if (!isEnabled(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            _reportUnexpectedChar(i, "was expecting double-quote to start field name");
        }
        int[] codes = CharTypes.getInputCodeLatin1JsNames();
        int maxCode = codes.length;
        boolean firstOk = i < maxCode ? codes[i] == 0 && (i < 48 || i > 57) : Character.isJavaIdentifierPart((char) i);
        if (!firstOk) {
            _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int ptr = this._inputPtr;
        int hash = this._hashSeed;
        int inputLen = this._inputEnd;
        if (ptr < inputLen) {
            do {
                int ch = this._inputBuffer[ptr];
                if (ch < maxCode) {
                    if (codes[ch] != 0) {
                        start = this._inputPtr - 1;
                        this._inputPtr = ptr;
                        return this._symbols.findSymbol(this._inputBuffer, start, ptr - start, hash);
                    }
                } else if (!Character.isJavaIdentifierPart((char) ch)) {
                    start = this._inputPtr - 1;
                    this._inputPtr = ptr;
                    return this._symbols.findSymbol(this._inputBuffer, start, ptr - start, hash);
                }
                hash = (hash * 33) + ch;
                ptr++;
            } while (ptr < inputLen);
        }
        start = this._inputPtr - 1;
        this._inputPtr = ptr;
        return _parseUnusualFieldName2(start, hash, codes);
    }

    protected String _parseApostropheFieldName() throws IOException, JsonParseException {
        int start;
        int ptr = this._inputPtr;
        int hash = this._hashSeed;
        int inputLen = this._inputEnd;
        if (ptr < inputLen) {
            int[] codes = CharTypes.getInputCodeLatin1();
            int maxCode = codes.length;
            do {
                int ch = this._inputBuffer[ptr];
                if (ch != 39) {
                    if (ch < maxCode && codes[ch] != 0) {
                        break;
                    }
                    hash = (hash * 33) + ch;
                    ptr++;
                } else {
                    start = this._inputPtr;
                    this._inputPtr = ptr + 1;
                    return this._symbols.findSymbol(this._inputBuffer, start, ptr - start, hash);
                }
            } while (ptr < inputLen);
        }
        start = this._inputPtr;
        this._inputPtr = ptr;
        return _parseFieldName2(start, hash, 39);
    }

    protected JsonToken _handleUnexpectedValue(int i) throws IOException, JsonParseException {
        switch (i) {
            case 39:
                if (isEnabled(Feature.ALLOW_SINGLE_QUOTES)) {
                    return _handleApostropheValue();
                }
                break;
            case 43:
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    _reportInvalidEOFInValue();
                }
                char[] cArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                return _handleInvalidNumberStart(cArr[i2], false);
            case 78:
                _matchToken("NaN", 1);
                if (!isEnabled(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return resetAsNaN("NaN", Double.NaN);
        }
        _reportUnexpectedChar(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    protected JsonToken _handleApostropheValue() throws IOException, JsonParseException {
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(": was expecting closing quote for a string value");
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            char i2 = c;
            if (i2 <= '\\') {
                if (i2 == '\\') {
                    c = _decodeEscaped();
                } else if (i2 <= '\'') {
                    if (i2 == '\'') {
                        this._textBuffer.setCurrentLength(outPtr);
                        return JsonToken.VALUE_STRING;
                    } else if (i2 < ' ') {
                        _throwUnquotedSpace(i2, "string value");
                    }
                }
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int outPtr2 = outPtr + 1;
            outBuf[outPtr] = c;
            outPtr = outPtr2;
        }
    }

    private String _parseUnusualFieldName2(int startPtr, int hash, int[] codes) throws IOException, JsonParseException {
        this._textBuffer.resetWithShared(this._inputBuffer, startPtr, this._inputPtr - startPtr);
        char[] outBuf = this._textBuffer.getCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        char maxCode = codes.length;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                break;
            }
            char c = this._inputBuffer[this._inputPtr];
            char i = c;
            if (i > maxCode) {
                if (!Character.isJavaIdentifierPart(c)) {
                    break;
                }
            } else if (codes[i] != 0) {
                break;
            }
            this._inputPtr++;
            hash = (hash * 33) + i;
            int outPtr2 = outPtr + 1;
            outBuf[outPtr] = c;
            if (outPtr2 >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            } else {
                outPtr = outPtr2;
            }
        }
        this._textBuffer.setCurrentLength(outPtr);
        TextBuffer tb = this._textBuffer;
        return this._symbols.findSymbol(tb.getTextBuffer(), tb.getTextOffset(), tb.size(), hash);
    }

    protected void _finishString() throws IOException, JsonParseException {
        int ptr = this._inputPtr;
        int inputLen = this._inputEnd;
        if (ptr < inputLen) {
            int[] codes = CharTypes.getInputCodeLatin1();
            int maxCode = codes.length;
            do {
                int ch = this._inputBuffer[ptr];
                if (ch >= maxCode || codes[ch] == 0) {
                    ptr++;
                } else if (ch == 34) {
                    this._textBuffer.resetWithShared(this._inputBuffer, this._inputPtr, ptr - this._inputPtr);
                    this._inputPtr = ptr + 1;
                    return;
                }
            } while (ptr < inputLen);
        }
        this._textBuffer.resetWithCopy(this._inputBuffer, this._inputPtr, ptr - this._inputPtr);
        this._inputPtr = ptr;
        _finishString2();
    }

    protected void _finishString2() throws IOException, JsonParseException {
        char[] outBuf = this._textBuffer.getCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(": was expecting closing quote for a string value");
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            char i2 = c;
            if (i2 <= '\\') {
                if (i2 == '\\') {
                    c = _decodeEscaped();
                } else if (i2 <= '\"') {
                    if (i2 == '\"') {
                        this._textBuffer.setCurrentLength(outPtr);
                        return;
                    } else if (i2 < ' ') {
                        _throwUnquotedSpace(i2, "string value");
                    }
                }
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int outPtr2 = outPtr + 1;
            outBuf[outPtr] = c;
            outPtr = outPtr2;
        }
    }

    protected void _skipString() throws IOException, JsonParseException {
        this._tokenIncomplete = false;
        int inputPtr = this._inputPtr;
        int inputLen = this._inputEnd;
        char[] inputBuffer = this._inputBuffer;
        while (true) {
            if (inputPtr >= inputLen) {
                this._inputPtr = inputPtr;
                if (!loadMore()) {
                    _reportInvalidEOF(": was expecting closing quote for a string value");
                }
                inputPtr = this._inputPtr;
                inputLen = this._inputEnd;
            }
            int inputPtr2 = inputPtr + 1;
            char i = inputBuffer[inputPtr];
            if (i <= '\\') {
                if (i == '\\') {
                    this._inputPtr = inputPtr2;
                    char c = _decodeEscaped();
                    inputPtr = this._inputPtr;
                    inputLen = this._inputEnd;
                } else if (i <= '\"') {
                    if (i == '\"') {
                        this._inputPtr = inputPtr2;
                        return;
                    } else if (i < ' ') {
                        this._inputPtr = inputPtr2;
                        _throwUnquotedSpace(i, "string value");
                    }
                }
            }
            inputPtr = inputPtr2;
        }
    }

    protected void _skipCR() throws IOException {
        if ((this._inputPtr < this._inputEnd || loadMore()) && this._inputBuffer[this._inputPtr] == '\n') {
            this._inputPtr++;
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    protected void _skipLF() throws IOException {
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    private int _skipWS() throws IOException, JsonParseException {
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = cArr[i];
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    _skipComment();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        _skipLF();
                    } else if (i2 == 13) {
                        _skipCR();
                    } else if (i2 != 9) {
                        _throwInvalidSpace(i2);
                    }
                }
            } else {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.getTypeDesc() + " entries");
            }
        }
    }

    private int _skipWSOrEnd() throws IOException, JsonParseException {
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = cArr[i];
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    _skipComment();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        _skipLF();
                    } else if (i2 == 13) {
                        _skipCR();
                    } else if (i2 != 9) {
                        _throwInvalidSpace(i2);
                    }
                }
            } else {
                _handleEOF();
                return -1;
            }
        }
    }

    private void _skipComment() throws IOException, JsonParseException {
        if (!isEnabled(Feature.ALLOW_COMMENTS)) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(" in a comment");
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c = cArr[i];
        if (c == '/') {
            _skipCppComment();
        } else if (c == '*') {
            _skipCComment();
        } else {
            _reportUnexpectedChar(c, "was expecting either '*' or '/' for a comment");
        }
    }

    private void _skipCComment() throws IOException, JsonParseException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                break;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = cArr[i];
            if (i2 <= 42) {
                if (i2 == 42) {
                    if (this._inputPtr >= this._inputEnd && !loadMore()) {
                        break;
                    } else if (this._inputBuffer[this._inputPtr] == '/') {
                        this._inputPtr++;
                        return;
                    }
                } else if (i2 < 32) {
                    if (i2 == 10) {
                        _skipLF();
                    } else if (i2 == 13) {
                        _skipCR();
                    } else if (i2 != 9) {
                        _throwInvalidSpace(i2);
                    }
                }
            }
        }
        _reportInvalidEOF(" in a comment");
    }

    private void _skipCppComment() throws IOException, JsonParseException {
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = cArr[i];
                if (i2 < 32) {
                    if (i2 == 10) {
                        _skipLF();
                        return;
                    } else if (i2 == 13) {
                        _skipCR();
                        return;
                    } else if (i2 != 9) {
                        _throwInvalidSpace(i2);
                    }
                }
            } else {
                return;
            }
        }
    }

    protected char _decodeEscaped() throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(" in character escape sequence");
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c = cArr[i];
        switch (c) {
            case '\"':
            case '/':
            case '\\':
                return c;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                int value = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this._inputPtr >= this._inputEnd && !loadMore()) {
                        _reportInvalidEOF(" in character escape sequence");
                    }
                    cArr = this._inputBuffer;
                    i = this._inputPtr;
                    this._inputPtr = i + 1;
                    int ch = cArr[i];
                    int digit = CharTypes.charToHex(ch);
                    if (digit < 0) {
                        _reportUnexpectedChar(ch, "expected a hex-digit for character escape sequence");
                    }
                    value = (value << 4) | digit;
                }
                return (char) value;
            default:
                return _handleUnrecognizedCharacterEscape(c);
        }
    }

    protected void _matchToken(String matchStr, int i) throws IOException, JsonParseException {
        int len = matchStr.length();
        do {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOFInValue();
            }
            if (this._inputBuffer[this._inputPtr] != matchStr.charAt(i)) {
                _reportInvalidToken(matchStr.substring(0, i), "'null', 'true', 'false' or NaN");
            }
            this._inputPtr++;
            i++;
        } while (i < len);
        if (this._inputPtr < this._inputEnd || loadMore()) {
            char c = this._inputBuffer[this._inputPtr];
            if (c >= '0' && c != ']' && c != '}' && Character.isJavaIdentifierPart(c)) {
                _reportInvalidToken(matchStr.substring(0, i), "'null', 'true', 'false' or NaN");
            }
        }
    }

    protected byte[] _decodeBase64(Base64Variant b64variant) throws IOException, JsonParseException {
        ByteArrayBuilder builder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char ch = cArr[i];
            if (ch > ' ') {
                int bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (ch == '\"') {
                        return builder.toByteArray();
                    }
                    bits = _decodeBase64Escape(b64variant, ch, 0);
                    if (bits < 0) {
                        continue;
                    }
                }
                int decodedData = bits;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                cArr = this._inputBuffer;
                i = this._inputPtr;
                this._inputPtr = i + 1;
                ch = cArr[i];
                bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    bits = _decodeBase64Escape(b64variant, ch, 1);
                }
                decodedData = (decodedData << 6) | bits;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                cArr = this._inputBuffer;
                i = this._inputPtr;
                this._inputPtr = i + 1;
                ch = cArr[i];
                bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (bits != -2) {
                        if (ch != '\"' || b64variant.usesPadding()) {
                            bits = _decodeBase64Escape(b64variant, ch, 2);
                        } else {
                            builder.append(decodedData >> 4);
                            return builder.toByteArray();
                        }
                    }
                    if (bits == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        cArr = this._inputBuffer;
                        i = this._inputPtr;
                        this._inputPtr = i + 1;
                        ch = cArr[i];
                        if (b64variant.usesPaddingChar(ch)) {
                            builder.append(decodedData >> 4);
                        } else {
                            throw reportInvalidBase64Char(b64variant, ch, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
                        }
                    }
                }
                decodedData = (decodedData << 6) | bits;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                cArr = this._inputBuffer;
                i = this._inputPtr;
                this._inputPtr = i + 1;
                ch = cArr[i];
                bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (bits != -2) {
                        if (ch != '\"' || b64variant.usesPadding()) {
                            bits = _decodeBase64Escape(b64variant, ch, 3);
                        } else {
                            builder.appendTwoBytes(decodedData >> 2);
                            return builder.toByteArray();
                        }
                    }
                    if (bits == -2) {
                        builder.appendTwoBytes(decodedData >> 2);
                    }
                }
                builder.appendThreeBytes((decodedData << 6) | bits);
            }
        }
    }

    protected void _reportInvalidToken(String matchedPart, String msg) throws IOException, JsonParseException {
        StringBuilder sb = new StringBuilder(matchedPart);
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                break;
            }
            char c = this._inputBuffer[this._inputPtr];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            this._inputPtr++;
            sb.append(c);
        }
        _reportError("Unrecognized token '" + sb.toString() + "': was expecting ");
    }
}
