package edu.qingyun.GsonConfig.QueHun.Test;

import java.util.List;

/**
 * Auto-generated: 2021-12-15 19:40:55
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class QueHunBasicReturn {

    private int count;
    private Level level;
    private Max_level max_level;
    private List<Double> rank_rates;
    private List<Integer> rank_avg_score;
    private double avg_rank;
    private double negative_rate;
    private long id;
    private String nickname;
    private List<Integer> played_modes;
    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
    public Level getLevel() {
        return level;
    }

    public void setMax_level(Max_level max_level) {
        this.max_level = max_level;
    }
    public Max_level getMax_level() {
        return max_level;
    }

    public void setRank_rates(List<Double> rank_rates) {
        this.rank_rates = rank_rates;
    }
    public List<Double> getRank_rates() {
        return rank_rates;
    }

    public void setRank_avg_score(List<Integer> rank_avg_score) {
        this.rank_avg_score = rank_avg_score;
    }
    public List<Integer> getRank_avg_score() {
        return rank_avg_score;
    }

    public void setAvg_rank(double avg_rank) {
        this.avg_rank = avg_rank;
    }
    public double getAvg_rank() {
        return avg_rank;
    }

    public void setNegative_rate(double negative_rate) {
        this.negative_rate = negative_rate;
    }
    public double getNegative_rate() {
        return negative_rate;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }

    public void setPlayed_modes(List<Integer> played_modes) {
        this.played_modes = played_modes;
    }
    public List<Integer> getPlayed_modes() {
        return played_modes;
    }

    @Override
    public String toString() {
        return "QueHunBasicReturn{" +
                "当前局数=" + count +
                ", level=" + level +
                ", max_level=" + max_level +
                ", rank_rates=" + rank_rates +
                ", rank_avg_score=" + rank_avg_score +
                ", avg_rank=" + avg_rank +
                ", negative_rate=" + negative_rate +
                ", id=" + id +
                ", nickname='" + nickname + '\'' +
                ", played_modes=" + played_modes +
                '}';
    }
}
