package cdi;

import javax.inject.Named;

import org.springframework.stereotype.Repository;

@Named
@Repository
public class SomeCdiDao {
	
	public int[] getData() {
		return new int[] {5, 89,100};
	}

}