package com.google.api.services.sheets.v4;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SheetsScopes {
    public static final String DRIVE = "https://www.googleapis.com/auth/drive";
    public static final String DRIVE_FILE = "https://www.googleapis.com/auth/drive.file";
    public static final String DRIVE_READONLY = "https://www.googleapis.com/auth/drive.readonly";
    public static final String SPREADSHEETS = "https://www.googleapis.com/auth/spreadsheets";
    public static final String SPREADSHEETS_READONLY = "https://www.googleapis.com/auth/spreadsheets.readonly";

    public static Set<String> all() {
        Set hashSet = new HashSet();
        hashSet.add(DRIVE);
        hashSet.add("https://www.googleapis.com/auth/drive.file");
        hashSet.add(DRIVE_READONLY);
        hashSet.add(SPREADSHEETS);
        hashSet.add(SPREADSHEETS_READONLY);
        return Collections.unmodifiableSet(hashSet);
    }

    private SheetsScopes() {
    }
}
