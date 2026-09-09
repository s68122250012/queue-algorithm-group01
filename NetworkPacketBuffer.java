public class NetworkPacketBuffer {

    public static void main(String[] args) {

        CircularQueueBuffer queue =
                new CircularQueueBuffer(5);

        queue.enqueue(new Packet("P1", 1, 500, 1));
        queue.enqueue(new Packet("P2", 2, 300, 2));
        queue.enqueue(new Packet("P3", 3, 200, 1));

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(new Packet("P4", 4, 600, 3));
        queue.enqueue(new Packet("P5", 5, 400, 2));
        queue.enqueue(new Packet("P6", 6, 700, 1));

        queue.display();

        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());
    }
}