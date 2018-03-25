package Team1;

import java.util.Scanner;

public class Child extends Person {
    /**
     * p is used for temporary store the object of connection class
     */
    Scanner sc = new Scanner(System.in);
    connection p;

    /**
     * create constructor
     * 
     * @param name
     * @param gender
     * @param age
     * @param status
     */
    public Child(String name, String gender, int age, String status) {
        super(name, gender, age, status);
    }

    /**
     * the child who is equal or less than 2 years old do not have the friend.
     * the age difference between this two child can not be more than 3 years.
     * 
     * @param x
     */
    public void setFriend(Person x) {
        if (x.getAge() <= 2 || getAge() - x.getAge() > 3 || getAge() - x.getAge() < -3) {
            System.out.println("They can not be friend");
        } else {
            p = new connection(x, "friend");
            re.add(p);
        }
    }

    /**
     * set two persons of the child. if child already have two parents, remove
     * them, then set the new parents.
     * 
     * @param y
     * @param z
     */
    public void setParent(Person y, Person z) {
        for (int i = 0; i < re.size(); i++) {
            if (getName().equals(re.get(i).getProf().getName()) && re.get(i).getRelationship().equals("parent")) {
                re.remove(i);
            }
        }
        p = new connection(y, "parent");
        re.add(p);
        p = new connection(z, "parent");
        re.add(p);
    }

    /**
     * find out the parent name of the child.
     */
    public void find_bloodrelation() {
        for (int i = 0; i < re.size(); i++) {
            if (re.get(i).getRelationship().equals("parent")) {
                System.out.println("The parent is " + re.get(i).getProf().getName());
            }
        }
    }

}
