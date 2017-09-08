package cn.bishiti.base.test.AdvancedFeatures.variableparameter;

public class SumUtil {
	
	public static int variableSun(int i,int j){
		System.out.println("fixd parameter");
		return i+j;	
	}
	
	public static int variableSun(int ... values){
		System.out.println("variable parameter");
		int total=0;
		for(int value:values){
			total+=value;
		}
		
		return total;	
	}
	
	public static void main(String args[]){
		System.out.println(variableSun(1,2,3,4,5,6));
		
		System.out.println(variableSun(1,2));
	}
	
}
