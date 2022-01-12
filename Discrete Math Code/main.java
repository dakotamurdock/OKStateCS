//Problem 2 algorithm I worked on in Java

//Problem Statement: Write an algorithm that takes as input a list of n distinct integers and finds the location of the
// largest even integer in the list or returns 0 if there are no even integers in the list.

public class main{
    public static void main(String[] args) {
        int[] input_list = new int[]{1, 1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 9, 9};
        int[] dup_list = new int[input_list.length];
        int i = 1;
        int j = 0;
        while(i < input_list.length){
            if(input_list[i] == input_list[i - 1]){
                dup_list[j] = input_list[i];
                ++j;
                while(i < input_list.length - 2 && input_list[i]==input_list[i+1]){
                    ++i;
                }
            }
            ++i;
        }
        for(int k=0; k < dup_list.length; ++k) {
            System.out.print(dup_list[k]);
        }
    }
}

// Problem 3 algorithm I worked on in Java

// Problem Statement: Write an algorithm that takes as input a list of n integers in nondecreasing order and produces
// the list of all values that occur more than once. (Note: a list of integers is nondecreasing if each integer in the
// list is at least as large as the previous integer in the list.)

//public class main{
//    public static void main(String[] args) {
//        int[] input_list = new int[]{99, 28, 11, 3, 4, 15, 87, 62, 5, 55, 38};
//
//        int i = 0;
//        int position = 0;
//        int big_even = -2147483648;
//        while(i < input_list.length){
//            if(input_list[i] % 2 == 0){
//                if(input_list[i] > big_even){
//                    big_even = input_list[i];
//                    position = i;
//                }
//            }
//            ++i;
//        }
//
//        System.out.println(position);
//
//    }
//}


