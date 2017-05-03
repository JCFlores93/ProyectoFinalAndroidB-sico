package edu.cibertec.android.pharmamedic.data;

import android.provider.BaseColumns;

/**
 * Created by Android on 26/11/2016.
 */

public class PersonaDBContract {

    public static final class PersonaEntry implements BaseColumns{
        public static final String TABLE_NAME="person";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_EMAIL =  "email";
        public static final String COLUMN_PASSWORD =  "password";
        public static final String COLUMN_LASTNAME="lastname";
    }
}
