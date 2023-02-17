package ads.Blatt6;

import java.util.Arrays;
import java.util.Comparator;

public class Scheduler {


	static class Job {
		double duration;

		public double getDeadline() {
			return deadline;
		}

		double deadline;

		public Job(double duration, double deadline) {
			this.duration = duration;
			this.deadline = deadline;
		}
	}


	static class ScheduleException extends RuntimeException {
		public ScheduleException(String msg) {
			super(msg);
		}
	}


	public static Job[] scheduleGreedy(Job[] jobs) throws ScheduleException {
		Job[] newjobs = new Job[jobs.length];
		Job[] result = new Job[jobs.length];

		System.arraycopy(jobs, 0, newjobs, 0, jobs.length); //Kopie
		sortArrayByDuration(newjobs);

		for (int i = 0; i < newjobs.length - 1; i++) {
			if (newjobs[i].duration+newjobs[i+1].duration <= newjobs[i+1].deadline) {
				result[i] = newjobs[i];
			} else {
				throw new ScheduleException("error");
			}
		}
		return result;
	}

	private static void sortArrayByDuration(Job[] jobs) {
		Arrays.sort(jobs, Comparator.comparing(Job::getDeadline));
	}



	public static void main(String[] args) {
		// a small test
		Scheduler.Job[] jobs = new Scheduler.Job[]{
						new Scheduler.Job(8, 10),
						new Scheduler.Job(2, 63),
						new Scheduler.Job(4, 28),
						new Scheduler.Job(16, 28),
						new Scheduler.Job(32, 60),
		};
//        Job[] schedule = scheduleGreedy(jobs);
//        for (Job j : schedule) {
//            // System.out.println(j.deadline + " " + j.duration);
//            System.out.println(j.duration + " " + j.deadline);
//        }
		Scheduler.scheduleGreedy(jobs);
		for (Job j : jobs) {
			System.out.println(j.duration + " " + j.deadline);
		}
	}
}

