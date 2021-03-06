/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golden;

/**
 *
 * @author samer
 */
public class ReaderThread implements Runnable {

    private Context ctx;

    public ReaderThread(Context ctx) {
        this.ctx = ctx;
    }

    public void run() {
        try {
            read();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void read() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                ctx.sem.acquire(1);
                ctx.mutex.acquire();
                System.out.println(Thread.currentThread().getName() + ": " + ctx.remove());
                ctx.mutex.release();
                Thread.sleep(750);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            //@todo here adding rand from 500 - 2000 ms      
        }

    }

//        while (!ctx.isEmpty()) {
//                try {
//                    mutex.acquire();
//                    try {
//                        System.out.println(Thread.currentThread().getName() + ": " + ctx.remove());
//                        Thread.sleep(750);
//                    } finally {
//                        mutex.release();
//                    }
//                } catch (InterruptedException ie) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }
}
