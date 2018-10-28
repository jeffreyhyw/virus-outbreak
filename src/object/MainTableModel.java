package object;

import javax.swing.table.AbstractTableModel;

public class MainTableModel extends AbstractTableModel {
    private String[] columnNames = {"Country","Infect","Death"};
    private Object data [][]=
		{
				{"China","200000","5000"},
				{"Africa","1000000","95000"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"},
				{"UK","20000","950"}
			};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
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
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
