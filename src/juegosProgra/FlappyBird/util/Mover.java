package juegosProgra.flappyBird.util;

import juegosProgra.flappyBird.fb.Pantalla;

public interface Mover  {
    
     void mover();
     default boolean validarMovimiento(ObjetoGrafico ob){
          if (Pantalla.mPantalla[ob.getX()][ob.getY()] == '#') {

                return true;
            } else {
                return false;
            }
     }
     public void reset();

}
