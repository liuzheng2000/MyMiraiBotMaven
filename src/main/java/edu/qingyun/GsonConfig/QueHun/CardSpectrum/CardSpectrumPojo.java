package edu.qingyun.GsonConfig.QueHun.CardSpectrum;

import java.util.List;

/**
 * Auto-generated: 2021-12-18 16:29:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CardSpectrumPojo {

    private String _id;
    private int modeId;
    private String uuid;
    private long startTime;
    private long endTime;
    private List<Players> players;
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_id() {
        return _id;
    }

    public void setModeId(int modeId) {
        this.modeId = modeId;
    }
    public int getModeId() {
        return modeId;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getUuid() {
        return uuid;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    public long getStartTime() {
        return startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    public long getEndTime() {
        return endTime;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }
    public List<Players> getPlayers() {
        return players;
    }

}