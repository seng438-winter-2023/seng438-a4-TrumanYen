@Test
	public void centralValueTestUpperRangedNotChanged() {
		int upper_expected = 5;
		classOneRange.getCentralValue();
		assertEquals("getCentralValue test if upper range changed.", upper_expected, classOneRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void centralValueTestLowerRangedNotChanged() {
		int lower_expected = 0;
		classOneRange.getCentralValue();
		assertEquals("getCentralValue test if lower range changed.", lower_expected, classOneRange.getLowerBound(), .000000001d);
	}
