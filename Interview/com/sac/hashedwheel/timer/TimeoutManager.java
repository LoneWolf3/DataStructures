package com.sac.hashedwheel.timer;

public class TimeoutManager {

    public static final long timeAtOrigin = System.currentTimeMillis();
    static {
        System.out.println("===============\n timeAtOrigin=" + timeAtOrigin);
    }

    private static volatile Object myLock = new Object();
    private static volatile TimeoutManager timeoutManager;
    private static volatile boolean ready = false;

    public static final int TOTAL_TIME_SLOT = 60; // each minute is
    // divided into 60 slots of
    // 1 seconds each

    public static final int DEFAULT_TIMEOUT = 30 * 1000;

    private TimeoutSlot[] slots = new TimeoutSlot[TOTAL_TIME_SLOT];

    public static final int SLOT_INTERVAL_SECONDS = 60 / TOTAL_TIME_SLOT;

    public static TimeoutManager getTimeoutManager() {
        if (!ready) {
            synchronized (myLock) {
                if (!ready) {
                    timeoutManager = new TimeoutManager();
                    ready = true;
                }
            }
        }
        return timeoutManager;
    }

    private TimeoutManager() {
        initializeSlots(TOTAL_TIME_SLOT);
    }

    public void startTimeoutThread() {
        System.out.println("going to start the timeout thread");

        new Thread(new TimeoutThread()).start();
    }

    private void initializeSlots(int size) {
        for (int i = 0; i < size; i++) {
            TimeoutSlot slot = new TimeoutSlot();
            slots[i] = slot;
        }
    }

    public void insertEntry(TimeoutListener listener) {

        final long currentTime = System.currentTimeMillis();
        long timeoutTime = currentTime + DEFAULT_TIMEOUT;

        long diffFromOrigin = timeoutTime - TimeoutManager.timeAtOrigin;
        System.out.println("diffFromOrigin=" + diffFromOrigin);

        TimeoutEntry entry = new TimeoutEntry(listener, currentTime,
                timeoutTime);

        int selectedSlot = getSelectedSlot(DEFAULT_TIMEOUT);

        TimeoutSlot slot = slots[selectedSlot];
        slot.insertEntry(entry);
    }

    private int getSelectedSlot(long delay) {
        final int slotSize = slots.length;
        final long currentTime = System.currentTimeMillis();

        final long totalTime = currentTime + delay;

        long diffFromOrigin = totalTime - TimeoutManager.timeAtOrigin;
        int diffFromOriginInSec = (int) diffFromOrigin / 1000;
        System.out.println("diffFromOriginInSec = " + diffFromOriginInSec);

        int selectedSlot = (int) (diffFromOriginInSec / SLOT_INTERVAL_SECONDS)
                % slotSize;
        System.out.println("" + "selectedSlot = " + selectedSlot);

        return selectedSlot;
    }

    public void processTimeout() {
        int selectedSlot = getSelectedSlot(0);
        System.out.println("" + "going to apply timeout on SLOT = "
                + selectedSlot);

        TimeoutSlot slot = slots[selectedSlot];

        slot.processTimeout();
    }

    public void printSlots() {
        int size = slots.length;
        for (int i = 0; i < size; i++) {
            TimeoutSlot slot = slots[i];
            System.out.println("SLOT=" + i);
            slot.printEntries();
        }
    }
}

class TimeoutThread implements Runnable {
    TimeoutManager timeoutManager = TimeoutManager.getTimeoutManager();

    public void run() {
        System.out.println("starting timeout THREAD = "
                + System.currentTimeMillis());
        synchronized (this) {
            System.out.println(
                    "will wait = " + TimeoutManager.DEFAULT_TIMEOUT);
            try {
                wait(TimeoutManager.DEFAULT_TIMEOUT);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            while (true) {
                System.out.println("==== starting processing "
                        + "for timeout processing =====");
                timeoutManager.processTimeout();
                System.out.println("" + "========== "
                        + "timeout processing completing =======");

                System.out.println("will wait = " + 60 * 1000
                        / TimeoutManager.TOTAL_TIME_SLOT);
                try {
                    wait(60 * 1000 / TimeoutManager.TOTAL_TIME_SLOT);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
