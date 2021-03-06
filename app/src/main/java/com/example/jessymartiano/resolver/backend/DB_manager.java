package com.example.jessymartiano.resolver.backend;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by David on 01/12/2016.
 */

public interface DB_manager {

    long addActivity(ContentValues values);
    long addBusiness(ContentValues values);
    long addUser(ContentValues values);

    boolean checkUser(ContentValues values);

    boolean removeActivity(long id);
    boolean removeBusiness(long id);
    boolean removeUser(long id);

    boolean updateActivity(long id, ContentValues values);
    boolean updateBusiness(long id, ContentValues values);
    boolean updateUser(long id, ContentValues values);

    Cursor getActivities();
    Cursor getBusinesses();
    Cursor getUsers();
    Cursor getActivitiesBusiness();

    boolean isUpdate();


}
