package ca.sheridancollege.beans;

import java.io.Serializable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StringForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8417007921451046314L;
	
	private String string;

}
