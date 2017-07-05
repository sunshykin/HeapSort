package sort;

public class HeapList extends SortBase 
{
    private List list = new List(), sorted = new List();   //список и сортированный список
    
    public HeapList(int[] array, boolean rev)  //конструктор
    {
        
        List temp = list;
        n = array.length;
        for (int i: array)
        {
            temp.elem = i;
            temp.next = new List();
            temp = temp.next;
        }
        reversed = rev;
    }
    
    @Override
    public void SetTree()   //отображение дерева
    {
        int start = n / 2 - 1;
        
        if (!form.isVisible())
            form.setVisible(true);  //отображаем форму
        for (int i = start; i >= 0; i--)
        {
            form.Init(list, n, sorted);  //отрисовываем текущее дерево
            try {Thread.sleep(1000);} catch (Exception e) { }
            if (reversed)
            {
                if (n > i*2+1 && get(i) < get(i*2+1))
                    swap(list, i, i*2+1);
                if (n > i*2+2 && get(i) < get(i*2+2))
                    swap(list, i, i*2+2);
            }
            else
            {
                if (n > i*2+1 && get(i) > get(i*2+1))
                    swap(list, i, i*2+1);
                if (n > i*2+2 && get(i) > get(i*2+2))
                    swap(list, i, i*2+2);
            }
        }
        form.Init(list, n, sorted);  //отрисовываем полученное дерево
        if (n > 0)
            AddToSort(list.elem);  //добавляем к сортированному дереву
    }
    
    @Override
    public void End()
    {
        form.dispose(); //закрываем окно
    }
    
    @Override
    public String GetResult()   //возвращаем отсортированный массив
    {
        String res = "";
        List temp = sorted;
        while (temp.next != null)
            res += temp.elem + " ";
        return res;
    }
    
    private void AddToSort(int n)   //добавляем к сортированному дереву
    {
        sorted.Add(n);
    }
    
    private int get(int num)    //функция получения элемента под индексом num
    {
        List temp = list;
        for (int i = 1; i <= num; i++)
        {
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        return temp.elem;
    }
       
    @Override
    public void del()   //удаляем первый элемент
    {
        list = list.next;
        n--;
    }
    
    public static void swap(List l, int pos1, int pos2)  //меняем местами 2 элемента в списке
    {
        List temp1 = l, temp2 = l;
        for (int i = 1; i <= pos1; i++)
        {
            if (temp1.next == null)
                break;
            temp1 = temp1.next;
        }
        for (int i = 1; i <= pos2; i++)
        {
            if (temp2.next == null)
                break;
            temp2 = temp2.next;
        }
        int t = temp1.elem;
        temp1.elem = temp2.elem;
        temp2.elem = t;
    }
    
}
