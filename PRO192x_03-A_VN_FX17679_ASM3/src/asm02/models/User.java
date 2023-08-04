package asm02.models;


import fx17679.java.asm01.asm01;

public abstract class User {
    private String name;
    private String customerId;


    public User() {
    }
    public User(String customerId, String name){
        this.customerId = customerId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        if(asm01.kiemTraCCCD(customerId) == 0)
            this.customerId = customerId;
        else
            System.out.println("Mã CCCD không hợp lệ !");
    }
}
