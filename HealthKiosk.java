import java.util.Scanner;
import java.util.Random;

public class HealthKiosk {
    public static void main(String[] args) {
        System.out.println("Welcome to the Ashesi Health Kiosk! We're here for you!");
        // Task 1
        double roundedBMI = 0;
        char service_code;
        int metric = 0;
        double dosage = 0;
        int intDosage = (int) dosage;
        double BMI = 0;
        int intBmi = (int) BMI;
        double roundedsinangle = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter service code (P/L/T/C):");
        service_code = input.nextLine().charAt(0);

        switch (Character.toUpperCase(service_code)) {
            case 'P':
                System.out.println("Go to Pharmacy");
                
                break;

            case 'L':
               System.out.println("Go to the Lab");
                break;

            case 'T':
                System.out.println("Go to Triage Desk");
                
                System.out.println("Enter the metric 1 for BMI, 2 for Dosage and 3 for simple trig helper:");
                metric = input.nextInt();

                if (metric == 1) {
                    double weight;
                    double height;
                    System.out.println("Enter your weight in kg:");
                    weight = input.nextDouble();
                    input.nextLine();
                    System.out.println("Enter your height in metres:");
                    height = input.nextDouble();
                    input.nextLine();

                    BMI = (weight) / (Math.pow(height, 2));
                     roundedBMI = Math.round(BMI * 10) / 10.0;
                    System.out.println("BMI " + roundedBMI);
                    if (roundedBMI < 18.5) {
                        System.out.println("Category: Underweight");
                    } else if (roundedBMI >= 18.5 && roundedBMI <= 24.9) {
                        System.out.println("Category: Normal");
                    } else if (roundedBMI >= 25.0 && roundedBMI <= 29.9) {
                        System.out.println("Category: Overweight");
                    } else if (roundedBMI >= 30) {
                        System.out.println("Category: Obese");
                    }
                } else if (metric == 2) {
                    
                    System.out.println("Enter your dosage in mg");
                    dosage = input.nextDouble();
                    int numberofTablets = (int) Math.ceil(dosage / 250);
                    System.out.println("Number of tablets needed " + numberofTablets);
                } else if (metric == 3) {
                    double degrees;
                    System.out.println("Enter an angle in degrees");
                    degrees = input.nextInt();
                    double sindegrees = Math.sin(Math.toRadians(degrees));
                    double cosdegrees = Math.cos(Math.toRadians(degrees));

                     roundedsinangle = (Math.round(sindegrees * 1000)) / 1000.0;
                    double roundedcosangle = (Math.round(cosdegrees * 1000)) / 1000.0;
                    System.out.println("Sin of angle " + roundedsinangle);
                    System.out.println("Cos of angle " + roundedcosangle);
                } else {
                    System.out.println("Invalid input");
                }
                break;
               

            case 'C':
                System.out.println("Go to Counselling");
                               
                break;

            default:
                System.out.println("Invalid service code");
                break;
        }
        //task 3
        Random rande = new Random();
                char letter = (char) ('A' + (int) (Math.random() * 26));
                int rande_1 = rande.nextInt(7) + 3;
                int rande_2 = rande.nextInt(7) + 3;
                int rande_3 = rande.nextInt(7) + 3;
                int rande_4 = rande.nextInt(7) + 3;

                String id = String.format("%c%d%d%d%d", letter, rande_1, rande_2, rande_3, rande_4);

                if (id.length() < 5) {
                    System.out.println("Invalid length of ID");
                } else if (!Character.isLetter(id.charAt(0))) {
                    System.out.println("The first letter must be a letter");
                } else if (!(Character.isDigit(id.charAt(1)) && Character.isDigit(id.charAt(2))
                        && Character.isDigit(id.charAt(3)) && Character.isDigit(id.charAt(4)))) {
                    System.out.println("There must be last 4 digits");
                } else {
                    System.out.println("Good ID");
                }
                //Task 4
                System.out.println("Enter your first name:");
                String name = input.nextLine();
                char first_letter = name.toUpperCase().charAt(0);

                char letterShift = (char) ('A' + (first_letter - 'A' + 2) % 26);
                System.out.println("Shifted letter of base code = " + letterShift);

                String last_two_chars = String.format("%c%c", id.charAt(3), id.charAt(4));
                if (metric==1) {
                String code = "" + letterShift + last_two_chars + roundedBMI;
            System.out.println(code);
        } else if (metric==2) {
            String code = "" + letterShift + last_two_chars + intDosage;
            System.out.println(code);
        } else if (metric==3) {
            
            String code = "" + letterShift + last_two_chars + intBmi;
            System.out.println(code);
                //Task 5
              switch (service_code) {
            case 'P':
                System.out.println("PHARMACY" + "|" + "ID=" + id + "|"  + "Code=" + code);
                break;
            case 'L':
                System.out.println("LAB" + "|" + "ID=" + id + "|" + "Code=" + code);
                break;
            case 'T':
                if (metric==1) {
                    System.out.println("TRIAGE" + "|" + "ID=" + id + "|" + "BMI=" + BMI + "|" + "Code=" + code);
                }
                 else if (metric==2) {
                    System.out.println("TRIAGE" + "|" + "ID=" + id + "|" + "dosage:" + BMI + "|" + "Code=" + code);
                } else if (metric==3) {
                    System.out.println(
                            "TRIAGE" + "|" + "ID=" + id + "|" + "Sin of angle=" + roundedsinangle + "|" + "Code=" + code);
                }
                break;
            case 'C':
                System.out.println("COUNCELLING" + "|" + "ID=" + id + "|" + "Code=" + code);
                break;
            default:
                System.out.println("Invalid service code");
        }
                
    }
}}

