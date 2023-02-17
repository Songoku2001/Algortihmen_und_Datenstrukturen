
package ads.Blatt6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SchedulerTest {

	void assertArrayEquals(Scheduler.Job[] jobs1, Scheduler.Job[] jobs2) {
		assertEquals(jobs1.length, jobs2.length);
		for (int i=0; i<jobs1.length; ++i) {
			assertTrue(jobs1[i]==jobs2[i]);
		}
	}
	
	@Test (expected = Scheduler.ScheduleException.class)
	public void test1() {
		// Jobs take 15 units but one deadline is 14.
		Scheduler.Job[] jobs = new Scheduler.Job[] {
				new Scheduler.Job(10,14),
				new Scheduler.Job(5,7)
		};
		Scheduler.Job[] jobsOld = jobs.clone();
		Scheduler.Job[] plan = Scheduler.scheduleGreedy(jobs);
		// scheduleGreedy should have no side effect on jobs!
		assertArrayEquals(jobsOld, jobs);
	}

	@Test
	public void test2() {
		// these jobs can be scheduled.
		Scheduler.Job[] jobs = new Scheduler.Job[] {
				new Scheduler.Job(5,25),
				new Scheduler.Job(5,20),
				new Scheduler.Job(5,15),
				new Scheduler.Job(5,10),
				new Scheduler.Job(5,5),
		};
		Scheduler.Job[] jobsOld = jobs.clone();
		Scheduler.Job[] plan = Scheduler.scheduleGreedy(jobs);
		// scheduleGreedy should have no side effect on jobs!
		assertArrayEquals(jobsOld, jobs);
	}

	@Test
	public void test3() {
		// these jobs can be scheduled.
		Scheduler.Job[] jobs = new Scheduler.Job[] {
				new Scheduler.Job(8,10),
				new Scheduler.Job(2,63),
				new Scheduler.Job(4,28),
				new Scheduler.Job(16,28),
				new Scheduler.Job(32,60),
		};
		Scheduler.Job[] jobsOld = jobs.clone();
		Scheduler.Job[] plan = Scheduler.scheduleGreedy(jobs);
		// scheduleGreedy should have no side effect on jobs!
		assertArrayEquals(jobsOld, jobs);
	}

}
