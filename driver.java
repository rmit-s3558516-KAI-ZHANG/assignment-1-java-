package Team1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class driver {
    /**
     * Person p is used for temporary store the object which is Adult or Child
     * Person pf is used for temporary store the relevant object while input the name(String)
     * pr is an arrayList to store the array dynamically
     * 
     */
    private String name;
    private String gender;
    private int age = 0;
    private String status;
    private String judge;
    private Person p, pf;
    Scanner sc = new Scanner(System.in);
    List<Person> pr = new ArrayList<Person>();

    /**
     * using "switch case" provide a menu list. when input "8" the program will
     * over. any other input except number 1-8 regard as invalid input, and will retype it
     */
    public void display_menu() {
        System.out.println("MiniNet Menu");
        System.out.println();
        System.out.println("============================================");
        System.out.println();
        System.out.println("1. Add a person");
        System.out.println("2. List every one");
        System.out.println("3. Select a person");
        System.out.println("4. Connect the person");
        System.out.println("5. Are these two direct friends");
        System.out.println("6. Find out the person's parents or child(ren)");
        System.out.println("7. list all connection");
        System.out.println("8. Exit");
        System.out.println("Please enter the option:");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
        case 1:
            this.add_person();
            break;
        case 2:
            this.list_all();
            break;
        case 3:
            this.select_person();
            break;
        case 4:
            this.connect();
            break;
        case 5:
            this.judge();
            break;
        case 6:
            this.find();
            break;
        case 7:
            this.listallconnection();
            break;
        case 8:
            System.out.println("exit!");
            break;
        default:
            System.out.println("Invalid input!");
            this.display_menu();
            break;
        }
    }

    /**
     * add the profile of the person in the memory space judge the age, if it is
     * less than 16, create a child object by using person reference. otherwise,
     * create an adult object by using person reference.
     */
    public void add_person() {
        boolean done = false;
        do {
            System.out.println("Please enter name:");
            name = sc.nextLine();
            System.out.println("Please enter gender:");
            gender = sc.nextLine();
            do {
                try {
                    System.out.println("Please enter age:");
                    age = sc.nextInt();
                    sc.nextLine();
                    done = true;
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input!");
                    sc.nextLine();
                }
            } while (!done);
            System.out.println("Please enter status:");
            status = sc.nextLine();
            if (age < 16) {
                p = new Child(name, gender, age, status);
            } else {
                p = new Adult(name, gender, age, status);
            }
            pr.add(p);
            System.out.println("Continue?");
            judge = sc.nextLine();
        } while (judge.charAt(0) == 'Y' || judge.charAt(0) == 'y');
        System.out.println();
        this.display_menu();
    }

    /**
     * list all of the person's profile after execute this method, invoke the
     * method display_men again.
     */
    public void list_all() {
        for (int i = 0; i < pr.size(); i++) {
            System.out.println("name: " + pr.get(i).getName());
            System.out.println("gender: " + pr.get(i).getGender());
            System.out.println("age: " + pr.get(i).getAge());
            System.out.println("status: " + pr.get(i).getStatus());
        }
        System.out.println();
        this.display_menu();
    }

    /**
     * input a String and return the relevant object
     */
    public void select() {
        int t = 0;
        String n;
        System.out.println("Please enter name:");
        n = sc.nextLine();
        for (int i = 0; i < pr.size(); i++) {
            if (n.equals(pr.get(i).getName())) {
                pf = pr.get(i);
                t++;
            }
        }
        if (t == 0) {
            System.out.println("Sorry,Not match!");
            this.select();
        }
    }

    /**
     * select_person method provide the sub menu with three functions. first is
     * displaying the profile of selected person second is updating the profile
     * of selected person third is deleting the selected person
     */
    public void select_person() {
        int option = 0;
        this.select();
        System.out.println("1. display the profile of selected person");
        System.out.println("2. update the profile of selected person");
        System.out.println("3. delete the selected person");
        System.out.println("Please enter the option:");
        option = sc.nextInt();
        sc.nextLine();
        switch (option) {
        case 1:
            this.display_profile();
            break;
        case 2:
            this.update_profile();
            break;
        case 3:
            this.delete_profile();
            break;
        default:
            System.out.println("Invalid input!");
            this.select_person();
        }
    }

    /**
     * display the profile of selected person. after execute this method, invoke
     * the method display_men again.
     */
    public void display_profile() {
        System.out.println("name: " + pf.getName());
        System.out.println("gender: " + pf.getGender());
        System.out.println("age: " + pf.getAge());
        System.out.println("status: " + pf.getStatus());
        System.out.println();
        this.display_menu();
    }

    /**
     * update the profile of selected person. if you type invalid value, the
     * program will demand you retype it. after execute this method, invoke the
     * method display_men again.
     */
    public void update_profile() {
        boolean done = false;
        int reset_age = 0;
        System.out.println("Please reset the name:");
        sc.nextLine();
        String reset_name = sc.nextLine();
        pf.setName(reset_name);
        System.out.println("Please reset the gender:");
        String reset_gender = sc.nextLine();
        pf.setGender(reset_gender);
        do {
            try {
                System.out.println("Please reset the age:");
                reset_age = sc.nextInt();
                sc.nextLine();
                pf.setAge(reset_age);
                done = true;
            } catch (InputMismatchException e) {
                System.out.println("Invprid input!");
                sc.nextLine();
            }
        } while (!done);
        System.out.println("Please reset the status:");
        String reset_status = sc.nextLine();
        pf.setStatus(reset_status);
        System.out.println();
        this.display_menu();
    }

    /**
     * delete one person, if the deleted person have a child, he/she can not be
     * deleted. the method judge_child is aim to judge whether the person have a
     * child. after execute this method, invoke the method display_men again.
     */
    public void delete_profile() {
        if (pf instanceof Adult) {
            if (((Adult) pf).judge_child() == false) {
                for (int i = 0; i < pr.size(); i++) {
                    if (pf.equals(pr.get(i))) {
                        pr.remove(i);
                        System.out.println("the selected person has been deleted!");
                    }
                }
            } else {
                System.out.println("the selected person can not be deleted!");
                this.select_person();
            }
        } else {
            for (int i = 0; i < pr.size(); i++) {
                if (pf.equals(pr.get(i))) {
                    pr.remove(i);
                    System.out.println("the selected person has been deleted!");
                }
            }
        }
        System.out.println();
        this.display_menu();
    }

    /**
     * connect two people in a meaningful way. the first option is connecting
     * two people to be friends. the second option is connecting two people to
     * be couples. the third option is setting the parent or child, the third
     * option judge the selected person is an adult or child, if the selected
     * person is an adult, you just can set a child, then you are forced to set
     * another parent and connect this two persons as a couple. if the selected
     * person is a child, you must set just two people as his/her parent. after
     * execute this method, invoke the method display_men again.
     */
    public void connect() {
        Person p1, p2, p3, p4, p5, p6, p7;
        Adult a1, a2;
        System.out.println("1. set the friend");
        System.out.println("2. set the couple");
        System.out.println("3. set the bloodrelation");
        System.out.println("Please enter the option:");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
        case 1:
            this.select();
            p1 = pf;
            this.select();
            p2 = pf;
            p1.setFriend(p2);
            p2.setFriend(p1);
            break;
        case 2:
            this.select();
            a1 = (Adult) pf;
            this.select();
            a2 = (Adult) pf;
            a1.setCouple(a2);
            a2.setCouple(a1);
            break;
        case 3:
            boolean g = false;
            this.select();
            p3 = pf;
            if (p3 instanceof Adult) {
                System.out.println("connect the child");
                this.select();
                p4 = pf;
                ((Adult) p3).setChild(p4);
                do {
                    System.out.println("connect another parent");
                    this.select();
                    p5 = pf;
                    if (p5 instanceof Adult) {
                        ((Adult) p5).setCouple(p3);
                        ((Adult) p3).setCouple(p5);
                        g = true;
                    } else {
                        System.out.println("Invalid");
                    }
                } while (!g);
            } else {
                System.out.println("connect one parent");
                this.select();
                p6 = pf;
                System.out.println("connect another parent");
                this.select();
                p7 = pf;
                ((Child) p3).setParent(p6, p7);
            }
        }
        System.out.println();
        this.display_menu();
    }

    /**
     * judge whether this two persons are friends or not. after execute this
     * method, invoke the method display_men again.
     */
    public void judge() {
        Person p1;
        Person p2;
        this.select();
        p1 = pf;
        this.select();
        p2 = pf;
        p1.judge_friend(p2);
        System.out.println();
        this.display_menu();
    }

    /**
     * list all connection of the selected person after execute this method,
     * invoke the method display_men again.
     */
    public void listallconnection() {
        this.select();
        pf.list();
        System.out.println();
        this.display_menu();
    }

    /**
     * find out the dependent of the person or the parent of the person after
     * execute this method, invoke the method display_men again.
     */
    public void find() {
        this.select();
        pf.find_bloodrelation();
        System.out.println();
        this.display_menu();
    }
}
