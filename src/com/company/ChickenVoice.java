package com.company;

class EggVoice extends Thread
{
    @Override
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            try{
                sleep(500);
            }catch(InterruptedException ignore){}

            System.out.println("яйцо");
        }

    }
}

public class ChickenVoice
{
    static EggVoice egg;

    public static void main(String[] args)
    {
        egg = new EggVoice();
        System.out.println("Спор начат...");
        egg.start();

        for(int i = 0; i < 10; i++)
        {
            try{
                Thread.sleep(500);
            }catch(InterruptedException ignore){}

            System.out.println("курица");
        }

        if(egg.isAlive())
        {
            try{
                egg.join();
            }catch(InterruptedException ignore){}

            System.out.println("Первым появилось яйцо");
        }
        else
        {
            System.out.println("Первой появилась курица");
        }
        System.out.println("Спор закончен!");
    }
}