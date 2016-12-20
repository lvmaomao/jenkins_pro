package com.appmarket.index;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
	
	private static final String Y_M_D_H_M_S_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String Y_M_D_FORMAT = "yyyy-MM-dd";

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    private static final SimpleDateFormat simpleDateFormatYMD = new SimpleDateFormat(Y_M_D_FORMAT, Locale.CANADA);
    private static final SimpleDateFormat simpleDateFormatYMDHMS = new SimpleDateFormat(Y_M_D_H_M_S_FORMAT, Locale.CANADA);

    public static String getDateFromTimestampYMDHMS(long timestamp) {
            Date d = new Date(timestamp);
            return simpleDateFormatYMDHMS.format(d);
    }

    public static String getDateFromTimestampYMD(String timestamp) {
        Date d = new Date(timestamp);
        return simpleDateFormatYMD.format(d);
    }

}
