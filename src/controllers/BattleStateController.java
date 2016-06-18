/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import models.Pokemon;

/**
 *
 * @author paolo
 */
public class BattleStateController {

    public static void setPokemon(Pokemon dummyPokemon, JLabel l_image_pokemon,
            JProgressBar pb_pokemon_life, JLabel l_pokemon_name, int player) {
        String trainerType;

        if (player == 0) {
            trainerType = "opponent";
        } else {
            trainerType = "opponent";
        }

        ImageIcon opponentImage = new ImageIcon("assets" + File.separator + "milotic_opponent.gif");
        l_image_pokemon.setIcon(opponentImage);

        pb_pokemon_life.setStringPainted(true);
        pb_pokemon_life.setMaximum(141);
        pb_pokemon_life.setMinimum(0);
        pb_pokemon_life.setValue(61);
        pb_pokemon_life.setString("61/141");

        l_pokemon_name.setText("Milotic");
    }

}
