package iterator;

import model.person;

import java.util.ArrayList;

public class ListPrinter implements Container{

    private ArrayList<person> userList = new ArrayList<>();

    @Override
    public Iterator getIterator(ArrayList<person> list) {
        this.userList = list;
        return new NameIterator();
    }

    private class NameIterator implements Iterator{

        int index;

        @Override
        public boolean hasNext() {
            if(index < userList.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return userList.get(index++);
            }
            return null;
        }
        @Override
        public int getIndex() {
            return index;
        }
    }
}
