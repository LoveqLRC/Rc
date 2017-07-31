package loveq.rc.rc.module.news.presenter;

import loveq.rc.rc.base.BasePresenter;

/**
 * Author：Rc
 * 0n 2017/7/31 22:38
 */

public interface INewsPresenter extends BasePresenter {
    /**
     * 频道排序或增删变化后调用此方法更新数据库
     */
    void operateChannelDb();
}
