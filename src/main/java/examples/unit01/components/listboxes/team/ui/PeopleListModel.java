
package examples.unit01.components.listboxes.team.ui;

import examples.unit01.components.listboxes.team.model.Person;

import java.util.List;
import javax.swing.AbstractListModel;

class PeopleListModel extends AbstractListModel {

    private List<Person> people;
    
    public PeopleListModel(List<Person> people) {
        this.people = people;
    }
    
    @Override
    public int getSize() {
        return people.size();
    }

    @Override
    public Object getElementAt(int index) {
        Person p = people.get(index);
        
        return p.getFirstName() + " " + p.getSecondName();
    }
    
    public void fireIntervalRemoved(int index){
        this.fireIntervalRemoved(index, getSize(), getSize() + 1);
    }
    
    public void fireIntervalAdded(){
        this.fireIntervalAdded(this, getSize(), getSize() + 1);
    }
    
}
