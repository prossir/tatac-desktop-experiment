package view;

import controllers.BattleStateController;
import java.awt.Color;
import java.util.List;
import models.Pokemon;

/**
 * @author paolo
 */
public class BattleInterface extends javax.swing.JFrame {

    private List<Pokemon> playerTeam;
    private List<Pokemon> enemyTeam;
    private int currentPlayerPokemon;
    private int currentEnemyPokemon;

    public BattleInterface() {
        initComponents();
        loadBattle();
    }

    public BattleInterface(List<Pokemon> playerTeam, List<Pokemon> computerTeam) {
        this.playerTeam = playerTeam;
        this.enemyTeam = computerTeam;
        currentEnemyPokemon = 0;
        currentPlayerPokemon = 0;
        initComponents();
        loadBattle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_battle_menu = new javax.swing.JPanel();
        b_move1 = new javax.swing.JButton();
        b_move2 = new javax.swing.JButton();
        b_move3 = new javax.swing.JButton();
        b_move4 = new javax.swing.JButton();
        cb_change_pokemon = new javax.swing.JComboBox<>();
        p_player_pokemon = new javax.swing.JPanel();
        l_player_pokemon_name = new javax.swing.JLabel();
        pb_player_pokemon_life = new javax.swing.JProgressBar();
        l_image_player_pokemon = new javax.swing.JLabel();
        l_player_pokemon_status = new javax.swing.JLabel();
        p_enemy_pokemon = new javax.swing.JPanel();
        l_enemy_pokemon_name = new javax.swing.JLabel();
        pb_enemy_pokemon_life = new javax.swing.JProgressBar();
        l_image_enemy_pokemon = new javax.swing.JLabel();
        l_enemy_pokemon_status = new javax.swing.JLabel();
        l_announcement = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        p_battle_menu.setBackground(new java.awt.Color(0, 0, 0));
        p_battle_menu.setForeground(new java.awt.Color(255, 255, 255));
        p_battle_menu.setOpaque(false);

        b_move1.setText("Move 1");
        b_move1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_move1ActionPerformed(evt);
            }
        });

        b_move2.setText("Move 2");
        b_move2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_move2ActionPerformed(evt);
            }
        });

        b_move3.setText("Move 3");
        b_move3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_move3ActionPerformed(evt);
            }
        });

        b_move4.setText("Move 4");
        b_move4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_move4ActionPerformed(evt);
            }
        });

        cb_change_pokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_change_pokemonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_battle_menuLayout = new javax.swing.GroupLayout(p_battle_menu);
        p_battle_menu.setLayout(p_battle_menuLayout);
        p_battle_menuLayout.setHorizontalGroup(
            p_battle_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_battle_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_battle_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_move1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(b_move2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_battle_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_move4, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(b_move3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(cb_change_pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        p_battle_menuLayout.setVerticalGroup(
            p_battle_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_battle_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_battle_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_move1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_move3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_change_pokemon))
                .addGap(6, 6, 6)
                .addGroup(p_battle_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_move2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_move4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p_player_pokemon.setBackground(new java.awt.Color(241, 231, 231));
        p_player_pokemon.setForeground(new java.awt.Color(255, 255, 255));

        l_player_pokemon_name.setForeground(new java.awt.Color(255, 255, 255));
        l_player_pokemon_name.setText("Player Pokemon Name");

        l_player_pokemon_status.setForeground(new java.awt.Color(255, 255, 255));
        l_player_pokemon_status.setText("Pokemon Status");

        javax.swing.GroupLayout p_player_pokemonLayout = new javax.swing.GroupLayout(p_player_pokemon);
        p_player_pokemon.setLayout(p_player_pokemonLayout);
        p_player_pokemonLayout.setHorizontalGroup(
            p_player_pokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_player_pokemonLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(l_image_player_pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(p_player_pokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_player_pokemon_status)
                    .addComponent(l_player_pokemon_name)
                    .addComponent(pb_player_pokemon_life, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        p_player_pokemonLayout.setVerticalGroup(
            p_player_pokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_player_pokemonLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(l_player_pokemon_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pb_player_pokemon_life, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_player_pokemon_status)
                .addContainerGap(80, Short.MAX_VALUE))
            .addComponent(l_image_player_pokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        p_enemy_pokemon.setBackground(new java.awt.Color(246, 234, 234));

        l_enemy_pokemon_name.setForeground(new java.awt.Color(245, 231, 231));
        l_enemy_pokemon_name.setText("Enemy Pokemon Name");

        l_image_enemy_pokemon.setBackground(new Color(0,255,0,0));
        l_image_enemy_pokemon.setForeground(new Color(0,225,0,0));
        l_image_enemy_pokemon.setOpaque(true);

        l_enemy_pokemon_status.setForeground(new java.awt.Color(255, 255, 255));
        l_enemy_pokemon_status.setText("Pokemon Status");

        javax.swing.GroupLayout p_enemy_pokemonLayout = new javax.swing.GroupLayout(p_enemy_pokemon);
        p_enemy_pokemon.setLayout(p_enemy_pokemonLayout);
        p_enemy_pokemonLayout.setHorizontalGroup(
            p_enemy_pokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_enemy_pokemonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(p_enemy_pokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb_enemy_pokemon_life, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_enemy_pokemon_name, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_enemy_pokemon_status))
                .addGap(80, 80, 80)
                .addComponent(l_image_enemy_pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        p_enemy_pokemonLayout.setVerticalGroup(
            p_enemy_pokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_enemy_pokemonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(l_enemy_pokemon_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pb_enemy_pokemon_life, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_enemy_pokemon_status)
                .addContainerGap(87, Short.MAX_VALUE))
            .addComponent(l_image_enemy_pokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        l_announcement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_announcement.setText("Announcements");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_enemy_pokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p_battle_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p_player_pokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_announcement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_enemy_pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_announcement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_player_pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_battle_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_move1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_move1ActionPerformed
        executeTurnAndResponse(0);
    }//GEN-LAST:event_b_move1ActionPerformed

    private void cb_change_pokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_change_pokemonActionPerformed
        int selectedPokemon = cb_change_pokemon.getSelectedIndex();
        int damage = currentPlayerPokemon = selectedPokemon;
        BattleStateController.setPokemon(playerTeam.get(currentPlayerPokemon),
                l_image_player_pokemon, pb_player_pokemon_life,
                l_player_pokemon_name, l_player_pokemon_status,
                1, b_move1, b_move2, b_move3, b_move4);

        b_move1.setEnabled(true);
        b_move2.setEnabled(true);
        b_move3.setEnabled(true);
        b_move4.setEnabled(true);
    }//GEN-LAST:event_cb_change_pokemonActionPerformed

    private void b_move2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_move2ActionPerformed
        executeTurnAndResponse(1);
    }//GEN-LAST:event_b_move2ActionPerformed

    private void b_move3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_move3ActionPerformed
        executeTurnAndResponse(2);
    }//GEN-LAST:event_b_move3ActionPerformed

    private void b_move4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_move4ActionPerformed
        executeTurnAndResponse(3);
    }//GEN-LAST:event_b_move4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BattleInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BattleInterface().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_move1;
    private javax.swing.JButton b_move2;
    private javax.swing.JButton b_move3;
    private javax.swing.JButton b_move4;
    private javax.swing.JComboBox<String> cb_change_pokemon;
    private javax.swing.JLabel l_announcement;
    private javax.swing.JLabel l_enemy_pokemon_name;
    private javax.swing.JLabel l_enemy_pokemon_status;
    private javax.swing.JLabel l_image_enemy_pokemon;
    private javax.swing.JLabel l_image_player_pokemon;
    private javax.swing.JLabel l_player_pokemon_name;
    private javax.swing.JLabel l_player_pokemon_status;
    private javax.swing.JPanel p_battle_menu;
    private javax.swing.JPanel p_enemy_pokemon;
    private javax.swing.JPanel p_player_pokemon;
    private javax.swing.JProgressBar pb_enemy_pokemon_life;
    private javax.swing.JProgressBar pb_player_pokemon_life;
    // End of variables declaration//GEN-END:variables

    private void loadBattle() {
        BattleStateController.setChangeablePokemon(playerTeam, cb_change_pokemon);

        BattleStateController.setPokemon(enemyTeam.get(currentEnemyPokemon), l_image_enemy_pokemon,
                pb_enemy_pokemon_life, l_enemy_pokemon_name, l_enemy_pokemon_status,
                0, null, null, null, null);

        BattleStateController.setPokemon(playerTeam.get(currentPlayerPokemon), l_image_player_pokemon,
                pb_player_pokemon_life, l_player_pokemon_name, l_player_pokemon_status,
                1, b_move1, b_move2, b_move3, b_move4);
    }

    private void executeTurnAndResponse(int chosenMove) {
        if (playerTeam.get(currentPlayerPokemon).getSpeed() //The player pokemon is quicker than the other
                >= enemyTeam.get(currentEnemyPokemon).getSpeed()) {
            playerBeginsTurn(chosenMove);
        } else {//Enemy plays last
            enemyBeginsTurn(chosenMove);
        }
    }

    private void disableMoves() {
        b_move1.setEnabled(false);
        b_move2.setEnabled(false);
        b_move3.setEnabled(false);
        b_move4.setEnabled(false);
    }

    private void playerBeginsTurn(int chosenMove) {
        playerPlays(chosenMove);
        //Calculates next best MINIMAX move of enemy. Includes the escenario where the poke is dead
        enemyPlays();
    }

    private void enemyBeginsTurn(int chosenMove) {
        int state = enemyPlays();
        switch (state) {
            case 2://ganaron no se que poner aqui
                break;
            case 1:
                playerPlays(chosenMove);
                break;
            case 0:// our pokemon has died
                break;
            default:
                break;
        }
    }

    private int enemyPlays() {
        int moveChoosen = BattleStateController.enemyMove(enemyTeam, currentEnemyPokemon, playerTeam,
                currentPlayerPokemon);
        if (moveChoosen > -1) {
            int damage = enemyTeam.get(0).damage(playerTeam.get(currentPlayerPokemon), moveChoosen);

            BattleStateController.setPokemon(playerTeam.get(currentPlayerPokemon),
                    l_image_player_pokemon, pb_player_pokemon_life, l_player_pokemon_name,
                    l_player_pokemon_status, 1, b_move1, b_move2, b_move3, b_move4);

            if (playerTeam.get(currentPlayerPokemon).getHitPoints() > 0) {//our pokemon is still alive            
                l_announcement.setText("El " + enemyTeam.get(currentEnemyPokemon).getName()
                        + " enemigo ha hecho "
                        + damage
                        + "de danho, con "
                        + enemyTeam.get(0).getChosenMoves().get(moveChoosen).getName());
                return 1; //player pokemon still alive
            } else {//our pokemon dies
                disableMoves();
                l_announcement.setText(playerTeam.get(currentPlayerPokemon).getName()
                        + " ha caido.");
                return 0; //player pokemon is dead
            }
        } else {// -1 -> 0; -2 -> 1 ...
            if (moveChoosen == -4) {
                l_announcement.setText("Fin de la partida");
                return 2; //enemy team has won
            }
            switch (moveChoosen) {
                case -1:
                    moveChoosen = 0;
                    break;
                case -2:
                    moveChoosen = 1;
                    break;
                case -3:
                    moveChoosen = 2;
                    break;
            }

            currentEnemyPokemon = moveChoosen;
            BattleStateController.setPokemon(enemyTeam.get(currentEnemyPokemon),
                    l_image_enemy_pokemon, pb_enemy_pokemon_life,
                    l_enemy_pokemon_name, l_enemy_pokemon_status,
                    0, null, null, null, null);
            return 1; //player pokemon still alive
        }
    }

    private void playerPlays(int chosenMove) {
        int damage = playerTeam.get(currentPlayerPokemon).damage(enemyTeam.get(currentEnemyPokemon),
                chosenMove);

        BattleStateController.setPokemon(enemyTeam.get(currentEnemyPokemon),
                l_image_enemy_pokemon, pb_enemy_pokemon_life, l_enemy_pokemon_name,
                l_enemy_pokemon_status, 0, null, null, null, null);

        l_announcement.setText(" " + playerTeam.get(currentPlayerPokemon).getName()
                + " ha hecho " + damage + "de danho, con "
                + playerTeam.get(currentPlayerPokemon).getChosenMoves().get(chosenMove).getName());
    }
}