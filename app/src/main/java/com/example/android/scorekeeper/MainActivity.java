package com.example.android.scorekeeper;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SCORE_START = 0;
    private static final int SCORE_TOUCHDOWN = 6;
    private static final int SCORE_POINT_AFTER_TOUCHDOWN = 1;
    private static final int SCORE_FIELD_GOAL = 3;
    private static final int SCORE_SAFETY = 2;
    private static final int SCORE_TWO_POINTS_CONVERSION = 2;

    private static final String SAVE_TEAM_A_SCORE = "SAVE_TEAM_A_SCORE";
    private static final String SAVE_TEAM_B_SCORE = "SAVE_TEAM_B_SCORE";

    private TextView mTeamAScoreTextView;
    private TextView mTeamBScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTeamAScoreTextView = (TextView) findViewById(R.id.tv_team_a_score);
        mTeamBScoreTextView = (TextView) findViewById(R.id.tv_team_b_score);

        resetScores();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(SAVE_TEAM_A_SCORE, mTeamAScoreTextView.getText().toString());
        outState.putString(SAVE_TEAM_B_SCORE, mTeamBScoreTextView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mTeamAScoreTextView.setText(savedInstanceState.getString(SAVE_TEAM_A_SCORE));
        mTeamBScoreTextView.setText(savedInstanceState.getString(SAVE_TEAM_B_SCORE));
    }

    public void onClickTouchdown(View view) {
        if (R.id.b_touchdown_team_a == view.getId()) {
            increaseTeamAScore(SCORE_TOUCHDOWN);
        } else {
            increaseTeamBScore(SCORE_TOUCHDOWN);
        }
    }

    public void onClickPointAfterTouchdown(View view) {
        if (R.id.b_point_after_touchdown_team_a == view.getId()) {
            increaseTeamAScore(SCORE_POINT_AFTER_TOUCHDOWN);
        } else {
            increaseTeamBScore(SCORE_POINT_AFTER_TOUCHDOWN);
        }
    }

    public void onClickFieldGoal(View view) {
        if (R.id.b_field_goal_team_a == view.getId()) {
            increaseTeamAScore(SCORE_FIELD_GOAL);
        } else {
            increaseTeamBScore(SCORE_FIELD_GOAL);
        }
    }

    public void onClickSafety(View view) {
        if (R.id.b_safety_team_a == view.getId()) {
            increaseTeamAScore(SCORE_SAFETY);
        } else {
            increaseTeamBScore(SCORE_SAFETY);
        }
    }

    public void onClickTwoPointConversion(View view) {
        if (R.id.b_two_point_conversion_team_a == view.getId()) {
            increaseTeamAScore(SCORE_TWO_POINTS_CONVERSION);
        } else {
            increaseTeamBScore(SCORE_TWO_POINTS_CONVERSION);
        }
    }

    private int getTeamAScore() {
        final String scoreString = mTeamAScoreTextView.getText().toString();
        return Integer.parseInt(scoreString);
    }

    private int getTeamBScore() {
        final String scoreString = mTeamBScoreTextView.getText().toString();
        return Integer.parseInt(scoreString);
    }

    private void setTeamAScore(int score) {
        mTeamAScoreTextView.setText(String.valueOf(score));
    }

    private void setTeamBScore(int score) {
        mTeamBScoreTextView.setText(String.valueOf(score));
    }

    private void increaseTeamAScore(int increaseByValue) {
        int score = getTeamAScore();
        score = score + increaseByValue;
        setTeamAScore(score);
    }

    private void increaseTeamBScore(int increaseByValue) {
        int score = getTeamBScore();
        score = score + increaseByValue;
        setTeamBScore(score);
    }

    private void resetScores() {
        setTeamAScore(SCORE_START);
        setTeamBScore(SCORE_START);
    }

    public void onClickResetScores(View view) {
        resetScores();
    }
}
