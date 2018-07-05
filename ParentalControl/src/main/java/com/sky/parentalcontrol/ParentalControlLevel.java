package com.sky.parentalcontrol;

/**
 * The Enum ParentalControlLevel.
 *
 * @author Vivek Khandagale
 */
public enum ParentalControlLevel {
	
	U("U",4),/** The ug. */
	PG("PG",8),/** The pg. */
	TWELVE("12",12),/** The twelve. */
	FIFTEEN("15",15),/** The fifteen. */
	EIGHTEEN("18",18);/** The eighteen. */
    
	  
	/** The rating. */
	private final String rating;
	
	/** The min age. */
	private final int minAge;
	
	/**
	 * Instantiates a new parental control level.
	 *
	 * @param rat the rating
	 * @param age the min. allowed age of viewing
	 */
	ParentalControlLevel(String rat, int age) {
		this.rating = rat;
		this.minAge = age;
	}
	
	/**
	 * Gets the min age.
	 *
	 * @return the min age
	 */
	public int getMinAge() {
		return minAge;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	
	/**
	 * Find parental control level.
	 *
	 * @param label the label
	 * @return the parental control level
	 */
	public static ParentalControlLevel findParentalControlLevel(String label){
        switch (label){
            case "U": return U;
            case "PG": return PG;
            case "12": return TWELVE;
            case "15": return FIFTEEN;
            case "18": return EIGHTEEN;
        }
        return null;
    }
}
