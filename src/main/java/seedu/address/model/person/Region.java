package seedu.address.model.person;

// enum Region {N, NE, W, E, C};

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Region {
    public static final String MESSAGE_CONSTRAINTS = "Regions should be one of: N, NE, W, E, C. They should not be blank.";
    public static final String VALIDATION_REGEX = "^(N|NE|W|E|C)$";
    public RegionType value;

    public enum RegionType {
        N("North"),
        NE("North East"),
        W("West"),
        E("East"),
        C("Central");

        public final String label;

        private RegionType(String label) {
            this.label = label;
        }
    }

    public Region(String region) {
        requireNonNull(region);
        checkArgument(isValidRegion(region), MESSAGE_CONSTRAINTS);
        this.value = RegionType.valueOf(region);
    }

    /**
     * Returns true if a given string is a valid region.
     */
    public static boolean isValidRegion(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns the user-facing label of the Region.
     */
    public String toLabel() {
        return value.label;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Region)) {
            return false;
        }

        Region otherRegion = (Region) other;
        return value.equals(otherRegion.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


}
