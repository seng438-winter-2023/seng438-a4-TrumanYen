// test covers creating a number array using null values
	@Test(expected = IllegalArgumentException.class)
	public void createNumberArrayTestNullValues() {
		Number[] result = DataUtilities.createNumberArray(null);
    }

    @Test(expected = IllegalArgumentException.class)
	public void createNumberArray2DTestNullValues() {
		Number[][] result = DataUtilities.createNumberArray2D(null);
	}