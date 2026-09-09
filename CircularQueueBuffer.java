class CircularQueueBuffer {

    private Packet[] buffer;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    public CircularQueueBuffer(int capacity) {

        this.capacity = capacity;

        buffer = new Packet[capacity];

        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean enqueue(Packet packet) {

        if (count == capacity) {
            System.out.println(packet + " Dropped (Buffer Full)");
            return false;
        }

        rear = (rear + 1) % capacity;

        buffer[rear] = packet;

        count++;

        return true;
    }

    public Packet dequeue() {

        if (count == 0) {
            System.out.println("Queue Empty");
            return null;
        }

        Packet temp = buffer[front];

        front = (front + 1) % capacity;

        count--;

        return temp;
    }

    public void display() {

        if (count == 0) {
            System.out.println("Queue Empty");
            return;
        }

        int index = front;

        for (int i = 0; i < count; i++) {

            System.out.print(buffer[index] + " ");

            index = (index + 1) % capacity;
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