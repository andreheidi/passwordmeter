package me.moriya.domain.checker;

import java.io.Serializable;

import me.moriya.domain.Score;

public interface Checker extends Serializable {

    public Score getScore();

}
