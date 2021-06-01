package java_concepts;

public class MaxHeap {
    public int[] heap = new int[16];
    public int size=0;


    public int getParent(int pos) {
        return pos/2;
    }

    public int getLeftNode(int pos) {
        return 2*pos;
    }

    public int getRightNode(int pos) {
        return 2*pos+1;
    }

    public void insert(int value) {
        heap[0] = Integer.MAX_VALUE;
        heap[++size] = value;
        int current = size;
        while(heap[current] > heap[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public void maxHeapify(int value) {
        if(isLeaf(value)) {
            return;
        }
        while(heap[value] < heap[getLeftNode(value)] || heap[value] < heap[getRightNode(value)]) {
            if(heap[getLeftNode(value)] > heap[getRightNode(value)]) {
                swap(value, getLeftNode(value));
                maxHeapify(getLeftNode(value));
            } else {
                swap(value, getRightNode(value));
                maxHeapify(getRightNode(value));
            }
        }
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int from, int to) {
        int temp = heap[from];
        heap[from] = heap[to];
        heap[to] = temp;
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i]
                            + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Remove an element from max heap
    public int extractMax()
    {
        int popped = heap[1];
        heap[1] = heap[size--];
        maxHeapify(1);
        return popped;
    }

    public static void main(String[] arg)
    {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is "
                + maxHeap.extractMax());
    }
}

