import java.util.*;

public class StudentManagement implements Administrator {
  private static List<Student> studentList = new ArrayList<>();
  public static int totalPopulation = 0;

  @Override
  public void addStudent(String studentName, int studentId, int studentAge, String studentGrade) {
    studentList.add(new Student(studentName, studentId, studentAge, studentGrade));
    totalPopulation++;
  }

  @Override
  public Student getStudentID(int studentId) {
    for (Student student : studentList) {
      if (student.getStudentId() == studentId) {
        return student;
      }
    }
    System.out.println("Student not found");
    return null;
  }

  @Override
  public void updateStudentInfo(
      String studentName, int studentId, int studentAge, String studentGrade) {
    Student student = getStudentID(studentId);
    if (student != null) {
      student.setName(studentName);
      student.setStudentAge(studentAge);
      student.setStudentGrade(studentGrade);
      System.out.println("Student information updated successfully!");
    }
  }

  @Override
  public void displayStudentInfo() {
    System.out.println("StudentID\tName\tAge\tGrade");
    for (Student student : studentList) {
      System.out.println(
          student.getStudentId()
              + "\t"
              + student.getStudentName()
              + "\t"
              + student.getStudentAge()
              + "\t"
              + student.getStudentGrade());
    }
    System.out.println("Total population: " + totalPopulation);
  }

  // Method to validate name
  public static String validateStringInput(Scanner userInput1, String promptMessage1) {
    String validName = "";
    while (true) {
      try {
        System.out.print(promptMessage1);
        validName = userInput1.nextLine();
        if (validName.matches("[a-zA-Z ]+")) {
          break;
        } else {
          System.out.println("Invalid input. Please enter a valid name.");
        }
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter a valid name.");
        break;
      }
    }
    return validName;
  }

  // Method to validate integer input for studentID, studentAge
  public static int validateIntegerInput(Scanner userInput2, String promptMessage2) {
    int validInteger;
    while (true) {
      try {
        System.out.print(promptMessage2);
        validInteger = Integer.parseInt(userInput2.nextLine());
        if (validInteger >= 0) { // Ensure it is non-negative
          break;
        } else {
          System.out.println("Invalid input. Please enter a positive integer.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid integer.");
      }
    }
    return validInteger;
  }

  // Method to validate character input for grade
  public static String validateGradeInput(Scanner userInput3, String promptMessage3) {
    Set<String> validGrade = new HashSet<>();
    validGrade.add("A*");
    validGrade.add("A");
    validGrade.add("B");
    validGrade.add("C");
    validGrade.add("D");
    validGrade.add("F");
    validGrade.add("G");
    validGrade.add("U");

    String grade;
    while (true) {
      try {
        System.out.print(promptMessage3);
        grade = userInput3.nextLine().toUpperCase();
        if (validGrade.contains(grade)) {
          break;
        } else {
          System.out.println("Invalid input. Please enter a valid grade.");
        }
      } catch (Exception e) {
        System.out.println("Invalid input occurred. Please try again.");
      }
    }
    return grade;
  }
}
