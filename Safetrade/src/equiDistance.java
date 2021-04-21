
public class equiDistance {
	public static boolean sameDistance(Place p1, Place p2, Place p3) {
		return p1.distance(p2)==p1.distance(p3);
	}
	public static void main(String[] arg) {
		Place p1=new Museum(1,2,3);
		Place p2=new Museum(2,3,4);
		Place p3=new Museum(4,5,6);
		System.out.println(p2.distance(p3));
		System.out.println(equiDistance.sameDistance(p1, p2, p3));
	}
}
