package ru.mgvk.velness.UI;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import ru.mgvk.wellness.R;

public class Tab extends LinearLayout {
    private static final int COLOR_SELECTED = Color.parseColor("#c96154");
    private static final int COLOR_UNSELECTED = Color.parseColor("#959a9d");
    int[] ids = new int[]{R.drawable.img_tab_bar_future, R.drawable.img_tab_bar_past, R.drawable.img_tab_bar_profile, R.drawable.img_tab_bar_future_sel, R.drawable.img_tab_bar_past_sel, R.drawable.img_tab_bar_profile_sel};
    ImageView imageView;
    int index = 0;
    TextView text;
    private String[] texts = new String[]{"Отметиться", "Мероприятия", "Профиль"};

    public Tab(Context context, int i) {
        super(context);
        this.index = i;
        setOrientation(1);
        setLayoutParams(new LayoutParams(-1, -1));
        setGravity(17);
        setPadding(0, 0, 0, UI.toDP(3));
        initImage();
        initText();
    }

    private void initImage() {
        this.imageView = new ImageView(getContext());
        this.imageView.setImageResource(this.ids[this.index]);
        this.imageView.setLayoutParams(new LayoutParams(-1, -1, 3.0f));
        addView(this.imageView);
    }

    private void initText() {
        this.text = new TextView(getContext());
        this.text.setText(this.texts[this.index]);
        this.text.setGravity(17);
        this.text.setTextColor(COLOR_UNSELECTED);
        this.text.setTextAlignment(4);
        this.text.setLayoutParams(new LayoutParams(-1, -1, 10.0f));
        this.text.setTextSize(8.0f);
        addView(this.text);
    }

    public void setSelected(boolean selected) {
        if (selected) {
            this.text.setTextColor(COLOR_SELECTED);
            this.imageView.setImageResource(this.ids[this.index + 3]);
            return;
        }
        this.text.setTextColor(COLOR_UNSELECTED);
        this.imageView.setImageResource(this.ids[this.index]);
    }
}
