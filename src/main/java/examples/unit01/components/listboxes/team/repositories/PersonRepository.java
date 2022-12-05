package examples.unit01.components.listboxes.team.repositories;


import examples.unit01.components.listboxes.team.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PersonRepository implements IPersonRepository {

    private List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(1, "German", "Carreño", 18),
                new Person(2, "Sergio", "Marqués", 20)
        ));
    private List<Person> team = new ArrayList<>(Arrays.asList(
                new Person(3, "Mariano", "Rajoy", 23)
        ));
    
    @Override
    public List<Person> getAll() {
        return people;
    }
    
    @Override
    public boolean delete(Person p) {
        return people.remove(p);
    }

    @Override
    public void addTeam(Person p) {
        team.add(p);
    }

    @Override
    public boolean delTeam(Person p) {
        return team.remove(p);
    }

    @Override
    public void add(Person p) {
        people.add(p);
    }

    @Override
    public List<Person> getTeam() {
        return team;
    }
    
    
    
}
