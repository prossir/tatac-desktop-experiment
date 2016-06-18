package controllers;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import models.Pokemon;

/**
 * @author paolo
 */
public class BattleStateController {

    public static void setPokemon(Pokemon pokemon, JLabel l_image_pokemon,
            JProgressBar pb_pokemon_life, JLabel l_pokemon_name,
            JLabel l_pokemon_status, int player) {
        String trainerType;

        if (player == 0) {
            trainerType = "opponent";
        } else {
            trainerType = "player";
        }

        ImageIcon opponentImage = new ImageIcon("assets" + File.separator
                + pokemon.getName() + "_" + trainerType + ".gif");
        l_image_pokemon.setIcon(opponentImage);

        pb_pokemon_life.setStringPainted(true);
        pb_pokemon_life.setMaximum(pokemon.getTotalHitPoints());
        pb_pokemon_life.setMinimum(0);
        pb_pokemon_life.setValue(pokemon.getHitPoints());
        pb_pokemon_life.setString(pokemon.getHitPoints() + "/"
                + pokemon.getTotalHitPoints());

        l_pokemon_name.setText(pokemon.getName());

        l_pokemon_status.setText("");
    }
}