package loveq.rc.rc.module.news.view;

import java.util.List;

import loveq.rc.rc.base.BaseView;
import loveq.rc.rc.db.entity.NewsChannelTable;

/**
 * Author：Rc
 * 0n 2017/8/1 06:44
 */

public interface INewsView extends BaseView {
    void initViewPager(List<NewsChannelTable> newsChannelTables);

    void initRxBusEvent();
}
