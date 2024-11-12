package com.example.agenda.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Agenda.db";

    public AppDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + CompromissoSchema.CompromissoTable.NAME + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CompromissoSchema.CompromissoTable.Cols.DESCRICAO + " TEXT, " +
                CompromissoSchema.CompromissoTable.Cols.DATA + " TEXT, " +
                CompromissoSchema.CompromissoTable.Cols.HORA + " TEXT" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CompromissoSchema.CompromissoTable.NAME);
        onCreate(db);
    }
}
