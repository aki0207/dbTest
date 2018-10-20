package com.example.dbtest;

import android.app.Activity;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;

import android.widget.LinearLayout;

import android.widget.TextView;



public class MainActivity extends Activity {



    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);

        setContentView(layout);



        PersonOpenHelper helper = new PersonOpenHelper(this);

        SQLiteDatabase db = helper.getReadableDatabase();



        Cursor c = db.query("person_table", new String[] { "mail_address", "password" },

                null, null, null, null, null);

        boolean isEof = c.moveToFirst();
        String result = "";

        while (isEof) {

            TextView tv = new TextView(this);
            result = "メールアドレス:" + c.getString(0) + "/パスワード:" + c.getString(1);

            tv.setText(result);

            isEof = c.moveToNext();

            layout.addView(tv);

        }

        c.close();



        db.close();

    }

}
