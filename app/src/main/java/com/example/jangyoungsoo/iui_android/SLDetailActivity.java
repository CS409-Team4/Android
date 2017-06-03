package com.example.jangyoungsoo.iui_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SLDetailActivity extends AppCompatActivity {

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sl_detailpage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        position = intent.getIntExtra(SLItemAdapter.EXTRA_MESSAGE, 0);

        TextView title = (TextView) findViewById(R.id.sl_detail_textView);
        TextView content = (TextView) findViewById(R.id.sl_detail_textView2);

        title.setText(SelectionActivity.slItemsFinal.get(position).getTitle());
        content.setText(SelectionActivity.slItemsFinal.get(position).getContent());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_add_to_fav:
                for (SLItem slitem : SelectionActivity.slItems) {
                    if (slitem.getId() == position) {
                        if (slitem.getFav()) {
                            slitem.setFav(false);
                        } else {
                            slitem.setFav(true);
                        }
                        break;
                    }
                }

                SelectionActivity.slFragment2.updateSLItemsFav();
                SelectionActivity.slFragment.setupListRecyclerView();
                SelectionActivity.slFragment2.setupListRecyclerView();
                finish();
                return true;
            case R.id.action_delete:
                for (SLItem slitem : SelectionActivity.slItems) {
                    if (slitem.getId() == position) {
                        SelectionActivity.slItems.remove(slitem);
                        break;
                    }
                }

                SelectionActivity.slFragment2.updateSLItemsFav();
                SelectionActivity.slFragment.setupListRecyclerView();
                SelectionActivity.slFragment2.setupListRecyclerView();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_sl_detailpage, menu);
        return true;
    }

}
