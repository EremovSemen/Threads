public class Task1 {

     volatile int num = 1;

    public  synchronized void stage1() {

//            if(num1 == num2) {
        if(num != 1){
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(num == 1) {
            System.out.println("A");
            num = 2;
            notify();
        }



//                num1++;
//                if(num1 > num2 & num1 > num3) {
//                    notify();
//                }
//                if(num1 != num2 || num1 != num3) {
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
    }


    public synchronized void stage2() {
//            if(num2< num1) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(num != 2){
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(num == 2) {
            System.out.println("B");
            num = 3;
            notify();
        }


//                num2++;
//                if( num2 > num3 & num2 == num1) {
//                    notify();
//                }
//                if (num2 == num1 & num2 > num3) {
//                    try {
//                        wait();
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
    }

    public synchronized void stage3() {
//            if( num3 < num2) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(num != 3){
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (num == 3) {
            System.out.println("C");
            num = 1;
            notify();
        }







//                num3++;
//                if(num3 == num1 & num3 == num2) {
//                    notify();
//                }
//                if(num3 == num2 ) {
//                    try {
//                        wait();
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

//            }

    }



    public static void main(String[] args) {
        Task1 task1 = new Task1();
      new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                task1.stage1();

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                task1.stage2();

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                task1.stage3();

            }
        }).start();


    }



}
