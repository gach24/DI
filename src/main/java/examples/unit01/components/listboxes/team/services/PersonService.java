package examples.unit01.components.listboxes.team.services;

import examples.unit01.components.listboxes.team.model.Person;
import examples.unit01.components.listboxes.team.repositories.IPersonRepository;

import java.util.List;


public class PersonService implements IPersonService {

    private IPersonRepository personRepository;
    
    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @Override
    public List<Person> getAll() {
        return personRepository.getAll();
    }
    
        @Override
    public void add(Person p) {
        personRepository.add(p);
    }
    
    @Override
    public boolean delete(Person p) {
        return personRepository.delete(p);
    }
    
    @Override
    public List<Person> getTeam() {
        return personRepository.getTeam();
    }

    @Override
    public void changePersonToTeam(Person p) {
        personRepository.delete(p);
        personRepository.addTeam(p);
      
    }

    @Override
    public void changePersonToStack(Person p) {
        personRepository.add(p);
        personRepository.delTeam(p);
    }


    
    
}
