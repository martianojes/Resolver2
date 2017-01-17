package com.example.jessymartiano.resolver.backend;

import com.example.jessymartiano.resolver.data.MySQL_DBManager;
import com.example.jessymartiano.resolver.data.*;

/**
 * Created by David on 01/12/2016.
 */

public class DBManagerFactory {


        static DB_manager manager = null;

        public static DB_manager getManager() {
            if (manager == null) {
                manager = new MySQL_DBManager()
                {};
            }
            return manager;
        }

}
