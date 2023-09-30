public class MultiDimentionalArrays2 {
        public static void main(String[] args){
            int[] array=new int[4];
            int[][] array2=new int[2][];
           int[] m1={4,1,88,3,2};
            int[] m2={9,4,13,18};
          array2[0]=m1;
          array2[1]=m2;

//?

            for (int[] i: array2){
                for(int j:i){
                    System.out.print(j+" ");

                }
                System.out.println();
                System.out.println("--------------------");}
        }
}
