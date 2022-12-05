package examples.unit01.components.listboxes.team.repositories;

import examples.unit01.components.listboxes.team.model.Person;

import java.util.List;


public interface IPersonRepository {
    public List<Person> getAll();
    public List<Person> getTeam();
    public boolean delete(Person p);
    public void add(Person p);
    public void addTeam(Person p);
    public boolean delTeam(Person p);
}
