package Week1;

import java.util.Scanner;

public class GamifiedQuiz {
    public static void main(String[] args) {
        try (Scanner quiz = new Scanner(System.in)) {
            System.out.println("Welcome to the Gamified Quiz!");
            System.out.print("What is your name? ");
            String name = quiz.nextLine();

            String[] questions = {
                    "What language does the CPU understand?",
                    "What is an assembly language?",
                    "What is an assembler?",
                    "What is a high-level programming language?",
                    "What is a source program?",
                    "What is an interpreter?",
                    "What is a compiler?",
                    "What is the difference between an interpreted language and a compiled language?"
            };
            String[] choice = {
                    "A. Machine language\nB. Assembly language\nC. High-level language\nD. Source code",
                    "A. A programming language that uses binary code\nB. A programming language that uses mnemonics to represent machine instructions\nC. A platform-independent language similar to English\nD. A tool used to convert high-level code into machine code",
                    "A. A program that converts high-level language into assembly code\nB. A program that translates assembly language into machine code\nC. A program that interprets machine code into human-readable text\nD. A tool used to execute high-level code directly",
                    "A. A language that uses binary instructions for the CPU\nB. A language that uses mnemonics for programming\nC. A language that is platform-independent and English-like\nD. A language that is machine-dependent and complex",
                    "A. A program written in machine language\nB. A program written in assembly language\nC. A program written in a high-level programming language\nD. A program written directly for execution on hardware",
                    "A. A program that translates and executes code line-by-line\nB. A program that converts high-level code into assembly code\nC. A program that compiles the entire source code into machine code\nD. A program that translates assembly into high-level code",
                    "A. A program that converts assembly code into high-level language\nB. A program that translates the entire source code into machine code before execution\nC. A program that executes source code without translation\nD. A tool used to debug source programs",
                    "A. An interpreted language is converted to binary, while a compiled language is not\nB. An interpreted language executes line-by-line, while a compiled language translates the whole program before execution\nC. An interpreted language is faster than a compiled language\nD. There is no difference between the two",
            };
            char[] answer = {'A', 'B', 'B', 'C', 'C', 'A', 'B', 'B' };
            int score = 0;
            for (int i = 0; i < questions.length; i++) {
                System.out.println("Question " + (i + 1) + "." + questions[i]);
                System.out.println(choice[i]);
                char userChoice;

                while (true) {
                    System.out.print("Enter your choice (A, B, C, or D): ");
                    String input = quiz.nextLine().trim().toUpperCase();

                    // Check if the input is valid (A, B, C, D)
                    if (input.length() == 1 && "ABCD".contains(input)) {
                        userChoice = input.charAt(0);
                        break; // Exit the loop on valid input
                    } else {
                        System.out.println("Invalid input. Please enter A, B, C, or D.");
                    }
                }
                if(userChoice == answer[i]){
                    score++;
                }
            }
            double percentage = (double) score/questions.length * 100;
            System.out.println("Congratulations " + name+ "! You have scored " +percentage+ "%.");
        }
    }
}
