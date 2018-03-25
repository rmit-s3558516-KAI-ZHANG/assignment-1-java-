package Team1;

import java.util.Scanner;

public class connection {
    private Person prof;
    private String relationship;

    Scanner sc = new Scanner(System.in);

    /**
     * create constructor
     * 
     * @param p
     * @param relation
     */
    public connection(Person p, String relation) {
        prof = p;
        relationship = relation;
    }

    /**
     * get the value of the attribute "prof"
     * 
     * @return Person
     */
    public Person getProf() {
        return prof;
    }

    /**
     * set the value of the attribute "prof"
     * 
     * @param prof
     */
    public void setProf(Person prof) {
        this.prof = prof;
    }

    /**
     * get the value of the attribute "relationship"
     * 
     * @return
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * set the value of the attribute "relationship"
     * 
     * @param relationship
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

}
