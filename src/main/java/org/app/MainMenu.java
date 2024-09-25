package org.app;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public static void runMainMenu(){

        JFrame frame = new JFrame("Main menu");
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextField speedField = new JTextField("Начальная скорость",12);
        speedField.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JTextField angleField = new JTextField("Угол полета",12);
        angleField.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton button = new JButton("Рассчитать");
        button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        button.addActionListener(e -> {
            Graph graph = new Graph(
                    Double.parseDouble(speedField.getText()),
                    Double.parseDouble(angleField.getText())
            );
            graph.drawGraph();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel.add(speedField);
        panel.add(angleField);
        panel.add(button);

        frame.add(panel);

        frame.setVisible(true);
    }
}
