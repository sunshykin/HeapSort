package sort;


public abstract class SortBase implements ISort
{
    protected boolean reversed;           //обратная сортировка
    protected int n;          //кол-во элементов
    protected VisualForm form = new VisualForm(); //форма для отображения
}
