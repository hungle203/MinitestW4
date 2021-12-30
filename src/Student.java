public class Student extends Human {
    private double mathScores;
    private double pointOfReason;
    private double pointChemistry;

    public Student(double mathScores, double pointOfReason, double pointChemistry) {
        this.mathScores = mathScores;
        this.pointOfReason = pointOfReason;
        this.pointChemistry = pointChemistry;
    }

    public Student(String name, int age, double mathScores, double pointOfReason, double pointChemistry) {
        super(name, age);
        this.mathScores = mathScores;
        this.pointOfReason = pointOfReason;
        this.pointChemistry = pointChemistry;
    }

    public double getMathScores() {
        return mathScores;
    }

    public void setMathScores(double mathScores) {
        this.mathScores = mathScores;
    }

    public double getPointOfReason() {
        return pointOfReason;
    }

    public void setPointOfReason(double pointOfReason) {
        this.pointOfReason = pointOfReason;
    }

    public double getPointChemistry() {
        return pointChemistry;
    }

    public void setPointChemistry(double pointChemistry) {
        this.pointChemistry = pointChemistry;
    }

    public double avg() {
        return (mathScores + pointOfReason + pointChemistry) / 3;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "mathScores=" + mathScores +
                ", pointOfReason=" + pointOfReason +
                ", pointChemistry=" + pointChemistry +
                '}';
    }
}
