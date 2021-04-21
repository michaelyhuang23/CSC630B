import java.util.*;
class PhoneCall {
	int startHour;
	int startMin;
	int duration;

	public PhoneCall(int startHour, int startMin, int duration) {
		this.startHour = startHour;
		this.startMin = startMin;
		this.duration = duration;
	}

	public int getStartHour() {
		return startHour;
	}

	public int getStartMin() {
		return startMin;
	}

	public int getDuration() {
		return duration;
	}
}

public class Exercise3 {
	public static int busiestHour(List<PhoneCall> dayCalls) {
		int[] counts = new int[24];
		for (PhoneCall call : dayCalls) {
			if (call.getDuration() >= 30)
				counts[call.getStartHour()]++;
		}
		int maxCount = 0;
		int maxIndex = 0;
		int i = 0;
		for (int count : counts) {
			if (count > maxCount) {
				maxCount = count;
				maxIndex = i;
			}
			i++;
		}
		return maxIndex;
	}
	
	public static void main(String[] args) {
		List<PhoneCall> list=new ArrayList<PhoneCall>();
		Random rand=new Random();
		for(int i=0;i<10000000;i++) 
			list.add(new PhoneCall(rand.nextInt(24),rand.nextInt(60),1+rand.nextInt(1000)));
		System.out.println(busiestHour(list));
	}
}
