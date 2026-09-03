public class main {
    public static void main(String[] args) {
        EmergencyQueue queue = new EmergencyQueue();

        Patient p1 = new Patient(1, "Alice", 25, "1234", "Fever");
        Patient p2 = new Patient(2, "Bob", 30, "5678", "Broken Arm");

        // Add them to the queue
        queue.enqueue(p1);
        queue.enqueue(p2);

        // Show who is in line (Alice, then Bob)
        queue.displayQueue();

        // Call the first patient (Alice gets called first because she arrived first)
        Patient called = queue.dequeue();
        System.out.println("Doctor is now seeing: " + called.getName());

        // Check who is left (Only Bob remains)
        queue.displayQueue();
    }
}