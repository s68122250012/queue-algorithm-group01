class LinearQueueBuffer {

    private Packet[] buffer;
    private int front;
    private int rear;
    private int capacity;

    public LinearQueueBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new Packet[capacity];
        front = 0;
        rear = -1;
    }

    public boolean enqueue(Packet packet) {

        if (rear == capacity - 1) {
            System.out.println(packet + " Dropped (Buffer Full)");
            return false;
        }

        buffer[++rear] = packet;
        return true;
    }

    public Packet dequeue() {

        if (front > rear) {
            System.out.println("Queue Empty");
            return null;
        }

        return buffer[front++];
    }

    public void display() {

        if (front > rear) {
            System.out.println("Queue Empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }
}