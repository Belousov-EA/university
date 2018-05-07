package okhttp3;

import java.io.IOException;

public interface Authenticator {
    public static final Authenticator NONE = new C08041();

    class C08041 implements Authenticator {
        C08041() {
        }

        public Request authenticate(Route route, Response response) {
            return null;
        }
    }

    Request authenticate(Route route, Response response) throws IOException;
}
