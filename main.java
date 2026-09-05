public class Main {
    public static void main(String[] args) {
        TreatmentStack history = new TreatmentStack();

        // 1. Push completed treatments onto the stack
        TreatmentRecord rec1 = new TreatmentRecord(101, "Alice", "Administered Paracetamol");
        TreatmentRecord rec2 = new TreatmentRecord(102, "Bob", "Arm X-ray and Cast applied");

        history.push(rec1);
        history.push(rec2);

        // 2. Display records (Bob shows first because he finished last)
        history.displayRecords();

        // 3. Pop the most recent record (Bob gets popped)
        TreatmentRecord popped = history.pop();
        System.out.println("Removed most recent: " + popped.getPatientName());

        // 4. Display again (Only Alice remains)
        history.displayRecords();
    }
}