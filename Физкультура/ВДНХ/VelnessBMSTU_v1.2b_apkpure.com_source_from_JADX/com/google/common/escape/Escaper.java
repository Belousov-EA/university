package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

@GwtCompatible
@Beta
public abstract class Escaper {
    private final Function<String, String> asFunction = new C07251();

    class C07251 implements Function<String, String> {
        C07251() {
        }

        public String apply(String from) {
            return Escaper.this.escape(from);
        }
    }

    public abstract String escape(String str);

    protected Escaper() {
    }

    public final Function<String, String> asFunction() {
        return this.asFunction;
    }
}
