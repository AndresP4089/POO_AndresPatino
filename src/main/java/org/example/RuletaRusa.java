package org.example;
import java.util.ArrayList;
import java.util.*;
import java.awt.Toolkit;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class RuletaRusa {
    private List<Integer> tambor; // # camaras del revolver
    private int bala; // posicion o indice de la bala
    private int posicionActual; // # pisicion o camara dispuesta para el siguiente disparo
    private  Random random; // numero aleatorio
    private boolean vivoMuerto;
    private List<String> juegodores;
    private int jugadorActual;

    public RuletaRusa() {
        this.tambor = new ArrayList<>();
        this.random = new Random();

        for(int i = 0; i < 6; i++){
            this.tambor.add(i);
        }

        bala = random.nextInt(5);
        posicionActual = random.nextInt(5);
    }

    public void reiniciarJuego () {
        bala = random.nextInt(5);
        posicionActual = random.nextInt(5);
    }

    public void disparar (int jugadorActual) {


        //Toolkit.getDefaultToolkit().beep();
        System.out.print("\n\nEra el turno de " + juegodores.get(jugadorActual) + ", quien disparó y está ");

        if (posicionActual == bala) {
            try {
                // Sonido 1: Beep
                File soundFile1 = new File("src/main/resources/pistol.wav");
                // Ruta del archivo .wav
                playSound(soundFile1);

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("!!!Muerto¡¡¡");
            vivoMuerto = false;
        } else {
            try {
                // Sonido 1: Beep
                File soundFile2 = new File("src/main/resources/sinbala.wav");
                // Ruta del archivo .wav
                playSound(soundFile2);

            } catch (Exception e) {
                e.printStackTrace();
            }
            vivoMuerto = true;
            System.out.println("!!!Vivo¡¡¡");
            if (posicionActual==5) {
                posicionActual=0;
            } else {
                posicionActual++;
            }
        }
    }

    @Override
    public String toString() {
        return "\n\nRuletaRusa{" +
                "bala=" + bala +
                ", posicionActual=" + posicionActual +
                ", random=" + random +
                ", vivoMuerto=" + vivoMuerto +
                ", juegodores=" + juegodores +
                ", jugadorActual=" + jugadorActual +
                '}';
    }

    public boolean isVivoMuerto() {
        return vivoMuerto;
    }

    public void cargarJugadores (List<String> jugadores) {
        this.juegodores = jugadores;
        jugadorActual = random.nextInt(jugadores.toArray().length - 1);
    }

    public void siguienteTirador () {
        if (jugadorActual == juegodores.toArray().length-1) {
            jugadorActual = 0;
        } else {
            this.jugadorActual++;
        }
    }

    public int getJugadorActual() {
        return jugadorActual;
    }

    private static void playSound(File soundFile) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();

        // Esperar a que termine el sonido
        try {
            Thread.sleep(clip.getMicrosecondLength() / 1000);  // Convertir microsegundos a milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
