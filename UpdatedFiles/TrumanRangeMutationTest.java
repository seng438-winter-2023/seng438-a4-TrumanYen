//Range constructor;
@Test
    public void test_constructor_exception_message() {
    	double lower = 20;
    	double upper = 0;
    	try {
    		Range testRange = new Range(lower,upper);
    	}
    	catch(IllegalArgumentException e) {
    		String msg = "Range(double, double): require lower (" + lower+ ") <= upper (" + upper + ").";
    				 

    		assertEquals(msg, e.getMessage() );
    	}
    }