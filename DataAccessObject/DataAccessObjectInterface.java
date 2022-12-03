package DataAccessObject;

import java.util.ArrayList;

public interface DataAccessObjectInterface <R>{
    public void create(R r);
    public void delete(R r);
    public void edit(R r);
    public ArrayList<R> selectAll();
}
