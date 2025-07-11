/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.*;
import java.util.Arrays;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.Color;
import java.awt.Image;


import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author tryth
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
        refreshTable();
        populateCbox();
        
        resizeIcon(addBookBtn, "/image/edit.png", 15, 15);
        resizeIcon(subBtn, "/image/job-application.png", 20, 20);
        resizeIcon(updBtn, "/image/update.png", 20, 20);
        resizeIcon(delBtn, "/image/recycle-bin.png", 20, 20);
        resizeIcon(clearBtn, "/image/broom.png", 20, 20);
    }
    
    public void refreshTable(){
        DefaultTableModel model = new DefaultTableModel();
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:MySQL://Localhost:3306/books_db";
            String user = "root";
            String pass = "";
            ResultSet rs = null;
            
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            
            String query = "SELECT * FROM borrowers_tbl";
            rs = stmt.executeQuery(query);
            
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            
            //for headers
            String headers[] = {"Borrowers ID", "Book Name", "Borrower Name", "Date Borrowed", "Status"};
            for(String header: headers){
                model.addColumn(header);
            }
            
            //for data in database
            while(rs.next()){
                Object[] row = new Object[columnCount];
                for(int i = 1; i<=columnCount; i++){
                    row[i-1] = rs.getObject(i);
                }
                model.addRow(row);
                lendRecord.setModel(model);
            }
            
            lendRecord.getColumn("Status").setCellRenderer(new DefaultTableCellRenderer(){
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
                    
                    Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    
                    if(value != null){
                        String status = value.toString().toLowerCase();
                        if(status.equals("borrowed")){
                            cell.setForeground(Color.RED);
                        }else if(status.equals("returned")){
                            cell.setForeground(Color.GREEN);
                        }else{
                            cell.setForeground(Color.BLACK);
                        }
                    }else{
                        cell.setForeground(Color.BLACK);
                    }
                    
                    return cell;
                }
            });
            
            rs.close();
            stmt.close();
            conn.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "Error" + e.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bookCbox = new javax.swing.JComboBox<>();
        addBookBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        borrowName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateBorrowed = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rad1 = new javax.swing.JRadioButton();
        rad2 = new javax.swing.JRadioButton();
        subBtn = new javax.swing.JButton();
        updBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lendRecord = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 153));

        jPanel1.setBackground(new java.awt.Color(26, 83, 92));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Script MT Bold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 203, 68));
        jLabel1.setText("Book Lending Form");

        jLabel2.setFont(new java.awt.Font("Calisto MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 191, 120));
        jLabel2.setText("Book Title:");

        bookCbox.setBackground(new java.awt.Color(255, 238, 169));
        bookCbox.setEditable(true);
        bookCbox.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 15)); // NOI18N
        bookCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookCboxActionPerformed(evt);
            }
        });

        addBookBtn.setBackground(new java.awt.Color(234, 166, 77));
        addBookBtn.setFont(new java.awt.Font("Calisto MT", 1, 10)); // NOI18N
        addBookBtn.setText("EDIT BOOKS");
        addBookBtn.setToolTipText("");
        addBookBtn.setFocusable(false);
        addBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calisto MT", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 191, 120));
        jLabel4.setText("Borrowers Name:");

        borrowName.setBackground(new java.awt.Color(255, 238, 169));
        borrowName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calisto MT", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 191, 120));
        jLabel5.setText("Status");

        dateBorrowed.setBackground(new java.awt.Color(255, 238, 169));
        dateBorrowed.setText("YYYY-MM-DD");

        jLabel6.setFont(new java.awt.Font("Calisto MT", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 191, 120));
        jLabel6.setText("Date Borrowed");

        jPanel3.setBackground(new java.awt.Color(255, 238, 169));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        rad1.setFont(new java.awt.Font("Calisto MT", 1, 12)); // NOI18N
        rad1.setForeground(new java.awt.Color(204, 0, 0));
        rad1.setText("Borrowed");
        rad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad1ActionPerformed(evt);
            }
        });

        rad2.setFont(new java.awt.Font("Calisto MT", 1, 12)); // NOI18N
        rad2.setForeground(new java.awt.Color(51, 204, 0));
        rad2.setText("Returned");
        rad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(rad1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rad2)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rad2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        subBtn.setBackground(new java.awt.Color(0, 109, 7));
        subBtn.setFont(new java.awt.Font("Calisto MT", 1, 10)); // NOI18N
        subBtn.setForeground(new java.awt.Color(255, 255, 255));
        subBtn.setText("SUBMIT");
        subBtn.setToolTipText("");
        subBtn.setFocusable(false);
        subBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subBtnActionPerformed(evt);
            }
        });

        updBtn.setBackground(new java.awt.Color(0, 80, 184));
        updBtn.setFont(new java.awt.Font("Calisto MT", 1, 10)); // NOI18N
        updBtn.setForeground(new java.awt.Color(255, 255, 255));
        updBtn.setText("UPDATE");
        updBtn.setToolTipText("");
        updBtn.setFocusable(false);
        updBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updBtnActionPerformed(evt);
            }
        });

        delBtn.setBackground(new java.awt.Color(178, 43, 5));
        delBtn.setFont(new java.awt.Font("Calisto MT", 1, 10)); // NOI18N
        delBtn.setForeground(new java.awt.Color(255, 255, 255));
        delBtn.setText("DELETE");
        delBtn.setToolTipText("");
        delBtn.setFocusable(false);
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(137, 145, 189));
        clearBtn.setFont(new java.awt.Font("Calisto MT", 1, 10)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("CLEAR");
        clearBtn.setToolTipText("");
        clearBtn.setFocusable(false);
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookCbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(borrowName)
                    .addComponent(dateBorrowed)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookCbox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borrowName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(26, 83, 92));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.SystemColor.controlHighlight));

        jLabel3.setFont(new java.awt.Font("Script MT Bold", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 203, 68));
        jLabel3.setText("Lending Record");

        lendRecord.setBackground(new java.awt.Color(255, 238, 169));
        lendRecord.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lendRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        lendRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lendRecordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lendRecord);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookCboxActionPerformed

    private void populateCbox(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:MySQL://Localhost:3306/books_db";
            String user = "root";
            String pass = "";
            ResultSet rs = null;
            
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            
            String query = "SELECT book_name FROM books_tbl";
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                bookCbox.addItem(rs.getString("book_name"));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "Error" + e.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void addBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookBtnActionPerformed
        // TODO add your handling code here:
        Books addBook = new Books(); // Create the new frame instance
        addBook.setVisible(true);                 // Show the frame
        addBook.setLocationRelativeTo(null);     // (optional) Center on screen
        this.dispose();
    }//GEN-LAST:event_addBookBtnActionPerformed
    
    private void resizeIcon(javax.swing.JButton button, String imagepath, int width, int height){
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(imagepath));
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon =  new ImageIcon(scaledImage);
        button.setIcon(resizedIcon);
    }
    
    private void rad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad1ActionPerformed
        // TODO add your handling code here:
        rad1.setSelected(true);
        rad2.setSelected(false);
    }//GEN-LAST:event_rad1ActionPerformed

    private void rad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad2ActionPerformed
        // TODO add your handling code here:
        rad1.setSelected(false);
        rad2.setSelected(true);
    }//GEN-LAST:event_rad2ActionPerformed

    private boolean isValidDate(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        sdf.setLenient(false);
        try{
            sdf.parse(dateStr);
            return true;
        }catch(ParseException e){
            return false;
        }
    }
    
    private void subBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subBtnActionPerformed
        // TODO add your handling code here:
        String bName, borrower, date, status;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:MySQL://Localhost:3306/books_db";
            String user = "root";
            String pass = "";
            
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            
            if(borrowName.getText().equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "Borrower name is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            }else if(dateBorrowed.getText().equals("") || !isValidDate(dateBorrowed.getText().trim())){
                JOptionPane.showMessageDialog(new JFrame(), "Date publish is required and must be in YYYY-MM-DD format", "Dialog", JOptionPane.ERROR_MESSAGE);
            }else if(rad1.isSelected()==false && rad2.isSelected()==false){
                JOptionPane.showMessageDialog(new JFrame(), "Status is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            }else{
                bName = (String) bookCbox.getSelectedItem();
                borrower = borrowName.getText().trim();
                date = dateBorrowed.getText().trim();
                
                if(rad1.isSelected()){
                    status = "Borrowed";
                }else{
                    status = "Returned";
                }
                
                String query = "INSERT INTO borrowers_tbl(book_name, name, date_borrowed, status)" + "VALUES ('" + bName + "','" + borrower +"','" + date +"','" + status +"')";
                stmt.executeUpdate(query);
                
                bookCbox.setSelectedIndex(0);
                borrowName.setText("");
                dateBorrowed.setText("YYYY-MM-DD");
                rad1.setSelected(false);
                rad2.setSelected(false);
                
                JOptionPane.showMessageDialog(new JFrame(), "Borrowers Added Successfully", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "Error" + e.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_subBtnActionPerformed

    private void updBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updBtnActionPerformed
        // TODO add your handling code here:
        String bName, borrower, date, status;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:MySQL://Localhost:3306/books_db";
            String user = "root";
            String pass = "";
            
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            
            if(borrowName.getText().equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "Borrower name is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            }else if(dateBorrowed.getText().equals("") || !isValidDate(dateBorrowed.getText().trim())){
                JOptionPane.showMessageDialog(new JFrame(), "Date publish is required and must be in YYYY-MM-DD format", "Dialog", JOptionPane.ERROR_MESSAGE);
            }else if(rad1.isSelected()==false && rad2.isSelected()==false){
                JOptionPane.showMessageDialog(new JFrame(), "Status is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            }else{
                bName = (String) bookCbox.getSelectedItem();
                borrower = borrowName.getText().trim();
                date = dateBorrowed.getText().trim();
                
                if(rad1.isSelected()){
                    status = "Borrowed";
                }else{
                    status = "Returned";
                }
                
                int selectedRow = lendRecord.getSelectedRow();
                String id = lendRecord.getValueAt(selectedRow,0).toString();
                
                if(id.equals("")){
                    JOptionPane.showMessageDialog(new JFrame(), "Borrowers ID is required to update the data", "Dialog", JOptionPane.ERROR_MESSAGE);
                }else{
                    String query = "UPDATE borrowers_tbl SET book_name = '" + bName + "', name = '" + borrower + "', date_borrowed = '" + date + "', status = '" + status + "' WHERE id = '" + id + "'";;
                    stmt.executeUpdate(query);
                    
                    bookCbox.setSelectedIndex(0);
                    borrowName.setText("");
                    dateBorrowed.setText("YYYY-MM-DD");
                    rad1.setSelected(false);
                    rad2.setSelected(false);

                    JOptionPane.showMessageDialog(new JFrame(), "Updated Successfully", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                    refreshTable();
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "Error" + e.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:MySQL://Localhost:3306/books_db";
            String user = "root";
            String pass = "";
            
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            
            int selectedRow = lendRecord.getSelectedRow();
            String id = lendRecord.getValueAt(selectedRow,0).toString();
                
            if(id.equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "Books ID is required to update the data", "Dialog", JOptionPane.ERROR_MESSAGE);
            }else{
                String query = "SELECT * FROM books_tbl WHERE id = '"+ id + "'";
                ResultSet rs = stmt.executeQuery(query);
                
                if(rs.next()){
                    String delete = "DELETE FROM borrowers_tbl WHERE id = '" + id + "'";
                    stmt.executeUpdate(delete);
                    
                    showMessageDialog(null, "Successfully Deleted");
                    refreshTable();
                    
                    bookCbox.setSelectedIndex(0);
                    borrowName.setText("");
                    dateBorrowed.setText("YYYY-MM-DD");
                    rad1.setSelected(false);
                    rad2.setSelected(false);
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Book ID is required to delete the data", "Dialog", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "Error" + e.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        bookCbox.setSelectedIndex(0);
        borrowName.setText("");
        dateBorrowed.setText("YYYY-MM-DD");
        rad1.setSelected(false);
        rad2.setSelected(false);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void lendRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lendRecordMouseClicked
        // TODO add your handling code here:
        int selectedRow = lendRecord.getSelectedRow();
        
        if(selectedRow != -1){
            String id = lendRecord.getValueAt(selectedRow, 0).toString();
            String book = lendRecord.getValueAt(selectedRow, 1).toString();
            String borrowers = lendRecord.getValueAt(selectedRow, 2).toString();
            String date = lendRecord.getValueAt(selectedRow, 3).toString();
            String status = lendRecord.getValueAt(selectedRow, 4).toString();
            
            for(int i = 0; i < bookCbox.getItemCount(); i++){
                if(bookCbox.getItemAt(i).equals(book)){
                    bookCbox.setSelectedIndex(i);
                    break;
                }
            }
            
            borrowName.setText(borrowers);
            dateBorrowed.setText(date);
            
            if(status.equals("Borrowed")){
                rad1.setSelected(true);
                rad2.setSelected(false);
            }else{
                rad1.setSelected(false);
                rad2.setSelected(true);
            }
        }
    }//GEN-LAST:event_lendRecordMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookBtn;
    private javax.swing.JComboBox<String> bookCbox;
    private javax.swing.JTextField borrowName;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField dateBorrowed;
    private javax.swing.JButton delBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lendRecord;
    private javax.swing.JRadioButton rad1;
    private javax.swing.JRadioButton rad2;
    private javax.swing.JButton subBtn;
    private javax.swing.JButton updBtn;
    // End of variables declaration//GEN-END:variables
}
