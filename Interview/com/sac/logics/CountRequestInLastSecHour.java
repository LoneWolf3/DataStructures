package com.sac.logics;

import java.sql.Time;
import java.util.concurrent.atomic.AtomicLong;

/**
 * http://blog.gainlo.co/index.php/2016/09/12/dropbox-interview-design-hit-counter/?utm_source=glassdoor&utm_campaign=glassdoor&utm_medium=92116
 *
 *
 * 
 * To do this for time window of T seconds, have a queue data structure where
 * you queue the timestamps of individual requests as they arrive. When you want
 * to read the number of requests arrived during the most recent window of T
 * seconds, first drop from the "old" end of the queue those timestamps that are
 * older than T seconds, then read the size of the queue. You should also drop
 * elements whenever you add a new request to the queue to keep its size bounded
 * (assuming bounded rate for incoming requests).
 * 
 * This solution works up to arbitrary precision, e.g. millisecond accuracy. If
 * you are content with returning approximate answers, you can e.g. for time
 * window of T = 3600 (an hour), consolidate requests coming within same second
 * into a single queue element, making queue size bounded by 3600. I think that
 * would be more than fine, but theoretically loses accuracy. For T = 1, you can
 * do consolidation on millisecond level if you want.
 * 
 * In pseudocode:
 * 
 * queue Q
 * 
 * proc requestReceived() Q.insertAtFront(now()) collectGarbage()
 * 
 * proc collectGarbage() limit = now() - T while (! Q.empty() && Q.lastElement()
 * < limit) Q.popLast()
 * 
 * proc count() collectGarbage() return Q.size()
 */
public class CountRequestInLastSecHour {

}