package com.contoryum.pratikingilizce;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Data extends SQLiteAssetHelper {

    private  static final String DATABASE_NAME="mmm.db";
    private  static final int DATABASE_VERSION=1;

    public Data(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
