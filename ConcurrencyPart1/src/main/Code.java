public class Code {


    /*ATM atm = new ATM(1000);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.withdraw("Max", 300);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.withdraw("Mason", 500);
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                atm.withdraw("Mark", 400);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();*/


    /* Counter counter  = new Counter();
        long before = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for ( int i = 0; i < 1000; i++){
                    counter.inc();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for ( int i = 0; i < 1000; i++){
                    counter.dec();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for ( int i = 0; i < 1000; i++){
                    counter.inc2();
                }
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for ( int i = 0; i < 1000; i++){
                    counter.dec2();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long after = System.currentTimeMillis();
        System.out.println(counter.getValue());
        System.out.println(counter.getValue2());
        System.out.println(after - before);
    */

    /*
    private static final int SIZE = 50_000_000;
    private static final int HALF = SIZE / 2;
    public static void main(String[] args) {
        startTimer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                withCurrency();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                withoutCurrency();
            }
        }).start();


    }

    private static void startTimer(){
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                 int seconds = 0;
                try {
                    while (true){
                        System.out.println(seconds++);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        timer.setDaemon(true);
        timer.start();
    }

    public static void withCurrency(){
        float[] array = new float[SIZE];
        for (int i = 0; i < SIZE; i++){
            array[i] = 1f;
        }
        long before = System.currentTimeMillis();
        float[] firstHalf = new float[HALF];
        float[] secondHalf = new float[HALF];
        System.arraycopy(array, 0, firstHalf,0, HALF);
        System.arraycopy(array, HALF, secondHalf,0, HALF);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++){
                    float f = (float) i;
                    firstHalf[i] = (float)(firstHalf[i]*Math.sin(0.2f + f/5)* Math.cos(0.2f + f / 5) * Math.cos(0.4 + f / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++){
                    float f = (float) (i+HALF);
                    secondHalf[i] = (float)(secondHalf[i]*Math.sin(0.2f + f/5)* Math.cos(0.2f + f / 5) * Math.cos(0.4 + f / 2));
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.arraycopy(firstHalf,0,array,0,HALF);
        System.arraycopy(secondHalf,0,array,HALF,HALF);
        long after = System.currentTimeMillis();
        System.out.println("withCurrency: " + (after - before));
    }

    public static void withoutCurrency(){
        float[] array = new float[SIZE];
        for (int i = 0; i < SIZE; i++){
           array[i] = 1f;
        }
        long before = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++){
            float f = (float) i;
            array[i] = (float)(array[i]*Math.sin(0.2f + f/5)* Math.cos(0.2f + f / 5) * Math.cos(0.4 + f / 2));
        }
        long after = System.currentTimeMillis();
        System.out.println("withoutCurrency: " + (after - before));
    }*/

    /*private static List<String> list;
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        //List<Integer> list3 = new ArrayList<>();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                list = new ArrayList<>();
                //System.out.println(1);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long before = System.currentTimeMillis();
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(list.size());
                long after = System.currentTimeMillis();
                System.out.println(after - before);
                //System.out.println(2);
            }
        });

        thread1.start();
        thread2.start();

        /*Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
            }
        });*/
    //thread3.start();

        /*try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());*/


        /* System.out.println("Start");
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    for (int i = 0 ; i<1000; i++){
                        if(Thread.currentThread().isInterrupted()){
                            break;
                        }
                        System.out.print(i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i<1000;i++){
            System.out.print("H");
            if(i==100){
                thread.interrupt();
            }
        }
        System.out.println("\nFinish");*/
}*/
}
