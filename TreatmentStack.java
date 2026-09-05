public class TreatmentStack {
    private StackNode top; // The item at the very top of the pile

    public TreatmentStack() {
        this.top = null;
    }

    // 1. Push - Add completed record to the top of the stack
    public void push(TreatmentRecord record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top; // New node sits on top of the old top
        top = newNode;      // Top now points to the new node
        System.out.println("Recorded treatment for: " + record.getPatientName());
    }

    // 2. Pop - Remove and return the most recent completed record
    public TreatmentRecord pop() {
        if (top == null) {
            System.out.println("Treatment history is empty! Nothing to pop.");
            return null;
        }
        TreatmentRecord removedRecord = top.record;
        top = top.next; // Move top pointer to the item below
        return removedRecord;
    }

    // 3. Display - Show all records from most recent to oldest
    public void displayRecords() {
        if (top == null) {
            System.out.println("No treatment records to display.");
            return;
        }
        System.out.println("--- Treatment History (Most Recent First) ---");
        StackNode current = top;
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }
}