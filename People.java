import java.util.Scanner;

public class People {
    
    static Scanner input = new Scanner(System.in);
    private int id;
    private String name;
    private String email;
    private int age;
    private String address;
    private long phone;
    public People(int id, String name, String email, int age, String address, long phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }
    public People(){
        this.id = 0;
        this.name = null;
        this.email = null;
        this.age = 0;
        this.address = null;
        this.phone = 0;
        
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }
    public long getPhone() {
        return phone;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    public void input(){
        System.out.print("Enter ID = ");
        id = input.nextInt();
        System.out.print("Enter name = ");
        input.nextLine();
        name = input.nextLine();
        System.out.print("Enter email = ");
        email = input.nextLine();
        System.out.print("Enter age = ");
        age = input.nextInt();
        System.out.print("Enter address = ");
        input.nextLine();
        address = input.nextLine();
        System.out.print("Enter phone = ");
        phone = input.nextInt();
    }
}
