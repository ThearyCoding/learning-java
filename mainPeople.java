import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainPeople{
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        List<People> people = new ArrayList<People>();
        int choice;
        LoadingProcess.simulateLoading(100, 12);
        do{
            
            System.out.println();
            SubPeople.MenuInit();
            System.out.println();
            System.out.print("\tSelect one options = ");
            choice = input.nextInt();
            switch (choice){
                case 0:
                    LoadingProcess.simulateLoading(100, 5);
                    System.out.println();
                    System.exit(0);
                    break;
                case 1:
                    LoadingProcess.simulateLoading(100, 5);
                    System.out.println();
                    SubPeople.ShowAllProducts(people);
                    break;
                case 2:
                    LoadingProcess.simulateLoading(100, 5);
                    System.out.println();
                    SubPeople.AddMorePeople(people);
                    break;
                case 3:
                    LoadingProcess.simulateLoading(100, 5);
                    System.out.println();
                    SubPeople.RemovePeople(people);
                    break;
                case 4:
                    LoadingProcess.simulateLoading(100, 5);
                    System.out.println();
                    SubPeople.EditPeople(people); break;
                case 5:
                    LoadingProcess.simulateLoading(100, 5);
                    System.out.println();
                    SubPeople.SearchPerson(people); break;
                case 6:
                    LoadingProcess.simulateLoading(100, 5);
                    System.out.print("\033c"); break;
            }
        }while(true);
    }
}