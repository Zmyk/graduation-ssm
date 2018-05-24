/**
 * 
 */
package utils;

import java.util.Collection;
import java.util.HashMap;

import com.aliyuncs.exceptions.ClientException;

/**
 * @author zhang
 *
 */
public class test {

	/**
	 * @param args
	 * @throws ClientException 
	 */
	public static void GetV(int[] gray) {
		HashMap<Integer,Integer> number = new HashMap<Integer,Integer>();
		for(int i = 0;i<gray.length;i++){
			if (number.containsKey(gray[i])){
				int temp = number.get(gray[i]);
				number.put(gray[i],temp+1);
			}else{
				number.put(gray[i],1);
			}
		}
		Collection<Integer> number_key = number.keySet();
		int maxCount = 0;
		HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
		for (Integer integer : number_key) {
			if(number.get(integer)>maxCount){
				result.clear();
				maxCount = number.get(integer);
				result.put(integer, number.get(integer));
			}
			else if(number.get(integer)==maxCount){
				result.put(integer, number.get(integer));
			}
		}
		Collection<Integer> result_key = result.keySet();
		int i = 1;
		for (Integer integer : result_key) {
			System.out.println("出现次数最多的第"+i+"个数字是:"+integer+","+"出现次数为:"+result.get(integer));
			i++;
		}
		
	}

	
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,4,4,5,5,5,6,6,6};
		GetV(a);
	}

}
