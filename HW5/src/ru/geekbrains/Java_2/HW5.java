package ru.geekbrains.Java_2;

import java.util.Arrays;

public class HW5 {
	private static final int SIZE = 1000000;
	private static final int T_COUNT = 2;
	private static final int T_SIZE = SIZE/ T_COUNT;
	static float[] arr = new float[SIZE];
	private static Object mon = new Object();

    public static void main(String[] args) {
		Arrays.fill(arr, 1);
    	singleThread(arr);
		doubleThread(arr);

    }

	private static void doubleThread(float[] arr) {
    	long a = System.currentTimeMillis();
    	Thread t1 = new Thread(()-> {
    		float [] a1 = new float[T_SIZE];
    		System.arraycopy(arr,0,a1,0, T_SIZE);
			for (int i = 0; i <a1.length; i++) {
				a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
			}
			System.arraycopy(a1,0,arr,0,T_SIZE);

		});
    	Thread t2 = new Thread(()-> {
    		float [] a2 = new float[T_SIZE];
			System.arraycopy(arr,0,a2,0, T_SIZE);
			for (int i = 0; i <a2.length; i++) {
				a2[i] = (float)(a2[i] * Math.sin(0.2f + (i+arr.length/T_COUNT) / 5) * Math.cos(0.2f + (i+arr.length/T_COUNT) / 5) * Math.cos(0.4f + (i+arr.length/T_COUNT) / 2));
			}
			System.arraycopy(a2,0,arr,T_SIZE,T_SIZE);
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(System.currentTimeMillis() - a);
	}

	public static void singleThread(float[] arr){
		long a = System.currentTimeMillis();
		for (int i = 0; i <arr.length ; i++) {
			arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}
		System.out.println(System.currentTimeMillis() - a);
	}
}
