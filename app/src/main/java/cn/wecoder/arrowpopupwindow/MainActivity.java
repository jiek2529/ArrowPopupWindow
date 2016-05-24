package cn.wecoder.arrowpopupwindow;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.wecoder.arrowpopupwindow.library.widgets.popupwindow.ArrowPopupWindow;
import cn.wecoder.arrowpopupwindow.library.widgets.popupwindow.ArrowTiedFollowPopupWindow;
import cn.wecoder.arrowpopupwindow.library.widgets.popupwindow.ArrowTiedPopupWindow;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable runnable;
    int color = R.color.transparent_70;
    private Button mLeftButton;
    private Button mRightButton;
    private Button mTopButton;
    private Button mBottomButton;
    private Button mPositionButton;
    private Button mOffsetButton;
    private TextView mTextView;
    private ArrowTiedFollowPopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        initPopupWindow();
    }

    private void dismiss() {
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        runnable = new Runnable() {
            @Override
            public void run() {
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                }
            }
        };
        handler.postDelayed(runnable, 5000);
    }

    private void initListeners() {
        mLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                }
                mPopupWindow.setArrow(color, 0.5f, ArrowPopupWindow.ArrowSize.SMALL);
                mPopupWindow.setTiedView(mLeftButton, ArrowTiedPopupWindow.TiedDirection.LEFT);
                mPopupWindow.setOffset(0, 0);
                mPopupWindow.preShow();
                mPopupWindow.show();
                dismiss();
            }
        });
        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                }
                mPopupWindow.setArrow(color, 0.5f, ArrowPopupWindow.ArrowSize.SMALL);
                mPopupWindow.setTiedView(mRightButton, ArrowTiedPopupWindow.TiedDirection.RIGHT);
                mPopupWindow.setOffset(0, 0);
                mPopupWindow.preShow();
                mPopupWindow.show();
                dismiss();
            }
        });
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                }
                mPopupWindow.setArrow(color, 0.5f, ArrowPopupWindow.ArrowSize.SMALL);
                mPopupWindow.setTiedView(mTopButton, ArrowTiedPopupWindow.TiedDirection.TOP);
                mPopupWindow.setOffset(0, 0);
                mPopupWindow.preShow();
                mPopupWindow.show();
                dismiss();
            }
        });
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                }
                mPopupWindow.setArrow(color, 0.5f, ArrowPopupWindow.ArrowSize.SMALL);
                mPopupWindow.setTiedView(mBottomButton, ArrowTiedPopupWindow.TiedDirection.BOTTOM);
                mPopupWindow.setOffset(0, 0);
                mPopupWindow.preShow();
                mPopupWindow.show();
                dismiss();
            }
        });
        mPositionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                }
                mPopupWindow.setArrow(color, 0.7f, ArrowPopupWindow.ArrowSize.SMALL);
                mPopupWindow.setTiedView(mPositionButton, ArrowTiedPopupWindow.TiedDirection.RIGHT);
                mPopupWindow.setOffset(0, 0);
                mPopupWindow.preShow();
                mPopupWindow.show();
                dismiss();
            }
        });
        mOffsetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                }
                mPopupWindow.setArrow(color, 0.7f, ArrowPopupWindow.ArrowSize.SMALL);
                mPopupWindow.setTiedView(mOffsetButton, ArrowTiedPopupWindow.TiedDirection.LEFT);
                mPopupWindow.setOffset(-10, -10);
                mPopupWindow.preShow();
                mPopupWindow.show();
                dismiss();
            }
        });
    }

    private void initViews() {
        mLeftButton = (Button) findViewById(R.id.left);
        mRightButton = (Button) findViewById(R.id.right);
        mTopButton = (Button) findViewById(R.id.top);
        mBottomButton = (Button) findViewById(R.id.bottom);
        mOffsetButton = (Button) findViewById(R.id.offset);
        mPositionButton = (Button) findViewById(R.id.position);
        mTextView = new TextView(this);
        mTextView.setText("hello world\nvery nice\ngood");
        mTextView.setTextColor(getResources().getColor(R.color.gray));
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
    }

    private void initPopupWindow() {
        mPopupWindow = new ArrowTiedFollowPopupWindow(MainActivity.this);
        mPopupWindow.setBackground(color, 10, 10, 20);
//        mPopupWindow.setPopupView(mTextView);
        mPopupWindow.setPopupView(getLayoutInflater().inflate(R.layout.test_ll, null));
        mPopupWindow.setEdge(80, 0, 10, 0);
        mPopupWindow.setEdgeLine(R.color.edge, 1);
        mPopupWindow.setAnimationStyle(R.style.cardPopupAnimation);
        mPopupWindow.setOutsideTouchable(true);
    }

    @Override
    protected void onDestroy() {
        dismissPopup();
        super.onDestroy();
    }

    private void dismissPopup() {
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        }
    }

    public void click_do(View view) {
        Toast.makeText(MainActivity.this, "asdjfasldfa", Toast.LENGTH_SHORT).show();
        dismissPopup();
    }
}
