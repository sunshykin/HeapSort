package sort;

public class List {
    int elem;
    List next;
    
    public void Add(int n)  //функция добавления элемента в конец списка
    {
        List temp = this;
        while (temp.next != null)   //идем до конца списка
            temp = temp.next;
        temp.elem = n;  //добавляем
        temp.next = new List();
    }
}
