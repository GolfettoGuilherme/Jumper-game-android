package com.mb.golfetto.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.mb.golfetto.jumper.R;
import com.mb.golfetto.jumper.engine.Som;
import com.mb.golfetto.jumper.graphics.Cores;
import com.mb.golfetto.jumper.graphics.Tela;

public class Passaro {

    public static final float X = 100;
    public static final int RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private final Bitmap passaro;
    private float altura;
    private Som som;
    private Tela tela;

    public Passaro(Tela tela, Context context, Som som){
        this.tela = tela;
        this.altura = tela.getAltura() / 2;
        this.som = som;
        Bitmap dp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(dp,RAIO * 2, RAIO * 2, false);
    }

    public void desenhaNo(Canvas canvas){
        //canvas.drawCircle(X,altura,RAIO,VERMELHO);
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null);
    }

    public void cai() {
        //o ponto zero da tela é o topo, por isso estou aumentando a var altura
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if(!chegouNoChao){
            this.altura += 5;
        }
    }

    public void pula() {
        if (altura > RAIO) {
            som.toca(Som.PULO);
            this.altura -= 150;
        }

    }

    public float getAltura() {
        return altura;
    }
}
