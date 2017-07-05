package sort;


public class HeapArray extends SortBase  //сортировка для массива
{
    private int[] arr, sorted = null;   //массив и сортированный массив
    
    public HeapArray(int[] array, boolean rev)  //конструктор
    {
        arr = array;
        n = array.length;
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
            form.Init(arr, n, sorted);  //отрисовываем текущее дерево
            try {Thread.sleep(1000);} catch (Exception e) { }
            if (reversed)
            {
                if (n > i*2+1 && arr[i] < arr[i*2+1])
                    swap(arr, i, i*2+1);
                if (n > i*2+2 && arr[i] < arr[i*2+2])
                    swap(arr, i, i*2+2);
            }
            else
            {
                if (n > i*2+1 && arr[i] > arr[i*2+1])
                    swap(arr, i, i*2+1);
                if (n > i*2+2 && arr[i] > arr[i*2+2])
                    swap(arr, i, i*2+2);
            }
        }
           
        form.Init(arr, n, sorted);  //отрисовываем полученное дерево
        if (sorted != null)
        { 
            if (n > 0)
                AddToSort(arr[0]);  //добавляем к сортированному дереву
        }
        else
        {
            sorted = new int[1];
            sorted[0] = arr[0];   //добавляем к сортированному дереву первый элемент
        }
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
        for (int i: sorted)
            res += i+" ";
        return res;
    }
    
    private void AddToSort(int n)   //добавляем к сортированному дереву
    {
        int[] temp = new int[sorted.length + 1];    //увеличиваем массив на 1 элемент
        for (int i = 0; i < sorted.length; i++)
            temp[i] = sorted[i];    //переносим старые элементы
        temp[sorted.length] = n;    //добавляем новый
        sorted = temp;
    }
    
    @Override
    public void del()   //удаляем первый элемент
    {
        if (n > 1)  //если больше 1 элемента осталось
        {
            int[] temp = new int[n-1];  //уменьшаем на 1 элемент
            for (int i = 1; i < n; i++)
                temp[i-1] = arr[i];     //копируем старые элементы
            arr = temp;
        }
        else
            arr = null;
        n--;    //уменьшаем кол-во элементов
    }
    
    public static void swap(int[] arr, int pos1, int pos2)  //меняем местами 2 элемента в массиве
    {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
    
}
