package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HeapForm extends javax.swing.JFrame {

    private char type = ' ', input = ' ';   //type - тип хранения массив/список, input - файл/форма
    private boolean reversed = false;       //обозначение для обратной сортировки
    private JTextField txt;                 //текст с формы
    private String fileline;                //текст из файла
    
    public HeapForm() {
        initComponents();
        StartInit();
    }
    
    private void StartInit()    //функция для скрытия некоторых элементов при начале работы программы
    {
        InputLabel.setVisible(false);
        FromTextFieldRadio.setVisible(false);
        FromFileRadio.setVisible(false);
        SortButton.setVisible(false);
        ReverseCheck.setVisible(false);
        ResultLabel.setVisible(false);
        SaveButton.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StructRadioGroup = new javax.swing.ButtonGroup();
        InputRadioGroup = new javax.swing.ButtonGroup();
        FileChooser = new javax.swing.JFileChooser();
        ArrayRadio = new javax.swing.JRadioButton();
        ListRadio = new javax.swing.JRadioButton();
        StructLabel = new javax.swing.JLabel();
        InputLabel = new javax.swing.JLabel();
        FromTextFieldRadio = new javax.swing.JRadioButton();
        FromFileRadio = new javax.swing.JRadioButton();
        AdditionPanel = new javax.swing.JPanel();
        SortButton = new javax.swing.JButton();
        ReverseCheck = new javax.swing.JCheckBox();
        ResultLabel = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Пирамидальная сортировка");

        StructRadioGroup.add(ArrayRadio);
        ArrayRadio.setText("Массив");
        ArrayRadio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ArrayRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArrayClicked(evt);
            }
        });

        StructRadioGroup.add(ListRadio);
        ListRadio.setText("Список");
        ListRadio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ListRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListClicked(evt);
            }
        });

        StructLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StructLabel.setText("Выберите тип структуры для хранения значений");

        InputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InputLabel.setText("Выберите способ ввода данных");

        InputRadioGroup.add(FromTextFieldRadio);
        FromTextFieldRadio.setText("Ввести вручную");
        FromTextFieldRadio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FromTextFieldRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldClicked(evt);
            }
        });

        InputRadioGroup.add(FromFileRadio);
        FromFileRadio.setText("Загрузить файл");
        FromFileRadio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FromFileRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileClicked(evt);
            }
        });

        javax.swing.GroupLayout AdditionPanelLayout = new javax.swing.GroupLayout(AdditionPanel);
        AdditionPanel.setLayout(AdditionPanelLayout);
        AdditionPanelLayout.setHorizontalGroup(
            AdditionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        AdditionPanelLayout.setVerticalGroup(
            AdditionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        SortButton.setText("Отсортировать элементы");
        SortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortBtnClicked(evt);
            }
        });

        ReverseCheck.setText("Обратный порядок сортировки");
        ReverseCheck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ReverseCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReverseClicked(evt);
            }
        });

        ResultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultLabel.setText("Результат: ");

        SaveButton.setText("Сохранить");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StructLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(FromTextFieldRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FromFileRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ArrayRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ListRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(ReverseCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AdditionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(SortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(StructLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArrayRadio)
                    .addComponent(ListRadio))
                .addGap(15, 15, 15)
                .addComponent(InputLabel)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FromTextFieldRadio)
                    .addComponent(FromFileRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdditionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReverseCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SortButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListClicked
        if (ListRadio.isSelected()) //если выбран список
        {
            if (type == ' ')    //если тип еще не выбирался, то показываем следующие элементы на форме
            {
                InputLabel.setVisible(true);        //лэйбл
                FromTextFieldRadio.setVisible(true);//флажок с формы
                FromFileRadio.setVisible(true);     //флажок из файла
            }
            type = 'l';     //устанавливаем тип list
        }
    }//GEN-LAST:event_ListClicked

    private void FileClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileClicked
        if (FromFileRadio.isSelected()) //если выбран файл
        {
            if (input == ' ') //если ввод еще не выбирался, то показываем следующие элементы на форме
            {
                ReverseCheck.setVisible(true);  //обратная сортировка
                SortButton.setVisible(true);    //кнопка сортировать
            }
            input = 'f';
            AdditionPanel.removeAll();
            AdditionPanel.paint(AdditionPanel.getGraphics());
            AdditionPanel.setLayout(new FlowLayout());
            JButton SelectButton = new JButton("Выбрать файл...");
            SelectButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                { SelectClicked(evt); }
            });
            AdditionPanel.add(SelectButton);    //добавляем кнопку выбора файла
            AdditionPanel.validate();           //отрисовываем ее на панели
        }
    }//GEN-LAST:event_FileClicked

    private void TextFieldClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldClicked
        if (FromTextFieldRadio.isSelected()) //если выбран ввод с формы
        {
            if (input == ' ') //если ввод еще не выбирался, то показываем следующие элементы на форме
            {
                ReverseCheck.setVisible(true);
                SortButton.setVisible(true);
            }
            input = 't';
            AdditionPanel.removeAll();
            AdditionPanel.validate();
            AdditionPanel.setLayout(new BorderLayout());
            JLabel name = new JLabel("Введите элементы, разделяя их пробелами");
            name.setHorizontalAlignment(0);
            AdditionPanel.add(name, BorderLayout.NORTH);    //добавляем Label
            txt = new JTextField();
            AdditionPanel.add(txt, BorderLayout.SOUTH);     //добавляем текстовое поле
            AdditionPanel.validate();           //отрисовываем
        }
    }//GEN-LAST:event_TextFieldClicked

    private void ArrayClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArrayClicked
        if (ArrayRadio.isSelected()) //если выбран массив
        {
            if (type == ' ') //если тип еще не выбирался, то показываем следующие элементы на форме
            {
                InputLabel.setVisible(true);
                FromTextFieldRadio.setVisible(true);
                FromFileRadio.setVisible(true);
            }
            type = 'a';
        }
    }//GEN-LAST:event_ArrayClicked

    private void ReverseClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReverseClicked
        if (ReverseCheck.isSelected())  //если нажат флажок обратной сортировки
            reversed = true;
        else
            reversed = false;
    }//GEN-LAST:event_ReverseClicked
    
    private void SortBtnClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortBtnClicked
        String[] nums = new String[1];  //массив для строковых значений разделенных пробелами
        int[] array = new int[1];
        try {
            if (input == 't' && !txt.getText().equals(""))  //если ввод с формы и ввод не пуст
            {
                nums = txt.getText().split(" ");    //разделяем слова, разделенные пробелами
                array = new int[nums.length];
                for (int i = 0; i < nums.length; i++)
                    array[i] = Integer.parseInt(nums[i]);   //каждое слово конвертируем в int 
            }
            else if (input == 'f' && !fileline.equals(""))  //если ввод из файла и ввод не пуст
            {
                nums = fileline.split(" ");    //разделяем слова, разделенные пробелами
                array = new int[nums.length];
                nums[0] = nums[0].substring(1);
                for (int i = 0; i < nums.length; i++)
                    array[i] = Integer.parseInt(nums[i]);   //каждое слово конвертируем в int 
            }
        }
        catch (NumberFormatException e) //Если попался символ не являющийся цифрой
        {
            DialogShow("Неверный формат вводимых данных.");
            return; //заканчиваем функцию
        }
        if (type == 'a')    //если выбран массив
        {
            HeapArray  Sorter = new HeapArray(array, reversed); //создаем сортировщик
            for (int i = 0; i <= nums.length; i++)
            {
                if (i != 0) 
                    try {Thread.sleep(3000);} catch (Exception e) { }
                Sorter.SetTree();   //отрисовываем дерево
                Sorter.del();       //удаляем первый элемент
            }
            try {Thread.sleep(3000);} catch (Exception e) { }
            Sorter.End();   //закрываем окно
            ResultLabel.setText("Результат: " + Sorter.GetResult());    //выводим результат на форму
        }
        else
        {
            HeapList  Sorter = new HeapList(array, reversed); //создаем сортировщик
            for (int i = 0; i <= nums.length; i++)
            {
                if (i != 0) 
                    try {Thread.sleep(3000);} catch (Exception e) { }
                Sorter.SetTree();   //отрисовываем дерево
                Sorter.del();       //удаляем первый элемент
            }
            try {Thread.sleep(3000);} catch (Exception e) { }
            Sorter.End();   //закрываем окно
            ResultLabel.setText("Результат: " + Sorter.GetResult());    //выводим результат на форму
        }
        ResultLabel.setVisible(true);   //Отображаем строку с результатом на форме
        SaveButton.setVisible(true);    //отображаем кнопку "сохранить"
    }//GEN-LAST:event_SortBtnClicked

    private void SaveClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveClicked
        //если была нажата кнопка сохранить
        if (FileChooser.showDialog(null, "Сохранить файл") == JFileChooser.APPROVE_OPTION) 
            //если файл был выбран
        {
            try {
                FileWriter file = new FileWriter(FileChooser.getSelectedFile().getPath());
                file.write(ResultLabel.getText());  //записываем в файл
                file.close();
                DialogShow("Результат сохраннен в файл.");
            } catch (IOException ex) {  //если произошла ошибка
                DialogShow("Произошла ошибка.");
            }
        }
    }//GEN-LAST:event_SaveClicked
    
    private void DialogShow(String msg)
    {
        JOptionPane.showMessageDialog(null, msg, 
                "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void SelectClicked(java.awt.event.ActionEvent evt) {
        //Если была нажата кнопка "Выбрать файл"
        if (FileChooser.showDialog(null, "Открыть файл") == JFileChooser.APPROVE_OPTION) 
        {
            try {
                FileReader file = new FileReader(FileChooser.getSelectedFile().getPath());
                BufferedReader br = new BufferedReader(file);
                fileline = br.readLine();   //читаем строку из файла
            } catch (Exception ex) {    //если ошибка
                DialogShow("Произошла ошибка.");
            }
        }
    }                            

    
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
            java.util.logging.Logger.getLogger(HeapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HeapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HeapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HeapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HeapForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdditionPanel;
    private javax.swing.JRadioButton ArrayRadio;
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JRadioButton FromFileRadio;
    private javax.swing.JRadioButton FromTextFieldRadio;
    private javax.swing.JLabel InputLabel;
    private javax.swing.ButtonGroup InputRadioGroup;
    private javax.swing.JRadioButton ListRadio;
    private javax.swing.JLabel ResultLabel;
    private javax.swing.JCheckBox ReverseCheck;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SortButton;
    private javax.swing.JLabel StructLabel;
    private javax.swing.ButtonGroup StructRadioGroup;
    // End of variables declaration//GEN-END:variables
}
