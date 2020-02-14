
import java.util.*;

public class Sorts{
    private long steps;

    /**
     *  Description of Constructor
     *
     * @param  list  Description of Parameter
     */
    public Sorts(){
        steps = 0;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(ArrayList <Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();

        steps = 0;
        for (int outer = 0; outer < list.size() - 1; outer++){
            for (int inner = 0; inner < list.size()-outer-1; inner++){
                steps += 3;//count one compare and 2 gets
                if (list.get(inner)>(list.get(inner + 1))){
                    steps += 4;//count 2 gets and 2 sets
                    int temp = list.get(inner);
                    list.set(inner,list.get(inner + 1));
                    list.set(inner + 1,temp);
                }
            }
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(ArrayList <Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();
        int n = list.size();
        
        /* a[0] to a[n-1] is the array to sort */
        for (int j = 0; j < n-1; j++)
        {
            /* find the min element in the unsorted a[j .. n-1] */
        
            /* assume the min is the first element */
            int iMin = j;
            /* test against elements after j to find the smallest */
            for (int i = j+1; i < n; i++)
            {
                /* if this element is less, then it is the new minimum */
                steps++;
                if (list.get(i) < list.get(iMin))
                {
                    /* found new minimum; remember its index */
                    iMin = i;
                }
            }
            steps++;
            int temp = list.get(j);
            list.set(j, list.get(iMin));
            list.set(iMin, temp);
            
        }
        
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(ArrayList <Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();
        
        int i = 1;
        
        while (i < list.size()) {
            int x = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > x) {
                steps++;
                list.set(j,list.get(j+1));
                j -= 1;
            }
            list.set(j+1, x);
            i++;
            steps++;
            
        }
        
    }

    public void mergeSort(ArrayList<Integer> list, int start, int end){
        if((end - start) >= 2){
            int mid = (end - start)/2;
            mergeSort(list, start, start + mid);
            mergeSort(list, start + mid +1, end);
            steps++;
            int i=start;
            int j=start + mid +1;
            while(i<j && j<=end){
                steps++;
                if(list.get(i) > list.get(j)){
                    list.add(i, list.remove(j));
                    i++;
                    j++;
                }else if(list.get(i) == list.get(j)){
                    list.add(i+1, list.remove(j));
                    i++;
                    j++;
                }else{
                    i++;
                }
            }  

        }else{
            if(end > start){
                steps++;
                if(list.get(start) > list.get(end)){
                    int endValue = list.remove(end);
                    steps++;
                    list.add(start, endValue);
                }                
            }
        }
    }
    
    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount(){
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount){
        steps = stepCount;
    }
}
