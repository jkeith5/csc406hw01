import java.lang.*;

public class Main {

    public static void main(String[] args) {
	// creating new tasks
        Runnable guiTask = new taskClass(' ', 300, 0); //simulated gui thread
        Runnable wpTask= new taskClass('a',1000,1);


        // wrapping threads


        //priorities set


        //run the threads

    }
}

class taskClass implements Runnable{
    private char aChar;
    private int times;
    private int type;//0 is gui, 1 is WP, 2 is dsd, 3 is printer
    public taskClass(char myChar, int howMany, int type){
        this.aChar=myChar;
        this.times=howMany;
        this.type=type;//o
    }
    public void run(){
        if (this.type==0){
            for (int i=0; i<times*2;i++){
                System.out.println("GUI POLL " + i);
                if (i%2==0){
                    System.out.println();
                    Thread.yield();
                }
            }
        }
        if (this.type==1){
            for (int i=0; i<this.times;i++){
                System.out.print(this.aChar);
                if (i%10==0){
                    System.out.println();
                    Thread.yield();
                }
            }
        }
        if (this.type==2){

        }

    }
}