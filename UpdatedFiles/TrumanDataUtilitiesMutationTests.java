@Test(expected = IllegalArgumentException.class)
    public void test_exceptionThrown_nullDataColumns(){
    	DataUtilities.calculateColumnTotal(null, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_columnTotal_indexVeryOutofBounds(){
    	DataUtilities.calculateColumnTotal(v2dPositives, 3);
    }
    @Test
    public void test_columnTotal_secondIndex() {
    	
    	double expected = 6;
    	String msg = "Expect return 06";
    	double actual = DataUtilities.calculateColumnTotal(v2dPositives, 1);	
    	assertEquals(msg,expected, actual, .000000001d);
    	
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_exceptionThrown_nullDataRows(){
    	DataUtilities.calculateRowTotal(null, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_rowTotal_indexVeryOutofBounds(){
    	DataUtilities.calculateRowTotal(v2dPositives, 3);
    }
    @Test
    public void test_rowTotal_secondIndex() {
    	
    	double expected = 7;
    	String msg = "Expect return 7";
    	double actual = DataUtilities.calculateRowTotal(v2dPositives, 1);	
    	assertEquals(msg,expected, actual, .000000001d);
    	
    }