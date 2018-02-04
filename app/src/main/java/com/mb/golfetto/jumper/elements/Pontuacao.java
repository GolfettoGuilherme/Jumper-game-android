package com.mb.golfetto.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.mb.golfetto.jumper.graphics.Cores;

public class Pontuacao {

    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos = 0;

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100,100,BRANCO);
    }

    public void aumenta() {
        this.pontos++;
    }
}
