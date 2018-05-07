package ru.mgvk.velness;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.lang.reflect.Field;

public class User {
    private static String FOFType;
    private static Context context;
    private static String email;
    private static String fullName;
    private static String group;
    private static String phone;
    private static String pressureArrival;
    private static String pressureLeave;
    private static String profileImgURL;
    private static String teacher;
    private static String timeArrival;
    private static String timeLeave;
    private static String username;

    static void init(Context context) {
        context = context;
        load();
    }

    public static String getFullName() {
        return fullName;
    }

    public static void setFullName(String fullName) {
        fullName = fullName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        email = email;
    }

    public static String getGroup() {
        return group;
    }

    public static void setGroup(String group) {
        group = group;
    }

    public static String getTeacher() {
        return teacher;
    }

    public static void setTeacher(String teacher) {
        teacher = teacher;
    }

    public static String getFOFType() {
        return FOFType;
    }

    public static void setFOFType(String FOFType) {
        FOFType = FOFType;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        phone = phone;
    }

    public static String getTimeArrival() {
        return timeArrival;
    }

    public static void setTimeArrival(String timeArrival) {
        timeArrival = timeArrival;
    }

    public static String getTimeLeave() {
        return timeLeave;
    }

    public static void setTimeLeave(String timeLeave) {
        timeLeave = timeLeave;
    }

    public static String getPressureArrival() {
        return pressureArrival;
    }

    public static void setPressureArrival(String pressureArrival) {
        pressureArrival = pressureArrival;
    }

    public static String getPressureLeave() {
        return pressureLeave;
    }

    public static void setPressureLeave(String pressureLeave) {
        pressureLeave = pressureLeave;
    }

    public static String getProfileImgURL() {
        return profileImgURL;
    }

    public static void setProfileImgURL(String profileImgURL) {
        profileImgURL = profileImgURL;
    }

    public static void save() {
        if (context != null) {
            Editor e = context.getSharedPreferences("User", 0).edit();
            for (Field field : User.class.getDeclaredFields()) {
                if (field.getType() == String.class) {
                    try {
                        e.putString(field.getName(), (String) field.get(null));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
            e.apply();
        }
    }

    public static void load() {
        int i = 0;
        if (context != null) {
            SharedPreferences s = context.getSharedPreferences("User", 0);
            Field[] declaredFields = User.class.getDeclaredFields();
            int length = declaredFields.length;
            while (i < length) {
                Field field = declaredFields[i];
                if (field.getType() == String.class) {
                    try {
                        field.set(null, s.getString(field.getName(), ""));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                i++;
            }
        }
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        username = username;
    }
}
