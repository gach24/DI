
package examples.unit01.components.listboxes.team.ui;

import examples.unit01.components.listboxes.team.model.Person;

import java.util.List;
import javax.swing.AbstractListModel;

class TeamListModel extends AbstractListModel {

    private List<Person> team;
    
    public TeamListModel(List<Person> team) {
        this.team = team;
    }
    
    @Override
    public int getSize() {
        return team.size();
    }

    @Override
    public Object getElementAt(int index) {
        Person p = team.get(index);
        return p.getFirstName() + " " + p.getSecondName();
    }

    
    public void fireIntervalRemoved(int index){
        this.fireIntervalRemoved(index, getSize(), getSize() + 1);
    }
    
    public void fireIntervalAdded(){
        this.fireIntervalAdded(this, getSize(), getSize() + 1);
    }

}
