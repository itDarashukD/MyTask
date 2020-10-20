package Multiheading;

import java.util.concurrent.Semaphore;

//Задача про 5 философов которым нудно поесть,если есть только 2 стула.Они не долны заблокировать друг друга!
public class Filosov extends Thread {

    private boolean eatOff = false; //уже поесл
    private String nameFilosof;
    private Semaphore semafor;

    public Filosov(String nameFilosof, Semaphore semafor) {

        this.nameFilosof = nameFilosof;
        this.semafor = semafor;

    }

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);//количество потоков,одновременно запускаэщихся в мьтекс(количество стульев)

        new Filosov("Сократ", semaphore).start();
        new Filosov("Арестотель", semaphore).start();
        new Filosov("Кант", semaphore).start();
        new Filosov("Юнг", semaphore).start();
        new Filosov("Ницше", semaphore).start();
    }

    public void run() {

        if (!eatOff) {
            try {
                semafor.acquire();

                System.out.println(nameFilosof + " сел поесть ");
                Thread.sleep(2000);

                System.out.println(" филосов " + nameFilosof + " ест");
                Thread.sleep(2000);
                eatOff = true;


                System.out.println(nameFilosof + "   поел и выходит из-за стола  ");
                semafor.release();
                Thread.sleep(2000);


            } catch (InterruptedException e) {
                System.out.println("Что-то пошло не так");
            }

        }

    }
}

