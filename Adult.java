package Team1;

import java.util.Scanner;

public class Adult extends Person {
    /**
     * a is used for temporary store the object of connection class
     */
    connection a;
    Scanner sc = new Scanner(System.in);

    /**
     * create constructor
     * 
     * @param name
     * @param gender
     * @param age
     * @param status
     */
    public Adult(String name, String gender, int age, String status) {
        super(name, gender, age, status);
    }

    /**
     * the adult can not be friend with child.
     */
    public void setFriend(Person x) {
        if (x instanceof Child) {
            System.out.println("They can not be friends");
        } else {
            a = new connection(x, "friend");
            re.add(a);
        }
    }

    /**
     * ensure one adult only have one spouse. if an adult already have one
     * spouse, delete it, then set a new one.
     * 
     * @param y
     */
    public void setCouple(Person y) {
        for (int i = 0; i < re.size(); i++) {
            if (y.getName().equals(re.get(i).getProf().getName())) {
                if (re.get(i).getRelationship().equals("couple"))
                    re.remove(i);
            }
        }
        a = new connection(y, "couple");
        re.add(a);
    }

    /**
     * set a child except the same one
     * 
     * @param t
     */
    public void setChild(Person t) {
        int u = 0;
        for (int i = 0; i < re.size(); i++) {
            if (t.getName().equals(re.get(i).getProf().getName()) && re.get(i).getRelationship().equals("dependent")) {
                System.out.println("You have already add this child");
            } else {
                a = new connection(t, "dependent");
            }
            u++;
        }
        if (u == 0) {
            a = new connection(t, "dependent");
        }
        re.add(a);
    }

    /**
     * judge whether the person is the child of this adult.
     * 
     * @return boolean
     */
    public boolean judge_child() {
        int a = 0;
        for (int i = 0; i < re.size(); i++) {
            if (re.get(i).getProf().getAge() < 16 && re.get(i).getRelationship().equals("dependent")) {
                a++;
                return true;
            } else {
                return false;
            }
        }
        if (a == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * find out the child name of parent.
     */
    public void find_bloodrelation() {
        for (int i = 0; i < re.size(); i++) {
            if (re.get(i).getRelationship().equals("dependent")) {
                System.out.println("The child is " + re.get(i).getProf().getName());
            }
        }
    }
}
