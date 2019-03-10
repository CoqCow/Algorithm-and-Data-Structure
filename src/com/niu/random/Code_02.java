package com.niu.random;

import java.util.Scanner;

public class Code_02 {
    public static class Node {
        public int a;
        public int b;
        public int c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Node[] nodes=new Node[n+1];
        int num=0;
        for(int i=1;i<=n;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            nodes[i]=new Node(a,b,c);
        }
        for(int i=1;i<=n;i++){
            if(isBug(nodes,i)){
                num++;
            }
        }
        System.out.println(num);
    }
   public static boolean isBug(Node[] nodes,int i){
        for(int j=1;j<nodes.length;j++){
            if(j==i) continue;
            if(nodes[i].a<nodes[j].a&&nodes[i].b<nodes[j].b&&nodes[i].c<nodes[j].c){
                return true;
            }
        }
        return false;
    }
}
