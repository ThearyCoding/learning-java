
import java.util.List;
import java.util.Scanner;

public class SubPeople {
    private static int idforCheck;
    static Scanner input = new Scanner(System.in);
    public static void MenuInit() {
        int boxWidth = 100; // 1000 pixels / 10 pixels per character
        String horizontalLine = "═".repeat(boxWidth - 2);
        String emptyLine = " ".repeat(boxWidth - 2);
    
        System.out.println("╔" + horizontalLine + "╗");
        System.out.println("║" + emptyLine + "║");
        System.out.println("║" + centerText("Welcome to People List", boxWidth - 2) + "║");
        System.out.println("║" + emptyLine + "║");
        System.out.println("╠" + horizontalLine + "╣");
        System.out.println("║" + centerText("[1] Show All People", boxWidth - 2) + "║");
        System.out.println("║" + centerText("[2] Add More People", boxWidth - 2) + "║");
        System.out.println("║" + centerText("[3] Remove People", boxWidth - 4) + "  ║");
        System.out.println("║" + centerText("[4] Edit People", boxWidth - 6) + "    ║");
        System.out.println("║" + centerText("[5] Search People", boxWidth - 5) + "   ║");
        System.out.println("║" + centerText("[6] Clear Screen", boxWidth - 6) + "    ║");
        System.out.println("║" + centerText("[0] Exit the program", boxWidth - 2) + "║");
        System.out.println("╚" + horizontalLine + "╝");
    }
    
    public static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        String paddedText = " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
        return paddedText;
    }
    
    
    public static void ShowAllProducts(List<People> people) {
        StringBuilder table = new StringBuilder();
        table.append("+------+--------------+---------------------+-----+----------------------+----------------------+\n");
        table.append("|  ID  |     Name     |        Email        | Age |       Address        |          Phone       |\n");
        table.append("+------+--------------+---------------------+-----+----------------------+----------------------+\n");
    
        for (People p : people) {
            String idStr = String.format("| %4d |", p.getId());
            String nameStr = String.format(" %-13s|", p.getName());
            String emailStr = String.format(" %-19s |", p.getEmail());
            String ageStr = String.format(" %3d |", p.getAge());
            String addressStr = String.format(" %-18s   |", p.getAddress());
            String phoneStr = String.format(" %10d          |\n", p.getPhone());
    
            table.append(idStr).append(nameStr).append(emailStr).append(ageStr).append(addressStr).append(phoneStr);
            table.append("+------+--------------+---------------------+-----+----------------------+----------------------+\n");
        }
    
        // Print the table after the loop is complete
        System.out.println(table.toString());
    }
    
    public static void AddMorePeople(List<People> people) {
        while (true) {
            People p = new People();
            p.input();
            people.add(p);
            System.out.print("Would you like to add more people (y/n) = ");
            String response = input.nextLine();
            
            if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
                continue;
            } else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
                break;
            }
        }
    }
    public static void RemovePeople(List<People> people){
        ShowAllProducts(people);
        System.out.print("Enter ID to Remove People = ");
        idforCheck = input.nextInt();
        for (People p : people){
            if(p.getId() == idforCheck){
                System.out.println("The ID of the person have been removed");
                System.out.println("ID      =  " + p.getId());
                System.out.println("Name    = " + p.getName());
                System.out.println("Email   = " + p.getEmail());
                System.out.println("Age     = " + p.getAge());
                System.out.println("Address = " + p.getAddress());
                System.out.println("Phone   = " + p.getPhone());
                people.remove(p);

                break;
            }else {
                System.out.println("No person found with the specified ID.");
            }
        }
    }

    public static void EditPeople(List<People> peoples){
        ShowAllProducts(peoples);
        System.out.print("Enter ID of the People to Update = ");
        idforCheck = input.nextInt();

        for(People p : peoples){
            if(p.getId() == idforCheck){
                System.out.print("Enter New ID = ");
                p.setId(input.nextInt());
                System.out.print("Enter New Name = ");
                input.nextLine();
                p.setName(input.nextLine());
                System.out.print("Enter New Email = ");
                p.setEmail(input.nextLine());
                System.out.print("Enter New Age = ");
                p.setAge(input.nextInt());
                System.out.print("Enter new Address = ");
                p.setAddress(input.nextLine());
                System.out.print("Enter new Phone = ");
                p.setPhone(input.nextInt());
                System.out.println("This ID of the person have been updated");
                System.out.println("ID      =  " + p.getId());
                System.out.println("Name    = " + p.getName());
                System.out.println("Email   = " + p.getEmail());
                System.out.println("Age     = " + p.getAge());
                System.out.println("Address = " + p.getAddress());
                System.out.println("Phone   = " + p.getPhone());
                break;
            }
            else {
                System.out.println("Invalid index. Please choose a valid index.");
            }
        }
    }
    public static void SearchPerson(List<People> people){
        System.out.print("Enter ID to Search = ");
        idforCheck = input.nextInt();

        for(People p : people){
            if(p.getId() == idforCheck){
                System.out.println("Search Found The Information as below");
                System.out.println("ID      =  " + p.getId());
                System.out.println("Name    = " + p.getName());
                System.out.println("Email   = " + p.getEmail());
                System.out.println("Age     = " + p.getAge());
                System.out.println("Address = " + p.getAddress());
                System.out.println("Phone   = " + p.getPhone());
                break;
            }
        }
    }
    
    
    
}
