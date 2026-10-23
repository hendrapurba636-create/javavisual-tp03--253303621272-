
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

public class MainWindow extends JFrame {

    private final CharacterManager characterManager;

    private JPanel mainPanel;
    private JPanel characterPanel;
    private JLabel averageLabel;

    public MainWindow(CharacterManager characterManager) {
        super("Character Manager v0.3");

        this.characterManager = characterManager;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 450);
        setLocationRelativeTo(null);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {

        mainPanel = new JPanel(new BorderLayout(10, 10));

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JLabel titleLabel = new JLabel(
                "=== Daftar Karakter ===",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        characterPanel = new JPanel();

        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Label statistik di bagian bawah
        averageLabel = new JLabel("", SwingConstants.CENTER);

        averageLabel.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        averageLabel.setBorder(
                BorderFactory.createEmptyBorder(10, 5, 10, 5)
        );

        mainPanel.add(averageLabel, BorderLayout.SOUTH);

        add(mainPanel);

        tampilkanKarakter();
    }

    private void tampilkanKarakter() {

        characterPanel.removeAll();

        ArrayList<Character> characterList =
                characterManager.getAllCharacters();

        for (Character character : characterList) {

            JLabel characterLabel = new JLabel(
                    character.getName()
                    + " | Tipe: " + character.getType()
                    + " | Level: " + character.getLevel()
                    + " | HP: " + character.getHitPoints()
            );

            characterLabel.setFont(
                    new Font("Arial", Font.BOLD, 14)
            );

            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(8, 10, 8, 10)
            );

            characterPanel.add(characterLabel);
        }

        // Mengambil rata-rata dari Model
        double average = characterManager.getAverageLevel();

        averageLabel.setText(
                String.format(
                        Locale.US,
                        "Rata-rata Level: %.1f",
                        average
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }
}