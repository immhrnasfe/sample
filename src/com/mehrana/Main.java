package com.mehrana;

import com.mehrana.entity.Leave;
import com.mehrana.entity.Personnel;
import com.mehrana.service.LeaveService;
import com.mehrana.service.PersonnelService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PersonnelService personnelService = new PersonnelService();
        LeaveService leaveService = new LeaveService();


        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Personnel personnel = new Personnel();

                    System.out.println("Enter name:");
                    personnel.setUserName(scanner.next());

                    System.out.println("Enter nationalCode:");
                    personnel.setNationalCode(scanner.next());

                    System.out.println("Enter phone number:");
                    personnel.setPhoneNumber(scanner.next());

                    System.out.println("Enter email:");
                    personnel.setEmail(scanner.next());

                    personnelService.save(personnel);
                    System.out.println("Added successfully.");
                    break;
                case 2:
                    System.out.println(" list personal: ");
                    personnelService.getAllPersonnel();
                    break;
                case 3:
                    System.out.println("Enter nationalCode : ");
                    String nationalCode = scanner.nextLine();

                    Personnel foundpersonnel = personnelService.getNationalCode(nationalCode);
                    if (foundpersonnel != null) {
                        Leave leave = new Leave();
                        System.out.println("Enter start date (YYYY-MM-DD): ");
                        leave.setStartDate(String.valueOf(LocalDate.parse(scanner.nextLine())));

                        System.out.println("Enter end date (YYYY-MM-DD): ");
                        leave.setEndDate(String.valueOf(LocalDate.parse(scanner.nextLine())));
                        leaveService.saveLeave(leave, foundpersonnel);
                    }
                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Exiting program: ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again ...");
                    break;
            }

        }
    }

    public static void showMenu() {
        System.out.println("""
                1. add personnel:
                 2. list personnel:
                 3. add leave:
                 4. show leave:
                 5. Exit:""");


    }


//    private static Scanner scanner;
//    private static PersonalController personalController = new PersonalController();
//    private static HolidayController holidayController = new HolidayController();
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//
//        while (true) {
//            showMenu();
//
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.println("Enter your username:");
//                    String username = scanner.next();
//                    System.out.println("Enter your nationalCode :");
//                    String nationalCode = scanner.next();
//                    System.out.println("Enter your email");
//                    String email = scanner.next();
//                    System.out.println("Enter your holiday");
//                    String holiday = scanner.next();
//                    Personal personal = new Personal();
//                    Long id = null;
//                    personal.setId(id);
//                    personal.setUsername(username);
//                    personal.setNationalCode(nationalCode);
//                    personal.setEmail(email);
//
//                    personalController.save(personal);
//                    holidayController.addHoliday(scanner, personal);
//                    System.out.println("Personal information saved successfully.");
//
//                    break;
//                case 2:
//                    List<Personal> personalList = personalController.findAll();
//                    if (personalList.isEmpty()) {
//                        System.out.println("No personal information found.");
//                    } else {
//                        System.out.println("Personal Information List:");
//                        for (Personal info : personalList) {
//                            System.out.println(info);
//                        }
//                    }
//                    break;
//                case 3:
//                    System.out.println("Enter the ID :");
//                    int idToUpdate = scanner.nextInt();
//                    scanner.nextLine();
//
//                    List<Personal> allPersonal = personalController.findAll();
//                    Personal updatePersonal = null;
//                    for (Personal p : allPersonal) {
//                        if (p.getId() == idToUpdate) {
//                            updatePersonal = p;
//                            break;
//                        }
//                    }
//                    if (updatePersonal == null) {
//                        System.out.println("Personal information not found.");
//                    } else {
//                        System.out.println("Enter new username " + updatePersonal.getUsername());
//                        updatePersonal.setUsername(scanner.nextLine());
//                        System.out.println("Enter new nationalCode "+ updatePersonal.getNationalCode() );
//                        updatePersonal.setNationalCode(scanner.nextLine());
//                        System.out.println("Enter new email" + updatePersonal.getEmail());
//                        updatePersonal.setEmail(scanner.nextLine());
//
//                        boolean updated = personalController.update(updatePersonal);
//                        if (updated) {
//                            System.out.println("Personal information updated successfully.");
//                        } else {
//                            System.out.println("Failed to update personal information.");
//                        }
//                    }
//                    break;
//                case 4:
//                    System.out.println("Enter the ID :");
//                    Long idToDelete = scanner.nextLong();
//                    if (false) {
//                        System.out.println("Personal not found.");
//                    } else {
//                        personalController.delete(idToDelete);
//                        System.out.println("Personal deleted successfully.");
//                    }
//                    break;
//                case 5:
//                    System.out.println("Enter the ID :");
//                    Long findById = scanner.nextLong();
//                    Personal personal1 = personalController.findById(findById);
//                    if (personal1 != null) {
//                        System.out.println("Personal found successfully.");
//                    }
//                    break;
//                case 6:
//                    System.out.println("Exiting program.");
//            }
//        }
//
//
//    }
//
//    public static void showMenu() {
//        System.out.println("1.add personal " +
//                "\n2.list personal" +
//                "\n3.update personal" +
//                "\n4.delete personal" +
//                "\n5.Find Personal by ID" +
//                "\n6.Exit");
//
//
//    }


    //    static ArrayList<Personal> personalList = new ArrayList<>();
    //    static ArrayList<Holiday> holidayArrayList = new ArrayList<>();
    //
    //
    //    public static void main(String[] args) {
    //
    //        PersonalController personalController = new PersonalController();
    //        Scanner scanner = new Scanner(System.in);
    //
    //        while (true) {
    //            showMenu();
    //            create(scanner, personalController);
    //        }
    //    }
    //
    //    public static void create(Scanner scanner, PersonalController personalController) {
    //     while (true) {
    //            int chooseNumber = scanner.nextInt();
    //            Personal information = null;
    //            switch (chooseNumber) {
    //                case 1:
    ////                    System.out.println("you select personal information");
    ////                    information = PersonalService.addPersonal(scanner);
    ////                    if (information != null) {
    ////                        personalList.add(information);
    ////                        System.out.println("personal added successfully");
    ////                    } else {
    ////                        System.out.println("personal not added");
    ////                    }
    ////                    break;
    //                    Personal personal = new Personal();
    //                    System.out.print("Enter your firstName: ");
    //                    personal.setFirstName(scanner.nextLine());
    //                    scanner.nextLine();
    //
    //                    System.out.print("Enter your lastName: ");
    //                    personal.setLastName(scanner.nextLine());
    //
    //                    System.out.print("Enter your Email: ");
    //                    personal.setEmail(scanner.nextLine());
    //
    //                    System.out.print("Enter your nationalCode: ");
    //                    personal.setNationalCode(scanner.nextLine());
    //                    scanner.nextLine();
    //
    //                    personalController.save(personal);
    //                    break;
    //
    //                case 2:
    //
    //                    break;
    //                case 3:
    //                    System.out.println("you select holiday ");
    //                    Holiday.addHoliday(scanner);
    //                    if (!(information != null)) {
    //                        System.out.println("No personal information available to associate with the holiday.");
    //                    } else {
    ////                        holidayArrayList.add(holiday);
    //                        System.out.println("Processing holiday for: " + information.getClass().getSimpleName() );
    //                    }
    //                    break;
    //
    //                case 4:
    //                    System.out.println("you select confirm holiday ");
    //                    break;
    //                case 5:
    //                    System.out.println("back to the main menu");
    //
    //                    return;
    //                default:
    //            }
    //        }
    //
    //    }


}
