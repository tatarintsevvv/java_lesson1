package ru.geekbrains;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

class PhoneRecord {
    private String lastName;
    private String phoneNumber;

    public PhoneRecord(String lastName, String phoneNumber) {
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    boolean equals(String lastName) {
        if(this.lastName == lastName) {
            return true;
        } else {
            return false;
        }
    }
    public String getPhoneNamber() {
        return this.phoneNumber;
    }
}

public class PhoneBook {
    private LinkedList<PhoneRecord> list;

    public PhoneBook() {
        list = new LinkedList<PhoneRecord>();
    }

    public void add(String lastName, String phoneNumber) {
        this.list.add(new PhoneRecord(lastName, phoneNumber));
    }

    public ArrayList<String> get(String lastName) {
        ArrayList<String> phoneList = new ArrayList<>();
        Iterator iterator = this.list.iterator();
        while(iterator.hasNext()) {
            PhoneRecord temp = (PhoneRecord)iterator.next();
            if(temp.equals(lastName)) {
                phoneList.add(temp.getPhoneNamber());
            }
        }
        return phoneList;
    }
}
