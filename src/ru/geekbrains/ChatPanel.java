package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class ChatPanel extends JPanel {
    private LinkedList<String> posts;

    public ChatPanel() {
        super();
        posts = new LinkedList<>();
    }

    public void addString(String str) {
        posts.addLast(str);
    }

    private void doDrawing(Graphics g) {

        var g2d = (Graphics2D) g;
        Dimension sizeOriginal = this.getSize();
        g2d.setColor(Color.blue);

        Iterator iterator = posts.iterator();
        int i = 0;
        int height = 0;
        int width = sizeOriginal.width;
        while(iterator.hasNext()) {
            String str = iterator.next().toString();
            g2d.drawString(str, 5, 12 + i * 20);
            i++;
            height = 12 + (i +1) * 20;
            FontMetrics fm = g2d.getFontMetrics();
            width = Math.max(fm.stringWidth(str), width);
        }
        if((height > sizeOriginal.height) || (width > sizeOriginal.width)) {
            sizeOriginal.height = Math.max(height, sizeOriginal.height);
            sizeOriginal.width = Math.max(width, sizeOriginal.width);
            this.setSize(sizeOriginal);
            this.setPreferredSize(sizeOriginal);
            this.revalidate();
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

}
