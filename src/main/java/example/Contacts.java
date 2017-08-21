package example;

import javax.persistence.*;


@Entity
@Table(name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;

    public Contacts() {

    }

    public Contacts(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Contacts(String name) {

        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
