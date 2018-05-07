package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

public class SheetsRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    public SheetsRequestInitializer(String str) {
        super(str);
    }

    public SheetsRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeSheetsRequest((SheetsRequest) abstractGoogleJsonClientRequest);
    }

    protected void initializeSheetsRequest(SheetsRequest<?> sheetsRequest) throws IOException {
    }
}
