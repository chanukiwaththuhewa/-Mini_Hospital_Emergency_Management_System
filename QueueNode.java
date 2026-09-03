public class QueueNode {
    Patient patient;       // The patient's data
    QueueNode next;        // The next person in line

    public QueueNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}