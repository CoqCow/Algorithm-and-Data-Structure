package com.niu.tree;

public class Code_06_SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merge<E> merge;

    public Code_06_SegmentTree(E[] arr, Merge<E> merge) {
        data = (E[]) new Object[arr.length];
        this.merge = merge;
        for (int i = 0; i < data.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        int mid = left + (right - left) / 2;
        buildSegmentTree(leftIndex, left, mid);
        buildSegmentTree(rightIndex, mid + 1, right);
        tree[treeIndex] = merge.merge(tree[leftIndex], tree[rightIndex]);
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
