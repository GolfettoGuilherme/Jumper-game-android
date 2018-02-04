package com.mb.golfetto.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.mb.golfetto.jumper.R;
import com.mb.golfetto.jumper.elements.Canos;
import com.mb.golfetto.jumper.elements.GameOver;
import com.mb.golfetto.jumper.elements.Passaro;
import com.mb.golfetto.jumper.elements.Pontuacao;
import com.mb.golfetto.jumper.graphics.Tela;

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Context context;
    private Canos canos;
    private Pontuacao pontuacao;
    private Som som;

    public Game(Context context) {
        super(context);
        tela = new Tela(context);
        this.context = context;
        som = new Som(context);

        inicializaElementos();
        setOnTouchListener(this);

    }

    private void inicializaElementos() {

        passaro = new Passaro(tela, context,som);
        pontuacao = new Pontuacao();
        canos = new Canos(tela,pontuacao, context, som);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back,back.getWidth(),tela.getAltura(), false);
    }

    @Override
    public void run() {

        while(isRunning){
            if(!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            //desenho dos componentes do jogo
            canvas.drawBitmap(background,0,0,null);

            passaro.desenhaNo(canvas);
            passaro.cai();

            canos.desenhaNo(canvas);
            canos.move();

            pontuacao.desenhaNo(canvas);

            if(new VerificadorDeColisao(passaro,canos).temColisao()) {
                som.toca(Som.COLISAO);
                new GameOver(tela).desenhaNo(canvas);
                isRunning = false;
            }

            holder.unlockCanvasAndPost(canvas);

        }
    }

    public void inicia() {
        isRunning = true;
    }

    public void pausa() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        passaro.pula();
        return false;
    }
}
