public class SwitchBegginnerExercise3 {
    public void colors(String color){
        switch (color){
            case "Red":{
                System.out.println("Apple");break;
            }
            case "Blue":{
                System.out.println("Sky");break;
            }
            case "Green":{
                System.out.println("Grass");break;
            }
            default:{
                System.err.println("'There is no information'");
            }
        }

    }
}
