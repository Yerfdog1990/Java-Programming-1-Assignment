public class Student {
  private int studentId;
  private String studentName;
  private int studentAge;
  private String studentGrade;

  public Student(String studentName, int studentId, int studentAge, String studentGrade) {
    this.studentId = studentId;
    this.studentName = studentName;
    this.studentAge = studentAge;
    this.studentGrade = studentGrade;
  }

  public int getStudentId() {
    return studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public int getStudentAge() {
    return studentAge;
  }

  public String getStudentGrade() {
    return studentGrade;
  }

  public void setName(String studentName) {
    this.studentName = studentName;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public void setStudentAge(int studentAge) {
    this.studentAge = studentAge;
  }

  public void setStudentGrade(String studentGrade) {
    this.studentGrade = studentGrade;
  }

  @Override
  public String toString() {
    return "Student{"
        + "studentId="
        + studentId
        + ", studentName='"
        + studentName
        + '\''
        + ", studentAge="
        + studentAge
        + ", studentGrade="
        + studentGrade
        + '}';
  }
}
