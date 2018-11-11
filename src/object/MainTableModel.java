package object;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MainTableModel extends AbstractTableModel {
    private String[] columnNames = {"Country", "Infect", "Death"};

    private ArrayList<Country> countries;

    public MainTableModel(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return countries.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Country c = countries.get(row);
        switch (col) {
            case 0:
                return c.getName();
            case 1:
                return c.getInfectedPopulation();
            case 2:
                return c.getDeathPopulation();

            default:
                return null;
        }
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        Country c = countries.get(row);
        switch (col) {
            case 0:
                c.setName((String) value);
                break;
            case 1:
                c.addInfectedPopulation((int) value);
                break;
            case 2:
                c.addDeathPopulation((int) value);
                break;

            default:
                break;
        }
        fireTableCellUpdated(row, col);
    }
}
