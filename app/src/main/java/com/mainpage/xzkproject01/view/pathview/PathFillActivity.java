package com.mainpage.xzkproject01.view.pathview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.flawdemo.bridge.log.LogUtils;
import com.mainpage.xzkproject01.R;

/**
 * @author xzk
 * @data 2018/9/7
 * @remark path填充模式选择
 */
public class PathFillActivity extends AppCompatActivity implements View.OnClickListener {

    private PathFillTypeView path_fill_view;
    private Button but_fill_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_fill);

        path_fill_view = findViewById(R.id.path_fill_view);
        but_fill_click = findViewById(R.id.but_fill_click);
        but_fill_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_fill_click:
                String changeModel = path_fill_view.changeModel();
                but_fill_click.setText(changeModel);
                break;
            default:
                LogUtils.d("id未注册");
                break;
        }
    }
}
