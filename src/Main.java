import java.lang.*;

public class Main {

    public static void main(String[] args) {
	// creating new tasks
        Runnable guiTask = new taskClass(' ', 300, 0); //simulated gui thread
        Runnable wpTask= new taskClass('a',1000,1);
        Runnable dsTask= new taskClass('a', 2500, 2);
        Runnable prTask= new taskClass('b', 3600,3);
        // wrapping threads
        Thread guiThread = new Thread(guiTask);
        Thread wpThread = new Thread(wpTask);
        Thread dsThread= new Thread(dsTask);
        Thread prThread= new Thread(prTask);
        //priorities set
        guiThread.setPriority(Thread.MAX_PRIORITY);
        wpThread.setPriority(Thread.MAX_PRIORITY);
        dsThread.setPriority(Thread.MAX_PRIORITY);
        prThread.setPriority(Thread.MAX_PRIORITY);
        //run the threads
        guiThread.start();
        wpThread.start();
        dsThread.start();
        prThread.start();
    }
}

class taskClass implements Runnable{
    private char aChar;
    private int times;
    private int type;//0 is gui, 1 is WP, 2 is dsd, 3 is printer
    taskClass(char myChar, int howMany, int type){
        this.aChar=myChar;
        this.times=howMany;
        this.type=type;//o
    }
    public void run(){
        if (this.type==0){//GUI poll
            for (int i=1; i<=times*2;i++){
                System.out.println("GUI POLL " + i);
                if (i%2==0){
                    System.out.println();
                    Thread.yield();
                }
            }
        }
        if (this.type==1){//Thread stuff for Word Processor
            for (int i=1; i<=this.times;i++){
                System.out.print(this.aChar);
                if (i%10==0){
                    System.out.println();
                    Thread.yield();
                }
            }
        }
        if (this.type==2){//thread stuff for Data Storage
            for(int i=1; i<=this.times; i++){
                System.out.print("DS:"+ i);
                if (i%60==0){
                    System.out.println();
                    Thread.yield();
                }
            }
        }
        if (this.type==3){
            for (int i=1; i<this.times; i++){
                System.out.print("Print Line: "+i+" chars AA thru BB");
                if (i%6==0){
                    System.out.println();
                    Thread.yield();
                }
            }
        }

    }
}