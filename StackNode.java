public class StackNode {
    TreatmentRecord record;
    StackNode next; // The node right below this one

    public StackNode(TreatmentRecord record) {
        this.record = record;
        this.next = null;
    }
}