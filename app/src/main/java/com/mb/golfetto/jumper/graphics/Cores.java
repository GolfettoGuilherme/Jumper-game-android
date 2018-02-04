package com.mb.golfetto.jumper.graphics;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by Guilherme on 04/02/2018.
 */

public class Cores {
    public static Paint getCorDoPassaro() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000); //FORMATO ARGB
        return paint;
    }

    public static Paint getCorDoCano() {
        Paint verde =new Paint();
        verde.setColor(0xFF00FF00);
        return verde;
    }

    public static Paint getCorDaPontuacao() {
        Paint branco =new Paint();
        branco.setColor(0xFFFFFFFF);
        branco.setTextSize(80);
        branco.setTypeface(Typeface.DEFAULT_BOLD);
        branco.setShadowLayer(3, 5, 5,0xFF000000);
        return branco;
    }
    public static  Paint getCorDoGameOver(){
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        vermelho.setTextSize(80);
        vermelho.setTypeface(Typeface.DEFAULT_BOLD);
        vermelho.setShadowLayer(2,3,3,0xFF000000);
        return vermelho;
    }
}
