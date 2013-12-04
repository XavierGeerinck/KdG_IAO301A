/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.componentenvoorbeeld;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author wouter
 */
@Named // or @ManagedBean
@SessionScoped
public class TableData implements Serializable
{
    private List<Integer> numbers = java.util.Arrays.asList(1,2,3,4,5);
    private List<Row> rows = new ArrayList<Row>();

    public TableData()
    {
        for(Integer number: numbers)
            rows.add(new Row(number));
    }
    
    public List<Row> getRows()
    {
        return rows;
    }

    public String deleteRow(Row nameToDelete)
    {
        rows.remove(nameToDelete);
        return null;
    }
}