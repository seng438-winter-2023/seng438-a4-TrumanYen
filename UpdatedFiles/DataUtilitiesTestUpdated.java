package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.*;
import org.junit.*;
import org.jmock.*;
import static org.hamcrest.Matchers.*;


public class DataUtilitiesTest{

	// all the values that we will need for DataUtilitiesTest
	
	private KeyedValues values1;
	private KeyedValues values2;
    	private KeyedValues values3;
    	private KeyedValues values4;
    	private KeyedValues values5;
	private Values2D v2dPositives;
	private Values2D v2dNegatives;
	private Values2D v2dZeroes;
	private Values2D v2dDecimals;
	private Values2D v2dNulls;
	private Values2D v2dEmpty;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception { 

    	// setup of mock objects that are used throughout tests

        Mockery mockingContext = new Mockery();
        
        values1 = mockingContext.mock(KeyedValues.class, "values1");
        values2 = mockingContext.mock(KeyedValues.class, "values2");
        values3 = mockingContext.mock(KeyedValues.class, "values3");
	values4 = mockingContext.mock(KeyedValues.class, "values4");
        values5 = mockingContext.mock(KeyedValues.class, "values5");
        
        v2dPositives = mockingContext.mock(Values2D.class, "v2dPositives");
        v2dNegatives = mockingContext.mock(Values2D.class, "v2dNegatives");
        v2dZeroes = mockingContext.mock(Values2D.class, "v2dZeroes");
        v2dDecimals = mockingContext.mock(Values2D.class, "v2dDecimals");
        v2dNulls = mockingContext.mock(Values2D.class, "v2dNulls");
        v2dEmpty = mockingContext.mock(Values2D.class, "v2dEmpty");
        
        Integer[][] arr1 = {{1,2},{3,4}};
        Integer[][] arr2 = {{-1,-2},{-3,-4}};
        Double[][] arr3 = {{0.1,0.2},{0.3,0.4}};
        
        	
        mockingContext.checking(new Expectations() {
            {
            	//Initializing Value2D mocks
            	allowing(v2dPositives).getColumnCount();
                will(returnValue(2));
                allowing(v2dPositives).getRowCount();
                will(returnValue(2));
                allowing(v2dPositives).getValue(0,0);
                will(returnValue(arr1[0][0]));
                allowing(v2dPositives).getValue(0,1);
                will(returnValue(arr1[0][1]));
                allowing(v2dPositives).getValue(1,0);
                will(returnValue(arr1[1][0]));
                allowing(v2dPositives).getValue(1,1);
                will(returnValue(arr1[1][1]));
                allowing(v2dPositives).getValue(with(lessThan(0)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dPositives).getValue(with(greaterThan(1)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dPositives).getValue(with(any(int.class)),with(lessThan(0)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dPositives).getValue(with(any(int.class)),with(greaterThan(1)));
                will(throwException(new IndexOutOfBoundsException()));
                
                allowing(v2dNegatives).getColumnCount();
                will(returnValue(2));
                allowing(v2dNegatives).getRowCount();
                will(returnValue(2));
                allowing(v2dNegatives).getValue(0,0);
                will(returnValue(arr2[0][0]));
                allowing(v2dNegatives).getValue(0,1);
                will(returnValue(arr2[0][1]));
                allowing(v2dNegatives).getValue(1,0);
                will(returnValue(arr2[1][0]));
                allowing(v2dNegatives).getValue(1,1);
                will(returnValue(arr2[1][1]));
                allowing(v2dNegatives).getValue(with(lessThan(0)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dNegatives).getValue(with(greaterThan(1)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dNegatives).getValue(with(any(int.class)),with(lessThan(0)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dNegatives).getValue(with(any(int.class)),with(greaterThan(1)));
                will(throwException(new IndexOutOfBoundsException()));
                
                allowing(v2dZeroes).getColumnCount();
                will(returnValue(2));
                allowing(v2dZeroes).getRowCount();
                will(returnValue(2));
                allowing(v2dZeroes).getValue(0,0);
                will(returnValue(0));
                allowing(v2dZeroes).getValue(0,1);
                will(returnValue(0));
                allowing(v2dZeroes).getValue(1,0);
                will(returnValue(0));
                allowing(v2dZeroes).getValue(1,1);
                will(returnValue(0));
                allowing(v2dZeroes).getValue(with(lessThan(0)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dZeroes).getValue(with(greaterThan(1)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dZeroes).getValue(with(any(int.class)),with(lessThan(0)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dZeroes).getValue(with(any(int.class)),with(greaterThan(1)));
                will(throwException(new IndexOutOfBoundsException()));
                
                allowing(v2dDecimals).getColumnCount();
                will(returnValue(2));
                allowing(v2dDecimals).getRowCount();
                will(returnValue(2));
                allowing(v2dDecimals).getValue(0,0);
                will(returnValue(arr3[0][0]));
                allowing(v2dDecimals).getValue(0,1);
                will(returnValue(arr3[0][1]));
                allowing(v2dDecimals).getValue(1,0);
                will(returnValue(arr3[1][0]));
                allowing(v2dDecimals).getValue(1,1);
                will(returnValue(arr3[1][1]));
                allowing(v2dDecimals).getValue(with(lessThan(0)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dDecimals).getValue(with(greaterThan(1)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dDecimals).getValue(with(any(int.class)),with(lessThan(0)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dDecimals).getValue(with(any(int.class)),with(greaterThan(1)));
                will(throwException(new IndexOutOfBoundsException()));
                
                allowing(v2dNulls).getColumnCount();
                will(returnValue(2));
                allowing(v2dNulls).getRowCount();
                will(returnValue(2));
                allowing(v2dNulls).getValue(0,0);
                will(returnValue(null));
                allowing(v2dNulls).getValue(0,1);
                will(returnValue(null));
                allowing(v2dNulls).getValue(1,0);
                will(returnValue(null));
                allowing(v2dNulls).getValue(1,1);
                will(returnValue(null));
                allowing(v2dNulls).getValue(with(lessThan(0)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dNulls).getValue(with(greaterThan(1)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dNulls).getValue(with(any(int.class)),with(lessThan(0)));
                will(throwException(new IndexOutOfBoundsException()));
                allowing(v2dNulls).getValue(with(any(int.class)),with(greaterThan(1)));
                will(throwException(new IndexOutOfBoundsException()));
                
                allowing(v2dEmpty).getColumnCount();
                will(returnValue(0));
                allowing(v2dEmpty).getRowCount();
                will(returnValue(0));
                allowing(v2dEmpty).getValue(with(any(int.class)),with(any(int.class)));
                will(throwException(new IndexOutOfBoundsException()));
                
                
            	// Trying to initialize a KeyedValues object using getters             
            	allowing(values1).getItemCount();

                // initialize KeyedValues object using getters             
                allowing(values1).getItemCount();
                will(returnValue(2));
                allowing(values1).getValue(1);
                will(returnValue(2));
                allowing(values1).getValue(0);
                will(returnValue(2));
                allowing(values1).getKey(0);
                will(returnValue(0));
                allowing(values1).getKey(1);
                will(returnValue(1));             
                
                
                allowing(values2).getItemCount();
                will(returnValue(1));
                allowing(values2).getValue(0);
                will(returnValue(-4));
                allowing(values2).getKey(0);
                will(returnValue("Hello"));
                
                allowing(values3).getItemCount();
                will(returnValue(1));
                allowing(values3).getValue(0);
                will(returnValue(0));
                allowing(values3).getKey(0);
                will(returnValue(3.7666));
                
		allowing(values4).getItemCount();
                will(returnValue(2));
                allowing(values4).getValue(0);
                will(returnValue(1));
                allowing(values4).getValue(1);
                will(returnValue(null));
                allowing(values4).getKey(0);
                will(returnValue("A"));
                allowing(values4).getKey(1);
                will(returnValue("B"));
                
                allowing(values5).getItemCount();
                will(returnValue(-1));
                allowing(values5).getValue(0);
                will(returnValue(1));
                allowing(values5).getValue(1);
                will(returnValue(2)); 
                allowing(values5).getKey(0);
                will(returnValue("A"));
                allowing(values5).getKey(0);
                will(returnValue("B"));
                                
                
            }
        });
    }

	
    // This test covers Null values for Cumalitive percentage method in data Utilities
//    @Test
//    public void testNullCumalitive() {
//        KeyedValues result = DataUtilities.getCumulativePercentages(values4);
//        assertEquals(0, result.getValue(0));
//    }

    // This test covers Int values for Cumalitive percentage method in data Utilities    
//    @Test
//    public void testGetCumalitivePercentagesReturnsCorrectValueAtIndexZeroForIntKeys() {                      
//       
//        KeyedValues result = DataUtilities.getCumulativePercentages(values1);                           
//        assertEquals(0.5, result.getValue(0));      
//    }

    // This test covers Int values for Cumalitive percentage method in data Utilities
//    @Test
//    public void testGetCumalitivePercentagesReturnsCorrectValueAtIndexOneForIntKeys() {                      
//       
//        KeyedValues result = DataUtilities.getCumulativePercentages(values1);                           
//        assertEquals(1, result.getValue(1));      
//    }
    
//    @Test(expected = Exception.class)
//    public void testGetCumalitivePercentagesThrowsExceptionForValueNegativeInt() {
//    	KeyedValues result = DataUtilities.getCumulativePercentages(values2);                                       
//    }
    
    // This test covers Cumalitive percentage throws exception for value zero
//    @Test(expected = Exception.class)
//    public void testGetCumalitivePercentagesThrowsExceptionForValueZero() {
//        KeyedValues result = DataUtilities.getCumulativePercentages(values3);
//        //assertEquals(1, result.getValue(0));
//        // shouldnt it throw exception
//    }
    
    // test covers creating a number array using positive doubles
    @Test
    public void createNumberArrayTestPositiveDoubles() {
        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[] arrayOneD = { 0.1, 0.2, 0.3 };

        Number[] expected = new Number[3];
        expected[0] = 0.1;
        expected[1] = 0.2;
        expected[2] = 0.3;

        Number[] result = DataUtilities.createNumberArray(arrayOneD);

        assertArrayEquals("createNumberArray fails for input of doubles", expected, result);
    }

    // test covers creating a number array using negative doubles    
    @Test
    public void createNumberArrayTestNegativeDoubles() {
        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[] arrayOneD = {-0.1, -0.2, -0.3};

        Number[] expected = new Number[3];
        expected[0] = -0.1;
        expected[1] = -0.2;
        expected[2] = -0.3;

        Number[] result = DataUtilities.createNumberArray(arrayOneD);

        assertArrayEquals("createNumberArray fails for input of negative doubles", expected, result);
    }

    // test covers creating a number array with no values
    @Test
    public void createNumberArrayTestEmptyArray() {
        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[] arrayOneD = {};

        Number[] expected = new Number[0];

        Number[] result = DataUtilities.createNumberArray(arrayOneD);

        assertArrayEquals("createNumberArea fails for empty array", expected, result);
    }

    // test covers creating a number array using null values
    @Test(expected = Exception.class)
    public void createNumberArrayTestNullValues() {
        Number[] result = DataUtilities.createNumberArray(null);
    }

    // test covers creating a 2D number array using positive doubles    
    @Test
    public void create2DNumberArrayTestPositiveDoubles() {

        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[][] arrayTwoD = { { 0.1, 0.00002 }, { 0.0001, 0.5 } };

        Number[][] expected = new Number[2][2];
        expected[0][0] = 0.1;
        expected[0][1] = 0.00002;
        expected[1][0] = 0.0001;
        expected[1][1] = 0.5;

        Number[][] result = DataUtilities.createNumberArray2D(arrayTwoD);

        assertArrayEquals("createNumberArray2D fails for 2d double array", expected, result);
    }
    
    // test covers creating a 2D number array using negative doubles 
    @Test
    public void create2DNumberArrayTestNegativeDoubles() {

        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[][] arrayTwoD = { { -0.1, -0.00002 }, { -0.0001, -0.5 } };

        Number[][] expected = new Number[2][2];
        expected[0][0] = -0.1;
        expected[0][1] = -0.00002;
        expected[1][0] = -0.0001;
        expected[1][1] = -0.5;

        Number[][] result = DataUtilities.createNumberArray2D(arrayTwoD);

        assertArrayEquals("createNumberArray2D fails for 2d negative double array", expected, result);
    }

    // test covers creating a 2D number array using positive doubles 
    @Test
    public void create2DNumberArrayTestEmptyArray() {

        // equivalent classes:
        // no entries in array
        // only doubles in array
        double[][] arrayTwoD = {};

        Number[][] expected = new Number[0][0];

        Number[][] result = DataUtilities.createNumberArray2D(arrayTwoD);

        assertArrayEquals("createNumberArray2D fails for empty double array", expected, result);
    }
    
    @Test(expected = Exception.class)
    public void createNumberArray2DTestNullValues() {
        Number[][] result = DataUtilities.createNumberArray2D(null);
    }
        
    
    // ECT's keys are doubles, integers and strings
    // ECT's Boundary values are null, negatives and positives (if applicable)
    
    

    @Test(expected = IllegalArgumentException.class)
    public void test_columnTotal_indexOutofBounds() {
    	DataUtilities.calculateColumnTotal(v2dPositives, 2);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_columnTotal_indexNegative() {
    	DataUtilities.calculateColumnTotal(v2dPositives, -1);
    	
    }
    @Test
    public void test_columnTotal_positiveSum() {
    	double expected = 4;
    	String msg = "Expect return 4";
    	double actual = DataUtilities.calculateColumnTotal(v2dPositives, 0);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_columnTotal_negativeSum() {
    	double expected = -4;
    	String msg = "Expect return -4";
    	double actual = DataUtilities.calculateColumnTotal(v2dNegatives, 0);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_columnTotal_zeroSum() {
    	double expected = 0;
    	String msg = "Expect return 0";
    	double actual = DataUtilities.calculateColumnTotal(v2dZeroes, 0);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_columnTotal_decimalValues() {
    	double expected = 0.4 ;
    	String msg = "Expect return 0.4";
    	double actual = DataUtilities.calculateColumnTotal(v2dDecimals, 0);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_columnTotal_nullValues() {
    	double expected = 0 ;
    	String msg = "Expect return 0";
    	double actual = DataUtilities.calculateColumnTotal(v2dNulls, 0);
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_columnTotal_emptyValues() {
    	DataUtilities.calculateColumnTotal(v2dEmpty, 0);
    }
    @Test
    public void test_columnTotal_positiveSum_allValidRows() {
    	double expected = 4;
    	String msg = "Expect return 4";
    	int[] validRows = {0,1};
    	double actual = DataUtilities.calculateColumnTotal(v2dPositives, 0, validRows);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_columnTotal_positiveSum_overloadedNulls() {
    	double expected = 0;
    	String msg = "Expect return 0";
    	int[] validRows = {0,1};
    	double actual = DataUtilities.calculateColumnTotal(v2dNulls, 0, validRows);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_columnTotal_positiveSum_someValidRows() {
    	double expected = 3;
    	String msg = "Expect return 3";
    	int[] validRows = {1};
    	double actual = DataUtilities.calculateColumnTotal(v2dPositives, 0, validRows);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_columnTotal_positiveSum_noValidRows() {
    	double expected = 0;
    	String msg = "Expect return 0";
    	int[] validRows = {};
    	double actual = DataUtilities.calculateColumnTotal(v2dPositives, 0, validRows);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_columnTotal_positiveSum_invalidRows() {
    	double expected = 4;
    	String msg = "Expect return 4";
    	int[] validRows = {0,1,3};
    	double actual = DataUtilities.calculateColumnTotal(v2dPositives, 0, validRows);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_rowTotal_positiveSum_allValidCols() {
    	double expected = 3;
    	String msg = "Expect return 3";
    	int[] validCols = {0,1};
    	double actual = DataUtilities.calculateRowTotal(v2dPositives, 0, validCols);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_rowTotal_positiveSum_overloadedNulls() {
    	double expected = 0;
    	String msg = "Expect return 0";
    	int[] validRows = {0,1};
    	double actual = DataUtilities.calculateRowTotal(v2dNulls, 0, validRows);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_rowTotal_positiveSum_someValidCols() {
    	double expected = 2;
    	String msg = "Expect return 2";
    	int[] validCols = {1};
    	double actual = DataUtilities.calculateRowTotal(v2dPositives, 0, validCols);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_rowTotal_positiveSum_noValidCols() {
    	double expected = 0;
    	String msg = "Expect return 0";
    	int[] validCols = {};
    	double actual = DataUtilities.calculateRowTotal(v2dPositives, 0, validCols);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_rowTotal_positiveSum_invalidCols() {
    	double expected = 3;
    	String msg = "Expect return 3";
    	int[] validCols = {0,1,3};
    	double actual = DataUtilities.calculateRowTotal(v2dPositives, 0, validCols);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    /*
    test_rowTotal_indexOutofBounds()
    test_rowTotal_indexNegative()
    test_rowTotal_positiveSum()
    test_rowTotal_negativeSum()
    test_rowTotal_zeroSum()
    test_rowTotal_decimalValues()
    test_rowTotal_nullValues()
    test_rowTotal_emptyValues()*/
    
    @Test(expected = IllegalArgumentException.class)
    public void test_rowTotal_indexOutofBounds() {
    	DataUtilities.calculateRowTotal(v2dPositives, 2);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_rowTotal_indexNegative() {
    	DataUtilities.calculateRowTotal(v2dPositives, -1);

    }
    @Test
    public void test_rowTotal_positiveSum() {
    	double expected = 3;
    	String msg = "Expect return 3";
    	double actual = DataUtilities.calculateRowTotal(v2dPositives, 0);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_rowTotal_negativeSum() {
    	double expected = -3;
    	String msg = "Expect return -3";
    	double actual = DataUtilities.calculateRowTotal(v2dNegatives, 0);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_rowTotal_zeroSum() {
    	double expected = 0;
    	String msg = "Expect return 0";
    	double actual = DataUtilities.calculateRowTotal(v2dZeroes, 0);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }
    @Test
    public void test_rowTotal_decimalValues() {
    	double expected = 0.3;
    	String msg = "Expect return 0.3";
    	double actual = DataUtilities.calculateRowTotal(v2dDecimals, 0);
    	
    	assertEquals(msg,expected, actual, .000000001d);
    }

	@Test
    public void test_rowTotal_nullValues() {
    	double expected = 0;
    	String msg = "Expect return 0";
    	double actual = DataUtilities.calculateRowTotal(v2dNulls, 0);	
    	assertEquals(msg,expected, actual, .000000001d);
    	
    }
//    @Test(expected = Exception.class)
//    public void test_rowTotal_emptyValues() {
//    	DataUtilities.calculateRowTotal(v2dEmpty, 0);	
//    }

    @After
    public void tearDown() throws Exception {
    }
    

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
    
    

}

