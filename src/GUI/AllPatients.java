package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AllPatients {

    private JTable table1;
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JTextField textField1;
    private JButton searchButton;
    static JFrame frame = new JFrame("All Patients");

    public AllPatients() {

        // table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // set dynamic columns
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("City");
        tableModel.addColumn("State");
        tableModel.addColumn("Phone");
        tableModel.addColumn("Email Address");
        table1.setModel(tableModel);

        // add rows to table
        tableModel.addRow(new Object[]{"Chad", "Burke", "Gilford", "NH", "555-555-5555", "x@gmail.com"});
        tableModel.addRow(new Object[]{"Chad2", "Burke", "Gilford", "NH", "555-555-5555", "x@gmail.com"});
        tableModel.addRow(new Object[]{"Chad3", "Burke", "Gilford", "NH", "555-555-5555", "x@gmail.com"});

        // style cell renderer .. add some padding
        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBorder(BorderFactory.createCompoundBorder(getBorder(), padding));
                return this;
            }
        };

        table1.getColumnModel().getColumn(0).setCellRenderer(r);
        table1.getColumnModel().getColumn(1).setCellRenderer(r);

        // hide the editor border
        JTextField tf = new JTextField();
        tf.setBorder(BorderFactory.createEmptyBorder());
        tf.setBorder(BorderFactory.createCompoundBorder(tf.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        table1.setDefaultEditor(Object.class, new DefaultCellEditor(tf));

        // set row height
        table1.setRowHeight(table1.getRowHeight() + 8);
        table1.setRowMargin(3);

        // set selection color
        table1.setSelectionBackground(new Color(Integer.parseInt("A1CDEC", 16)));

        // allow sorting
        table1.setAutoCreateRowSorter(true);

        // open ui
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setMinimumSize(new Dimension(650, 76));
        mainPanel.setPreferredSize(new Dimension(750, 469));
        scrollPane = new JScrollPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(scrollPane, gbc);
        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        table1 = new JTable();
        table1.setFillsViewportHeight(true);
        table1.setIntercellSpacing(new Dimension(4, 4));
        table1.setRowMargin(4);
        scrollPane.setViewportView(table1);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(3, 3, 3, 3), -1, -1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(panel1, gbc);
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        textField1 = new JTextField();
        panel1.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Search by name, phone, email :");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchButton = new JButton();
        searchButton.setText("Search");
        panel1.add(searchButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}