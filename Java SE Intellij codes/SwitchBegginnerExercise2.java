public class SwitchBegginnerExercise2 {
    public void marks(char mark) {
        switch (mark){
            case 'A':{
                System.out.println("Excellent");break;
            }
            case 'B':{
                System.out.println("Perfect");break;
            }
            case 'C':{
                System.out.println("Good");break;
            }
            case 'D':{
                System.out.println("Not Bad");break;
            }
            case 'E':{
                System.out.println("Bad");break;
            }
            case'F':{
                System.err.println("FAILED");break;
            }
        }
    }
}
