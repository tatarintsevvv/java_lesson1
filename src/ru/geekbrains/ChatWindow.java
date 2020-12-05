package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Map;

public class ChatWindow extends JFrame {
    public ChatWindow() throws HeadlessException {
        super("Окно чата");
        setBounds(300, 300, 500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Панель содержимого
        Container container = getContentPane();

        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);

        // панель отображения чата
        ChatPanel chat = new ChatPanel();
        JScrollPane scrollPane = new JScrollPane(chat);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        container.add(scrollPane);


        JTextField textInput = new JTextField();
        container.add(textInput);
        JButton submit = new JButton("Отправить");
        submit.addActionListener(e -> {
            String text = textInput.getText();
            if(!text.isEmpty() && !text.isBlank()) {
                chat.addString(text);
                chat.repaint();
            } else {
                JOptionPane.showMessageDialog(
                        container,
                        "Не введен текст",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
            textInput.setText("");
            textInput.requestFocus();
        });
        container.add(submit);

        layout.putConstraint(SpringLayout.SOUTH, submit , -10, SpringLayout.SOUTH,  container);
        layout.putConstraint(SpringLayout.EAST, submit, -10, SpringLayout.EAST, container);
        layout.putConstraint(SpringLayout.NORTH, textInput, 2, SpringLayout.NORTH, submit);
        layout.putConstraint(SpringLayout.EAST, textInput, -10, SpringLayout.WEST, submit);
        layout.putConstraint(SpringLayout.WEST, textInput, 20, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.SOUTH, scrollPane, -5, SpringLayout.NORTH, submit);
        layout.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.EAST, scrollPane, -5, SpringLayout.EAST, container);
        layout.putConstraint(SpringLayout.WEST, scrollPane, 5, SpringLayout.WEST, container);


        setVisible(true);

    }
}
