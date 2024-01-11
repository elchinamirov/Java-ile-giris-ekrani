public class MultiDimentionalArrays {
public static void main(String[] args){
   int[] array=new int[4];
   int[][] array2=new int[2][3];
   array2[0][0]=23;
    array2[0][1]=24;
    array2[0][2]=25;

    array2[1][0]=26;
    array2[1][1]=27;
    array2[1][2]=28;
    for (int[] i: array2){
        for(int j:i){
            System.out.print(j+" ");

    }
        System.out.println();
        System.out.println("--------------------");}
}



}
