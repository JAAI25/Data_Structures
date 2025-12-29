//Doubly   Linear

class node
{
    public int data;
    public node next;
    public node prev;

    public node(int no)
    {
        this.data = no;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLL
{
    private node first;
    
    private int iCount;

    public DoublyLL()
    {
        System.out.println("Object of DoublyLL gets created.");
        this.first = null;
        this.iCount = 0;
    }

    public void InsertFirst(int no)
    {
        node newn = null;
        newn = new node(no);
    

        if(this.first == null)
        {
            this.first = newn;
        }
        else
        {
            newn.next = first;
            this.first.prev = newn;
            this.first = newn; 
            
        }
        this.iCount++;
    }

    public void InsertLast(int no)
    {
        node newn = null;
        node temp = null;

        newn = new node(no);

        if(this.first == null)
        {
            this.first = newn;
        }
        else
        {
            temp = this.first;

            while(temp.next != null)
            {
                temp = temp.next;
            }
            
            newn.prev = temp;
            temp.next = newn;
        }
        this.iCount++;
    }

   

    public void DeleteFirst()
    {
        if(this.first == null)
        {
            return;
        }
        else if(this.first.next == null)
        {
            this.first = null; 
        }
        else
        {
            this.first = this.first.next;
            this.first.prev = null;
        }
        System.gc();
        iCount--;
    }

    public void DeleteLast()
    {
        node temp = null;

        if(this.first == null)
        {
            return;
        }
        else if(this.first.next == null)
        {
            this.first = null;
        }
        else
        {
            temp = this.first;

            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next.prev = null;
        }
        System.gc();
        iCount--; 
    }

    public void Display()
    {
        node temp = null;

        temp = this.first;

        System.out.print("null<=>");
        while(temp != null)
        {
            System.out.print(" |" +temp.data+ " |<=>");
            temp = temp.next;
        }
        System.out.print("null\n");

    }

    public int Count()
    {
        return this.iCount;
    }

    public void InsertAtPos(int no, int pos)
    {
        node temp = null;
        node newn = null;
        int iCnt = 0;
        if(pos < 1 || pos > iCount + 1)
        {
            System.out.println("Invalid position.");
            return;
        }

        if(pos == 1)
        {
            this.InsertFirst(no);
        }
        else if(pos == iCount + 1)
        {
            this.InsertLast(no);
        }
        else
        {
            newn = new node(no);
            
            temp = this.first;
            for(iCnt = 1; iCnt <pos-1; iCnt++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            newn.prev = temp;

            temp.next.prev = newn;
            temp.next = newn;

            this.iCount++;

        }
       
    }

    public void DeleteAtPos(int pos)
    {
        node temp = null;
        node target = null;

        int iCnt = 0;

        if(pos < 1 || pos > iCount)
        {
            System.out.println("Invalid position.");
            return;
        }

        if(pos == 1)
        {
            this.DeleteFirst();
        }
        else if(pos == iCount)
        {
            this.DeleteLast();
        }
        else
        {
            temp = this.first;
            for(iCnt = 1; iCnt < pos-1;iCnt++)
            {
                temp = temp.next;
            }
            target = temp.next;
            temp.next = target.next;
            target.next.prev = temp;

            this.iCount--;
        }
        System.gc(); 
    }
}

class program450
{
    public static void main(String A[])
    {
        int iRet = 0;
        DoublyLL obj = null;

        obj = new DoublyLL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are :"+iRet);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.InsertLast(121);

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are :"+iRet);

        obj.DeleteFirst();

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are :"+iRet);

        obj.DeleteLast();

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are :"+iRet);

        obj.InsertAtPos(105,4);

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are :"+iRet);

        obj.DeleteAtPos(4);

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are :"+iRet);

        //Important for memory deallocation
        obj = null;
        System.gc();
    }
}