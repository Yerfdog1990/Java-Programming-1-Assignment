public interface Administrator {
  void addStudent(String studentName, int studentId, int studentAge, String studentGrade);

  void updateStudentInfo(String studentName, int studentId, int studentAge, String studentGrade);

  Student getStudentID(int studentId);

  void displayStudentInfo();
}
