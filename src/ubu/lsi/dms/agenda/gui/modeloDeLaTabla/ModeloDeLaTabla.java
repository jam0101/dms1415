package ubu.lsi.dms.agenda.gui.modeloDeLaTabla;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public abstract class ModeloDeLaTabla extends AbstractTableModel{
	
	private String[] columnNames;
	
	public ModeloDeLaTabla(String[] columnNames){
		this.columnNames = columnNames;
	}

	public int getColumnCount() {
        return columnNames.length;
    }

    public abstract int getRowCount();

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public abstract Object getValueAt(int row, int col);

	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
//    public boolean isCellEditable(int row, int col) {
//        if (col < 2) {
//            return false;
//        } else {
//            return true;
//        }
//    }
    
//    public void setValueAt(Object value, int row, int col) {
//        data[row][col] = value;
//        fireTableCellUpdated(row, col);
//    }
}
