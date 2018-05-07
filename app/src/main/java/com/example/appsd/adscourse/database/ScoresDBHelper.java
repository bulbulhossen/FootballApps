package com.example.appsd.adscourse.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by yehya khaled on 2/25/2015.
 */
public class ScoresDBHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "Scores.db";
    private static final int DATABASE_VERSION = 4;

    public ScoresDBHelper(Context context)   {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CreateScoresTable = "CREATE TABLE IF NOT EXISTS " + ScoresContract.SCORES_TABLE + " ("
                + ScoresContract.scores_table._ID + " INTEGER PRIMARY KEY,"
                + ScoresContract.scores_table.DATE_COL + " TEXT NOT NULL,"
                + ScoresContract.scores_table.TIME_COL + " INTEGER NOT NULL,"
                + ScoresContract.scores_table.HOME_COL + " TEXT NOT NULL,"
                + ScoresContract.scores_table.AWAY_COL + " TEXT NOT NULL,"
                + ScoresContract.scores_table.LEAGUE_COL + " INTEGER NOT NULL,"
                + ScoresContract.scores_table.HOME_GOALS_COL + " TEXT NOT NULL,"
                + ScoresContract.scores_table.AWAY_GOALS_COL + " TEXT NOT NULL,"
                + ScoresContract.scores_table.MATCH_ID + " INTEGER NOT NULL,"
                + ScoresContract.scores_table.MATCH_DAY + " INTEGER NOT NULL,"
                + " UNIQUE ("+ ScoresContract.scores_table.MATCH_ID+") ON CONFLICT REPLACE"
                + " );";
        db.execSQL(CreateScoresTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)  {
        //Remove old values when upgrading.
        db.execSQL("DROP TABLE IF EXISTS " + ScoresContract.SCORES_TABLE);
    }
}
