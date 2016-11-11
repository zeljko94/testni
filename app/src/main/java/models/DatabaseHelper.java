package models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zeljko94 on 11.11.2016..
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME    = "raspored_pma";
    public static final int    DB_VERSION = 1;

    private final String CREATE_RASPORED = "CREATE TABLE raspored(id INTEGER PRIMARY KEY, nastavnik TEXT, predmet TEXT, ucionica TEXT, vrijeme_od TEXT, vrijeme_do TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.rawQuery(CREATE_RASPORED, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.rawQuery("DROP TABLE IF EXISTS raspored", null);
        this.onCreate(db);
    }
}
