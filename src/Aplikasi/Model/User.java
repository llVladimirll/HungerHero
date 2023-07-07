package Aplikasi.Model;

public class User {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    public User(String name,String email, String password, String phoneNumber, String address){
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
