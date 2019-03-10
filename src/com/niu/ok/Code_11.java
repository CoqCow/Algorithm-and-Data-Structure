package com.niu.ok;

import java.util.Scanner;

public class Code_11 {
    public static class Node {
        public int money;
        public String name;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        Node[] nodes = new Node[strings.length];
        for (int i = 0; i < nodes.length; i++) {
            s = scanner.nextLine();
            strings = s.split(" ");
            Node node = new Node();
            node.money = Integer.parseInt(strings[1]);
            node.name = strings[0];
            nodes[i] = node;
        }
        int sum = 0;
        for (int i = 0; i < nodes.length; i++) {
            sum += nodes[i].money;
        }
        int arg = (int) Math.floor(sum / nodes.length);
        //System.out.println(arg);
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].money -= arg;
        }
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i].money>=0) continue;
            for(int j=0;j<nodes.length;j++){
                if(i==j) continue;
                if(nodes[i].money+nodes[j].money>=0&&nodes[i].money!=0){
                    System.out.println(nodes[i].name+" "+nodes[j].name+" "+(-nodes[i].money));
                    nodes[i].money=0;
                    nodes[j].money=nodes[i].money+nodes[j].money;
                }
            }
        }
    }
}
