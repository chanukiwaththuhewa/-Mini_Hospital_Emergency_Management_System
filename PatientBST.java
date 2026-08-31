public class PatientBST {
    private BSTNode root;

    public PatientBST() {
        this.root = null;
    }

    //  Insert Operation
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private BSTNode insertRec(BSTNode current, Patient patient) {
        if (current == null) {
            return new BSTNode(patient);
        }
        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRec(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRec(current.right, patient);
        } else {
            System.out.println("Patient with ID " + patient.getPatientId() + " already exists.");
        }
        return current;
    }

    //  Search Operation
    public Patient search(int patientId) {
        BSTNode result = searchRec(root, patientId);
        return (result != null) ? result.patient : null;
    }

    private BSTNode searchRec(BSTNode current, int patientId) {
        if (current == null || current.patient.getPatientId() == patientId) {
            return current;
        }
        if (patientId < current.patient.getPatientId()) {
            return searchRec(current.left, patientId);
        }
        return searchRec(current.right, patientId);
    }

    //  Delete Operation
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private BSTNode deleteRec(BSTNode current, int patientId) {
        if (current == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return null;
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = deleteRec(current.left, patientId);
        } else if (patientId > current.patient.getPatientId()) {
            current.right = deleteRec(current.right, patientId);
        } else {
            
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            current.patient = findMin(current.right);
            current.right = deleteRec(current.right, current.patient.getPatientId());
        }
        return current;
    }

    private Patient findMin(BSTNode node) {
        BSTNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.patient;
    }

    // In-Order Traversal (Ascending Order of ID)
    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("No patient records found.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.println(current.patient);
            inOrderRec(current.right);
        }
    }
}