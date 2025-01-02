/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daffa.table;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author daffa
 */
public class CheckBoxTableHeaderRenderer extends JCheckBox implements TableCellRenderer {
    private final JTable TABLE;
    private final int COLUMN;
    
    public CheckBoxTableHeaderRenderer(JTable table, int column) {
        this.TABLE = table;
        this.COLUMN = column;
        
        init();
    }
    
    private void init() {
        putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Table.background");
        setHorizontalAlignment(CENTER);
        
        TABLE.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int col = TABLE.columnAtPoint(me.getPoint());
                    if (col == COLUMN) {
                        putClientProperty(FlatClientProperties.SELECTED_STATE, null);
                        setSelected(!isSelected());
                        selectedTableRow(isSelected());
                    }
                }
            }
        });
        
        TABLE.getModel().addTableModelListener((tme) -> {
            if (tme.getColumn() == COLUMN || tme.getType() == TableModelEvent.DELETE) {
                checkRow();
            }
        });
    }
    
    private void checkRow() {
        boolean initValue = TABLE.getRowCount() == 0 ? false : (boolean) TABLE.getValueAt(0, COLUMN);
        for (int i = 1; i < TABLE.getRowCount(); i++) {
            boolean v = (boolean) TABLE.getValueAt(i, COLUMN);
            if (initValue != v) {
                putClientProperty(FlatClientProperties.SELECTED_STATE, FlatClientProperties.SELECTED_STATE_INDETERMINATE);
                TABLE.getTableHeader().repaint();
                return;
            }
        }
        putClientProperty(FlatClientProperties.SELECTED_STATE, null);
        setSelected(initValue);
        TABLE.getTableHeader().repaint();
    }
    
    private void selectedTableRow(boolean selected) {
        for (int i = 0; i < TABLE.getRowCount(); i++) {
            TABLE.setValueAt(selected, i, COLUMN);
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        return this;
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(UIManager.getColor("TableHeader.bottomSeparatorColor"));
        float size = UIScale.scale(1f);
        g2.fill(new Rectangle2D.Float(0, getHeight() - size, getWidth(), size));
        g2.dispose();
        super.paintComponent(grphcs);
    }          
}
