package research;
/*
 * Written by Alex Goslen 2017
 * */
public class TimeKeeper {
	protected  long startTime;
	protected  long lastTime;
	protected  long now;
	protected double elapsed;
	protected long displayTime;
	
	public TimeKeeper(long startTime) {
		this.startTime = startTime;
		lastTime = 0;
		now = 0;
		elapsed = 0;
	}
	
	
	public double changeInTime() {
		now = System.currentTimeMillis();
        elapsed = (now - lastTime) / 1000.0;
        lastTime = now;
        return elapsed;
	}


	public long getStartTime() {
		return startTime;
	}


	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}


	public long getLastTime() {
		return lastTime;
	}


	public void setLastTime(long lastTime) {
		this.lastTime = lastTime;
	}


	public long getNow() {
		return now;
	}


	public void setNow(long now) {
		this.now = now;
	}


	public double getElapsed() {
		return elapsed;
	}


	public void setElapsed(double elapsed) {
		this.elapsed = elapsed;
	}
	
	public long getDisplayTime() {
		return displayTime;
	}


	public void setDisplayTime(long displayTime) {
		this.displayTime = displayTime;
	}
	
	

}
