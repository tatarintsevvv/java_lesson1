package ru.geekbrains;

class Vertex {
    private String label;

    private boolean isVisited;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void display() {
        System.out.println(label);
    }
}

public class Graph {
    final private int MAX_SIZE;
    private int size;
    private Vertex[] vertexis;
    private int[][] arr;

    public Graph(int maxSize) {
        MAX_SIZE = maxSize;
        size = 0;
        vertexis = new Vertex[MAX_SIZE];
        arr = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }
    }

    public void add(Vertex vertex) {
        vertexis[size++] = vertex;
    }

    public void addEdge(int start, int end) {
        arr[start][end] = 1;
        arr[end][start] = 1;
    }

    private int getNearestUnvisitedVertex(int num) {
        for (int i = 0; i < vertexis.length; i++) {
            if(arr[num][i] == 1 && !vertexis[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }
    
    // метод обхода в глубину рекурсией
    public void DFS(int num) {
        vertexis[num].setVisited(true);

        //for (int i = 0; i < vertexis.length; i++) {
        int v = -1;
        do {
            v = getNearestUnvisitedVertex(num);
            if(v != -1 && !vertexis[v].isVisited()) {
                fullDisplayVertex(num, v);
                DFS(v);
            }
        } while(v != -1);

    }

    public void BDFS(int num) {
        int[] queue = new int[size];
        int head = 0;
        int tail = 0;

        vertexis[0].setVisited(true);
        queue[tail++] = num;

        int v2;
        while(head < tail) {
            num = queue[tail++];

            for (int i = 0; i < size; i++) {
                v2 = getNearestUnvisitedVertex(num);
                if(!vertexis[i].isVisited() && v2 != -1) {
                    vertexis[i].setVisited(true);
                    vertexis[i].display();
                    queue[tail++] = i;
                }
            }
        }


        for (int i = 0; i < vertexis.length; i++) {
            vertexis[i].setVisited(false);
        }
    }

    public void refreshVertixes() {
        for (int i = 0; i < vertexis.length; i++) {
            vertexis[i].setVisited(false);
        }
    }

    public void fullDisplayVertex(int first, int second) {
        System.out.println("вершины " + vertexis[first].getLabel() + " - " + vertexis[second].getLabel());
    }
}
