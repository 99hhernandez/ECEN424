public class Calculator {
	private String name;                                //object name
	
	public Float addition(Float A, Float B){            //addition function
		return A+B;
	}
	public Float subtraction(Float A, Float B){         //subtraction function
		return A-B;
	}
	public Float multiplication(Float A, Float B){      //multiplication function
		return A*B;
	}
	public void setname(String N){                      //set object name
        	this.name = N;
  	}
	public String getname(){                            //get object name
        	return name;
  	}
}
