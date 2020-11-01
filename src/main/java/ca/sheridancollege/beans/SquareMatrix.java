package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquareMatrix implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1161108354409402235L;
	
	private int length;
}
