package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String passWord;
    private int passWordLength;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private String alternateEmail;
    private String schoolSuffix = "ubc.alumni.ca";

    //Constructor to receive first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println(("Email has been created. \n"));

        //set the department using the private function setDepartment()
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        System.out.println("Enter the length of your password between 10 - 15:");
        while(true) {
            Scanner in = new Scanner(System.in);
            this.passWordLength = in.nextInt();
            if(this.passWordLength < 10 || this.passWordLength > 15) {
                System.out.println("Please enter another length. ");
            }
            else {
                break;
            }
        }

        int result;

        while(true) {
            System.out.println("Enter 0 for a random password or 1 to strengthen your current password:");
            Scanner in = new Scanner(System.in);
            result = in.nextInt();
            if(result == 0 || result == 1) {
                break;
            }
        }

        if(result == 0) {
            //call method that returns a random password
            this.passWord = randomPassword(this.passWordLength);
            System.out.println("Your password is: " + this.passWord);
        }

        else if(result == 1) {
            System.out.println("Please enter a password: ");
            Scanner in = new Scanner(System.in);
            String password = in.nextLine();
            while (password.length() != this.passWordLength) {
                System.out.println("Please enter a password of length: " + this.passWordLength);
                in = new Scanner(System.in);
                password = in.nextLine();
            }
            //call method that returns a stronger password
            this.passWord = strongPassword(password);
            System.out.println("Your password is: " + this.passWord);
        }

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + schoolSuffix;
        System.out.println("Your email is: " + email);


    }

    //Ask for department
    private String setDepartment() {
        System.out.println("Enter the faculty: ");
        while (true) {
            Scanner in = new Scanner(System.in);
            String inputString = in.nextLine();
            if (inputString.equals("Engineering") || inputString.equals("engineering")) {
                return "Engineering";
            }
            if (inputString.equals("Business") || inputString.equals("business")) {
                return "Business";
            }
            if (inputString.equals("Arts") || inputString.equals("arts")) {
                return "Arts";
            }
            if (inputString.equals("Science") || inputString.equals("science")) {
                return "Science";
            }
            System.out.println("Please try again: ");
        }

    }


    //Generate random password
    private String randomPassword(int length) {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUV";
        String numbers = "1234576890";
        String symbols = "!@#$%&";

        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * (4));

            if(rand == 0) {
                int rand2 = (int) (Math.random() * lowerCase.length());
                password[i] = lowerCase.charAt(rand2);
            }
            else if (rand == 1) {
                int rand2 =(int) (Math.random() * upperCase.length());
                password[i] = upperCase.charAt(rand2);
            }

            else if (rand == 2) {
                int rand2 = (int) (Math.random() * numbers.length());
                password[i] = numbers.charAt(rand2);
            }

            else if (rand == 3) {
                int rand2 = (int) (Math.random() * symbols.length());
                password[i] = symbols.charAt(rand2);
            }



        }
        return new String(password);
    }

    //Strengthen the password
    private String strongPassword(String password) {

        char[] retpassword = new char[this.passWordLength];

        for(int i = 0; i < password.length(); i++) {
            if(password.charAt(i) == 'o' || password.charAt(i) == 'O') {
                retpassword[i] = '0';
            }
            else if(password.charAt(i) == 'e' || password.charAt(i) == 'E') {
                retpassword[i] = '3';
            }
            else if(password.charAt(i) == 's' || password.charAt(i) == 'S') {
                retpassword[i] = '$';
            }
            else if(password.charAt(i) == 'l' || password.charAt(i) == 'L') {
                retpassword[i] = '1';
            }
            else if(password.charAt(i) == 'b' || password.charAt(i) == 'B') {
                retpassword[i] = '8';
            }
            else {
                retpassword[i] = password.charAt(i);
            }

        }
        return new String(retpassword);
    }


    //set mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    //set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //change password
    public  void changePassword(String password) {
        this.passWord = password;
    }

    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return passWord;
    }

}
