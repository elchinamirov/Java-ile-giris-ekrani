public class SwitchPractice {

    public void example(int point) {
        if (point==2){
            System.out.println("pis");
        } else if (point==10) {
            System.out.println("ela");
        }else{
            System.err.println("Melumat yoxdur");
        }

    }
    public void exampleWithSwitch(int point) {
        switch (point){
            case 2: {System.out.println("pis");break;
        }
            case 3: {System.out.println("kafi");break;
            }
            case 4:{
                System.out.println("yaxsi");break;
            }
            case 5:{
                System.out.println("ELA");break;
            }
            default:{
                System.err.println("Melumat yoxdur");break;
            }
        }}}