package com.example.tictactoe;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    int turn = 1;
    int turnsPlayed = 0;
    TextView turnText;
    ImageView topLeft, topMiddle, topRight, middleLeft, middle, middleRight, bottomLeft,
            bottomMiddle, bottomRight;
    String xTag;
    String oTag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        turnText = findViewById(R.id.turnText);

        topLeft = findViewById(R.id.topLeft);
        topMiddle = findViewById(R.id.topMiddle);
        topRight = findViewById(R.id.topRight);
        middleLeft = findViewById(R.id.leftMiddle);
        middle = findViewById(R.id.middle);
        middleRight = findViewById(R.id.rightMiddle);
        bottomLeft = findViewById(R.id.bottomLeft);
        bottomMiddle = findViewById(R.id.bottomMiddle);
        bottomRight = findViewById(R.id.bottomRight);

        topLeft.setTag(null);
        topMiddle.setTag(null);
        topRight.setTag(null);
        middleLeft.setTag(null);
        middle.setTag(null);
        middleRight.setTag(null);
        bottomRight.setTag(null);
        bottomMiddle.setTag(null);
        bottomLeft.setTag(null);




        xTag = new String("x");
        oTag = new String("o");



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onTurnPlayed(View view) {
        if (turn == 1){
            ((ImageView)view).setVisibility(View.VISIBLE);
            ((ImageView) view).setImageResource(R.drawable.tic_tac_toe_x);
            ((ImageView)view).setTag(xTag);
            ((ImageView)view).setClickable(false);
            turn ++;
            turnsPlayed ++;
            if ((topLeft.getTag() != null && topMiddle.getTag()!=null && topRight.getTag()!=null) && topLeft.getTag() .equals(topMiddle.getTag()) && topMiddle.getTag().equals(topRight.getTag())){
                System.out.println("Player One Wins!");
                gameOver(1);
            }
            if ((middleLeft.getTag() != null && middle.getTag()!=null && middleRight.getTag()!=null) && middleLeft.getTag() .equals(middle.getTag()) && middle.getTag().equals(middleRight.getTag())){
                System.out.println("Player One Wins!");
                gameOver(1);
            }
            if ((bottomLeft.getTag() != null && bottomMiddle.getTag()!=null && bottomRight.getTag()!=null) && bottomLeft.getTag() .equals(bottomMiddle.getTag()) && bottomMiddle.getTag().equals(bottomRight.getTag())){
                System.out.println("Player One Wins!");
                gameOver(1);
            }

            if ((topLeft.getTag() != null && middleLeft.getTag()!=null && bottomLeft.getTag()!=null) && topLeft.getTag() .equals(middleLeft.getTag()) && middleLeft.getTag().equals(bottomLeft.getTag())){
                System.out.println("Player One Wins!");
                gameOver(1);
            }
            if ((topMiddle.getTag() != null && middle.getTag()!=null && bottomMiddle.getTag()!=null) && topMiddle.getTag() .equals(middle.getTag()) && middle.getTag().equals(bottomMiddle.getTag())){
                System.out.println("Player One Wins!");
                gameOver(1);
            }
            if ((topRight.getTag() != null && middleRight.getTag()!=null && bottomRight.getTag()!=null) && topRight.getTag() .equals(middleRight.getTag()) && middleRight.getTag().equals(bottomRight.getTag())){
                System.out.println("Player One Wins!");
                gameOver(1);
            }

            if ((topLeft.getTag() != null && middle.getTag()!=null && bottomRight.getTag()!=null) && topLeft.getTag() .equals(middle.getTag()) && middle.getTag().equals(bottomRight.getTag())){
                System.out.println("Player One Wins!");
                gameOver(1);
            }
            if ((topRight.getTag() != null && middle.getTag()!=null && bottomLeft.getTag()!=null) &&topRight.getTag() .equals(middle.getTag()) && middle.getTag().equals(bottomLeft.getTag())){
                System.out.println("Player One Wins!");
                gameOver(1);
            }

            if (turnsPlayed == 9){
                gameOver(3);
            }
            turnText.setText("Player Two's Turn");
        }
        else{
            ((ImageView)view).setVisibility(View.VISIBLE);
            ((ImageView) view).setImageResource(R.drawable.tic_tac_toe_o);
            ((ImageView)view).setClickable(false);
            turn --;
            turnsPlayed++;
            ((ImageView)view).setTag(oTag);
            if ((topLeft.getTag() != null && topMiddle.getTag()!=null && topRight.getTag()!=null) && topLeft.getTag() .equals(topMiddle.getTag()) && topMiddle.getTag().equals(topRight.getTag())){
                System.out.println("Player Two Wins!");
                gameOver(2);
            }
            if ((middleLeft.getTag() != null && middle.getTag()!=null && middleRight.getTag()!=null) && middleLeft.getTag() .equals(middle.getTag()) && middle.getTag().equals(middleRight.getTag())){
                System.out.println("Player Two Wins!");
                gameOver(2);
            }
            if ((bottomLeft.getTag() != null && bottomMiddle.getTag()!=null && bottomRight.getTag()!=null) && bottomLeft.getTag() .equals(bottomMiddle.getTag()) && bottomMiddle.getTag().equals(bottomRight.getTag())){
                System.out.println("Player Two Wins!");
                gameOver(2);
            }

            if ((topLeft.getTag() != null && middleLeft.getTag()!=null && bottomLeft.getTag()!=null) && topLeft.getTag() .equals(middleLeft.getTag()) && middleLeft.getTag().equals(bottomLeft.getTag())){
                System.out.println("Player Two Wins!");
                gameOver(2);
            }
            if ((topMiddle.getTag() != null && middle.getTag()!=null && bottomMiddle.getTag()!=null) && topMiddle.getTag() .equals(middle.getTag()) && middle.getTag().equals(bottomMiddle.getTag())){
                System.out.println("Player Two Wins!");
                gameOver(2);
            }
            if ((topRight.getTag() != null && middleRight.getTag()!=null && bottomRight.getTag()!=null) && topRight.getTag() .equals(middleRight.getTag()) && middleRight.getTag().equals(bottomRight.getTag())){
                System.out.println("Player Two Wins!");
                gameOver(2);
            }

            if ((topLeft.getTag() != null && middle.getTag()!=null && bottomRight.getTag()!=null) && topLeft.getTag() .equals(middle.getTag()) && middle.getTag().equals(bottomRight.getTag())){
                System.out.println("Player Two Wins!");
                gameOver(2);
            }
            if ((topRight.getTag() != null && middle.getTag()!=null && bottomLeft.getTag()!=null) &&topRight.getTag() .equals(middle.getTag()) && middle.getTag().equals(bottomLeft.getTag())){
                System.out.println("Player Two Wins!");
                gameOver(2);
            }

            if (turnsPlayed == 9){
                gameOver(3);
            }
            turnText.setText("Player One's Turn");
        }
    }

    public void gameOver(int winner){
        if (winner == 1){
            Intent intent = new Intent(this, GameOverActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("result", 1);
            this.startActivityForResult(intent, 1, null);
        }
        else if (winner == 2){
            Intent intent = new Intent(this, GameOverActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("result", 2);
            this.startActivityForResult(intent, 1, null);
        }
        else{
            Intent intent = new Intent(this, GameOverActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("result", 3);
            this.startActivityForResult(intent, 1, null);
        }
    }
}