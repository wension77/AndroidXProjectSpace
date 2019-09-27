package com.winsion.roombasic;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * author: hewensheng
 * date  : 2019/9/26 11:38
 * desc  :
 */
@Database(entities = {Word.class},version = 1,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    public abstract WordDao getWordDao();
}
