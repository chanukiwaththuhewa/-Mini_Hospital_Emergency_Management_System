public class EmergencyQueue {
    private QueueNode front; // First person in line
    private QueueNode rear;  // Last person in line

    // 1. Add patient to the line
    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        
        if (front == null) { 
            // Line is empty, so this person is both front and back
            front = newNode;
            rear = newNode;
        } else {
            // Line is not empty, attach to the back
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(patient.getName() + " joined the emergency queue.");
    }

    // 2. Call the next patient for treatment
    public Patient dequeue() {
        if (front == null) {
            System.out.println("No patients are waiting!");
            return null;
        }
        
        // Take the front person out
        Patient treatedPatient = front.patient;
        front = front.next; // The next person is now the new front
        
        if (front == null) {
            rear = null; // Line is now completely empty
        }
        
        return treatedPatient;
    }

    // 3. Show everyone in the line
    public void displayQueue() {
        if (front == null) {
            System.out.println("The queue is empty.");
            return;
        }

        System.out.println("--- Patients Waiting ---");
        QueueNode current = front;
        while (current != null) {
            System.out.println("- " + current.patient.getName());
            current = current.next;
        }
    }
}