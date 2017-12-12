package com.sac.hashedwheel.timer;

import java.util.LinkedList;

public class TimeoutSlot {

    private final LinkedList<TimeoutEntry> list = new LinkedList<TimeoutEntry>();

    public synchronized void processTimeout() {
        System.out.println("-------TimeoutSlot-------------");
        long currentTime = System.currentTimeMillis();
        System.out.println("-------TimeoutSlot currentTime=" + currentTime);
        LinkedList<TimeoutEntry> timeoutList = new LinkedList<TimeoutEntry>();
        while (true) {
            int size = list.size();
            System.out.println("-------TimeoutSlot size=" + size);
            if (list.size() == 0) {
                break;
            }
            TimeoutEntry entry = list.removeFirst();
            if (entry != null) {
                long timeout = entry.getTimeoutTime();
                int diff = (int) Math.abs(timeout - currentTime) / 1000;
                System.out.println("-------TimeoutSlot diff = " + diff);
                if (currentTime > timeout
                        || diff < (60 / TimeoutManager.TOTAL_TIME_SLOT)) {
                    timeoutList.addLast(entry);
                } else {
                    list.addFirst(entry);
                    break;
                }
            } else {
                break;
            }
        }
        if (timeoutList.size() > 0) {
            TimeoutHandler handler = new TimeoutHandler(timeoutList);
            new Thread(handler).start();
        }
    }

    public synchronized void insertEntry(TimeoutEntry entry) {
        list.addLast(entry);
    }

    public synchronized void printEntries() {
        final int size = list.size();
        for (int i = 0; i < size; i++) {
            TimeoutEntry entry = list.get(i);
            entry.printEntry();
        }
    }

    class TimeoutHandler implements Runnable {
        private LinkedList<TimeoutEntry> timeoutList = null;

        TimeoutHandler(LinkedList<TimeoutEntry> timeoutList) {
            this.timeoutList = timeoutList;
        }

        public void run() {
            final int size = timeoutList.size();
            System.out
                    .println("-------TimeoutHandler timeoutList.size=" + size);
            for (int i = 0; i < size; i++) {
                TimeoutEntry entry = timeoutList.get(i);
                TimeoutListener listener = entry.getListener();
                listener.timeout();
            }
        }
    }
}
