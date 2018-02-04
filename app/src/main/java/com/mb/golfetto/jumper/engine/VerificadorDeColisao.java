package com.mb.golfetto.jumper.engine;

import com.mb.golfetto.jumper.elements.Canos;
import com.mb.golfetto.jumper.elements.Passaro;

class VerificadorDeColisao {

    private Passaro passaro;
    private Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }


    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
