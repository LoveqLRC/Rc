package loveq.rc.rc.module.news.ui;

import android.view.View;

import java.util.List;

import loveq.rc.rc.base.BaseActivity;
import loveq.rc.rc.db.entity.NewsChannelTable;
import loveq.rc.rc.module.news.presenter.INewsPresenter;
import loveq.rc.rc.module.news.view.INewsView;

/**
 * Author：Rc
 * 0n 2017/7/31 22:28
 */

public class NewsActivity extends BaseActivity<INewsPresenter> implements INewsView {
    @Override
    public void onClick(View view) {

    }

    @Override
    public void toast(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void initViewPager(List<NewsChannelTable> newsChannelTables) {

    }

    @Override
    public void initRxBusEvent() {

    }
}
