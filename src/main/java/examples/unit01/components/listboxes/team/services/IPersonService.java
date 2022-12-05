
package examples.unit01.components.listboxes.team.services;

import examples.unit01.components.listboxes.team.model.Person;

import java.util.List;

public interface IPersonService {
    public List<Person> getAll();
    public List<Person> getTeam();
    public boolean delete(Person p);
    public void add(Person p);
    public void changePersonToTeam(Person p);
    public void changePersonToStack(Person p);
}

