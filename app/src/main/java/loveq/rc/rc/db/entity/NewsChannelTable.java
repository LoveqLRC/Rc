package loveq.rc.rc.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author：Rc
 * 0n 2017/7/30 11:58
 */
@Entity
public class NewsChannelTable {
    String newsChannelName;
    String newsChannelId;
    String newsChannelType;
    boolean newsChannelSelect;
    int newsChannelIndex;
    boolean newsChannelFixed;
    @Generated(hash = 782834619)
    public NewsChannelTable(String newsChannelName, String newsChannelId,
            String newsChannelType, boolean newsChannelSelect, int newsChannelIndex,
            boolean newsChannelFixed) {
        this.newsChannelName = newsChannelName;
        this.newsChannelId = newsChannelId;
        this.newsChannelType = newsChannelType;
        this.newsChannelSelect = newsChannelSelect;
        this.newsChannelIndex = newsChannelIndex;
        this.newsChannelFixed = newsChannelFixed;
    }
    @Generated(hash = 518806505)
    public NewsChannelTable() {
    }
    public String getNewsChannelName() {
        return this.newsChannelName;
    }
    public void setNewsChannelName(String newsChannelName) {
        this.newsChannelName = newsChannelName;
    }
    public String getNewsChannelId() {
        return this.newsChannelId;
    }
    public void setNewsChannelId(String newsChannelId) {
        this.newsChannelId = newsChannelId;
    }
    public String getNewsChannelType() {
        return this.newsChannelType;
    }
    public void setNewsChannelType(String newsChannelType) {
        this.newsChannelType = newsChannelType;
    }
    public boolean getNewsChannelSelect() {
        return this.newsChannelSelect;
    }
    public void setNewsChannelSelect(boolean newsChannelSelect) {
        this.newsChannelSelect = newsChannelSelect;
    }
    public int getNewsChannelIndex() {
        return this.newsChannelIndex;
    }
    public void setNewsChannelIndex(int newsChannelIndex) {
        this.newsChannelIndex = newsChannelIndex;
    }
    public boolean getNewsChannelFixed() {
        return this.newsChannelFixed;
    }
    public void setNewsChannelFixed(boolean newsChannelFixed) {
        this.newsChannelFixed = newsChannelFixed;
    }


}
