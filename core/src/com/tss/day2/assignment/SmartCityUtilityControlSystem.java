package com.tss.day2.assignment;

import java.util.Scanner;

public class SmartCityUtilityControlSystem {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            int user_choice = mainMenu();
            switch (user_choice) {
                case 1:
                    electricityService();
                    // mainMenu();
                    break;

                case 2:
                    waterService();
                    // mainMenu();
                    break;

                case 3:
                    internetService();
                    // mainMenu();
                    break;

                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }


    }

    private static int mainMenu() {
        System.out.println("Enter the type of service:\n1. Electricity Service\n2. Water Service\n3. Internet Service\n4. Exit\n\nEnter choice:");
        return scanner.nextInt();
    }

    private static void electricityService() {

        System.out.println("Select the type of connection:\n1. Domestic Connection\n2. Commercial Connection\n3. Industrial Connection\n4. Back\n\nEnter choice:");
        int sub_choice = scanner.nextInt();

        switch (sub_choice) {
            case 1: {
                domesticElectricityService();
                break;
            }
            case 2: {
                commercialElectricityService();
                break;
            }
            case 3: {
                industrialElectricityService();
                break;
            }

            case 4: {
                // mainMenu();
                return;
            }
            default:
                System.out.println("Invalid choice");
                break;

        }
        electricityService();
    }

    private static double inputUnitsConsumed() {
        System.out.println("Enter the units consumed");
        double units_consumed = scanner.nextDouble();
        if (units_consumed < 0) {
            System.out.println("Enter valid units");
            inputUnitsConsumed();
        }
        return units_consumed;
    }

    private static void domesticElectricityService() {
        double energy_charge = 0, extra_charge = 0, rebate_amount = 0, units_consumed = 0;
        String connection_type = "Domestic Connection";
        final double domestic_fixed_charge = 50;

        units_consumed = inputUnitsConsumed();

        if (units_consumed <= 100) {
            energy_charge = units_consumed * 2;
        } else if (units_consumed <= 300) {
            energy_charge = (100 * 2) + ((units_consumed - 100) * 3);
        } else {
            energy_charge += (100 * 2) + (200 * 3) + ((units_consumed - 300) * 5);
        }

        if (energy_charge > 2000) {
            extra_charge = energy_charge * 0.10;
        }
        displayElectricityBill(connection_type, units_consumed, energy_charge, domestic_fixed_charge, extra_charge, rebate_amount);

    }

    private static void commercialElectricityService() {
        double energy_charge = 0, extra_charge = 0, rebate_amount = 0, units_consumed = 0;
        String connection_type = "Commercial Connection";
        final double commercial_fixed_charge = 150;

        units_consumed = inputUnitsConsumed();


        if (units_consumed <= 200) {
            energy_charge = units_consumed * 5;
        } else if (units_consumed <= 500) {
            energy_charge = (200 * 5) + ((units_consumed - 200) * 7);
        } else {
            energy_charge = (200 * 5) + (300 * 7) + ((units_consumed - 500) * 10);
        }
        displayElectricityBill(connection_type, units_consumed, energy_charge, commercial_fixed_charge, extra_charge, rebate_amount);
    }

    private static void industrialElectricityService() {
        double energy_charge = 0, extra_charge = 0, rebate_amount = 0, units_consumed = 0;
        String connection_type = "Industrial Connection";
        final double industrial_fixed_charge = 500;

        units_consumed = inputUnitsConsumed();

        energy_charge = units_consumed * 12;
        if (units_consumed > 1000) {
            rebate_amount = energy_charge * 0.15;
        }
        displayElectricityBill(connection_type, units_consumed, energy_charge, industrial_fixed_charge, extra_charge, rebate_amount);
    }

    private static void displayElectricityBill(String connection_type, double units_consumed, double energy_charge, double fix_charge, double extra_charge, double rebate_amount) {
        double total_bill = energy_charge + fix_charge + extra_charge - rebate_amount;
        System.out.println("Connection Type: " + connection_type + "\nUnits Consumed: " + units_consumed + "\nEnergy Charge: " + energy_charge + "\nFixed Charge: " + fix_charge + "\nExtra Charge: " + extra_charge + "\nRebate: " + rebate_amount + "\nTotal Bill: " + total_bill);

    }

    private static void waterService() {
        System.out.println("Enter type of water usage:\n1. Residential\n2. Society\n3. Factory\n4. Back\n\nEnter choice:");
        int sub_choice = scanner.nextInt();


        switch (sub_choice) {
            case 1: {
                residentialWaterService();
                break;
            }
            case 2: {
                societyWaterService();
                break;
            }
            case 3: {
                industryWaterService();
                break;
            }
            case 4: {
                // mainMenu();
                return;
            }
            default:
                System.out.println("Invalid choice");
                break;
        }

        waterService();
    }

    private static void residentialWaterService() {
        double total_bill = 0;
        String usage = "";
        int per_person_charge = 30;
        System.out.println("Enter the number of persons");
        int persons = scanner.nextInt();
        total_bill = persons * per_person_charge;

        usage = "Residential";
        if (total_bill > 3000) {
            total_bill *= 1.08;
        }
        System.out.println("Usage Type: " + usage + "\nFix Charge per entity: " + per_person_charge + "\nTotal Water Bill: " + total_bill);

    }

    private static void societyWaterService() {
        double total_bill = 0;
        String usage = "";
        int per_tap_charge = 25;

        System.out.println("Enter the number of taps");
        int taps = scanner.nextInt();
        total_bill = taps * per_tap_charge;

        usage = "Society";

        if (total_bill > 3000) {
            total_bill *= 1.08;
        }

        System.out.println("Usage Type: " + usage + "\nFix Charge per entity: " + per_tap_charge + "\nTotal Water Bill: " + total_bill);

    }

    private static void industryWaterService() {

        double total_bill = 0;
        String usage = "";
        int per_machine_charge = 100;

        System.out.println("Enter the number of machines");
        int machines = scanner.nextInt();
        total_bill = machines * per_machine_charge;

        usage = "Industrial";

        if (total_bill > 3000) {
            total_bill *= 1.08;
        }

        System.out.println("Usage Type: " + usage + "\nFix Charge per entity: " + per_machine_charge + "\nTotal Water Bill: " + total_bill);

    }

    private static void internetService() {
        while (true) {
            System.out.println("Enter the type of plan:\n1. Student Plan\n2. Home Plan\n3. Business Plan\n4. Back\n\nEnter choice:");
            int sub_choice = scanner.nextInt();

            switch (sub_choice) {
                case 1: {
                    internetStudentPlan();
                    break;
                }
                case 2: {
                    internetHomePlan();
                    break;
                }
                case 3: {
                    internetBusinessPlan();
                }
                case 4: {
                    // mainMenu();
                    return;
                }
                default:
                    System.out.println("Invalid choice");
                    continue;
            }
        }
    }

    private static void internetStudentPlan() {
        double total_bill = 0;
        int duration = 0;
        String plan = "Student";
        while (true) {
            System.out.println("Enter the number of duration:\n1. 1 Month\n2. 3 Months\n3. 6 Months\n\nEnter choice:");
            int plan_duration = scanner.nextInt();

            switch (plan_duration) {
                case 1:
                    total_bill = 299;
                    duration = 1;
                    break;
                case 2:
                    total_bill = 799;
                    duration = 3;
                    break;
                case 3:
                    total_bill = 1499 * 0.95;
                    duration = 6;
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }
            break;
        }
        System.out.println("Plan: " + plan + "\nDuration: " + duration + "\nTotal Bill: " + total_bill);

    }

    private static void internetHomePlan() {
        double total_bill = 0;
        int duration = 0;
        String plan = "Home";


        while (true) {
            System.out.println("Enter the number of duration:\n1. 1 Month\n2. 3 Months\n3. 6 Months\n\nEnter choice:");
            int plan_duration = scanner.nextInt();
            switch (plan_duration) {
                case 1:
                    total_bill = 499;
                    duration = 1;
                    break;
                case 2:
                    total_bill = 1399;
                    duration = 3;
                    break;
                case 3:
                    total_bill = 2699 * 0.95;
                    duration = 6;
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }
            break;
        }
        System.out.println("Plan: " + plan + "\nDuration: " + duration + "\nTotal Bill: " + total_bill);

    }

    private static void internetBusinessPlan() {
        double total_bill = 0;
        int duration = 0;
        String plan = "Business";

        while (true) {
            System.out.println("Enter the number of duration:\n1. 1 Month\n2. 3 Months\n3. 6 Months\n\nEnter choice:");
            int plan_duration = scanner.nextInt();

            switch (plan_duration) {
                case 1:
                    total_bill = 999;
                    duration = 1;
                    break;
                case 2:
                    total_bill = 2799;
                    duration = 3;
                    break;
                case 3:
                    total_bill = 5499 * 0.95;
                    duration = 6;
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }
            break;
        }

        System.out.println("Plan: " + plan + "\nDuration: " + duration + "\nTotal Bill: " + total_bill);
    }

}