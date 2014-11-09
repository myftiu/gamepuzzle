package com.myftiu.king.model;

/**
 * @author by ali myftiu.
 */
public class Score {

    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score1 = (Score) o;

        if (score != score1.score) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return score;
    }
}
