package com.rohisnatardev.ichwan.appprojectplanb;

import android.provider.BaseColumns;

public class Contract {

    private Contract(){

    }

    public static final class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "Userentry";
        public static final String NAME_COLUMN = "username";
        public static final String TIMESTAMP_COLUMN = "timestamp";
    }
}
