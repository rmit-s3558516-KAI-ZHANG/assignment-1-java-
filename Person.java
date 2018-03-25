package Team1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Person {
    /**
     * re is an array list to store the object of connection class.
     */
    private String name;
    private String gender;
    private int age;
    private String status;
    Scanner sc = new Scanner(System.in);
    List<connection> re = new ArrayList<connection>();

    /**
     * create constructor
     * 
     * @param name
     * @param gender
     * @param age
     * @param status
     */
    public Person(String name, String gender, int age, String status) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.status = status;
    }

    /**
     * get the value of the attribute "name"
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * get the value of the attribute "age"
     * 
     * @return int
     */
    public int getAge() {
        return age;
    }

    /**
     * get the value of the attribute "gender"
     * 
     * @return String
     */
    public String getGender() {
        return gender;
    }

    /**
     * get the value of the attribute "status"
     * 
     * @return String
     */
    public String getStatus() {
        return status;
    }

    /**
     * set the value of the attribute "name"
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the value of the attribute "gender"
     * 
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * set the value of the attribute "age"
     * 
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * set the value of the attribute "status"
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * abstract class, it is need to be implemented in the subclass
     * 
     * @param x
     */
    public abstract void setFriend(Person x);

    /**
     * abstract class, it is need to be implemented in the subclass
     */
    public abstract void find_bloodrelation();

    /**
     * judge whether this two persons are friends or not the local variable a is
     * aiming to judge whether the relation of this person is exist in the
     * arrayList
     * 
     * @param x
     */
    public void judge_friend(Person x) {
        int a = 0;
        for (int i = 0; i < re.size(); i++) {
            if (re.get(i).getProf().equals(x) && re.get(i).getRelationship().equals("friend")) {
                System.out.println("They are friends");
            } else {
                System.out.println("They are not friends");
            }
            a++;
        }
        if (a == 0) {
            System.out.println("They are not friends");
        }
    }

    /**
     * list all of the connection of the selected person
     */
    public void list() {
        for (int i = 0; i < re.size(); i++) {
            System.out.println("relation person: " + re.get(i).getProf().getName());
            System.out.println("relation: " + re.get(i).getRelationship());
        }
    }
}
