

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Person> mem;

    public School() {
        mem = new ArrayList<>();
    }

    public void addMember(Person person) {
        mem.add(person);
    }

    @Override
    public String toString() {
        String result = "";
        for (Person member : mem) {
            result += member.toString() + "\n";
        }
        return result;
    }
}