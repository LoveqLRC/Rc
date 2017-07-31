package loveq.rc.rc.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author：Rc
 * 0n 2017/7/30 11:58
 */
@Entity
public class Channel {
    String newsChannelName;
    String newsChannelId;
    String newsChannelType;
    String newsChannelSelect;
    String newsChannelIndex;
    String newsChannelFixed;
    @Generated(hash = 104496804)
    public Channel(String newsChannelName, String newsChannelId,
            String newsChannelType, String newsChannelSelect,
            String newsChannelIndex, String newsChannelFixed) {
        this.newsChannelName = newsChannelName;
        this.newsChannelId = newsChannelId;
        this.newsChannelType = newsChannelType;
        this.newsChannelSelect = newsChannelSelect;
        this.newsChannelIndex = newsChannelIndex;
        this.newsChannelFixed = newsChannelFixed;
    }
    @Generated(hash = 459652974)
    public Channel() {
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
    public String getNewsChannelSelect() {
        return this.newsChannelSelect;
    }
    public void setNewsChannelSelect(String newsChannelSelect) {
        this.newsChannelSelect = newsChannelSelect;
    }
    public String getNewsChannelIndex() {
        return this.newsChannelIndex;
    }
    public void setNewsChannelIndex(String newsChannelIndex) {
        this.newsChannelIndex = newsChannelIndex;
    }
    public String getNewsChannelFixed() {
        return this.newsChannelFixed;
    }
    public void setNewsChannelFixed(String newsChannelFixed) {
        this.newsChannelFixed = newsChannelFixed;
    }
}
