package com.taotao.greenddemo;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

import com.example.Record;
import com.example.RecordDao;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

public class MainActivity extends ListActivity {

    private EditText et;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String textColumn = RecordDao.Properties.Text.columnName;
        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
        cursor =  getDb().query(getNoteDao().getTablename(), getNoteDao().getAllColumns(), null, null, null, null, orderBy);

        String[] from = {textColumn, RecordDao.Properties.Date.columnName};
        int[] to = {android.R.id.text1,android.R.id.text2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,from,to);
        setListAdapter(adapter);
        et = (EditText) findViewById(R.id.editTextNote);

    }



    private RecordDao getNoteDao() {
        // 通过 BaseApplication 类提供的 getDaoSession() 获取具体 Dao
        return ((DemoApplication) this.getApplicationContext()).getDaoSession().getRecordDao();
    }

    private SQLiteDatabase getDb() {
        // 通过 BaseApplication 类提供的 getDb() 获取具体 db
        return ((DemoApplication) this.getApplicationContext()).getDb();
    }
    /**
     * Button 点击的监听事件
     *
     * @param view
     */
    public void onMyButtonClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAdd:
                addRecord();
                break;
            case R.id.buttonQuery:
                search();
                break;
            default:
                ToastUtils.show(getApplicationContext(), "What's wrong ?");
                break;
        }
    }

    private void search() {
        String text = et.getText().toString();
        et.setText("");
        if (text == null || text.equals("")) {
            ToastUtils.show(getApplicationContext(), "Please enter a note to query");
        } else {
            // Query 类代表了一个可以被重复执行的查询
            Query query = getNoteDao().queryBuilder()
                    .where(RecordDao.Properties.Text.eq(text))
                    .orderAsc(RecordDao.Properties.Date)
                    .build();
            // 查询结果以 List 返回
            List notes = query.list();
            ToastUtils.show(getApplicationContext(), "There have " + notes.size() + " records");
        }
        // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    private void addRecord() {
        String text = et.getText().toString();
        et.setText("");

        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = "Added on " + df.format(new Date());

        if (text == null || text.equals("")) {
            ToastUtils.show(getApplicationContext(), "Please enter a note to add");
        } else {
            // 插入操作，简单到只要你创建一个 Java 对象
            Record record = new Record();
            record.setId(null);
            record.setText(text);
            record.setDate(new Date());
            getNoteDao().insert(record);
            Log.d("tttt", "Inserted new note, ID: " + record.getId());
            cursor.requery();
        }
    }
}
