package sort;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.pow;

public class VisualForm extends javax.swing.JFrame {

    private int n = 0;
    private int[] array = null, sorted_a = null;    //обычный и сортированный массивы
    private List list = null, sorted_l = null;      //обычный и сортированный списки
    private Graphics g;     //графика окна
    
    public VisualForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseMoved
        
    }//GEN-LAST:event_PanelMouseMoved

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //DrawTree();
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualForm().setVisible(true);
            }
        });
    }
    
    public void Draw()  //функция отрисовки всего
    {
        g = getGraphics();  //заносим в переменную текущую графику
        g.clearRect(Panel.getX(), Panel.getY(), getWidth(), getHeight());   //очищаем окно
        DrawSorted();   //"рисуем" список отсортированных элементов
        if (n > 0)
            DrawTree();     //если есть элементы в дереве - рисуем его
        Panel.paintComponents(g);   //добавляем все на панель
    }
    
    public void Init(int[] arr, int num, int[] sort)    //функция для работы с массивами
    {
        n = num;
        array = arr;
        sorted_a = sort;
        Draw();     //рисуем
    }
    
    public void Init(List li, int num, List sort)   //функция для работы со списками
    {
        n = num;
        list = li;
        sorted_l = sort;
        Draw();     //рисуем
    }
    
    private String GetElem(int n)   //получаем элемент списка/массива под индексом n
    {
        if (array != null)  //если массив
        {
            return ""+array[n];
        }
        else if (list != null)  //если список
        {
            List temp = list;
            for (int i = 1; i <= n; i++)
            {
                if (temp.next == null)
                    break;
                temp = temp.next;
            }
            return ""+temp.elem;
        }
        return "";
    }
    
    public void DrawSorted()    //рисуем отсортированные элементы
    {
        String line = "Отсортированные элементы: ";
        if (sorted_a != null)   //если массив
            for (int i: sorted_a)
                line += i + " ";
        else if (sorted_l != null)  //если список
        {
            List temp = sorted_l;
            while (temp.next != null)
            {
                line += temp.elem + " ";
                temp = temp.next;
            }
        }
        g.drawString(line, 20, 60); //рисуем
    }
    
    private void DrawTree()     //рисуем дерево
    {
        int lvl = 1, w = Panel.getWidth(), h = Panel.getY() + 50;
        while (pow(2, lvl) <= n)    //находим глубину дерева
            lvl++;
        int count = 0;      //количество нарисованных элементов
        for (int i = 1; i <= lvl; i++)
        {
            h+=40;
            int new_w = Panel.getX() + (int)(w/pow(2, i));
            for (int j = 0; j < pow(2, i-1); j++)
            {
                if (count == n) break;
                if (j != 0)
                    new_w += 2*(w/pow(2, i));
                g.setColor(Color.WHITE);        //белый цвет
                g.fillOval(new_w, h, 20, 20);   //рисуем фон
                g.setColor(Color.BLACK);        //черный цвет
                String num = GetElem(count);
                if (num.length() > 1)
                    g.drawString(num, new_w+3, h+15);   //рисуем цифры внутри
                else 
                    g.drawString(num, new_w+7, h+15);   //рисуем цифры внутри
                g.drawOval(new_w, h, 20, 20);    //рисуем окантовку
                count++;    //количество отрисованных
            }
            if (count == n) break;  //если достаточно
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables

}
