package main.java.com.splitwiseV2.dao;

public interface Savable {

	public default boolean save() {
		try {
			//TODO: Actual Implementation to save the relevant Objects into Database
			System.out.println(this.getClass()+" saved.");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
