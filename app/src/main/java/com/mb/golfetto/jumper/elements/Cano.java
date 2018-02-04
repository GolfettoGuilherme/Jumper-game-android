package com.mb.golfetto.jumper.elements;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.mb.golfetto.jumper.R;
import com.mb.golfetto.jumper.graphics.Cores;
import com.mb.golfetto.jumper.graphics.Tela;

public class Cano {

    private static final int TAMANHO_DO_CANO = 450;
    private static final int LARGURA_DO_CANO = 200;

    private static final Paint VERDE = Cores.getCorDoCano();
    private final int alturaDoCanoInferior;
    private final Bitmap canoInfeior;
    private final Bitmap canoSuperior;
    private int posicao;
    private Tela tela;
    private int alturaDoCanoSuperior;


    public Cano(Tela tela, int posicao, Context context){
        this.tela = tela;
        alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
        this.posicao = posicao;
        Bitmap dp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);

        canoInfeior = Bitmap.createScaledBitmap(dp, LARGURA_DO_CANO, alturaDoCanoInferior, false);

        canoSuperior = Bitmap.createScaledBitmap(dp,LARGURA_DO_CANO,alturaDoCanoSuperior, false);
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 250);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoSuperiorNo(canvas);
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(Canvas canvas){
        //canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO , alturaDoCanoSuperior, VERDE);
        canvas.drawBitmap(canoInfeior,posicao, alturaDoCanoInferior,null);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas){
        //canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO , tela.getAltura(), VERDE);
        canvas.drawBitmap(canoSuperior, posicao, 0,null);
    }



    public void move() {
        this.posicao -= 5;
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao < passaro.X + passaro.RAIO;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - passaro.RAIO < this.alturaDoCanoSuperior
                || passaro.getAltura() + passaro.RAIO > this.alturaDoCanoInferior;
    }
}
